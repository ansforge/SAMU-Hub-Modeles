# We will be using the file schemas.yaml as data source to use with gomplate in order to generate all the files
# required for each schema

# generate base generator config files
gomplate -f ./templates/schema.generator-config.json.tmpl -d config=./schemas.yaml -o ./output/generator/config

# generate usecase config files
gomplate -f ./templates/schema.usecase.generator-config.json.tmpl -d config=./schemas.yaml -o ./output/generator/config

# generate wrapper config files
gomplate -f ./templates/schema.wrapper.generator-config.json.tmpl -d config=./schemas.yaml -o ./output/generator/config

# generate ContentMessage class
gomplate -f ./templates/ContentMessage.java.tmpl -d config=./schemas.yaml -o ./output/edxl/ContentMessage.java

# generate EDXL-DE json schema
gomplate -f ./templates/EDXL-DE-full.schema.json.tmpl -d config=./schemas.yaml -o ./output/json-schema/EDXL-DE-full.schema.json

# generate RC-XML-ContentType xsd schema
gomplate -f ./templates/RC-XML-ContentType.xsd.tmpl -d config=./schemas.yaml -o ./output/xsd/RC-XML-ContentType.xsd
