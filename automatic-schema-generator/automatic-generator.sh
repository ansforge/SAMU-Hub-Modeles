# We will be using the file schemas.yaml as data source to use with gomplate in order to generate all the files
# required for each schema

# Run the script to generate base generator config files
gomplate -f ./templates/schema.generator-config.json.tmpl -d config=./schemas.yaml -o ./output

# Run the script to generate usecase config files
gomplate -f ./templates/schema.usecase.generator-config.json.tmpl -d config=./schemas.yaml -o ./output

# Run the script to generate wrapper config files
gomplate -f ./templates/schema.wrapper.generator-config.json.tmpl -d config=./schemas.yaml -o ./output
