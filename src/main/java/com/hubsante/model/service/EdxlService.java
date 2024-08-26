package com.hubsante.model.service;

import com.hubsante.model.edxl.EdxlMessage;
import com.hubsante.model.service.handlers.EdxlHandler;
import com.hubsante.modelsinterface.exception.ValidationException;
import com.hubsante.modelsinterface.interfaces.EdxlMessageInterface;
import com.hubsante.modelsinterface.interfaces.EdxlServiceInterface;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.hubsante.modelsinterface.config.Constants.ENVELOPE_SCHEMA;
import static com.hubsante.modelsinterface.config.Constants.ENVELOPE_XSD;

@Slf4j
public class EdxlService implements EdxlServiceInterface {

    private Validator validator;
    private EdxlHandler edxlHandler;

    @Override
    public String getDistributionIDFromEdxlMessage(String s) throws ValidationException, IOException {
        String distributionID = null;
            if (isJson(s)) {
                validator.validateJSON(s, ENVELOPE_SCHEMA);
                return edxlHandler.deserializeJsonEDXLEnvelope(s).getDistributionID();
            } else {
                validator.validateXML(s, ENVELOPE_XSD);
                return edxlHandler.deserializeXmlEDXLEnvelope(s).getDistributionID();
            }
    }

    private boolean isJson(String message) {
        if (message.startsWith("{") || message.startsWith("[")) {
            return true;
        } else return false;
    }

    @Override
    public String getDescriptorExplicitAddressValue(EdxlMessageInterface edxlMessage) {
        return ((EdxlMessage) edxlMessage).getDescriptor().getExplicitAddress().getExplicitAddressValue();
    }

    @Override
    public String getDescriptorLanguage(EdxlMessageInterface edxlMessageInterface) {
        return "";
    }

    @Override
    public String getDescriptorExplicitAddressScheme(EdxlMessageInterface edxlMessageInterface) {
        return "";
    }
}
