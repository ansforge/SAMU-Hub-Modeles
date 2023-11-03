package com.hubsante.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hubsante.model.edxl.ContentMessage;
import com.hubsante.model.edxl.EdxlMessage;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class EdxlHandler {

//    @Autowired
    private XmlMapper xmlMapper;

//    @Autowired
    private ObjectMapper jsonMapper;

    public EdxlHandler() {
        xmlMapper = (XmlMapper) new XmlMapper()
                .registerModule(new JavaTimeModule())
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

        xmlMapper.configure(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        jsonMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
    }

    public EdxlMessage deserializeJsonEDXL(String json) throws JsonProcessingException {
        return jsonMapper.readValue(json, EdxlMessage.class);
    }

    public ContentMessage deserializeJsonContentMessage(String json) throws JsonProcessingException {
        EdxlMessage edxlMessage = deserializeJsonEDXL(json);
        return edxlMessage.getContent().getContentObject().getContentWrapper()
                .getEmbeddedContent().getMessage();
    }

    public EdxlMessage deserializeXmlEDXL(String xml) throws JsonProcessingException {
        return xmlMapper.readValue(xml, EdxlMessage.class);
    }

    public ContentMessage deserializeXmlContentMessage(String xml) throws JsonProcessingException {
        EdxlMessage edxlMessage = deserializeXmlEDXL(xml);
        return edxlMessage.getContent().getContentObject().getContentWrapper()
                .getEmbeddedContent().getMessage();
    }

    public String serializeJsonEDXL(EdxlMessage edxlMessage) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(edxlMessage);
    }

    public String prettyPrintJsonEDXL(EdxlMessage edxlMessage) throws JsonProcessingException {
        return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(edxlMessage);
    }

    public String serializeXmlEDXL(EdxlMessage edxlMessage) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(edxlMessage);
    }

    public String prettyPrintXmlEDXL(EdxlMessage edxlMessage) throws JsonProcessingException {
        return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(edxlMessage);
    }
}
