/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
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
package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CustomContentValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("Custom Content json validation passes")
    public void jsonCustomContentValidationPasses() throws IOException {
        validationPasses("EDXL-DE", false);
    }

    @Test
    @DisplayName("Custom Content xml validation passes")
    public void xmlCustomContentValidationPasses() throws IOException {
        validationPasses("EDXL-DE", true);
    }
    //endregion
}
