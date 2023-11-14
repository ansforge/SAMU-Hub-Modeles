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

import java.time.OffsetDateTime;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Casualties
 */
@JsonPropertyOrder({
        Casualties.JSON_PROPERTY_C_O_N_T_E_X_T,
        Casualties.JSON_PROPERTY_D_A_T_I_M_E,
        Casualties.JSON_PROPERTY_D_E_C_O_N_T,
        Casualties.JSON_PROPERTY_T_R_I_A_G_E_R_E_D,
        Casualties.JSON_PROPERTY_T_R_I_A_G_E_Y_E_L_L_O_W,
        Casualties.JSON_PROPERTY_T_R_I_A_G_E_G_R_E_E_N,
        Casualties.JSON_PROPERTY_T_R_I_A_G_E_B_L_A_C_K,
        Casualties.JSON_PROPERTY_M_I_S_S_I_N_G
})
@JsonTypeName("casualties")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-08T11:29:35.594+01:00[Europe/Paris]")
public class Casualties {
    public static final String JSON_PROPERTY_C_O_N_T_E_X_T = "CONTEXT";
    private String CONTEXT;

    public static final String JSON_PROPERTY_D_A_T_I_M_E = "DATIME";
    private OffsetDateTime DATIME;

    public static final String JSON_PROPERTY_D_E_C_O_N_T = "DECONT";
    private Integer DECONT;

    public static final String JSON_PROPERTY_T_R_I_A_G_E_R_E_D = "TRIAGERED";
    private Integer TRIAGERED;

    public static final String JSON_PROPERTY_T_R_I_A_G_E_Y_E_L_L_O_W = "TRIAGEYELLOW";
    private Integer TRIAGEYELLOW;

    public static final String JSON_PROPERTY_T_R_I_A_G_E_G_R_E_E_N = "TRIAGEGREEN";
    private Integer TRIAGEGREEN;

    public static final String JSON_PROPERTY_T_R_I_A_G_E_B_L_A_C_K = "TRIAGEBLACK";
    private Integer TRIAGEBLACK;

    public static final String JSON_PROPERTY_M_I_S_S_I_N_G = "MISSING";
    private Integer MISSING;

    public Casualties() {
    }

    public Casualties CONTEXT(String CONTEXT) {

        this.CONTEXT = CONTEXT;
        return this;
    }

    /**
     * Le champ doit être renseigné mais peut ne pas être interprété
     *
     * @return CONTEXT
     **/
    @JsonProperty(JSON_PROPERTY_C_O_N_T_E_X_T)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getCONTEXT() {
        return CONTEXT;
    }


    @JsonProperty(JSON_PROPERTY_C_O_N_T_E_X_T)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCONTEXT(String CONTEXT) {
        this.CONTEXT = CONTEXT;
    }


    public Casualties DATIME(OffsetDateTime DATIME) {

        this.DATIME = DATIME;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, optionnel. Le champ peut ne pas être émis ni interprété
     *
     * @return DATIME
     **/
    @JsonProperty(JSON_PROPERTY_D_A_T_I_M_E)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getDATIME() {
        return DATIME;
    }


    @JsonProperty(JSON_PROPERTY_D_A_T_I_M_E)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDATIME(OffsetDateTime DATIME) {
        this.DATIME = DATIME;
    }


    public Casualties DECONT(Integer DECONT) {

        this.DECONT = DECONT;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, optionnel. Le champ peut ne pas être émis ni interprété
     *
     * @return DECONT
     **/
    @JsonProperty(JSON_PROPERTY_D_E_C_O_N_T)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getDECONT() {
        return DECONT;
    }


    @JsonProperty(JSON_PROPERTY_D_E_C_O_N_T)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDECONT(Integer DECONT) {
        this.DECONT = DECONT;
    }


    public Casualties TRIAGERED(Integer TRIAGERED) {

        this.TRIAGERED = TRIAGERED;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, optionnel. Le champ peut ne pas être émis ni interprété
     *
     * @return TRIAGERED
     **/
    @JsonProperty(JSON_PROPERTY_T_R_I_A_G_E_R_E_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTRIAGERED() {
        return TRIAGERED;
    }


    @JsonProperty(JSON_PROPERTY_T_R_I_A_G_E_R_E_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTRIAGERED(Integer TRIAGERED) {
        this.TRIAGERED = TRIAGERED;
    }


    public Casualties TRIAGEYELLOW(Integer TRIAGEYELLOW) {

        this.TRIAGEYELLOW = TRIAGEYELLOW;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, optionnel. Le champ peut ne pas être émis ni interprété
     *
     * @return TRIAGEYELLOW
     **/
    @JsonProperty(JSON_PROPERTY_T_R_I_A_G_E_Y_E_L_L_O_W)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTRIAGEYELLOW() {
        return TRIAGEYELLOW;
    }


    @JsonProperty(JSON_PROPERTY_T_R_I_A_G_E_Y_E_L_L_O_W)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTRIAGEYELLOW(Integer TRIAGEYELLOW) {
        this.TRIAGEYELLOW = TRIAGEYELLOW;
    }


    public Casualties TRIAGEGREEN(Integer TRIAGEGREEN) {

        this.TRIAGEGREEN = TRIAGEGREEN;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, optionnel. Le champ peut ne pas être émis ni interprété
     *
     * @return TRIAGEGREEN
     **/
    @JsonProperty(JSON_PROPERTY_T_R_I_A_G_E_G_R_E_E_N)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTRIAGEGREEN() {
        return TRIAGEGREEN;
    }


    @JsonProperty(JSON_PROPERTY_T_R_I_A_G_E_G_R_E_E_N)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTRIAGEGREEN(Integer TRIAGEGREEN) {
        this.TRIAGEGREEN = TRIAGEGREEN;
    }


    public Casualties TRIAGEBLACK(Integer TRIAGEBLACK) {

        this.TRIAGEBLACK = TRIAGEBLACK;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, optionnel. Le champ peut ne pas être émis ni interprété
     *
     * @return TRIAGEBLACK
     **/
    @JsonProperty(JSON_PROPERTY_T_R_I_A_G_E_B_L_A_C_K)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTRIAGEBLACK() {
        return TRIAGEBLACK;
    }


    @JsonProperty(JSON_PROPERTY_T_R_I_A_G_E_B_L_A_C_K)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTRIAGEBLACK(Integer TRIAGEBLACK) {
        this.TRIAGEBLACK = TRIAGEBLACK;
    }


    public Casualties MISSING(Integer MISSING) {

        this.MISSING = MISSING;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, optionnel. Le champ peut ne pas être émis ni interprété
     *
     * @return MISSING
     **/
    @JsonProperty(JSON_PROPERTY_M_I_S_S_I_N_G)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMISSING() {
        return MISSING;
    }


    @JsonProperty(JSON_PROPERTY_M_I_S_S_I_N_G)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMISSING(Integer MISSING) {
        this.MISSING = MISSING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Casualties casualties = (Casualties) o;
        return Objects.equals(this.CONTEXT, casualties.CONTEXT) &&
                Objects.equals(this.DATIME, casualties.DATIME) &&
                Objects.equals(this.DECONT, casualties.DECONT) &&
                Objects.equals(this.TRIAGERED, casualties.TRIAGERED) &&
                Objects.equals(this.TRIAGEYELLOW, casualties.TRIAGEYELLOW) &&
                Objects.equals(this.TRIAGEGREEN, casualties.TRIAGEGREEN) &&
                Objects.equals(this.TRIAGEBLACK, casualties.TRIAGEBLACK) &&
                Objects.equals(this.MISSING, casualties.MISSING);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CONTEXT
                , DATIME
                , DECONT
                , TRIAGERED
                , TRIAGEYELLOW
                , TRIAGEGREEN
                , TRIAGEBLACK
                , MISSING);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Casualties {\n");
        sb.append("    CONTEXT: ").append(toIndentedString(CONTEXT)).append("\n");
        sb.append("    DATIME: ").append(toIndentedString(DATIME)).append("\n");
        sb.append("    DECONT: ").append(toIndentedString(DECONT)).append("\n");
        sb.append("    TRIAGERED: ").append(toIndentedString(TRIAGERED)).append("\n");
        sb.append("    TRIAGEYELLOW: ").append(toIndentedString(TRIAGEYELLOW)).append("\n");
        sb.append("    TRIAGEGREEN: ").append(toIndentedString(TRIAGEGREEN)).append("\n");
        sb.append("    TRIAGEBLACK: ").append(toIndentedString(TRIAGEBLACK)).append("\n");
        sb.append("    MISSING: ").append(toIndentedString(MISSING)).append("\n");
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
