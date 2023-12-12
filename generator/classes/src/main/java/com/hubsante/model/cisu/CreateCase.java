/*
 *
 *
 *
 *
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.cisu.AdditionalInformation;
import com.hubsante.model.cisu.Alert;
import com.hubsante.model.cisu.Location;
import com.hubsante.model.cisu.Qualification;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * CreateCase
 */
@JsonPropertyOrder(
    {CreateCase.JSON_PROPERTY_CASE_ID, CreateCase.JSON_PROPERTY_SENDER_CASE_ID,
     CreateCase.JSON_PROPERTY_CREATION,
     CreateCase.JSON_PROPERTY_REFERENCE_VERSION,
     CreateCase.JSON_PROPERTY_QUALIFICATION, CreateCase.JSON_PROPERTY_LOCATION,
     CreateCase.JSON_PROPERTY_INITIAL_ALERT, CreateCase.JSON_PROPERTY_NEW_ALERT,
     CreateCase.JSON_PROPERTY_ADDITIONAL_INFORMATION,
     CreateCase.JSON_PROPERTY_FREETEXT})
@JsonTypeName("createCase")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-12T10:46:15.933411Z[Etc/UTC]")
public class CreateCase {
  public static final String JSON_PROPERTY_CASE_ID = "caseId";
  private String caseId;

  public static final String JSON_PROPERTY_SENDER_CASE_ID = "senderCaseId";
  private String senderCaseId;

  public static final String JSON_PROPERTY_CREATION = "creation";
  private OffsetDateTime creation;

  public static final String JSON_PROPERTY_REFERENCE_VERSION =
      "referenceVersion";
  private String referenceVersion;

  public static final String JSON_PROPERTY_QUALIFICATION = "qualification";
  private Qualification qualification;

  public static final String JSON_PROPERTY_LOCATION = "location";
  private Location location;

  public static final String JSON_PROPERTY_INITIAL_ALERT = "initialAlert";
  private Alert initialAlert;

  public static final String JSON_PROPERTY_NEW_ALERT = "newAlert";
  private List<Alert> newAlert;

  public static final String JSON_PROPERTY_ADDITIONAL_INFORMATION =
      "additionalInformation";
  private AdditionalInformation additionalInformation;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public CreateCase() {}

  public CreateCase caseId(String caseId) {

    this.caseId = caseId;
    return this;
  }

  /**
   * Identifiant technique de l&#39;affaire et partagé entre tous les
   *intervenants. Il doit pouvoir être généré de façon unique et décentralisée
   *et ne présenter aucune ambiguïté. Il est généré par les systèmes du
   *partenaire récepteur de la primo-demande de secours et contient une clé
   *conventionnelle permettant d&#39;identifier la source. Valorisation :
   *{cleConventionnelle}:{cleUnique} où cleConventionnelle est la clé utilisée
   *par le partenaire emetteur et cleUnique l&#39;identifiant locale
   *d&#39;affaire dans le système du partenaire emetteur. cleUnique est une
   *chaîne de caractère (string) comprise entre 4 et 22 caractères
   *alphanumériques.
   * @return caseId
   **/
  @JsonProperty(JSON_PROPERTY_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCaseId() {
    return caseId;
  }

  @JsonProperty(JSON_PROPERTY_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }

  public CreateCase senderCaseId(String senderCaseId) {

    this.senderCaseId = senderCaseId;
    return this;
  }

  /**
   * Valoriser avec l&#39;identifiant de l&#39;affaire dans le SI de
   *l&#39;émetteur du message Ce champ est facultatif, il ne sera notamment pas
   *transmis par NexSIS Dans le cas où deux opérateurs ont besoin
   *d&#39;identifier une affaire, ils peuvent utiliser les derniers caractères
   *de l&#39;identifiant local de leur partenaire.
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

  public CreateCase creation(OffsetDateTime creation) {

    this.creation = creation;
    return this;
  }

  /**
   * Groupe date heure de début de partage lié à la création de l&#39;affaire
   *(et donc de génération du caseId). Il doit être renseigné à la fin du
   *processus de la  création  de la première alerte. Lors de l&#39;ajout
   *d&#39;alerte à une affaire ce champ ne doit pas être modifié.
   *L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé.
   * @return creation
   **/
  @JsonProperty(JSON_PROPERTY_CREATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getCreation() {
    return creation;
  }

  @JsonProperty(JSON_PROPERTY_CREATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreation(OffsetDateTime creation) {
    this.creation = creation;
  }

  public CreateCase referenceVersion(String referenceVersion) {

    this.referenceVersion = referenceVersion;
    return this;
  }

  /**
   * Indique le numéro de version du référentiel des nomenclatures des codes
   *transmis.  Cela permet aux différents systèmes de s&#39;assurer qu&#39;ils
   *utilisent la même version des codes de nomenclature que leurs partenaires.
   * @return referenceVersion
   **/
  @JsonProperty(JSON_PROPERTY_REFERENCE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getReferenceVersion() {
    return referenceVersion;
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReferenceVersion(String referenceVersion) {
    this.referenceVersion = referenceVersion;
  }

  public CreateCase qualification(Qualification qualification) {

    this.qualification = qualification;
    return this;
  }

  /**
   * Get qualification
   * @return qualification
   **/
  @JsonProperty(JSON_PROPERTY_QUALIFICATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Qualification getQualification() {
    return qualification;
  }

  @JsonProperty(JSON_PROPERTY_QUALIFICATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setQualification(Qualification qualification) {
    this.qualification = qualification;
  }

  public CreateCase location(Location location) {

    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Location getLocation() {
    return location;
  }

  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLocation(Location location) {
    this.location = location;
  }

  public CreateCase initialAlert(Alert initialAlert) {

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

  public CreateCase newAlert(List<Alert> newAlert) {

    this.newAlert = newAlert;
    return this;
  }

  public CreateCase addNewAlertItem(Alert newAlertItem) {
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

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_NEW_ALERT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNewAlert(List<Alert> newAlert) {
    if (newAlert == null) {
      return;
    }
    if (this.newAlert == null) {
      this.newAlert = new ArrayList<>();
    }
    this.newAlert.addAll(newAlert);
  }

  public CreateCase
  additionalInformation(AdditionalInformation additionalInformation) {

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
  public void
  setAdditionalInformation(AdditionalInformation additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  public CreateCase freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Texte libre permettant de donner des informations supplémentaires
   *concernant l&#39;affaire
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
    CreateCase createCase = (CreateCase)o;
    return Objects.equals(this.caseId, createCase.caseId) &&
        Objects.equals(this.senderCaseId, createCase.senderCaseId) &&
        Objects.equals(this.creation, createCase.creation) &&
        Objects.equals(this.referenceVersion, createCase.referenceVersion) &&
        Objects.equals(this.qualification, createCase.qualification) &&
        Objects.equals(this.location, createCase.location) &&
        Objects.equals(this.initialAlert, createCase.initialAlert) &&
        Objects.equals(this.newAlert, createCase.newAlert) &&
        Objects.equals(this.additionalInformation,
                       createCase.additionalInformation) &&
        Objects.equals(this.freetext, createCase.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseId, senderCaseId, creation, referenceVersion,
                        qualification, location, initialAlert, newAlert,
                        additionalInformation, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCase {\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    senderCaseId: ")
        .append(toIndentedString(senderCaseId))
        .append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
    sb.append("    referenceVersion: ")
        .append(toIndentedString(referenceVersion))
        .append("\n");
    sb.append("    qualification: ")
        .append(toIndentedString(qualification))
        .append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    initialAlert: ")
        .append(toIndentedString(initialAlert))
        .append("\n");
    sb.append("    newAlert: ").append(toIndentedString(newAlert)).append("\n");
    sb.append("    additionalInformation: ")
        .append(toIndentedString(additionalInformation))
        .append("\n");
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
