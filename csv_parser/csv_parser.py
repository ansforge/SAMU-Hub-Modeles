import pandas as pd
import json
from jsonpath_ng import parse
import yaml


# DATA COLLECTION AND CLEANING
# Read CSV, skipping useless first and last lines
df = pd.read_excel('model.xlsx', sheet_name="partageAffaire", skiprows=7, nrows=109)
# Dropping useless columns
df = df.iloc[:, :29]
# Replacing comment cells (starting with '# ') with NaN in 'Donnée xx' columns
df.iloc[:, 1:6] = df.iloc[:, 1:6].applymap(lambda x: pd.NA if str(x).startswith('# ') else x)
# Adding a name column (NexSIS by default, overriden by 'Nouvelle Balise' if exists)
df['name'] = df['Balise NexSIS']
df.loc[df['Nouvelle balise'].notnull(), 'name'] = df['Nouvelle balise']

# DATA ENRICHMENT
# Get level in data hierarchy
df['level_shift'] = -1
for i in range(1, 6):
    df[f"level_{i}"] = df[f"Donnée (Niveau {i})"].notnull().cumsum()
    df[f"previous_level_{i}"] = df[f"level_{i}"].shift(periods=1, fill_value=0)
    df["level_shift"] = df.apply(
        lambda row: i if row[f"level_{i}"] != row[f"previous_level_{i}"] else row['level_shift'], axis=1)


# Get IDs, parent and build data hierarchy tree structure
def get_parent(row):
    parent = '1'
    for i in range(1, row['level_shift']):
        parent += '.' + str(row[f"level_{i}"])
    return parent


def build_id(row):
    id = '1'
    for i in range(1, row['level_shift'] + 1):
        id += '.' + str(row[f"level_{i}"])
    return id


df['id'] = df.apply(build_id, axis=1)
df['parent'] = df.apply(get_parent, axis=1)


# 2. Recursive data (children in their parent, to be explored like a tree)
def get_element_with_its_children(previous_children, elem_id):
    elem = df.loc[elem_id].to_dict()
    if elem['id'] in previous_children:
        elem['children'] = previous_children[elem_id]
    return elem


df = df.set_index('id', drop=False)
children = {}
for i in range(5, 0, -1):
    previous_children = children
    children_df = df[df['level_shift'] == i]
    children_ids = children_df.groupby('parent')['id'].apply(list)
    children = {
        parent_id: list(map(lambda child_id: get_element_with_its_children(previous_children, child_id), children_ids))
        for (parent_id, children_ids) in children_ids.items()}
rootObject = {
    'id': '1',
    'level_shift': 0,
    'name': 'CreateCaseMessage',
    'Objet': 'X',
    'children': children['1']
}


# DATA USAGE
def is_array(elem):
    """Is elem an array?"""
    return elem['Cardinalité'].endswith('n')


# Recursively build a json example
def build_example(elem):
    if elem['Objet'] != 'X':
        if str(elem['Exemples']) == 'nan':
            return 'None'
        return elem['Exemples']
    elif 'children' not in elem:
        print(elem['name'])
        return {}
    else:
        children = {}
        for child in elem['children']:
            if is_array(child):
                children[child['name']] = [build_example(child)]
            else:
                children[child['name']] = build_example(child)
        return children


json_example = build_example(rootObject)
with open('example.json', 'w') as outfile:
    json.dump(json_example, outfile, indent=4)

# Go through data (list or tree) and use it to build the expected JSON schema
json_schema = {
    '$schema': 'http://json-schema.org/draft-07/schema#',
    'id': 'schema.json#',
    'version': '0.4.9',
    'example': 'example.json#',
    'required': [],
    'properties': {},
    'definitions': {}
}


def is_typed_object(elem):
    """Is elem an object and using a specific reusable type?"""
    isObject = elem['Objet'] == 'X'
    isTyped = str(elem['Format (ou type)']) != 'nan'
    return isObject & isTyped


def get_object_type(elem):
    """Get the type of elem (defaults to its name if there is no type specified)"""
    return elem['Format (ou type)'] if is_typed_object(elem) else elem['name']


def has_format_details(elem, details):
    """Does elem have a format details starting with details?"""
    return str(elem['Détails de format']) != 'nan' and elem['Détails de format'].startswith(details)


def type_matching(child):
    """Get the matching type for a given type name"""
    typeName = child['Format (ou type)']
    if typeName == 'date':
        return 'string', r'\d{4}-\d{2}-\d{2}'
    elif typeName == 'datetime':
        return 'string', r'\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}'
    elif typeName == 'phoneNumber':
        return 'string', r'tel:([#\+\*]|37000|00+)?[0-9]{2,15}'
    else:
        if has_format_details(child, 'REGEX: '):
            return typeName, child['Détails de format'][7:]
        else:
            return typeName, None


def get_parent_example_path(parent):
    if parent['level_shift'] == 0:
        return json_schema['example']
    return json_schema['definitions'][get_object_type(parent)]['example']


def add_field_child_property(parent, child, properties):
    """Update parent properties by adding the child information for a field child"""
    typeName, pattern = type_matching(child)
    parentExamplePath = get_parent_example_path(parent)
    childDetails = {
        'type': typeName,
        'example': parentExamplePath + '/' + child['name'] + ('/0' if is_array(child) else '')
    }
    if str(child['Description']) != 'nan':
        childDetails['description'] = child['Description']
    if pattern is not None:
        childDetails['pattern'] = pattern
    if has_format_details(child, 'ENUM: '):
        childDetails['enum'] = child['Détails de format'][6:].split(', ')
    if is_array(child):
        properties[child['name']] = {
            'type': 'array',
            'items': childDetails
        }
    else:
        properties[child['name']] = childDetails


def add_object_child_definition(parent, child, definitions):
    """
    Update parent definitions (required and properties) by adding the child information for an object child
    Creates definitions for the child object if it does not exist yet
    """
    childTypeName = get_object_type(child)
    parentExamplePath = get_parent_example_path(parent)
    typeName = get_object_type(child)
    if typeName not in json_schema['definitions']:
        json_schema['definitions'][typeName] = {
            'type': 'object',
            'required': [],
            'properties': {},
            'example': parentExamplePath + '/' + child['name'] + ('/0' if is_array(child) else '')
        }
    if child['Cardinalité'].startswith('1'):
        definitions['required'].append(child['name'])
    properties = definitions['properties']
    if is_array(child):
        properties[child['name']] = {
            'type': 'array',
            'items': {
                '$ref': '#/definitions/' + childTypeName,
                'example': parentExamplePath + '/' + child['name'] + ('/0' if is_array(child) else '')
            }
        }
    else:
        properties[child['name']] = {
            '$ref': '#/definitions/' + childTypeName,
            'example': parentExamplePath + '/' + child['name'] + ('/0' if is_array(child) else '')
        }


def add_child(parent, child, definitions):
    """Update parent definitions by adding the child information"""
    if child['Objet'] != 'X':
        add_field_child_property(parent, child, definitions['properties'])
    else:
        add_object_child_definition(parent, child, definitions)


def fill_object_definition(elem, root=False):
    """
    Update the definition (required and properties) of the type of elem by traversing its direct children
    if root, write it on the top level of the schema and not in definitions
    """
    if root:
        definition = json_schema
    else:
        if 'children' not in elem:
            assert elem['Format (ou type)'] in json_schema['definitions'], \
                f"The type of the object {elem['name']} is not defined"
            return json_schema['definitions'][elem['Format (ou type)']]
        typeName = get_object_type(elem)
        definition = json_schema['definitions'][typeName]
    # Fill the elem definitions based on the children
    for child in elem['children']:
        add_child(elem, child, definition)
    return definition


def depth(x):
    """Get the depth of a dictionary"""
    if type(x) is dict and x:
        return 1 + max(depth(x[a]) for a in x)
    if type(x) is list and x:
        return 1 + max(depth(a) for a in x)
    return 0


def get_examples_with_json_example(definition):
    """Collect example in the json_example if it is not too deep"""
    json_schema_path = "$" + definition['example'].split('#')[1]
    path_with_arrays = json_schema_path.replace('/0', '[0]')
    path = path_with_arrays.replace('/', '.')
    example = parse(path).find(json_example)[0].value
    if depth(example) < 2:
        definition['examples'] = [example]
    # Do it as well for all its children properties
    if 'properties' in definition:
        for prop in definition['properties']:
            propDef = definition['properties'][prop]
            if 'items' in propDef:
                get_examples_with_json_example(propDef['items'])
            else:
                get_examples_with_json_example(propDef)


def use_elem(elem):
    # BUILD JSON SCHEMA
    if elem['Objet'] == 'X':
        # Root element: write it on the top level of the schema and not in definitions
        # Lower objects: in definitions -> update the type in definitions by traversing the direct children
        fill_object_definition(elem, root=elem['level_shift'] == 0)


def DFS(root):
    use_elem(root)
    if 'children' in root:
        for child in root['children']:
            DFS(child)


print('Generating JSON schema...')
DFS(rootObject)
with open('schema.json', 'w') as outfile:
    json.dump(json_schema, outfile, indent=4)
print('JSON schema generated.')


# BUILD AsyncAPI SCHEMA
def build_asyncapi_schema():
    asyncapi_schema = {}
    definitions = json_schema['definitions']
    # Add root object to definitions so it is treated as a normal object
    # Dropping useless root infos
    root_definition = {key: json_schema[key] for key in json_schema if key not in [
        '$schema', 'definitions', 'version', 'id'
    ]}
    definitions = {
        **{rootObject['name']: root_definition},
        **definitions
    }
    # Simply collect all objects (and root properties)
    for elem_name, definition in definitions.items():
        get_examples_with_json_example(definition)
        asyncapi_schema[elem_name] = definition
    return asyncapi_schema


print('Generating AsyncAPI schema...')
with open('template.asyncapi.yaml') as f:
    full_yaml = yaml.load(f, Loader=yaml.loader.SafeLoader)
full_yaml['components']['schemas'] = {
    **full_yaml['components']['schemas'],
    **build_asyncapi_schema()
}
with open('hubsante.asyncapi.yaml', 'w') as file:
    documents = yaml.dump(full_yaml, file)
print('AsyncAPI schema generated.')
