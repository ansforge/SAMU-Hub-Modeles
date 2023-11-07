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


package com.hubsante.model.emsi;

import java.util.Objects;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hubsante.model.emsi.Context;
import com.hubsante.model.emsi.Event;
import com.hubsante.model.emsi.Mission;

import java.util.ArrayList;
import java.util.List;

import com.hubsante.model.edxl.ContentMessage;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * EMSIDC
 */
@JsonPropertyOrder({
        EMSIDC.JSON_PROPERTY_C_O_N_T_E_X_T,
        EMSIDC.JSON_PROPERTY_E_V_E_N_T,
        EMSIDC.JSON_PROPERTY_M_I_S_S_I_O_N
})
@JsonTypeName("EMSI_DC")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JacksonXmlRootElement(localName = "message")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-07T12:10:56.446+01:00[Europe/Paris]")
public class EMSIDC extends ContentMessage {
    @JacksonXmlProperty(isAttribute = true)
    String xmlns = "urn:emergency:cisu:2.0";
    public static final String JSON_PROPERTY_C_O_N_T_E_X_T = "CONTEXT";
    private Context CONTEXT;

    public static final String JSON_PROPERTY_E_V_E_N_T = "EVENT";
    private Event EVENT;

    public static final String JSON_PROPERTY_M_I_S_S_I_O_N = "MISSION";
    private List<Mission> MISSION;

    public EMSIDC() {
    }

    public EMSIDC CONTEXT(Context CONTEXT) {

        this.CONTEXT = CONTEXT;
        return this;
    }

    /**
     * Get CONTEXT
     *
     * @return CONTEXT
     **/
    @JsonProperty(JSON_PROPERTY_C_O_N_T_E_X_T)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Context getCONTEXT() {
        return CONTEXT;
    }


    @JsonProperty(JSON_PROPERTY_C_O_N_T_E_X_T)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCONTEXT(Context CONTEXT) {
        this.CONTEXT = CONTEXT;
    }


    public EMSIDC EVENT(Event EVENT) {

        this.EVENT = EVENT;
        return this;
    }

    /**
     * Get EVENT
     *
     * @return EVENT
     **/
    @JsonProperty(JSON_PROPERTY_E_V_E_N_T)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Event getEVENT() {
        return EVENT;
    }


    @JsonProperty(JSON_PROPERTY_E_V_E_N_T)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEVENT(Event EVENT) {
        this.EVENT = EVENT;
    }


    public EMSIDC MISSION(List<Mission> MISSION) {

        this.MISSION = MISSION;
        return this;
    }

    public EMSIDC addMISSIONItem(Mission MISSIONItem) {
        if (this.MISSION == null) {
            this.MISSION = new ArrayList<>();
        }
        this.MISSION.add(MISSIONItem);
        return this;
    }

    /**
     * Get MISSION
     *
     * @return MISSION
     **/
    @JsonProperty(JSON_PROPERTY_M_I_S_S_I_O_N)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Mission> getMISSION() {
        return MISSION;
    }


    @JsonProperty(JSON_PROPERTY_M_I_S_S_I_O_N)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMISSION(List<Mission> MISSION) {
        if (MISSION == null) {
            return;
        }
        if (this.MISSION == null) {
            this.MISSION = new ArrayList<>();
        }
        this.MISSION.addAll(MISSION);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EMSIDC EMSI_DC = (EMSIDC) o;
        return Objects.equals(this.CONTEXT, EMSI_DC.CONTEXT) &&
                Objects.equals(this.EVENT, EMSI_DC.EVENT) &&
                Objects.equals(this.MISSION, EMSI_DC.MISSION);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CONTEXT, EVENT, MISSION);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EMSIDC {\n");
        sb.append("    CONTEXT: ").append(toIndentedString(CONTEXT)).append("\n");
        sb.append("    EVENT: ").append(toIndentedString(EVENT)).append("\n");
        sb.append("    MISSION: ").append(toIndentedString(MISSION)).append("\n");
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
