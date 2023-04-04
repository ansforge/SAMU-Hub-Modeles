const yaml = require('js-yaml');
const fs = require('fs')
const JavaGenerator = require('@asyncapi/modelina').JavaGenerator;
const JAVA_DESCRIPTION_PRESET = require('@asyncapi/modelina').JAVA_DESCRIPTION_PRESET;
const JAVA_COMMON_PRESET = require('@asyncapi/modelina').JAVA_COMMON_PRESET;
const JAVA_CONSTRAINTS_PRESET = require('@asyncapi/modelina').JAVA_CONSTRAINTS_PRESET;
const JAVA_JACKSON_PRESET = require('@asyncapi/modelina').JAVA_JACKSON_PRESET;

const ENVELOPE_CLASS = "MessageEnvelope";

const asyncApiSchema = yaml.load(
    fs.readFileSync('../dispatcher/src/main/resources/hubsante.asyncapi.yaml', 'utf8')
);

// ToDo(bbo): see if it is really needed.
// If it is, is there is a better way to do that (especially: does it work for nested structure)?
// TypeScript implem https://github.com/asyncapi/modelina/blob/ed8d3feca60e5af7c97c7c7b5784256ccca20047/src/generators/typescript/renderers/ClassRenderer.ts#L55
/**
 * Adds an empty and a complete constructor to the class
 */
const constructorBuilder = {
    class: {
        ctor(elem) {
            const properties = [];
            for (const [name, property] of Object.entries(elem.model.properties)) {
                // @ts-ignore
                properties[name] = property.property.type;
            }

            return `public ${elem.model.name}(){\n}\n
public ${elem.model.name}(
  ${Object.entries(properties).map(([name, type], i) => `${type} ${name}`).join(", ")}
) {
${Object.keys(properties).map(prop => `\tthis.${prop} = ${prop};`).join("\n")}
}`;
        },
    }
};

/**
 * Makes message class extend the Envelope class
 */
const interfaceBuilder = {
    class: {
        self({content, model}) {
            if (model.name === ENVELOPE_CLASS) {
                return content;
            }
            return content.replace(
                `public class ${model.name} {`,
                `public class ${model.name} extends ${ENVELOPE_CLASS} {`,
            );
        },
    }
};

const generator = new JavaGenerator({
    collectionType: "Array",
    presets: [
        {
            preset: JAVA_COMMON_PRESET,
            options: {
                equals: true,
                hashCode: true,
                classToString: true,
            }
        },
        JAVA_CONSTRAINTS_PRESET,
        JAVA_JACKSON_PRESET,
        JAVA_DESCRIPTION_PRESET,
        constructorBuilder,
        interfaceBuilder,
    ]
});

async function generate() {
    const models = await generator.generate(asyncApiSchema);
    for (const model of models) {
        buildJavaFile(model);
    }
}

function buildJavaFile(model) {
    // console.log(model);
    fs.writeFileSync(
        `generated/java/${model.modelName}.java`,
        `package com.hubsante.message;
              \n${model.dependencies.join("\n")}
              \n${model.result}`
    );
}

generate().then(
    () => console.log('Generation done ✨')
);
