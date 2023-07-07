import pandas as pd
import json

# DATA COLLECTION AND CLEANING
# Read CSV, skipping useless first and last lines
df = pd.read_csv('model.csv', skiprows=7, sep=";", nrows=91)
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
    'Objet': 'X',
    'children': children['1']
}

# DATA USAGE
# Go through data (list or tree) and use it to build the expected JSON schema
json_schema = {
    '$schema': 'http://json-schema.org/draft-07/schema#',
    'id': 'schema.json#',
    'version': '0.4.9',
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


def add_field_child_property(properties, child):
    """Update properties by adding the child information for a field child"""
    if str(child['Cardinalité']).endswith('n'):
        properties[child['name']] = {
            'type': 'array',
            'items': {
                'type': 'string'
            }
        }
    else:
        properties[child['name']] = {
            'type': 'string'
        }


def add_object_child_property(properties, child):
    """Update properties by adding the child information for an object child"""
    childTypeName = get_object_type(child)
    if str(child['Cardinalité']).endswith('n'):
        properties[child['name']] = {
            'type': 'array',
            'items': {
                '$ref': '#/definitions/' + childTypeName
            }
        }
    else:
        properties[child['name']] = {
            '$ref': '#/definitions/' + childTypeName
        }


def add_child_property(properties, child):
    """Update properties by adding the child information"""
    if child['Objet'] != 'X':
        add_field_child_property(properties, child)
    else:
        add_object_child_property(properties, child)


def fill_object_definition(elem, root=False):
    """
    Update the definition (required and properties) of the type of elem by traversing its direct children
    if root, write it on the top level of the schema and not in definitions
    """
    if root:
        definition = json_schema
    else:
        typeName = get_object_type(elem)
        if typeName not in json_schema['definitions']:
            json_schema['definitions'][typeName] = {
                'type': 'object',
                'required': [],
                'properties': {}
            }
        if 'children' not in elem:
            return
        definition = json_schema['definitions'][typeName]
    # Fill the required and properties based on the children
    for child in elem['children']:
        if child['Cardinalité'].startswith('1'):
            definition['required'].append(child['name'])
        add_child_property(definition['properties'], child)


def use_elem_new(elem):
    # Root element: write it on the top level of the schema and not in definitions
    if elem['level_shift'] == 0:
        fill_object_definition(elem, root=True)

    # Lower objects: it's a definition
    # -> update the type in definitions by traversing the direct children
    elif elem['level_shift'] > 0 and elem['Objet'] == 'X':
        fill_object_definition(elem)


def DFS(root):
    use_elem_new(root)
    if 'children' in root:
        for child in root['children']:
            DFS(child)


print('Generating JSON schema...')
DFS(rootObject)
print('JSON schema generated.')

with open('schema.json', 'w') as outfile:
    json.dump(json_schema, outfile, indent=4)
