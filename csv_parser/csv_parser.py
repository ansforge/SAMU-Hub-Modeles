import pandas as pd
import json
from jsonpath_ng import parse
import yaml
import docx
import argparse
from datetime import date
import warnings
import uml_generator
import os

from pathlib import Path

# Improving panda printing | Ref.: https://stackoverflow.com/a/11711637
pd.set_option('display.max_rows', 500)
pd.set_option('display.max_columns', 500)
pd.set_option('display.width', 1000)

# Ignoring Openpyxl Excel's warnings | Ref.: https://stackoverflow.com/a/64420416
warnings.filterwarnings('ignore', category=UserWarning, module='openpyxl')

full_asyncapi = None

def run(sheet, name, version, filter):
    class Color:
        ORANGE = '\033[93m'
        RED = '\033[91m'
        PURPLE = '\033[95m'
        BOLD = '\033[1m'
        UNDERLINE = '\033[4m'
        END = '\033[0m'

    version = version or date.today().strftime("%y.%m.%d")
    print(f"{Color.BOLD}{Color.UNDERLINE}{Color.PURPLE}"
          f"Building version {version} of {'15-NexSIS' if filter else ''} {sheet} sheet "
          f"into {name} schema..."
          f"{Color.END}")

    RUN_DOCX_OUTPUT_EXAMPLES = False

    DATA_DEPTH = 6  # nombre de niveaux de données

    def get_params_from_sheet(sheet):
        """ Automatically get the number of rows and columns to use for this sheet. """
        full_df = pd.read_excel('model.xlsx', sheet_name=sheet, header=None)
        # Getting modelName from cell A1
        modelName = full_df.iloc[0, 0]
        # Computing number of rows in table
        # rows = df.iloc[7:, 0]
        # Simply remove initial rows & total row
        # ToDo: be more resilient to nan & \xa0 in full_df.iloc[8:,0] and compute nb with count?
        rows = full_df.shape[0] - 8 - 1
        # Compute number of columns in table
        try:
            # By finding the CUT column
            cols = full_df.iloc[7, :].tolist().index('CUT')
        except ValueError:
            # Simply by removing the 6 last editor feedback columns
            cols = full_df.shape[1] - 6
        return {
            'modelName': modelName,
            'cols': cols,
            'rows': rows
        }

    def get_nomenclature(elem):
        # filename to target (.csv format)
        nomenclature_name = elem['Détails de format'][14:]
        path_file = ''
        for filename in os.listdir(os.path.join("..", "nomenclature_parser", "out", "latest", "csv")):
            if filename.startswith(nomenclature_name):
                path_file = os.path.join("..", "nomenclature_parser", "out", "latest", "csv", filename)

        if path_file != '':
            df_nomenclature = pd.read_csv(path_file, sep=",", keep_default_na=False, na_values=['_'], encoding="utf-8")
            L_ret = df_nomenclature["code"].values.tolist()
        else:
            # ToDo: ajouter un bloc dans le else pour détecter des https:// et aller chercher les nomenclatures publiées en ligne (MOS/NOs par exemple)
            print(f'{nomenclature_name} does not exist. Cannot load associated nomenclature.')
            return []
        return L_ret

    params = get_params_from_sheet(sheet)
    # Schema name is in name = RC-EDA (or RS-EDA) for instance
    MODEL_NAME = params['modelName']  # CreateCase
    MODEL_TYPE = MODEL_NAME[0].lower() + MODEL_NAME[1:]  # createCase
    def isCreateCase():
        return MODEL_TYPE == "createCase"

    if not filter and isCreateCase():
        MODEL_TYPE = "createCaseHealth"
    WRAPPER_NAME = f"{MODEL_TYPE}Wrapper"  # createCaseWrapper
    NB_ROWS = params['rows']
    NB_COLS = params['cols']

    Path('out/' + name).mkdir(parents=True, exist_ok=True)

    # DATA COLLECTION AND CLEANING
    # Read CSV, skipping useless first and last lines
    df = pd.read_excel('model.xlsx', sheet_name=sheet, skiprows=7, nrows=NB_ROWS, converters={'ID': int})
    # Dropping useless columns
    df = df.iloc[:, :NB_COLS]
    # Column validation
    REQUIRED_COLUMNS = [
        *[f"Donnée (Niveau {i})" for i in range(1, DATA_DEPTH + 1)],
        'ID', 'Description', 'Cardinalité', 'Balise NexSIS', 'Nouvelle balise', 'Objet', 'Format (ou type)'
    ]
    if not (set(REQUIRED_COLUMNS) <= set(df.columns)):
        print(f"{Color.RED}ERROR: some key columns are missing:{Color.ORANGE}")
        print(set(REQUIRED_COLUMNS) - set(df.columns))
        print(f"Make sure all these columns are existing: {REQUIRED_COLUMNS}.{Color.END}")
        exit(1)

    # Keeping only 15-NexSIS fields if filter is set
    if filter:
        df = df[df['15-18'] == 'X']
    else:
        df = df[df['15-15'] == 'X']

    # Storing input data in a file to track versions
    df.to_csv(f'out/{name}/{name}.input.csv')

    # Replacing comment cells (starting with '# ') with NaN in 'Donnée xx' columns
    df.iloc[:, 1:1 + DATA_DEPTH] = df.iloc[:, 1:1 + DATA_DEPTH].applymap(
        lambda x: pd.NA if str(x).startswith('# ') else x)
    # if MODEL_NAME != "RC-DE":
    #     # Adding the wrapper
    #     # - Moving all levels one level down
    #     df = df.rename(columns={f"Donnée (Niveau {i})": f"Donnée (Niveau {i + 1})" for i in range(1, DATA_DEPTH + 1)})
    #     DATA_DEPTH += 1
    #     # - Adding the wrapper line
    #     df.insert(1, "Donnée (Niveau 1)", None)
    #     df = pd.concat([
    #         pd.DataFrame({
    #             'ID': -1,
    #             'Description': f"Object {MODEL_NAME}",
    #             'Nouvelle balise': MODEL_TYPE,
    #             'Cardinalité': '1..1',
    #             'Objet': 'X',
    #             'Format (ou type)': MODEL_TYPE,
    #             'Donnée (Niveau 1)': f"Objet {MODEL_NAME}"
    #         }, index=[-1]),
    #         df
    #     ])
    # Adding a name column (NexSIS by default, overriden by 'Nouvelle Balise' if exists)
    df['name'] = df['Balise NexSIS']
    df.loc[df['Nouvelle balise'].notnull(), 'name'] = df['Nouvelle balise']

    # DATA ENRICHMENT
    # Get level in data hierarchy
    df['level_shift'] = -1
    for i in range(1, 1 + DATA_DEPTH):
        # Number of distinct values in 'level i' column before that item included
        df[f"level_{i}"] = df[f"Donnée (Niveau {i})"].notnull().cumsum()
        # Number of distinct values in 'level i' column before that item excluded
        df[f"previous_level_{i}"] = df[f"level_{i}"].shift(periods=1, fill_value=0)
        # If the 2 numbers are different => that item's active 'Donnée' column is i => update 'level_shift' column
        df["level_shift"] = df.apply(
            lambda row: i if row[f"level_{i}"] != row[f"previous_level_{i}"] else row['level_shift'], axis=1)

    # DATA VALIDATION
    HAS_ERROR = False

    def get_row_donnees_count(df):
        # Filter columns based on the specified prefix
        niveau_columns = [col for col in df.columns if col.startswith('Donnée (Niveau')]
        # Count non-null values in each row for the selected columns
        return df[niveau_columns].notnull().sum(axis=1)

    row_donnees_count = get_row_donnees_count(df)
    # - Lines with multiple 'Données'
    if not df[row_donnees_count > 1].empty:
        print(f"{Color.RED}ERROR: some rows have multiple 'Données' fields:{Color.ORANGE}")
        print(df[row_donnees_count > 1])
        print(f"Perhaps these lines contains uncorrectly formatted comments (should start with '# ').{Color.END}")
        HAS_ERROR = True
    # - Lines with no 'Données'
    if not df[row_donnees_count == 0].empty:
        print(f"{Color.RED}ERROR: some rows have no 'Données' field:{Color.ORANGE}")
        print(df[row_donnees_count == 0])
        print(f"Perhaps these lines should be deleted or contained only comments.{Color.END}")
        HAS_ERROR = True
    # - No name
    if not df[df['name'].isnull()].empty:
        print(f"{Color.RED}ERROR: some rows have no 'name' field:{Color.ORANGE}")
        print(df[df['name'].isnull()])
        print(f"Name is based on column 'Balise NexSIS' overwritten by any value in 'Nouvelle balise'.\n"
              f"Check these columns are correctly set up.{Color.END}")
        HAS_ERROR = True
    # - name with spaces
    if not df[df['name'].str.contains(' ')].empty:
        print(f"{Color.RED}ERROR: some rows have spaces in their 'name' field:{Color.ORANGE}")
        print(df[df['name'].str.contains(' ')])
        print(f"Name is based on column 'Balise NexSIS' overwritten by any value in 'Nouvelle balise'.\n"
              f"Check these columns are correctly set up.{Color.END}")
        HAS_ERROR = True
    # - objects with basic types
    basic_types = ['integer', 'number', 'string', 'datetime', 'date']
    objects_with_basic_type_df = df.loc[
        (df['Objet'] == 'X') &
        (df['Format (ou type)'].isin(basic_types))
        ]
    if not objects_with_basic_type_df.empty:
        print(f"{Color.RED}ERROR: some rows have objects with basic type:{Color.ORANGE}")
        print(objects_with_basic_type_df)
        print(
            f"Objects (column 'Objet' = X) can't have a basic type (column 'Format (ou type)') {basic_types}.{Color.END}")
        HAS_ERROR = True
    # - Failed to compute level_shift
    if not df[df['level_shift'] == -1].empty:
        print(f"{Color.RED}ERROR: level_shift couldn't be computed for some rows:{Color.ORANGE}")
        print(df[df['level_shift'] == -1])
        print(
            f"If these rows were not mentioned in a previous error, "
            f"the exact reason should be investigated by the dev team...{Color.END}")
        HAS_ERROR = True
    if HAS_ERROR:
        exit(1)

    # Get IDs, parent and build data hierarchy tree structure
    def get_parent(row):
        parent = '1'
        for i in range(1, row['level_shift']):
            parent += '.' + str(row[f"level_{i}"])
        return parent

    def is_typed_object(row):
        """Is elem an object and using a specific reusable type?"""
        isObject = row['Objet'] == 'X'
        isTyped = str(row['Format (ou type)']) != 'nan'
        return isObject & isTyped

    def is_health_only(row):
        """Is elem only for 15-15?"""
        isHealthOnly = row['15-18'] != 'X' and row['15-15'] == 'X'
        return isHealthOnly

    def get_true_type(row):
        """Get the type of elem (defaults to its name if there is no type specified)"""
        if row["Objet"] != "X" or row['is_typed_object']:
            return row["Format (ou type)"]
        return row['name']

    def get_parent_type(row):
        if row['level_shift'] == 1:
            return MODEL_TYPE
        return df.loc[row['parent']]['true_type']

    def build_id(row):
        id = '1'
        for i in range(1, row['level_shift'] + 1):
            id += '.' + str(row[f"level_{i}"])
        return id

    def build_full_name(row):
        return row[f"Donnée (Niveau {row['level_shift']})"]

    df['is_typed_object'] = df.apply(is_typed_object, axis=1)
    df['is_health_only'] = df.apply(is_health_only, axis=1)
    df['true_type'] = df.apply(get_true_type, axis=1)
    df['id'] = df.apply(build_id, axis=1)
    df = df.set_index('id', drop=False)
    df['parent'] = df.apply(get_parent, axis=1)
    df['parent_type'] = df.apply(get_parent_type, axis=1)
    df['full_name'] = df.apply(build_full_name, axis=1)

    # 2. Recursive data (children in their parent, to be explored like a tree)
    def get_element_with_its_children(previous_children, elem_id):
        elem = df.loc[elem_id].to_dict()
        if elem['id'] in previous_children:
            elem['children'] = previous_children[elem_id]
        return elem

    children = {}
    for i in range(DATA_DEPTH, 0, -1):
        previous_children = children
        children_df = df[df['level_shift'] == i]
        children_ids = children_df.groupby('parent')['id'].apply(list)
        children = {
            parent_id: list(
                map(lambda child_id: get_element_with_its_children(previous_children, child_id), children_ids))
            for (parent_id, children_ids) in children_ids.items()}
    rootObject = {
        'id': '1',
        'level_shift': 0,
        'name': MODEL_TYPE,
        'Objet': 'X',
        'children': children['1']
    }

    # DATA USAGE
    def is_array(elem):
        """Is elem an array?"""
        cardinality = elem['Cardinalité']
        return not cardinality.endswith('1')

    def navigate_children_with_id(id_path):
        """
        Helper to navigate through children tree using item id.
        ex : '1.1.11' gives children['1'][0]['children'][11]['children']
        """
        # Removing wrapper
        current = children['1']
        id_path = id_path[2:]
        # Navigating following given id_path
        keys = list(map(int, id_path.split('.')))
        for key in keys:
            current = current[key - 1]['children']
        return current

    # Recursively build a json example
    def build_example(elem):
        if elem['Objet'] != 'X':
            if str(elem['Exemples']) == 'nan':
                return 'None'
            return elem['Exemples']
        elif 'children' not in elem:
            # ToDo: Could be object reference (so no children itself but first definition of its type has)
            # But it is not so easy to access the first reference here as nor the JSON Schema nor example are built yet
            # .id is not correct as the ID don't reset but are always increasing... computing some resetting id is necessary
            # type_first_definition = df[df['true_type'] == elem['true_type']].iloc[0].id
            # type_children = navigate_children_with_id(type_first_definition)
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
    with open(f'out/{name}/{name}.example.json', 'w') as outfile:
        json.dump(json_example, outfile, indent=4)

    # Go through data (list or tree) and use it to build the expected JSON schema
    json_schema = {
        '$schema': 'http://json-schema.org/draft-07/schema#',
        '$id': 'classpath:/json-schema/schema#',
        'x-id': f'{name}.schema.json#',  # required by JSV to find the schema file locally
        'version': version,
        'example': 'example.json#',
        'type': 'object',
        'title': MODEL_TYPE,
        'required': [],
        'properties': {},
        'definitions': {}
    }

    def has_format_details(elem, details):
        """Does elem have a format details starting with details?"""
        return str(elem['Détails de format']) != 'nan' and elem['Détails de format'].startswith(details)

    def type_matching(child):
        """Get the matching type for a given type name"""
        typeName = child['Format (ou type)']
        if typeName == 'date':
            return 'string', r'\d{4}-\d{2}-\d{2}', None
        elif typeName == 'datetime':
            return 'string', r'\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}', 'date-time'
        elif typeName == 'phoneNumber':
            return 'string', r'tel:([#\+\*]|37000|00+)?[0-9]{2,15}', None
        else:
            if has_format_details(child, 'REGEX: '):
                return typeName, child['Détails de format'][7:], None
            else:
                return typeName, None, None

    def get_parent_example_path(parent):
        if parent['level_shift'] == 0:
            return json_schema['example']
        return json_schema['definitions'][parent['true_type']]['example']

    def add_field_child_property(parent, child, definitions):
        """Update parent definitions (required and properties) by adding the child information for a field child"""
        if child['Cardinalité'].startswith('1'):
            definitions['required'].append(child['name'])
        typeName, pattern, format = type_matching(child)
        parentExamplePath = get_parent_example_path(parent)
        childDetails = {
            'type': typeName,
            'title': child['full_name'],
            'x-health-only': child['is_health_only'],
            'x-cols': 6,
            'example': parentExamplePath + '/' + child['name'] + ('/0' if is_array(child) else '')
        }
        if str(child['Description']) != 'nan':
            childDetails['description'] = child['Description']
        if pattern is not None:
            childDetails['pattern'] = pattern
        if format is not None:
            childDetails['format'] = format
        if has_format_details(child, 'ENUM: '):
            childDetails['enum'] = child['Détails de format'][6:].split(', ')
        # key word nomenclature trigger search over nomenclature folder for matching file
        if has_format_details(child, 'NOMENCLATURE: '):
            childDetails['enum'] = get_nomenclature(child)
        properties = definitions['properties']
        if is_array(child):
            properties[child['name']] = {
                'type': 'array',
                'x-health-only': child['is_health_only'],
                'items': childDetails
            }
            if child['Cardinalité'][-1].isdigit():
                properties[child['name']]['maxItems'] = int(child['Cardinalité'][-1])
        else:
            properties[child['name']] = childDetails

    def add_object_child_definition(parent, child, definitions):
        """
        Update parent definitions (required and properties) by adding the child information for an object child
        Creates definitions for the child object if it does not exist yet
        """
        childTypeName = child['true_type']
        parentExamplePath = get_parent_example_path(parent)
        typeName = child['true_type']
        if typeName not in json_schema['definitions']:
            json_schema['definitions'][typeName] = {
                'type': 'object',
                'title': child['full_name'],
                'x-display': 'expansion-panels',
                'x-health-only': child['is_health_only'],
                'required': [],
                'properties': {},
                'additionalProperties': False,
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
                }
            }
            if child['Cardinalité'][-1].isdigit():
                properties[child['name']]['maxItems'] = int(child['Cardinalité'][-1])
        else:
            properties[child['name']] = {
                '$ref': '#/definitions/' + childTypeName,
            }

    def add_child(parent, child, definitions):
        """Update parent definitions by adding the child information"""
        if child['Objet'] != 'X':
            add_field_child_property(parent, child, definitions)
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
                    (f"The type of the object '{elem['name']}' is not defined.\n"
                     f"Make sure the object is not empty")
                return json_schema['definitions'][elem['Format (ou type)']]
            typeName = elem['true_type']
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
        try:
            example = parse(path).find(json_example)[0].value
        except Exception as err:
            print(f"{Color.ORANGE}WARNING: '{err}' while getting example from JSON sample.{Color.ORANGE}")
            print(
                f"Path {path} of data '{definition['title']}' not found. Make sure parents and types are OK.{Color.END}")
            return
        if depth(example) < 2:
            definition['examples'] = [example]
        # Do it as well for all its children properties
        if 'properties' in definition:
            for prop in definition['properties']:
                propDetails = definition['properties'][prop]
                if 'items' in propDetails:
                    get_examples_with_json_example(get_definition_from_prop(propDetails['items']))
                else:
                    get_examples_with_json_example(get_definition_from_prop(propDetails))

    def get_definition_from_prop(prop):
        """Gives the definition of a property"""
        if '$ref' in prop:
            return json_schema['definitions'][prop['$ref'].split('/')[-1]]
        else:
            return prop

    def build_json_schema(elem):
        # BUILD JSON SCHEMA
        if elem['Objet'] == 'X':
            # Root element: write it on the top level of the schema and not in definitions
            # Lower objects: in definitions -> update the type in definitions by traversing the direct children
            fill_object_definition(elem, root=elem['level_shift'] == 0)

    def DFS(root, use_elem):
        use_elem(root)
        if 'children' in root:
            for child in root['children']:
                DFS(child, use_elem)

    print(f'{Color.BOLD}{Color.UNDERLINE}{Color.PURPLE}Generating JSON schema...{Color.END}')
    DFS(rootObject, build_json_schema)
    with open(f'out/{name}/{name}.schema.json', 'w') as outfile:
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
            **{MODEL_TYPE: root_definition},
            **definitions
        }
        # Simply collect all objects (and root properties)
        for elem_name, definition in definitions.items():
            get_examples_with_json_example(definition)
            asyncapi_schema[elem_name] = definition
        return asyncapi_schema

    openapi_components = build_asyncapi_schema()
    with open('common.openapi.yaml') as f:
        common_openapi_components = yaml.load(f, Loader=yaml.loader.SafeLoader)

    print(f'{Color.BOLD}{Color.UNDERLINE}{Color.PURPLE}Generating OpenAPI schema...{Color.END}')
    with open('template.openapi.yaml') as f:
        full_yaml = yaml.load(f, Loader=yaml.loader.SafeLoader)

        wrapper_yaml = {
            WRAPPER_NAME: {
                "type": "object",
                "required": [MODEL_TYPE],
                "properties": {
                    MODEL_TYPE: {
                        "$ref": "#/components/schemas/" + MODEL_TYPE
                    }
                }
            }
        }

        full_yaml['components']['schemas'] = {
            **full_yaml['components']['schemas'],
            **wrapper_yaml,
            **openapi_components
        }

    print(f'{Color.BOLD}{Color.UNDERLINE}{Color.PURPLE}Adding schema info to AsyncAPI spec...{Color.END}')
    with open('template.asyncapi.yaml') as f:
        asyncapi_yaml = yaml.load(f, Loader=yaml.loader.SafeLoader)

        asyncapi_yaml['components']['schemas'] = {
            **asyncapi_yaml['components']['schemas'],
            **common_openapi_components['components']['schemas'],
            **openapi_components
        }

        # Adding current asyncapi schemas to full asyncapi schema
        global full_asyncapi
        if (full_asyncapi is None):
            full_asyncapi = asyncapi_yaml
        else:
            full_asyncapi['components']['schemas'].update(asyncapi_yaml['components']['schemas'])

    with open(f'out/{name}/{name}.openapi.yaml', 'w') as file:
        documents = yaml.dump(full_yaml, sort_keys=False)
        documents = documents.replace('#/definitions/', "#/components/schemas/")
        file.write(documents)
    print('OpenAPI schema generated.')

    print(f'{Color.BOLD}{Color.UNDERLINE}{Color.PURPLE}Generating UML diagrams...{Color.END}')
    uml_generator.run(name, MODEL_NAME, version=version, filter=filter)
    print('UML diagrams generated.')

    named_df = df.copy().set_index(['parent_type', 'name']).fillna('')

    def get_excel_line(parent_type, name):
        try:
            # iloc[0] necessary even if there is only one line per name as it returns a DataFrame
            return named_df.loc[(parent_type, name)].iloc[0].to_dict()
        except AttributeError:
            return named_df.loc[(parent_type, name)].to_dict()

    def set_col_widths(table, widths):
        for row in table.rows:
            for idx, width in enumerate(widths):
                row.cells[idx].width = docx.shared.Cm(width)

    def def_to_table(name, definition, title='', doc=None, style='Medium Shading 1 Accent 1'):
        if doc is None:
            doc = docx.Document()

        # Add title
        doc.add_heading(title, level=1)

        # Add paragraph
        # doc.add_paragraph('This table represents the fields and types defined in the JSON schema.')

        table = doc.add_table(rows=1, cols=6, style=style)

        # Add table header
        header_cells = table.rows[0].cells
        header_cells[0].text = 'Nom de balise'
        header_cells[1].text = 'Champ correspondant'
        header_cells[2].text = 'Format'
        header_cells[3].text = 'Cardinalité'
        header_cells[4].text = 'Description'
        header_cells[5].text = 'Exemple'

        # Iterate through each property in the JSON schema
        for field, properties in definition['properties'].items():
            field_data = get_excel_line(name, field)
            row_cells = table.add_row().cells
            row_cells[0].text = field
            row_cells[1].text = field_data['full_name']
            typeInfo = field_data['true_type']
            if field_data['Objet'] == 'X':
                typeInfo = 'cf. type ' + typeInfo
            if field_data['Détails de format'] != '':
                typeInfo += "\n(" + field_data['Détails de format'] + ")"
            row_cells[2].text = typeInfo
            row_cells[3].text = field_data['Cardinalité']
            row_cells[4].text = field_data['Description']
            row_cells[5].text = str(field_data['Exemples'])

        # Specify the column widths (has to be on cells for Word) | Ref.: https://stackoverflow.com/a/43053996
        table.autofit = False
        table.allow_autofit = False
        column_widths = (3, 3.5, 2, 2.5, 8, 3)  # Widths in centimeters
        set_col_widths(table, column_widths)

        return doc

    print(f'{Color.BOLD}{Color.UNDERLINE}{Color.PURPLE}Generating Docx tables...{Color.END}')
    doc = docx.Document()
    # Set the page orientation to landscape
    section = doc.sections[0]
    new_width, new_height = section.page_height, section.page_width
    section.orientation = docx.enum.section.WD_ORIENT.LANDSCAPE
    section.page_width = new_width
    section.page_height = new_height
    # Json Schema rootObject makes the object table
    def_to_table(MODEL_TYPE, json_schema, title=f"Objet {MODEL_TYPE} ({MODEL_NAME})", doc=doc)
    # Then all Json Schema definitions are types tables
    for elem_name, definition in json_schema['definitions'].items():
        def_to_table(elem_name, definition, title=f"Type {elem_name}", doc=doc)
    doc.save(f'out/{name}/{name}.schema.docx')

    print('Docx tables generated.')

    if RUN_DOCX_OUTPUT_EXAMPLES:
        # Build styles comparison
        for style in [
            # 'Table Normal',
            'Colorful Grid',
            'Colorful Grid Accent 1',
            'Colorful Grid Accent 2',
            'Colorful Grid Accent 3',
            'Colorful Grid Accent 4',
            'Colorful Grid Accent 5',
            'Colorful Grid Accent 6',
            'Colorful List',
            'Colorful List Accent 1',
            'Colorful List Accent 2',
            'Colorful List Accent 3',
            'Colorful List Accent 4',
            'Colorful List Accent 5',
            'Colorful List Accent 6',
            'Colorful Shading',
            'Colorful Shading Accent 1',
            'Colorful Shading Accent 2',
            'Colorful Shading Accent 3',
            'Colorful Shading Accent 4',
            'Colorful Shading Accent 5',
            'Colorful Shading Accent 6',
            'Dark List',
            'Dark List Accent 1',
            'Dark List Accent 2',
            'Dark List Accent 3',
            'Dark List Accent 4',
            'Dark List Accent 5',
            'Dark List Accent 6',
            'Light Grid',
            'Light Grid Accent 1',
            'Light Grid Accent 2',
            'Light Grid Accent 3',
            'Light Grid Accent 4',
            'Light Grid Accent 5',
            'Light Grid Accent 6',
            'Light List',
            'Light List Accent 1',
            'Light List Accent 2',
            'Light List Accent 3',
            'Light List Accent 4',
            'Light List Accent 5',
            'Light List Accent 6',
            'Light Shading',
            'Light Shading Accent 1',
            'Light Shading Accent 2',
            'Light Shading Accent 3',
            'Light Shading Accent 4',
            'Light Shading Accent 5',
            'Light Shading Accent 6',
            'Medium Grid 1',
            'Medium Grid 1 Accent 1',
            'Medium Grid 1 Accent 2',
            'Medium Grid 1 Accent 3',
            'Medium Grid 1 Accent 4',
            'Medium Grid 1 Accent 5',
            'Medium Grid 1 Accent 6',
            'Medium Grid 2',
            'Medium Grid 2 Accent 1',
            'Medium Grid 2 Accent 2',
            'Medium Grid 2 Accent 3',
            'Medium Grid 2 Accent 4',
            'Medium Grid 2 Accent 5',
            'Medium Grid 2 Accent 6',
            'Medium Grid 3',
            'Medium Grid 3 Accent 1',
            'Medium Grid 3 Accent 2',
            'Medium Grid 3 Accent 3',
            'Medium Grid 3 Accent 4',
            'Medium Grid 3 Accent 5',
            'Medium Grid 3 Accent 6',
            'Medium List 1',
            'Medium List 1 Accent 1',
            'Medium List 1 Accent 2',
            'Medium List 1 Accent 3',
            'Medium List 1 Accent 4',
            'Medium List 1 Accent 5',
            'Medium List 1 Accent 6',
            'Medium List 2',
            'Medium List 2 Accent 1',
            'Medium List 2 Accent 2',
            'Medium List 2 Accent 3',
            'Medium List 2 Accent 4',
            'Medium List 2 Accent 5',
            'Medium List 2 Accent 6',
            'Medium Shading 1',
            'Medium Shading 1 Accent 1',
            'Medium Shading 1 Accent 2',
            'Medium Shading 1 Accent 3',
            'Medium Shading 1 Accent 4',
            'Medium Shading 1 Accent 5',
            'Medium Shading 1 Accent 6',
            'Medium Shading 2',
            'Medium Shading 2 Accent 1',
            'Medium Shading 2 Accent 2',
            'Medium Shading 2 Accent 3',
            'Medium Shading 2 Accent 4',
            'Medium Shading 2 Accent 5',
            'Medium Shading 2 Accent 6',
        ]:
            if 'Accent 1' in style:
                def_to_table(MODEL_NAME, json_schema, style=style).save(f'docx-styles/schema-{style}.docx')
            else:
                def_to_table(MODEL_NAME, json_schema, style=style).save(f'docx-styles/others/schema-{style}.docx')


if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        prog='Model Parser',
        description='Parses and converts the Excel model to the other needed formats',
    )
    parser.add_argument('-s', '--sheet', required=True, help='The Excel sheet to be parsed.')
    parser.add_argument('-n', '--name', required=True, help='The name to be given to the schema folder/file')
    parser.add_argument('-v', '--version', help='The version number to be used in model. Defaults to today.')
    parser.add_argument('-f', '--filter', default=False, help='If present, only 15-18 fields will be kept')
    args = parser.parse_args()

    run(args.sheet, args.name, args.version, args.filter)
