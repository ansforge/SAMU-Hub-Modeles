package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GeoResValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("GEO-RES json validation passes")
    void GeoResValidationPasses() throws IOException {
        validationPasses("GEO-RES", false);
    }

//    @Test
//    @DisplayName("GEO-RES xml validation passes")
//    public void xmlGeoResValidationPasses() throws IOException {
//        validationPasses("GEO-RES", true);
//    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("GEO-RES json validation fails")
    void GeoResValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - geolocalisationRes.resourceDetails[0].id: is missing but it is required"
        };
        jsonValidationFails("GEO-RES/GEO-RES-missing-required-fields.json", expectedErrors);
    }

//    @Test
//    @DisplayName("GEO-RES xml validation fails")
//    public void xmlGeoResValidationFails() throws IOException {
//        xmlValidationFails("GEO-RES/GEO-RES-missing-required-fields.xml", XML_MISSING, new String[]{"distributionID}' "});
//    }

    //endregion

}
