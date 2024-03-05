import argparse
import os
import shutil
import yaml

import csv_parser

# ---------------------------------------- ARGS CONFIGURATION
parser = argparse.ArgumentParser(
    prog='Workflow Automator',
    description='Automates the build workflow for the model (specs, schemas, ...)',
)
parser.add_argument('-s', '--stage', required=True, choices=['parser_and_mv', ''], help='The wokflow stage to run')
args = parser.parse_args()

print(args.stage)

# ---------------------------------------- SCHEMAS CONFIGURATION
schemas = [{
    'name': 'RC-EDA',
    'sheet': 'RC-EDA',
    'filter': True
}, {
    'name': 'RS-EDA',
    'sheet': 'RC-EDA',
    'filter': False
}, {
    'name': 'EMSI',
    'sheet': 'EMSI',
    'filter': False
}, {
    'name': 'GEO-POS',
    'sheet': 'GEO-POS',
    'filter': False
}, {
    'name': 'GEO-REQ',
    'sheet': 'GEO-REQ',
    'filter': False
}, {
    'name': 'GEO-RES',
    'sheet': 'GEO-RES',
    'filter': False
}]


# ---------------------------------------- STAGE FUNCTIONS
def parser_and_mv():
    for schema in schemas:
        # Run csv_parser
        csv_parser.run(schema['sheet'], schema['name'], None, schema['filter'])

        name = schema['name']
        # Copy schema to JsonSchema2XSD project
        shutil.copyfile(f"./out/{name}/{name}.schema.json", f"./json_schema2xsd/src/main/resources/{name}.schema.json")
        # Move output files
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

# ---------------------------------------- RUN
if args.stage == 'parser_and_mv':
    parser_and_mv()
else:
    exit(1)
