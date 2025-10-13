# We will be using the file schemas.yaml as data source to use with gomplate in order to generate all the files
# required for each schema

# Generate config files for each language
for lang in "." "ruby" "python" "csharp" "php"; do
    # generate base generator config files
    gomplate -f "./templates/$lang/schema.generator-config.json.tmpl" -d config=./schemas.yaml

    # generate usecase and wrapper overwrite configs only for Java
    if [ "$lang" == "." ]; then
        # generate usecase config files  
        gomplate -f "./templates/$lang/schema.usecase.generator-config.json.tmpl" -d config=./schemas.yaml

        # generate wrapper config files
        gomplate -f "./templates/$lang/schema.wrapper.generator-config.json.tmpl" -d config=./schemas.yaml
    fi
done

# generate ContentMessage class
gomplate -f ./templates/ContentMessage.java.tmpl -d config=./schemas.yaml -o ./output/edxl/ContentMessage.java

# generate EDXL-DE json schema
gomplate -f ./templates/EDXL-DE-full.schema.json.tmpl -d config=./schemas.yaml -o ./output/json-schema/EDXL-DE-full.schema.json

# generate RC-XML-ContentType xsd schema
gomplate -f ./templates/RC-XML-ContentType.xsd.tmpl -d config=./schemas.yaml -o ./output/xsd/RC-XML-ContentType.xsd
