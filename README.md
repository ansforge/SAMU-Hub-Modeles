>**WARNING**
\
>**This generator still needs additional configuration to work properly from end to end.
> At this point, we don't know if it will be possible at all.
> The current version does 90% of the work though.
> \
> \
> Here are the key points to keep in mind :
> \
> \
> 1- For an unknown reason, the generator can't handle nested arrays of referenced schemas. It produces array of Java Object instead of Array of the referenced object.
> \
> \
> I had to rework files for that.
> \
> \
> 2- There is an element in location-type.xsd which is named "public", which is a reserved named in Java. I needed to prefix it with an underscore ("_") in the generated class.
> \
> \
> 3- There are inconsistencies in the interpretation of properties marked as *dates*: 
> \
> dates defined at the root af a schema are generated as dates, but those coming from the "allOf" instruction are set as Strings.
> \
> \
> We intend to test the behavior of the OpenAPI generator to avoid these side effects.**

## Model generation
Based on [AsyncAPI's Modelina](https://github.com/asyncapi/modelina), this generates the data class based on the AsyncAPI schemas.

We first use the Oxygen XML Editor *XSD to JSON Schema Converter* to generate a json-schema [cisu.json](./cisu.json).

Then we embed it in the *components/schemas* section of the AsyncAPI descriptor [hubsante.asyncapi.yaml](./hubsante.asyncapi.yaml).

The npm script below will use the AsyncAPI descriptor as a source for the *Modelina* generator.

### Install
Once in this folder, run `npm i`

### Run
```
# To build the models in the `generated/` folder
npm run generate

# To build the models and copy them to the Hub Santé
npm run generate4Hub
```