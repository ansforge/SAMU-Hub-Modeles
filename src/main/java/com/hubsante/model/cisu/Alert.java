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
import com.hubsante.model.cisu.AlertCode;
import com.hubsante.model.cisu.CallTaker;
import com.hubsante.model.cisu.Caller;
import com.hubsante.model.cisu.Contact;
import com.hubsante.model.cisu.Location;
import com.hubsante.model.cisu.Resource;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Alert
 */
@JsonPropertyOrder({
        Alert.JSON_PROPERTY_ALERT_ID,
        Alert.JSON_PROPERTY_RECEIVED_AT,
        Alert.JSON_PROPERTY_REPORTING,
        Alert.JSON_PROPERTY_ALERT_INFORMATION,
        Alert.JSON_PROPERTY_CALLER,
        Alert.JSON_PROPERTY_ALERT_LOCATION,
        Alert.JSON_PROPERTY_ALERT_CODE,
        Alert.JSON_PROPERTY_CONTACT,
        Alert.JSON_PROPERTY_CALL_TAKER,
        Alert.JSON_PROPERTY_RESOURCE
})
@JsonTypeName("alert")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Alert {
    public static final String JSON_PROPERTY_ALERT_ID = "alertId";
    private String alertId;

    public static final String JSON_PROPERTY_RECEIVED_AT = "receivedAt";
    private OffsetDateTime receivedAt;

    /**
     * Permet d&#39;attirer l&#39;attention des forces partenaires sur une affaire.   Eventuellement automatisé en fonction des critères saisis et de leur paramétrage, ou renseigné par l&#39;opérateur.  Prend les valeurs définies dans la nomenclature CISU.  Pour les systèmes multi-alertes mais gérant ce champs au niveau de l&#39;affaire, ils prennent le niveau d&#39;alerte le plus élevé (peut être complété par \&quot;Raison du transfert\&quot;)
     */
    public enum ReportingEnum {
        STANDARD("STANDARD"),

        ATTENTION("ATTENTION");

        private String value;

        ReportingEnum(String value) {
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
        public static ReportingEnum fromValue(String value) {
            for (ReportingEnum b : ReportingEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_REPORTING = "reporting";
    private ReportingEnum reporting;

    public static final String JSON_PROPERTY_ALERT_INFORMATION = "alertInformation";
    private String alertInformation;

    public static final String JSON_PROPERTY_CALLER = "caller";
    private Caller caller;

    public static final String JSON_PROPERTY_ALERT_LOCATION = "alertLocation";
    private Location alertLocation;

    public static final String JSON_PROPERTY_ALERT_CODE = "alertCode";
    private AlertCode alertCode;

    public static final String JSON_PROPERTY_CONTACT = "contact";
    private Contact contact;

    public static final String JSON_PROPERTY_CALL_TAKER = "callTaker";
    private CallTaker callTaker;

    public static final String JSON_PROPERTY_RESOURCE = "resource";
    private List<Resource> resource;

    public Alert() {
    }

    public Alert alertId(String alertId) {

        this.alertId = alertId;
        return this;
    }

    /**
     * Identifiant technique unique de l&#39;alerte. Il doit pouvoir être généré automatiquement par le système émetteur et ne doit pas avoir de signification / utilisation particulière par les différents systèmes pour garantir leur découplage. Voir la description de l&#39;identifiant de l&#39;affaire pour voir le format.
     *
     * @return alertId
     **/
    @JsonProperty(JSON_PROPERTY_ALERT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAlertId() {
        return alertId;
    }


    @JsonProperty(JSON_PROPERTY_ALERT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }


    public Alert receivedAt(OffsetDateTime receivedAt) {

        this.receivedAt = receivedAt;
        return this;
    }

    /**
     * Groupe date heure de réception de l&#39;alerte
     *
     * @return receivedAt
     **/
    @JsonProperty(JSON_PROPERTY_RECEIVED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getReceivedAt() {
        return receivedAt;
    }


    @JsonProperty(JSON_PROPERTY_RECEIVED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReceivedAt(OffsetDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }


    public Alert reporting(ReportingEnum reporting) {

        this.reporting = reporting;
        return this;
    }

    /**
     * Permet d&#39;attirer l&#39;attention des forces partenaires sur une affaire.   Eventuellement automatisé en fonction des critères saisis et de leur paramétrage, ou renseigné par l&#39;opérateur.  Prend les valeurs définies dans la nomenclature CISU.  Pour les systèmes multi-alertes mais gérant ce champs au niveau de l&#39;affaire, ils prennent le niveau d&#39;alerte le plus élevé (peut être complété par \&quot;Raison du transfert\&quot;)
     *
     * @return reporting
     **/
    @JsonProperty(JSON_PROPERTY_REPORTING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ReportingEnum getReporting() {
        return reporting;
    }


    @JsonProperty(JSON_PROPERTY_REPORTING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReporting(ReportingEnum reporting) {
        this.reporting = reporting;
    }


    public Alert alertInformation(String alertInformation) {

        this.alertInformation = alertInformation;
        return this;
    }

    /**
     * Texte libre permettant de donner des informations supplémentaires concernant l&#39;alerte
     *
     * @return alertInformation
     **/
    @JsonProperty(JSON_PROPERTY_ALERT_INFORMATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAlertInformation() {
        return alertInformation;
    }


    @JsonProperty(JSON_PROPERTY_ALERT_INFORMATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAlertInformation(String alertInformation) {
        this.alertInformation = alertInformation;
    }


    public Alert caller(Caller caller) {

        this.caller = caller;
        return this;
    }

    /**
     * Get caller
     *
     * @return caller
     **/
    @JsonProperty(JSON_PROPERTY_CALLER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Caller getCaller() {
        return caller;
    }


    @JsonProperty(JSON_PROPERTY_CALLER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCaller(Caller caller) {
        this.caller = caller;
    }


    public Alert alertLocation(Location alertLocation) {

        this.alertLocation = alertLocation;
        return this;
    }

    /**
     * Get alertLocation
     *
     * @return alertLocation
     **/
    @JsonProperty(JSON_PROPERTY_ALERT_LOCATION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Location getAlertLocation() {
        return alertLocation;
    }


    @JsonProperty(JSON_PROPERTY_ALERT_LOCATION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setAlertLocation(Location alertLocation) {
        this.alertLocation = alertLocation;
    }


    public Alert alertCode(AlertCode alertCode) {

        this.alertCode = alertCode;
        return this;
    }

    /**
     * Get alertCode
     *
     * @return alertCode
     **/
    @JsonProperty(JSON_PROPERTY_ALERT_CODE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public AlertCode getAlertCode() {
        return alertCode;
    }


    @JsonProperty(JSON_PROPERTY_ALERT_CODE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setAlertCode(AlertCode alertCode) {
        this.alertCode = alertCode;
    }


    public Alert contact(Contact contact) {

        this.contact = contact;
        return this;
    }

    /**
     * Get contact
     *
     * @return contact
     **/
    @JsonProperty(JSON_PROPERTY_CONTACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Contact getContact() {
        return contact;
    }


    @JsonProperty(JSON_PROPERTY_CONTACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContact(Contact contact) {
        this.contact = contact;
    }


    public Alert callTaker(CallTaker callTaker) {

        this.callTaker = callTaker;
        return this;
    }

    /**
     * Get callTaker
     *
     * @return callTaker
     **/
    @JsonProperty(JSON_PROPERTY_CALL_TAKER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public CallTaker getCallTaker() {
        return callTaker;
    }


    @JsonProperty(JSON_PROPERTY_CALL_TAKER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCallTaker(CallTaker callTaker) {
        this.callTaker = callTaker;
    }


    public Alert resource(List<Resource> resource) {

        this.resource = resource;
        return this;
    }

    public Alert addResourceItem(Resource resourceItem) {
        if (this.resource == null) {
            this.resource = new ArrayList<>();
        }
        this.resource.add(resourceItem);
        return this;
    }

    /**
     * Get resource
     *
     * @return resource
     **/
    @JsonProperty(JSON_PROPERTY_RESOURCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Resource> getResource() {
        return resource;
    }

    @JacksonXmlElementWrapper(useWrapping = false)

    @JsonProperty(JSON_PROPERTY_RESOURCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResource(List<Resource> resource) {
        if (resource == null) {
            return;
        }
        if (this.resource == null) {
            this.resource = new ArrayList<>();
        }
        this.resource.addAll(resource);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Alert alert = (Alert) o;
        return Objects.equals(this.alertId, alert.alertId) &&
                Objects.equals(this.receivedAt, alert.receivedAt) &&
                Objects.equals(this.reporting, alert.reporting) &&
                Objects.equals(this.alertInformation, alert.alertInformation) &&
                Objects.equals(this.caller, alert.caller) &&
                Objects.equals(this.alertLocation, alert.alertLocation) &&
                Objects.equals(this.alertCode, alert.alertCode) &&
                Objects.equals(this.contact, alert.contact) &&
                Objects.equals(this.callTaker, alert.callTaker) &&
                Objects.equals(this.resource, alert.resource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alertId
                , receivedAt
                , reporting
                , alertInformation
                , caller
                , alertLocation
                , alertCode
                , contact
                , callTaker
                , resource);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Alert {\n");
        sb.append("    alertId: ").append(toIndentedString(alertId)).append("\n");
        sb.append("    receivedAt: ").append(toIndentedString(receivedAt)).append("\n");
        sb.append("    reporting: ").append(toIndentedString(reporting)).append("\n");
        sb.append("    alertInformation: ").append(toIndentedString(alertInformation)).append("\n");
        sb.append("    caller: ").append(toIndentedString(caller)).append("\n");
        sb.append("    alertLocation: ").append(toIndentedString(alertLocation)).append("\n");
        sb.append("    alertCode: ").append(toIndentedString(alertCode)).append("\n");
        sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
        sb.append("    callTaker: ").append(toIndentedString(callTaker)).append("\n");
        sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
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
