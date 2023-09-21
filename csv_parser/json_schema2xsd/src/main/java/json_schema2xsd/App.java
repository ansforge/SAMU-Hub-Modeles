package json_schema2xsd;

import com.ethlo.jsons2xsd.Config;
import com.ethlo.jsons2xsd.Jsons2Xsd;
import org.w3c.dom.Document;

import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import java.io.InputStream;
import java.util.Arrays;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        for (String schema : Arrays.asList("EDXL-DE", "RC-DE", "RC-EDA")) {
            // Specify the path to your JSON schema file
            String jsonSchemaResourcePath = "/" + schema + "_schema.json";

            // Specify the path to save the generated XSD file
            String xsdFilePath = "out" + jsonSchemaResourcePath.replace(".json", ".xsd");

            // Create a Config object to customize the conversion
            Config config = new Config.Builder()
                    .targetNamespace("https://hub.esante.gouv.fr/" + schema + ".xsd")
                    .name(schema)
                    .build();

            try {
                System.out.println(jsonSchemaResourcePath);
                // Read the JSON schema from the classpath resources
                InputStream jsonSchemaStream = App.class.getResourceAsStream(jsonSchemaResourcePath);

                // Create a Reader from the InputStream
                InputStreamReader reader = new InputStreamReader(jsonSchemaStream);

                // Convert the JSON schema to an XML schema
                Document xmlSchemaDoc = Jsons2Xsd.convert(reader, config);

                // Convert the Document to a String
                String xmlSchema = documentToString(xmlSchemaDoc);

                // Write the generated XML schema to a file
                writeDocumentToFile(xmlSchemaDoc, xsdFilePath);
            } catch (Exception e) {
                e.printStackTrace();
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
        FileOutputStream outputStream = new FileOutputStream(filePath);
        transformer.transform(new DOMSource(document), new StreamResult(outputStream));
        outputStream.close();
    }
}

