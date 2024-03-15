package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GeoReqValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("GEO-REQ json validation passes")
    void GeoReqValidationPasses() throws IOException {
        validationPasses("GEO-REQ", false);
    }

//    @Test
//    @DisplayName("GEO-REQ xml validation passes")
//    public void xmlGeoReqValidationPasses() throws IOException {
//        validationPasses("GEO-REQ", true);
//    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("GEO-REQ json validation fails")
    void GeoReqValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - geolocalisationReq.resourceRequest_error: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("GEO-REQ/GEO-REQ-missing-required-fields.json", expectedErrors);
    }

//    @Test
//    @DisplayName("GEO-REQ xml validation fails")
//    public void xmlGeoReqValidationFails() throws IOException {
//        xmlValidationFails("GEO-REQ/GEO-REQ-missing-required-fields.xml", XML_MISSING, new String[]{"distributionID}' "});
//    }

    //endregion

}
