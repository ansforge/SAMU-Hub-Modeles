package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GeoPosValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("GEO-POS json validation passes")
    void geoPosValidationPasses() throws IOException {
        validationPasses("GEO-POS", false);
    }

//    @Test
//    @DisplayName("GEO-POS xml validation passes")
//    public void xmlGeoPosValidationPasses() throws IOException {
//        validationPasses("GEO-POS", true);
//    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("GEO-POS json validation fails")
    void geoPosValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - geolocalisationPos.positionUpdate[0].coord[0].lat: is missing but it is required",
                " - geolocalisationPos.positionUpdate[0].coord[0].lon: is missing but it is required"
        };
        jsonValidationFails("GEO-POS/GEO-POS-missing-required-fields.json", expectedErrors);
    }

//    @Test
//    @DisplayName("GEO-POS xml validation fails")
//    public void xmlGeoPosValidationFails() throws IOException {
//        xmlValidationFails("GEO-POS/geo-pos-missing-required-fields.xml", XML_MISSING, new String[]{"distributionID}' "});
//    }

    //endregion

}
