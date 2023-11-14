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
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hubsante.model.cisu.Contact;
import com.hubsante.model.cisu.DetailedName;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Caller
 */
@JsonPropertyOrder({
        Caller.JSON_PROPERTY_CALLER_CONTACT,
        Caller.JSON_PROPERTY_CALLBACK_CONTACT,
        Caller.JSON_PROPERTY_LANGUAGE,
        Caller.JSON_PROPERTY_FREETEXT,
        Caller.JSON_PROPERTY_DETAILED_NAME
})
@JsonTypeName("caller")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-07T12:09:36.642+01:00[Europe/Paris]")
public class Caller {
    public static final String JSON_PROPERTY_CALLER_CONTACT = "callerContact";
    private Contact callerContact;

    public static final String JSON_PROPERTY_CALLBACK_CONTACT = "callbackContact";
    private Contact callbackContact;

    /**
     * Langue parlée par le requérant. Permet de mettre en place des traducteurs si besoin. Utilise la nomenclature LANGUE du SI-SAMU.
     */
    public enum LanguageEnum {
        AF("AF"),

        AX("AX"),

        AL("AL"),

        DZ("DZ"),

        AS("AS"),

        AD("AD"),

        AO("AO"),

        AI("AI"),

        AQ("AQ"),

        AG("AG"),

        AR("AR"),

        AM("AM"),

        AW("AW"),

        AU("AU"),

        AT("AT"),

        AZ("AZ"),

        BS("BS"),

        BH("BH"),

        BD("BD"),

        BB("BB"),

        BY("BY"),

        BE("BE"),

        BZ("BZ"),

        BJ("BJ"),

        BM("BM"),

        BT("BT"),

        BO("BO"),

        BA("BA"),

        BW("BW"),

        BV("BV"),

        BR("BR"),

        IO("IO"),

        BN("BN"),

        BG("BG"),

        BF("BF"),

        BI("BI"),

        CV("CV"),

        KH("KH"),

        CM("CM"),

        CA("CA"),

        KY("KY"),

        CF("CF"),

        TD("TD"),

        CL("CL"),

        CN("CN"),

        CX("CX"),

        CC("CC"),

        CO("CO"),

        KM("KM"),

        CG("CG"),

        CK("CK"),

        CR("CR"),

        CI("CI"),

        HR("HR"),

        CU("CU"),

        CW("CW"),

        CY("CY"),

        CZ("CZ"),

        DK("DK"),

        DJ("DJ"),

        DM("DM"),

        DO("DO"),

        EC("EC"),

        EG("EG"),

        SV("SV"),

        GQ("GQ"),

        ER("ER"),

        EE("EE"),

        SZ("SZ"),

        ET("ET"),

        FK("FK"),

        FO("FO"),

        FJ("FJ"),

        FI("FI"),

        FR("FR"),

        GF("GF"),

        PF("PF"),

        TF("TF"),

        GA("GA"),

        GM("GM"),

        GE("GE"),

        DE("DE"),

        GH("GH"),

        GI("GI"),

        GR("GR"),

        GL("GL"),

        GD("GD"),

        GP("GP"),

        GU("GU"),

        GT("GT"),

        GG("GG"),

        GN("GN"),

        GW("GW"),

        GY("GY"),

        HT("HT"),

        HM("HM"),

        VA("VA"),

        HN("HN"),

        HK("HK"),

        HU("HU"),

        IS("IS"),

        IN("IN"),

        ID("ID"),

        IR("IR"),

        IQ("IQ"),

        IE("IE"),

        IM("IM"),

        IL("IL"),

        IT("IT"),

        JM("JM"),

        JP("JP"),

        JE("JE"),

        JO("JO"),

        KZ("KZ"),

        KE("KE"),

        KI("KI"),

        KP("KP"),

        KW("KW"),

        KG("KG"),

        LA("LA"),

        LV("LV"),

        LB("LB"),

        LS("LS"),

        LR("LR"),

        LY("LY"),

        LI("LI"),

        LT("LT"),

        LU("LU"),

        MO("MO"),

        MG("MG"),

        MW("MW"),

        MY("MY"),

        MV("MV"),

        ML("ML"),

        MT("MT"),

        MH("MH"),

        MQ("MQ"),

        MR("MR"),

        MU("MU"),

        YT("YT"),

        MX("MX"),

        FM("FM"),

        MC("MC"),

        MN("MN"),

        ME("ME"),

        MS("MS"),

        MA("MA"),

        MZ("MZ"),

        MM("MM"),

        NR("NR"),

        NP("NP"),

        NL("NL"),

        NC("NC"),

        NZ("NZ"),

        NI("NI"),

        NE("NE"),

        NG("NG"),

        NU("NU"),

        NF("NF"),

        MK("MK"),

        MP("MP"),

        NO("NO"),

        OM("OM"),

        PK("PK"),

        PW("PW"),

        _STATE_OF(" State of"),

        PA("PA"),

        PG("PG"),

        PY("PY"),

        PE("PE"),

        PH("PH"),

        PN("PN"),

        PL("PL"),

        PT("PT"),

        PR("PR"),

        QA("QA"),

        RE("RE"),

        RO("RO"),

        RU("RU"),

        RW("RW"),

        BL("BL"),

        KN("KN"),

        LC("LC"),

        MF("MF"),

        PM("PM"),

        VC("VC"),

        WS("WS"),

        SM("SM"),

        ST("ST"),

        SA("SA"),

        SN("SN"),

        RS("RS"),

        SC("SC"),

        SL("SL"),

        SG("SG"),

        SX("SX"),

        SK("SK"),

        SI("SI"),

        SB("SB"),

        SO("SO"),

        ZA("ZA"),

        GS("GS"),

        SS("SS"),

        ES("ES"),

        LK("LK"),

        SD("SD"),

        SR("SR"),

        SJ("SJ"),

        SE("SE"),

        CH("CH"),

        SY("SY"),

        TJ("TJ"),

        TH("TH"),

        TL("TL"),

        TG("TG"),

        TK("TK"),

        TO("TO"),

        TT("TT"),

        TN("TN"),

        TR("TR"),

        TM("TM"),

        TC("TC"),

        TV("TV"),

        UG("UG"),

        UA("UA"),

        AE("AE"),

        GB("GB"),

        US("US"),

        UM("UM"),

        UY("UY"),

        UZ("UZ"),

        VU("VU"),

        VE("VE"),

        VN("VN"),

        VG("VG"),

        VI("VI"),

        WF("WF"),

        EH("EH"),

        YE("YE"),

        ZM("ZM"),

        ZW("ZW");

        private String value;

        LanguageEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static LanguageEnum fromValue(String value) {
            for (LanguageEnum b : LanguageEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_LANGUAGE = "language";
    private LanguageEnum language;

    public static final String JSON_PROPERTY_FREETEXT = "freetext";
    private String freetext;

    public static final String JSON_PROPERTY_DETAILED_NAME = "detailedName";
    private DetailedName detailedName;

    public Caller() {
    }

    public Caller callerContact(Contact callerContact) {

        this.callerContact = callerContact;
        return this;
    }

    /**
     * Get callerContact
     *
     * @return callerContact
     **/
    @JsonProperty(JSON_PROPERTY_CALLER_CONTACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Contact getCallerContact() {
        return callerContact;
    }


    @JsonProperty(JSON_PROPERTY_CALLER_CONTACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCallerContact(Contact callerContact) {
        this.callerContact = callerContact;
    }


    public Caller callbackContact(Contact callbackContact) {

        this.callbackContact = callbackContact;
        return this;
    }

    /**
     * Get callbackContact
     *
     * @return callbackContact
     **/
    @JsonProperty(JSON_PROPERTY_CALLBACK_CONTACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Contact getCallbackContact() {
        return callbackContact;
    }


    @JsonProperty(JSON_PROPERTY_CALLBACK_CONTACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCallbackContact(Contact callbackContact) {
        this.callbackContact = callbackContact;
    }


    public Caller language(LanguageEnum language) {

        this.language = language;
        return this;
    }

    /**
     * Langue parlée par le requérant. Permet de mettre en place des traducteurs si besoin. Utilise la nomenclature LANGUE du SI-SAMU.
     *
     * @return language
     **/
    @JsonProperty(JSON_PROPERTY_LANGUAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public LanguageEnum getLanguage() {
        return language;
    }


    @JsonProperty(JSON_PROPERTY_LANGUAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }


    public Caller freetext(String freetext) {

        this.freetext = freetext;
        return this;
    }

    /**
     * Information sur le requérant : malentendant, impliqué dans l&#39;accident, … Les informations peuvent être passées sous forme de texte libre ou via une liste d&#39;adjectif
     *
     * @return freetext
     **/
    @JsonProperty(JSON_PROPERTY_FREETEXT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFreetext() {
        return freetext;
    }


    @JsonProperty(JSON_PROPERTY_FREETEXT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFreetext(String freetext) {
        this.freetext = freetext;
    }


    public Caller detailedName(DetailedName detailedName) {

        this.detailedName = detailedName;
        return this;
    }

    /**
     * Get detailedName
     *
     * @return detailedName
     **/
    @JsonProperty(JSON_PROPERTY_DETAILED_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DetailedName getDetailedName() {
        return detailedName;
    }


    @JsonProperty(JSON_PROPERTY_DETAILED_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDetailedName(DetailedName detailedName) {
        this.detailedName = detailedName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Caller caller = (Caller) o;
        return Objects.equals(this.callerContact, caller.callerContact) &&
                Objects.equals(this.callbackContact, caller.callbackContact) &&
                Objects.equals(this.language, caller.language) &&
                Objects.equals(this.freetext, caller.freetext) &&
                Objects.equals(this.detailedName, caller.detailedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callerContact
                , callbackContact
                , language
                , freetext
                , detailedName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Caller {\n");
        sb.append("    callerContact: ").append(toIndentedString(callerContact)).append("\n");
        sb.append("    callbackContact: ").append(toIndentedString(callbackContact)).append("\n");
        sb.append("    language: ").append(toIndentedString(language)).append("\n");
        sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
        sb.append("    detailedName: ").append(toIndentedString(detailedName)).append("\n");
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
