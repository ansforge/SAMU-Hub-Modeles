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
package com.hubsante.modelsinterface.edxl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hubsante.modelsinterface.report.ErrorWrapper;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(ErrorWrapper.class),
})
public class ContentMessageBase {

    /** This equals override is used to avoid breaking the equals override in the messages without RC-DE headers
     * (in particular ErrorWrapper), as without the override the equality check would only pass when comparing
     * an object to itself, and we care about the actual values.
     **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    // As this class has no fields, the hashcode is always 0
    @Override
    public int hashCode() {
        return 0;
    }

    public static class UseCaseHelper {
        public static final Map<String,String> useCases = Stream.of(new String[][] {
                {"error", ErrorWrapper.class.getCanonicalName()},
        }).collect(Collectors.toMap(useCaseData -> useCaseData[0], useCaseData -> useCaseData[1]));
    }
}
