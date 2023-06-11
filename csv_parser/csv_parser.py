import pandas as pd
import json

# Read CSV, skipping useless first and last lines
df = pd.read_csv('model.csv', skiprows=7, sep=";", nrows=105)
# Dropping useless columns
df = df.iloc[:, :29]
# Replacing comment cells (starting with '# ') with NaN in 'Donnée xx' columns
df.iloc[:, 1:6] = df.iloc[:, 1:6].applymap(lambda x: pd.NA if str(x).startswith('# ') else x)


df['level_shift'] = -1
for i in range(1, 6):
    df[f"level_{i}"] = df[f"Donnée (Niveau {i})"].notnull().cumsum()
    df[f"previous_level_{i}"] = df[f"level_{i}"].shift(periods=1, fill_value=0)
    df["level_shift"] = df.apply(lambda row: i if row[f"level_{i}"] != row[f"previous_level_{i}"] else row['level_shift'], axis=1)


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


json_schema = {
    'placeholder_list': []
}
def use_elem(elem):
    # ToDo: update this method to build the expected JSON schema
    # By building a python dict or using https://jsonschema-builder.readthedocs.io/en/latest/
    json_schema['placeholder_list'].append(elem['id'])
    print(elem['id'])


# 1. Flat linear data
flat_data = df.to_dict('records')
# Explored as a list
print('\n\tLIST\n')
for elem in flat_data:
    use_elem(elem)


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
    children = {parent_id: list(map(lambda child_id: get_element_with_its_children(previous_children, child_id), children_ids)) for (parent_id, children_ids) in children_ids.items()}
rootObject = {
    'id': 1,
    'children': children['1']
}


# Explored like a tree
# Depth first search (DFS) example
def print_tree_DFS(root):
    use_elem(root)
    if 'children' in root:
        for child in root['children']:
            print_tree_DFS(child)


# Breadth-first search (BFS) example
def print_tree_BFS(root):
    queue = [root]
    while len(queue) > 0:
        elem = queue.pop(0)
        use_elem(elem)
        if 'children' in elem:
            queue.extend(elem['children'])


print('\n\tDFS\n')
print_tree_DFS(rootObject)
print('\n\tBFS\n')
print_tree_BFS(rootObject)

with open('schema.json', 'w') as outfile:
    json.dump(json_schema, outfile, indent=4)
