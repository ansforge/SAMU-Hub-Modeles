/*
 *
 *
 *
 *
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.hubsante.model.cisu;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * RCEDA
 */
@JsonPropertyOrder({
        CreateCaseWrapper.JSON_PROPERTY_CREATE_CASE
})
@JsonTypeName("RC_EDA")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-07T12:09:36.642+01:00[Europe/Paris]")
public class CreateCaseWrapper extends DistributionElement {
    public static final String JSON_PROPERTY_CREATE_CASE = "createCase";
    private CreateCase createCase;

    public CreateCaseWrapper() {
    }

    public CreateCaseWrapper createCase(CreateCase createCase) {

        this.createCase = createCase;
        return this;
    }

    /**
     * Get createCase
     *
     * @return createCase
     **/
    @JsonProperty(JSON_PROPERTY_CREATE_CASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public CreateCase getCreateCase() {
        return createCase;
    }


    @JsonProperty(JSON_PROPERTY_CREATE_CASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreateCase(CreateCase createCase) {
        this.createCase = createCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateCaseWrapper RC_EDA = (CreateCaseWrapper) o;
        return Objects.equals(this.createCase, RC_EDA.createCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createCase);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RCEDA {\n");
        sb.append("    createCase: ").append(toIndentedString(createCase)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
