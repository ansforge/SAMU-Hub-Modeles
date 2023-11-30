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
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Victims
 */
@JsonPropertyOrder({
        Victims.JSON_PROPERTY_COUNT,
        Victims.JSON_PROPERTY_MAIN_VICTIM,
        Victims.JSON_PROPERTY_FREETEXT
})
@JsonTypeName("victims")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-30T16:37:50.003054300+01:00[Europe/Paris]")
public class Victims {

    /**
     * Indique le nombre de victimes selon la nomenclature du référentiel CISU
     */
    public enum CountEnum {
        _0("0"),

        _1("1"),

        SEVERAL("SEVERAL"),

        MANY("MANY"),

        UNKNOWN("UNKNOWN");

        private String value;

        CountEnum(String value) {
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
        public static CountEnum fromValue(String value) {
            for (CountEnum b : CountEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_COUNT = "count";
    private CountEnum count;


    /**
     * Identifie le type de la principale victime (celle dont l&#39;état de santé provoque le déclenchement de l&#39;envoi des secours). Prend les valeurs du référentiel CISU. Entre dans la détermination des partenaires impliqués par NexSIS.
     */
    public enum MainVictimEnum {
        INFANT("INFANT"),

        CHILD("CHILD"),

        ADULT("ADULT"),

        PREGNANT("PREGNANT"),

        SENIOR_VOIR_NOMENCLATURE_CISU_XX_("SENIOR (voir Nomenclature CISU XX)");

        private String value;

        MainVictimEnum(String value) {
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
        public static MainVictimEnum fromValue(String value) {
            for (MainVictimEnum b : MainVictimEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_MAIN_VICTIM = "mainVictim";
    private MainVictimEnum mainVictim;

    public static final String JSON_PROPERTY_FREETEXT = "freetext";
    private String freetext;

    public Victims() {
    }

    public Victims count(CountEnum count) {

        this.count = count;
        return this;
    }

    /**
     * Indique le nombre de victimes selon la nomenclature du référentiel CISU
     *
     * @return count
     **/
    @JsonProperty(JSON_PROPERTY_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public CountEnum getCount() {
        return count;
    }


    @JsonProperty(JSON_PROPERTY_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCount(CountEnum count) {
        this.count = count;
    }


    public Victims mainVictim(MainVictimEnum mainVictim) {

        this.mainVictim = mainVictim;
        return this;
    }

    /**
     * Identifie le type de la principale victime (celle dont l&#39;état de santé provoque le déclenchement de l&#39;envoi des secours). Prend les valeurs du référentiel CISU. Entre dans la détermination des partenaires impliqués par NexSIS.
     *
     * @return mainVictim
     **/
    @JsonProperty(JSON_PROPERTY_MAIN_VICTIM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public MainVictimEnum getMainVictim() {
        return mainVictim;
    }


    @JsonProperty(JSON_PROPERTY_MAIN_VICTIM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMainVictim(MainVictimEnum mainVictim) {
        this.mainVictim = mainVictim;
    }


    public Victims freetext(String freetext) {

        this.freetext = freetext;
        return this;
    }

    /**
     * Permet de complémenter en commentaire libre la(les) victime(s)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Victims victims = (Victims) o;
        return Objects.equals(this.count, victims.count) &&
                Objects.equals(this.mainVictim, victims.mainVictim) &&
                Objects.equals(this.freetext, victims.freetext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count
                , mainVictim
                , freetext);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Victims {\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    mainVictim: ").append(toIndentedString(mainVictim)).append("\n");
        sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
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
