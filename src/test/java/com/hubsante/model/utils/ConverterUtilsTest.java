/**
 * Copyright © 2023-2026 Agence du Numerique en Sante (ANS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubsante.model.utils;

import com.hubsante.model.EdxlHandler;
import com.hubsante.model.TestMessagesHelper;
import com.hubsante.model.edxl.EdxlMessage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessage;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConverterUtilsTest {
    public void isCisuModelUtil(String resourcePath, boolean isCisu) {
        EdxlHandler converter = new EdxlHandler();

        String rootFolder = TestMessagesHelper.class.getClassLoader().getResource(resourcePath).getFile();
        File[] subFiles = new File(rootFolder).listFiles(File::isDirectory);
        List<File> exampleFiles = new ArrayList<>();

        assert subFiles != null;
        Arrays.stream(subFiles).forEach(file -> {
            exampleFiles.addAll(Arrays.asList(Objects.requireNonNull(file.listFiles())));
        });

        exampleFiles.forEach(file -> {
            try {
                if (file.getName().endsWith(".json")) {
                    String jsonUseCase = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                    String fullMessage = wrapUseCaseMessage(jsonUseCase);
                    EdxlMessage message = converter.deserializeJsonEDXL(fullMessage);

                    Assertions.assertEquals(ConverterUtils.isCisuModel(message), isCisu);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void testIsCisuModel() throws IOException {
        isCisuModelUtil("sample/examples/RS-EDA", true);
        isCisuModelUtil("sample/examples/RC-EDA", true);
    }

    @Test
    public void testIsNotCisuModel() throws IOException {
        isCisuModelUtil("sample/examples/GEO-POS", false);
        isCisuModelUtil("sample/examples/EMSI", false);
    }
}
