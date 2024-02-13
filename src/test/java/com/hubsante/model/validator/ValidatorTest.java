package com.hubsante.model.validator;

import com.hubsante.model.TestMessagesHelper;
import com.hubsante.model.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.*;
import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static com.hubsante.model.utils.EdxlWrapperUtils.wrapUseCaseMessage;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class ValidatorTest extends AbstractValidatorTest {

    @Test
    @DisplayName("invalid content valid envelope")
    public void invalidContentValidEnvelopeTest() throws IOException {
        String json = getInvalidMessage("RC-EDA/invalid-RC-EDA-valid-EDXL.json");

        // envelope validation does not throw because envelope is ok
        assertDoesNotThrow(() -> validator.validateJSON(json, ENVELOPE_SCHEMA));
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        String xml = getInvalidMessage("RC-EDA/invalid-RC-EDA-valid-EDXL.xml");
        // envelope validation does not throw because envelope is ok
        assertDoesNotThrow(() -> validator.validateXML(xml, ENVELOPE_XSD));
        assertThrows(ValidationException.class, () -> validator.validateXML(xml, FULL_XSD));
    }

    @Test
    @DisplayName("too many valid schemas")
    void tooManyValidSchemas() throws IOException {
        String json = getInvalidMessage("too-many-valid-schemas.json");

        // validation throws due to presence of both createcase and emsi schemas
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, TOO_MANY_SCHEMAS);
        }
    }

    @Test
    @DisplayName("no schemas detected")
    void noSchemasDetected() throws IOException {
        String json = getInvalidMessage("RC-EDA/invalid-RC-EDA-no-schemas.json");

        // validation throws due to absence of schemas
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, NO_SCHEMAS);
        }
    }

    @Test
    @DisplayName("all examples files passing")
    public void examplesBundlePassingTest() {
        String rootFolder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();
        File[] subFolders = new File(rootFolder).listFiles();
        assert subFolders != null;
        List<File> exampleFiles = new ArrayList<>();

        Arrays.stream(subFolders).forEach(folder -> exampleFiles.addAll(Arrays.asList(Objects.requireNonNull(folder.listFiles()))));

        AtomicBoolean allPass = new AtomicBoolean(true);

        exampleFiles.forEach(file -> {
            try {
                String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                String fullJson = wrapUseCaseMessage(useCaseJson);

                validator.validateJSON(fullJson, FULL_SCHEMA);
                log.info("File {} is valid against schema", file.getName());

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ValidationException e) {
                allPass.set(false);
                log.error("File " + file.getName() + " is not valid against schema: " + e.getMessage());
            }
        });

        if (!allPass.get()) {
            fail("Some files are not valid against schema");
        }
    }
}
