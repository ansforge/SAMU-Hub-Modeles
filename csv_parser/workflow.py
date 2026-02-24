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
    description='Automates the build workflow for the model (specs, schemas, ... )',
)
parser.add_argument('-s', '--stage', required=True, choices=['parser_and_mv', 'test_case_parser', 'output_schemas_yaml'],
                    help='The workflow stage to run')
args = parser.parse_args()

print(args.stage)

# ---------------------------------------- SCHEMAS CONFIGURATION

perimeters = [{
    'name': '15-15',
    'file': 'test-cases-15-15'
}, {
    'name': '15-SMUR',
    'file': 'test-cases-15-SMUR'
}]


# ---------------------------------------- STAGE FUNCTIONS
def parser_and_mv():
    # Iterate over files in the models folder and extract every sheet name that doesn't start with #
    sheets = []
    for file in os.listdir('models'):
        if file.endswith('.xlsx'):
            sheets += [sheet for sheet in pd.ExcelFile(f'./models/{file}').sheet_names if not sheet.startswith('#')]

    # Load schemas.yaml
    with open('out/schemas.yaml', 'r') as file:
        schemas_yaml = yaml.safe_load(file)
    
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

        # Load the list of schemas to generate for the sheet
        schemas = [{'name': schema['schema'], 'sheet': schema['sheet'], 'filter': schema['perimeter'],
                         'model_type': schema['rootElement']} for schema in schemas_yaml['schemas'] if
                        schema['sheet'] == sheet and schema['file'] == file]

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


def test_case_parser():
    # Generate test-cases.json
    test_case_generator.run(perimeters)

def output_schemas_yaml():
    print("Generating schemas.yaml file...")
    # Iterate over every non-# sheet in the models folder and extract the mini-tables starting at A1 which contain
    # all the necessary schema information; specifically the following fields in the following order:
    # schema, perimeter, rootElement, package, customExtendPackage, customExtendClass, automaticGeneration, subschema
    # header, xmlns
    schemaMap = {'schemas': []}
    for file in os.listdir('models'):
        if file.endswith('.xlsx'):
            for sheet in pd.ExcelFile(f'./models/{file}').sheet_names:
                if not sheet.startswith('#'):
                    full_df = pd.read_excel(f'./models/{file}', header=None, sheet_name=sheet)
                    try:
                        #First, find the cell containing the header 'schema', which denotes the start of the schema details table
                        schemaIndex = None
                        for i in range(full_df.shape[0]):
                            if full_df.iloc[i, 0] == 'schema':
                                schemaIndex = i
                                break
                        #Then, find the width of the schema details table
                        schemaWidth = None
                        for i in range(full_df.shape[1]):
                            if pd.isna(full_df.iloc[schemaIndex, i]):
                                schemaWidth = i
                                break

                        #Then, find the end of the table
                        endIndex = None
                        for i in range(schemaIndex + 1, full_df.shape[0]):
                            if pd.isna(full_df.iloc[i, 0]):
                                endIndex = i
                                break
                    except:
                        print(f"Error in sheet {sheet}: schema details table is not well formatted.")
                        exit(1)
                    #Now that we have the dimensions of the table, we can extract it
                    schemaTable = full_df.iloc[schemaIndex:endIndex, 0:schemaWidth]
                    schemaTable.columns = schemaTable.iloc[0]
                    schemaTable = schemaTable[1:]
                    schemaTable.reset_index(drop=True, inplace=True)

                    #Replace NaN values with null
                    schemaTable = schemaTable.where(pd.notnull(schemaTable), None)

                    schemaTable['file'] = file
                    schemaTable['sheet'] = sheet

                    #Add the dataframes as dicts to the schemaMap['schemas']
                    print("Successfully detected schema table in sheet", sheet)
                    for i in range(schemaTable.shape[0]):
                        schemaMap['schemas'].append(schemaTable.iloc[i].to_dict())
                        print("Added schema to schemaMap:", schemaTable.at[i, 'schema'])

    #Write the schemaMap to a yaml file
    with open('out/schemas.yaml', 'w') as file:
        yaml.dump(schemaMap, file)
    print("schemas.yaml successfully written to file.")



# ---------------------------------------- RUN
if args.stage == 'parser_and_mv':
    parser_and_mv()
elif args.stage == 'test_case_parser':
    test_case_parser()
elif args.stage == 'output_schemas_yaml':
    output_schemas_yaml()
else:
    exit(1)
