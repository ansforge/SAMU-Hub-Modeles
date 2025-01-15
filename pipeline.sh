#!/bin/bash

# This script is used to generate the Java classes from the JSON Schemas and run the tests.
# It is intended to be run in a CI/CD environment, such as GitHub Actions.

set -e

echo "Cleaning up old generated schemas..."
# Clean up old generated schemas
find ./src/main/resources/json-schema -type f -name '*.json' ! -name 'customContent.schema.json' ! -name 'EDXL-DE-*.schema.json' -exec rm {} +

echo "Cleaning up old generated Java classes..."
# Clean up old generated Java classes
find ./src/main/java/com/hubsante/model -mindepth 1 -maxdepth 1 -type d ! -name 'builders' ! -name 'config' ! -name 'custom' ! -name 'edxl' ! -name 'exception' ! -name 'report' -exec rm -r {} +

echo "Running csv_parser to generate schemas.yaml..."
# Run csv_parser to generate schemas.yaml
cd csv_parser
python3 workflow.py --stage output_schemas_yaml

echo "Running csv_parser and collecting OpenAPI & JSON Schemas..."
# Run csv_parser and collect OpenAPI & JSON Schemas
python3 workflow.py --stage parser_and_mv

echo "Running test_case_generator..."
# Run test_case_generator
rm -r ./out/test-cases || true
python3 workflow.py --stage test_case_parser

echo "Collecting schemas.yaml and copying it to json_schema2xsd..."
# Collect schemas.yaml and copy it to json_schema2xsd
cp ./out/schemas.yaml ./json_schema2xsd/src/main/resources/schemas.yaml

echo "Running automatic-schema-generator and moving generated files to corresponding locations..."
# Run automatic-schema-generator and move generated files to corresponding locations
cd ../automatic-schema-generator
rm -r output || true
chmod +x ./automatic-generator.sh
./automatic-generator.sh

rsync -a --remove-source-files output/generator ../generator
rsync -a --remove-source-files output/generator_ruby ../generator_ruby
rsync -a --remove-source-files output/generator_python ../generator_python
rsync -a --remove-source-files output/generator_csharp ../generator_csharp

rsync -a --remove-source-files output/edxl ../src/main/java/com/hubsante/model
rsync -a --remove-source-files output/json-schema ../src/main/resources
rsync -a --remove-source-files output/xsd ../src/main/resources

echo "Generating XSDs..."
# Generate XSDs
cd ../csv_parser/json_schema2xsd
../../gradlew run

echo "Moving XSDs to src..."
# Move XSDs to src
find ../../src/main/resources/xsd -type f -name '*.xsd' ! -name 'EDXL-DE-*.xsd' ! -name 'customContent.xsd' ! -name 'RC-DE.xsd' ! -name 'RC-XML-ContentType.xsd' ! -name 'RS-ERROR.xsd' ! -path '**/other-supporting-schema/*' -exec rm {} +
mv out/*.xsd ../../src/main/resources/xsd/

echo "Removing input JSON Schemas..."
# Remove input JSON Schemas
rm src/main/resources/*.json

echo "Generating Java classes..."
# Generate Java classes
cd ../../generator
find ./config/ -type f | sort -n | while read -r file; do npx @openapitools/openapi-generator-cli generate -c "$file" --skip-validate-spec; done

echo "Replacing src/ with generated classes..."
# Replace src/ with generated classes
cd ..
rm -r ./src/main/java/com/hubsante/model/rcde || true
rm -r ./src/main/java/com/hubsante/model/cisu || true
rm -r ./src/main/java/com/hubsante/model/health || true
rm -r ./src/main/java/com/hubsante/model/emsi || true
rm -r ./src/main/java/com/hubsante/model/geolocation || true
rm -r ./src/main/java/com/hubsante/model/resources || true
rm -r ./src/main/java/com/hubsante/model/rpis || true
rm -r ./src/main/java/com/hubsante/model/technical || true
rm -r ./generator/classes/src/main/java/com/hubsante/model/report/ErrorCode.java || true
cp -r ./generator/classes/src/main/java/com/hubsante/model/* ./src/main/java/com/hubsante/model/

echo "Applying license..."
# Apply license
./gradlew licenseFormat

echo "Deleting old XML files..."
# Delete old XML files
find ./src/main/resources/sample/examples -name "*.xml" -type f -delete

echo "Generating XML files..."
# Generate XML files
./gradlew generateXml

echo "Building and running TECHNICAL tests..."
# Build and run TECHNICAL tests
./gradlew test --info -Ptechnical=true

echo "Building and running REAL MESSAGES tests..."
# Build and run REAL MESSAGES tests
./gradlew test --info

echo "Running ReportGenerator for test coverage..."
# Run ReportGenerator for test coverage
dotnet tool install -g dotnet-reportgenerator-globaltool
reportgenerator -reports:build/reports/jacoco/test/jacocoTestReport.xml -targetdir:coveragereport

echo "Workflow completed successfully."