package json_schema2xsd;

import com.ethlo.jsons2xsd.Config;
import com.ethlo.jsons2xsd.Jsons2Xsd;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {
        for (String schema : Arrays.asList("EMSI", "RC-DE", "RC-EDA", "RC-REF", "RS-EDA", "RS-INFO", "GEO-RES", "GEO-REQ", "GEO-POS", "RS-ERROR", "RS-RI",
        "RS-DR", "RS-RR", "RPIS", "RS-EDA-MAJ", "RS-SR", "TECHNICAL")) {
            // Specify the path to your JSON schema file
            String jsonSchemaResourcePath = "/" + schema + ".schema.json";

            // Specify the path to save the generated XSD file
            String xsdFilePath = "out" + jsonSchemaResourcePath.replace(".schema.json", ".xsd");

            // Create a Config object to customize the conversion
            Config config = new Config.Builder()
                    .targetNamespace(getTargetNamespace(schema))
                    .unwrapArrays(true)
                    .createRootElement(true)
                    .name(getRootElementNameFromSchema(schema))
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
                e.printStackTrace();
            }
        }
    }

    private static String getTargetNamespace(String schema) {
        if (schema.equalsIgnoreCase("RC-DE")) {
            return "urn:emergency:cisu:2.0";
        } else return "urn:emergency:cisu:2.0:" + getRootElementNameFromSchema(schema);
    }

    private static String getRootElementNameFromSchema(String schema) {
        String root;
        switch (schema) {
            case "EMSI":
                root = "emsi";
                break;
            case "RC-DE":
                root = "distributionElement";
                break;
            case "RC-REF":
                root = "reference";
                break;
            case "RC-EDA":
                root = "createCase";
                break;
            case "RS-EDA":
                root = "createCaseHealth";
                break;
            case "RS-INFO":
                root = "info";
                break;
            case "GEO-RES":
                root = "geoResourcesDetails";
                break;
            case "GEO-REQ":
                root = "geoResourcesRequest";
                break;
            case "GEO-POS":
                root = "geoPositionsUpdate";
                break;
            case "RS-ERROR":
                root = "error";
                break;
            case "RS-RI":
                root = "resourcesInfo";
                break;
            case "RS-DR":
                root = "resourcesRequest";
                break;
            case "RS-RR":
                root = "resourcesResponse";
                break;
            case "RPIS":
                root = "rpis";
                break;
            case "TECHNICAL":
                root = "technical";
                break;
            case "RS-EDA-MAJ":
                root = "createCaseHealthUpdate";
                break;
            case "RS-SR":
                root = "resourcesStatus";
                break;
            default:
                root = "";
        }
        return root;
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

