package com.hubsante.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.xml.stream.XMLInputFactory;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static JavaTimeModule createCustomJavaTimeModule() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        javaTimeModule.addSerializer(OffsetDateTime.class,
                new com.fasterxml.jackson.databind.ser.std.StdSerializer<OffsetDateTime>(OffsetDateTime.class) {

                    @Override
                    public void serialize(OffsetDateTime value, com.fasterxml.jackson.core.JsonGenerator gen,
                                          com.fasterxml.jackson.databind.SerializerProvider provider) throws IOException {
                        String formatted = value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
                        // Replace 'Z' with '+00:00' during serialization
                        if (formatted.endsWith("Z")) {
                            formatted = formatted.substring(0, formatted.length() - 1) + "+00:00";
                        }

                        gen.writeString(formatted);
                    }
                }
        );

        return javaTimeModule;
    }

    public static XmlMapper getXmlMapper() {
        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
        inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        inputFactory.setProperty("javax.xml.stream.isSupportingExternalEntities", false);

        XmlMapper xmlMapper = (XmlMapper) new XmlMapper(inputFactory)
                .registerModule(createCustomJavaTimeModule())
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

        xmlMapper.configure(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        return xmlMapper;
    }

    public static ObjectMapper getJsonMapper() {
        ObjectMapper jsonMapper = new ObjectMapper()
                .registerModule(createCustomJavaTimeModule())
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

        return jsonMapper;
    }
}
