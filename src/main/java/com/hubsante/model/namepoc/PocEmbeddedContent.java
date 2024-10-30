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
package com.hubsante.model.namepoc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PocEmbeddedContent {

    @JsonDeserialize(using = PocContentMessageDeserializer.class)
    private PocContentMessage useCaseMessage;

    public PocEmbeddedContent() {
    }

    public PocEmbeddedContent(PocContentMessage useCaseMessage) {
        this.useCaseMessage = useCaseMessage;
    }

    public <T extends PocContentMessage> T getMessage() {
        return (T) useCaseMessage;
    }

    public <T extends PocContentMessage> void setMessage(T message) {
        this.useCaseMessage = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PocEmbeddedContent that = (PocEmbeddedContent) o;
        return Objects.equals(useCaseMessage, that.useCaseMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(useCaseMessage);
    }


    /*
    * I had to override this toString method to avoid null values
     */
    @Override
    public String toString() {
        String embeddedContent = new StringBuilder()
                .append(useCaseMessage != null ? "inner message=" + useCaseMessage.toString() : "")
                .toString();

        return "EmbeddedContent{" +
                embeddedContent +
                '}';
    }
}
