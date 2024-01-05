import os
import csv_parser

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
}]


def parser_and_mv():
    for schema in schemas:
        # Run csv_parser
        csv_parser.run(schema['sheet'], schema['name'], None, schema['filter'])
        # Move output files
        name = schema['name']
        os.rename(f"./out/{name}/{name}.openapi.yaml", f"../generator/input/{name}.openapi.yaml")
        os.rename(f"./out/{name}/{name}.schema.json", f"../src/main/resources/json-schema/{name}.schema.json")


def main():
    parser = argparse.ArgumentParser(
        prog='Workflow Automator',
        description='Automates the build workflow for the model (specs, schemas, ...)',
    )
    parser.add_argument('-s', '--stage', required=True, choices=['parser_and_mv', ''], help='The wokflow stage to run')
    args = parser.parse_args()

    if args.stage == 'parser_and_mv':
        parser_and_mv()
    elif args.stage == '':
        run(args.sheet, args.name, args.version, args.filter)
    else:
        exit(1)