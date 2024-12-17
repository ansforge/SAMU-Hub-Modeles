package json_schema2xsd;

import com.ethlo.jsons2xsd.Config;
import com.ethlo.jsons2xsd.Jsons2Xsd;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.yaml.snakeyaml.Yaml;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class.getName());
        List<String> regexErrors = new ArrayList<>();
        
        //Get the schemas.yaml file from resource folder
        InputStream schemaStream = App.class.getResourceAsStream("/schemas.yaml");
        assert schemaStream != null;
        InputStreamReader schemaReader = new InputStreamReader(schemaStream);
        Map<String, List<HashMap<String,String>>> yamlMap = new HashMap<>();
        try (Reader reader = new BufferedReader(schemaReader)) {
            Yaml yaml = new Yaml();
            yamlMap = yaml.load(reader);
        } catch (IOException e) {
            logger.severe("Error while reading schemas.yaml: " + e);
            System.exit(1);
        }
        List<HashMap<String,String>> schemas = yamlMap.get("schemas");
        
        for (HashMap<String, String> schemaConfigMap : schemas) {
            // If automaticGeneration is set to 'N', skip the schema
            if (schemaConfigMap.containsKey("automaticGeneration") && schemaConfigMap.get("automaticGeneration").equals("N")) {
                continue;
            }
            String schema = schemaConfigMap.get("schema");
            // Specify the path to your JSON schema file
            String jsonSchemaResourcePath = "/" + schema + ".schema.json";

            // Specify the path to save the generated XSD file
            String xsdFilePath = "out" + jsonSchemaResourcePath.replace(".schema.json", ".xsd");

            // Create a Config object to customize the conversion
            Config config = new Config.Builder()
                    .targetNamespace(getTargetNamespace(schemaConfigMap))
                    .unwrapArrays(true)
                    .createRootElement(true)
                    .name(schemaConfigMap.get("rootElement"))
                    .build();

            try {
                System.out.println(jsonSchemaResourcePath);
                // Read the JSON schema from the classpath resources
                InputStream jsonSchemaStream = App.class.getResourceAsStream(jsonSchemaResourcePath);

                // Create a Reader from the InputStream
                InputStreamReader reader = new InputStreamReader(jsonSchemaStream);

                // Convert enum arrays in simple enums (see convertEnumArraysToSImpleEnum method javadoc below)
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(reader);
                List<String> convertedEnums = new ArrayList<>();
                convertEnumArraysToSimpleEnum(jsonNode, "", convertedEnums);

                try {
                    // Convert regex values to be compatible with XML schema 
                    // by removing ^ and $ characters from the beginning and end of the string
                    convertRegexValues(jsonNode);
                } catch (RuntimeException e) {
                    regexErrors.add("Error converting regex values in schema " + schema + ": " + e.getMessage());
                }
                
                // Create converted reader
                byte[] bytes = mapper.writeValueAsBytes(jsonNode);
                InputStream converted = new ByteArrayInputStream(bytes);
                InputStreamReader cvReader = new InputStreamReader(converted);

                // Convert the JSON schema to an XML schema
                Document xmlSchemaDoc = Jsons2Xsd.convert(cvReader, config);

                // if xmlSchema contains element, rewrite them.
                AtomicInteger counter = new AtomicInteger(0);
                revertEnumArraysConversion(xmlSchemaDoc.getDocumentElement(), convertedEnums, counter);

                if (counter.get() != convertedEnums.size()) {
                    throw new RuntimeException(getEnumConversionErrorMessage(convertedEnums));
                } else {
                    System.out.println("[Info] Parsed " + counter.get() + " arrays of Enum.");
                }

                // Convert the Document to a String
                String xmlSchema = documentToString(xmlSchemaDoc);

                // Write the generated XML schema to a file
                writeDocumentToFile(xmlSchemaDoc, xsdFilePath);
            } catch (Exception e) {
                logger.severe("Error while attempting to process schema " + schema + ": " + e );
                System.exit(1);
            }
        }
        if (!regexErrors.isEmpty()) {
            for (String error : regexErrors) {
                logger.severe(error);
            }
            System.exit(1);
        }
    }

    private static void convertRegexValues(JsonNode node) {
        if (!node.isObject()) {
            return;
        }

        if (node.has("pattern")) {
            String pattern = node.get("pattern").asText();
            if (pattern.startsWith("^") && pattern.endsWith("$")) {
                ((ObjectNode) node).put("pattern", pattern.substring(1, pattern.length() - 1));
            } else {
                // Patterns should always start with ^ and end with $, so if they don't, the model
                // is incorrectly defined
                throw new RuntimeException(node.get("title") + ": RegEx patterns should start with ^ and end with $.");
            }
        }

        for (Iterator<Map.Entry<String, JsonNode>> fields = node.fields(); fields.hasNext(); ) {
            Map.Entry<String, JsonNode> entry = fields.next();
            convertRegexValues(entry.getValue());
        }
    }
    
    private static String getTargetNamespace(HashMap<String, String> schema) {
        if (schema.get("schema").equals("RC-DE")) {
            return "urn:emergency:cisu:3.0";
        } else return "urn:emergency:" + (schema.get("xmlns") != null ? schema.get("xmlns") : "cisu:3.0:"+schema.get("schema"));
    }

    /*
     * This is an awful hack to skirt a missing feature on the underlying library (ethlo json2xsd),
     * which can not handle array of enum based strings.
     *
     * This leads to a misformatted xsd which can not be taken in charge of by the validators, with an unexistent type "enum".
     * The output we need is exactly the same as a regular enum, which the ethlo lib can manage perfectly, with only an additional attribute
     * maxOccurs="unbounded" and the validation works fine.
     *
     * So at this point we dynamically rewrite the Json Tree to artificially convert enum arrays to simple enums, and log the property name to add
     * this attribute.
     *
     * We should eventually handle this latest step automatically
     */
    public static void convertEnumArraysToSimpleEnum(JsonNode node, String propertyName, List<String> convertedEnums) {
        if (!node.isObject()) {
            return;
        }

        if (node.has("type") && node.get("type").asText().equals("array") &&
                node.get("items").has("enum")) {
            JsonNode itemsNode = node.get("items");
            ObjectNode objectNode = (ObjectNode) node;
            // objectNode.removeAll();
            objectNode.setAll((ObjectNode) itemsNode);
            ((ObjectNode) node).setAll(objectNode);

            // add property name of converted enum for later treatment
            convertedEnums.add(propertyName);
        }

        // Recursion. We pass the convertedEnums list to the lower level to supplement it at each step
        for (Iterator<Map.Entry<String, JsonNode>> fields = node.fields(); fields.hasNext(); ) {
            Map.Entry<String, JsonNode> entry = fields.next();
            convertEnumArraysToSimpleEnum(entry.getValue(), entry.getKey(), convertedEnums);
        }

    }

    public static void revertEnumArraysConversion(Element element, List<String> propertyNames, AtomicInteger counter) {
        // We search for the "name" attribute of the Element, which is the property name for us, because in the generated xsd the element Name will be "element",
        // "complexType", "sequence", etc. -> XML schema tags
        String elementName = element.getAttribute("name");

        // If condition is met, we set it back to an array type
        if (propertyNames.contains(elementName)) {
            element.setAttribute("maxOccurs", "unbounded");
            counter.incrementAndGet();
        }

        // We perform it recursively
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i) instanceof Element) {
                revertEnumArraysConversion((Element) element.getChildNodes().item(i), propertyNames, counter);
            }
        }
    }

    // Helper method to convert a DOM Document to a String
    private static String documentToString(Document document) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        return writer.getBuffer().toString();
    }

    // Helper method to write a DOM Document to a file
    private static void writeDocumentToFile(Document document, String filePath) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // https://www.w3docs.com/snippets/java/how-to-pretty-print-xml-from-java.html
        FileOutputStream outputStream = new FileOutputStream(filePath);
        transformer.transform(new DOMSource(document), new StreamResult(outputStream));
        outputStream.close();
    }

    private static String getEnumConversionErrorMessage(List<String> enums) {
        StringBuilder sb = new StringBuilder()
                .append("The number of reverted enum arrays is inconsistent with the number of converted ones.\n")
                .append("Please check these names aren't use somewhere else in the schema for a non 'array of Enum' item.\n")
                .append("List of converted arrays:\n\n");
        enums.forEach(sb::append);
        return sb.toString();
    }
}

