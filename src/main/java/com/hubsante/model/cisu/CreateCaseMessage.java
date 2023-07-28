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
    import com.hubsante.model.cisu.AdditionalInformation;
    import com.hubsante.model.cisu.Alert;
    import com.hubsante.model.cisu.Casualties;
    import com.hubsante.model.cisu.Location;
    import java.util.ArrayList;
    import java.util.List;
import com.hubsante.model.edxl.EdxlInnerMessage;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
    import com.fasterxml.jackson.annotation.JsonPropertyOrder;
    import com.fasterxml.jackson.annotation.JsonTypeName;

        /**
* CreateCaseMessage
*/
    @JsonPropertyOrder({
        CreateCaseMessage.JSON_PROPERTY_CASE_ID,
        CreateCaseMessage.JSON_PROPERTY_SENDER_CASE_ID,
        CreateCaseMessage.JSON_PROPERTY_CREATED_AT,
        CreateCaseMessage.JSON_PROPERTY_INITIAL_ALERT,
        CreateCaseMessage.JSON_PROPERTY_CASE_LOCATION,
        CreateCaseMessage.JSON_PROPERTY_CASUALTIES,
        CreateCaseMessage.JSON_PROPERTY_NEW_ALERT,
        CreateCaseMessage.JSON_PROPERTY_SEVERITY,
        CreateCaseMessage.JSON_PROPERTY_ADDITIONAL_INFORMATION,
        CreateCaseMessage.JSON_PROPERTY_FREETEXT
    })
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JacksonXmlRootElement (localName= "message")

public class CreateCaseMessage  extends EdxlInnerMessage {
    @JacksonXmlProperty(isAttribute = true)
    String xmlns = "urn:emergency:cisu:2.0";
        public static final String JSON_PROPERTY_CASE_ID = "caseId";
            private String caseId;

        public static final String JSON_PROPERTY_SENDER_CASE_ID = "senderCaseId";
            private String senderCaseId;

        public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
            private String createdAt;

        public static final String JSON_PROPERTY_INITIAL_ALERT = "initialAlert";
            private Alert initialAlert;

        public static final String JSON_PROPERTY_CASE_LOCATION = "caseLocation";
            private Location caseLocation;

        public static final String JSON_PROPERTY_CASUALTIES = "casualties";
            private List<Casualties> casualties;

        public static final String JSON_PROPERTY_NEW_ALERT = "newAlert";
            private List<Alert> newAlert;

              /**
   * [Non utilisé dans une première version car la définition et l&#39;usage restent à définir] Précise l&#39;urgence médicale :         EXTREME : Menace extrême pour la vie         SEVERE : Menace importante pour la vie         MODERATE - Menace possible pour la vie         MINOR : Peu ou pas de menace connue pour la vie         UNKNOWN : Niveau de menace inconnu Ce niveau de gravité est lié au Motif de Recours Medico-Secouriste associé à l&#39;appel.
   */
  public enum SeverityEnum {
    EXTREME("EXTREME"),
    
    SEVERE("SEVERE"),
    
    MODERATE("MODERATE"),
    
    MINOR("MINOR"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    SeverityEnum(String value) {
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
    public static SeverityEnum fromValue(String value) {
      for (SeverityEnum b : SeverityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

        public static final String JSON_PROPERTY_SEVERITY = "severity";
            private SeverityEnum severity;

        public static final String JSON_PROPERTY_ADDITIONAL_INFORMATION = "additionalInformation";
            private AdditionalInformation additionalInformation;

        public static final String JSON_PROPERTY_FREETEXT = "freetext";
            private String freetext;

public CreateCaseMessage() {
}

        public CreateCaseMessage caseId(String caseId) {
        
        this.caseId = caseId;
        return this;
        }

    /**
        * Identifiant fonctionnel unique de l&#39;affaire et partagé entre tous les intervenants. Il doit pouvoir être généré de façon unique et décentralisée et ne présenter aucune ambiguïté. Il est généré par la force réceptrice de la primo-demande de secours et contient un identifiant de la source. Format proposé : {SystèmeEmetteur}-{Date}-AL|AF{Sequence} Format NF399 : pays + CTA + date + # unique Format NexSIS : SC-20211105-077-cga-AF18 (SC-AAAAMMJJ-{codeCGA}-AL|AF{SEQUENCE}) (toutes les alertes créent pas des affaires, affaires peuvent avoir plusieurs alertes)
    * @return caseId
    **/
      @JsonProperty(JSON_PROPERTY_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCaseId() {
        return caseId;
    }


          @JsonProperty(JSON_PROPERTY_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCaseId(String caseId) {
                this.caseId = caseId;
        }


        public CreateCaseMessage senderCaseId(String senderCaseId) {
        
        this.senderCaseId = senderCaseId;
        return this;
        }

    /**
        * Identifiant de l&#39;affaire dans le SI de l&#39;émetteur du message
    * @return senderCaseId
    **/
      @JsonProperty(JSON_PROPERTY_SENDER_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSenderCaseId() {
        return senderCaseId;
    }


          @JsonProperty(JSON_PROPERTY_SENDER_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSenderCaseId(String senderCaseId) {
                this.senderCaseId = senderCaseId;
        }


        public CreateCaseMessage createdAt(String createdAt) {
        
        this.createdAt = createdAt;
        return this;
        }

    /**
        * Groupe date heure de début de partage lié à la création de l&#39;affaire (et donc de génération du caseId). Il doit être renseigné à la fin du processus de la  création  de la première alerte. Lors de l&#39;ajout d&#39;alerte à une affaire ce champ ne doit pas être modifié.  L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé. Le fuseau horaire pour UTC doit être représenté par &#39;-00:00&#39;
    * @return createdAt
    **/
      @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedAt() {
        return createdAt;
    }


          @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
        }


        public CreateCaseMessage initialAlert(Alert initialAlert) {
        
        this.initialAlert = initialAlert;
        return this;
        }

    /**
        * Get initialAlert
    * @return initialAlert
    **/
      @JsonProperty(JSON_PROPERTY_INITIAL_ALERT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Alert getInitialAlert() {
        return initialAlert;
    }


          @JsonProperty(JSON_PROPERTY_INITIAL_ALERT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInitialAlert(Alert initialAlert) {
                this.initialAlert = initialAlert;
        }


        public CreateCaseMessage caseLocation(Location caseLocation) {
        
        this.caseLocation = caseLocation;
        return this;
        }

    /**
        * Get caseLocation
    * @return caseLocation
    **/
      @JsonProperty(JSON_PROPERTY_CASE_LOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Location getCaseLocation() {
        return caseLocation;
    }


          @JsonProperty(JSON_PROPERTY_CASE_LOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCaseLocation(Location caseLocation) {
                this.caseLocation = caseLocation;
        }


        public CreateCaseMessage casualties(List<Casualties> casualties) {
        
        this.casualties = casualties;
        return this;
        }

            public CreateCaseMessage addCasualtiesItem(Casualties casualtiesItem) {
                if (this.casualties == null) {
                this.casualties = new ArrayList<>();
                }
                this.casualties.add(casualtiesItem);
                return this;
            }

    /**
        * Get casualties
    * @return casualties
    **/
      @JsonProperty(JSON_PROPERTY_CASUALTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Casualties> getCasualties() {
        return casualties;
    }


          @JsonProperty(JSON_PROPERTY_CASUALTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCasualties(List<Casualties> casualties) {
                if (casualties == null) { return; }
                if (this.casualties == null) {
                this.casualties = new ArrayList<>();
                }
                this.casualties.addAll(casualties);
        }


        public CreateCaseMessage newAlert(List<Alert> newAlert) {
        
        this.newAlert = newAlert;
        return this;
        }

            public CreateCaseMessage addNewAlertItem(Alert newAlertItem) {
                if (this.newAlert == null) {
                this.newAlert = new ArrayList<>();
                }
                this.newAlert.add(newAlertItem);
                return this;
            }

    /**
        * Get newAlert
    * @return newAlert
    **/
      @JsonProperty(JSON_PROPERTY_NEW_ALERT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Alert> getNewAlert() {
        return newAlert;
    }


          @JsonProperty(JSON_PROPERTY_NEW_ALERT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNewAlert(List<Alert> newAlert) {
                if (newAlert == null) { return; }
                if (this.newAlert == null) {
                this.newAlert = new ArrayList<>();
                }
                this.newAlert.addAll(newAlert);
        }


        public CreateCaseMessage severity(SeverityEnum severity) {
        
        this.severity = severity;
        return this;
        }

    /**
        * [Non utilisé dans une première version car la définition et l&#39;usage restent à définir] Précise l&#39;urgence médicale :         EXTREME : Menace extrême pour la vie         SEVERE : Menace importante pour la vie         MODERATE - Menace possible pour la vie         MINOR : Peu ou pas de menace connue pour la vie         UNKNOWN : Niveau de menace inconnu Ce niveau de gravité est lié au Motif de Recours Medico-Secouriste associé à l&#39;appel.
    * @return severity
    **/
      @JsonProperty(JSON_PROPERTY_SEVERITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public SeverityEnum getSeverity() {
        return severity;
    }


          @JsonProperty(JSON_PROPERTY_SEVERITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSeverity(SeverityEnum severity) {
                this.severity = severity;
        }


        public CreateCaseMessage additionalInformation(AdditionalInformation additionalInformation) {
        
        this.additionalInformation = additionalInformation;
        return this;
        }

    /**
        * Get additionalInformation
    * @return additionalInformation
    **/
      @JsonProperty(JSON_PROPERTY_ADDITIONAL_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }


          @JsonProperty(JSON_PROPERTY_ADDITIONAL_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdditionalInformation(AdditionalInformation additionalInformation) {
                this.additionalInformation = additionalInformation;
        }


        public CreateCaseMessage freetext(String freetext) {
        
        this.freetext = freetext;
        return this;
        }

    /**
        * Texte libre permettant de donner des informations supplémentaires concernant l&#39;affaire
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
        CreateCaseMessage createCaseMessage = (CreateCaseMessage) o;
        return Objects.equals(this.caseId, createCaseMessage.caseId) &&
        Objects.equals(this.senderCaseId, createCaseMessage.senderCaseId) &&
        Objects.equals(this.createdAt, createCaseMessage.createdAt) &&
        Objects.equals(this.initialAlert, createCaseMessage.initialAlert) &&
        Objects.equals(this.caseLocation, createCaseMessage.caseLocation) &&
        Objects.equals(this.casualties, createCaseMessage.casualties) &&
        Objects.equals(this.newAlert, createCaseMessage.newAlert) &&
        Objects.equals(this.severity, createCaseMessage.severity) &&
        Objects.equals(this.additionalInformation, createCaseMessage.additionalInformation) &&
        Objects.equals(this.freetext, createCaseMessage.freetext);
}

    @Override
    public int hashCode() {
        return Objects.hash(caseId, senderCaseId, createdAt, initialAlert, caseLocation, casualties, newAlert, severity, additionalInformation, freetext);
    }

    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCaseMessage {\n");
        sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
        sb.append("    senderCaseId: ").append(toIndentedString(senderCaseId)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    initialAlert: ").append(toIndentedString(initialAlert)).append("\n");
        sb.append("    caseLocation: ").append(toIndentedString(caseLocation)).append("\n");
        sb.append("    casualties: ").append(toIndentedString(casualties)).append("\n");
        sb.append("    newAlert: ").append(toIndentedString(newAlert)).append("\n");
        sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
        sb.append("    additionalInformation: ").append(toIndentedString(additionalInformation)).append("\n");
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
