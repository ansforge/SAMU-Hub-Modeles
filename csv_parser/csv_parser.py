import pandas as pd
import json

# DATA COLLECTION AND CLEANING
# Read CSV, skipping useless first and last lines
df = pd.read_csv('model_v2.csv', skiprows=7, sep=";", nrows=91)
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
    '$id': 'https://json-schema.org/draft-07/schema#',
    'properties': {},
    'definitions': {}
}

def isSharedObject(elem):
    isObject = elem['Objet'] == 'X'
    isShared = str(elem['Format (ou type)']) != 'nan'
    return isObject & isShared

def use_elem(elem):
    # By building a python dict or using https://jsonschema-builder.readthedocs.io/en/latest/

    parentPropertyName = None
    parentDefinitionName = None

    if elem['level_shift'] == 0:
        return

    if elem['level_shift'] > 1:
        parentDefinitionName = df.loc[elem['parent']]['Format (ou type)'] if isSharedObject(df.loc[elem['parent']]) else df.loc[elem['parent']]['name']
        parentPropertyName = df.loc[elem['parent']]['name']

    defName = elem['Format (ou type)'] if (isSharedObject(elem)) else elem['name']

    if elem['Objet'] == 'X':
        if defName not in json_schema['definitions']:
            json_schema['definitions'][defName] = {
                'type': 'object',
                'required': [],
                'properties': {}
            }
        if elem['level_shift'] == 1:
            json_schema['properties'][elem['name']] = {
                '$ref': '#/definitions/' + str(defName)
            }
        else:
            if str(elem['Cardinalité']).endswith('n'):
                json_schema['definitions'][parentDefinitionName]['properties'][elem['name']] = {
                    'type': 'array',
                    'items': {
                        '$ref': '#/definitions/' + str(defName)
                    }
                }
            else:
                json_schema['definitions'][parentDefinitionName]['properties'][elem['name']] = {
                    '$ref': '#/definitions/' + str(defName)
                }
            if str(elem['Cardinalité']).startswith('1'):
                json_schema['definitions'][parentDefinitionName]['required'].append(defName)
    else:
        if elem['level_shift'] == 1:
            json_schema['properties'][elem['name']] = {
                'type': 'string'
            }
        else:
            # directly write in parent object's properties
            if str(elem['Cardinalité']).endswith('n'):
                json_schema['definitions'][parentDefinitionName]['properties'][elem['name']] = {
                    'type': 'array',
                    'items': {
                        'type': 'string'
                    }
                }
            else:
                json_schema['definitions'][parentDefinitionName]['properties'][elem['name']] = {
                    'type': 'string'
                }
            if str(elem['Cardinalité']).startswith('1'):
                json_schema['definitions'][parentDefinitionName]['required'].append(defName)

def DFS(root):
    use_elem(root)
    if 'children' in root:
        for child in root['children']:
            DFS(child)

print('Generating JSON schema...')
DFS(rootObject)
print('JSON schema generated.')

with open('schema.json', 'w') as outfile:
    json.dump(json_schema, outfile, indent=4)
