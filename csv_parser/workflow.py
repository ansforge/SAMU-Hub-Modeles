import argparse
import os
import shutil
import yaml
import pandas as pd

import csv_parser
import test_case_generator

# ---------------------------------------- ARGS CONFIGURATION
parser = argparse.ArgumentParser(
    prog='Workflow Automator',
    description='Automates the build workflow for the model (specs, schemas, ...)',
)
parser.add_argument('-s', '--stage', required=True, choices=['parser_and_mv', 'test_case_parser'],
                    help='The workflow stage to run')
args = parser.parse_args()

print(args.stage)

# ---------------------------------------- SCHEMAS CONFIGURATION
sheets = [
    'RC-EDA',
    'EMSI',
    'GEO-POS',
    'GEO-REQ',
    'GEO-RES',
    'RC-REF',
    'RS-ERROR',
    'RS-INFO',
    'RS-RI',
    'RS-DR',
    'RS-RR',
    'RS-BPV',
    'customContent'
    'RS-SR'
]

perimeters = [{
    'name': 'Périmetre 15-15',
    'file': 'test-cases-15-15'
}]


# ---------------------------------------- STAGE FUNCTIONS
def parser_and_mv():
    # Iterate over each sheet
    for sheet in sheets:
        full_df = None
        filepath = None
        # Iterate over files in models folder
        for file in os.listdir('models'):
            # If we can't find the sheet, we look in the next file, if we can't find it anywhere, we throw
            try:
                # Load the excel file
                full_df = pd.read_excel(f'./models/{file}', header=None, sheet_name=sheet)
                filepath = f'models/{file}'
                break
            except ValueError:
                continue

        if full_df is None:
            print(f"Error: Sheet {sheet} not found in any file in the models folder.")
            print(f"Files checked: {os.listdir('models')}")
            exit(1)

        # For each sheet we read the A1 cell and get the list of schemas to generate
        if not pd.isna(full_df.iloc[0, 0]):
            schemas_array = full_df.iloc[0, 0].split(' ')

            # Schemas are formatted in the sheet as follows:
            # "schema1['name']:schema1['filter']:schema1['modelType'] schema2['name']:schema2['filter']:schema2['modelType'] ..."
            try:
                schemas = [
                    {'name': schemas_array[i].split(':')[0], 'sheet': sheet, 'filter': schemas_array[i].split(':')[1],
                     'model_type': schemas_array[i].split(':')[2]}
                    for i in range(len(schemas_array))]
            except IndexError:
                print(f"Error in sheet {sheet}: schema list (cell A2) is not well formatted. "
                      f"Should be 'name:filter:modelType' separated by a space. "
                      f"Ex: 'RC-EDA:15-18:createCase RS-EDA:15-15:createCaseHealth'. "
                      f"It was: '{full_df.iloc[1, 0]}'")
                exit(1)
        else:
            print(f"Error in sheet {sheet}: schema list (cell A1) is empty. "
                  f"Should be 'name:filter:modelType' separated by a space. "
                  f"Ex: 'RC-EDA:15-18:createCase RS-EDA:15-15:createCaseHealth'.")
            exit(1)

        for schema in schemas:
            # Run csv_parser
            csv_parser.run(schema['sheet'], schema['name'], None, schema['filter'], schema['model_type'], filepath)

            name = schema['name']
            # Copy schema to JsonSchema2XSD project
            shutil.copyfile(f"./out/{name}/{name}.schema.json",
                            f"./json_schema2xsd/src/main/resources/{name}.schema.json")
            # Move output files => should be in .gitignore
            if os.path.exists(f"../generator/input/{name}.openapi.yaml"):
                os.remove(f"../generator/input/{name}.openapi.yaml")
            os.rename(f"./out/{name}/{name}.openapi.yaml", f"../generator/input/{name}.openapi.yaml")
            if os.path.exists(f"../src/main/resources/json-schema/{name}.schema.json"):
                os.remove(f"../src/main/resources/json-schema/{name}.schema.json")
            os.rename(f"./out/{name}/{name}.schema.json", f"../src/main/resources/json-schema/{name}.schema.json")

        with open(f'out/hubsante.asyncapi.yaml', 'w') as file:
            documents = yaml.dump(csv_parser.full_asyncapi, sort_keys=False)
            documents = documents.replace('#/definitions/', "#/components/schemas/")
            file.write(documents)
        print('AsyncAPI schema generated.')


def test_case_parser():
    # Generate test-cases.json
    test_case_generator.run(perimeters)


# ---------------------------------------- RUN
if args.stage == 'parser_and_mv':
    parser_and_mv()
elif args.stage == 'test_case_parser':
    test_case_parser()
else:
    exit(1)
