/*
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using System.ComponentModel.DataAnnotations;
using OpenAPIDateConverter = HubsanteModel.Health.Client.OpenAPIDateConverter;

namespace HubsanteModel.Health.Model
{
    /// <summary>
    /// MedicalNote
    /// </summary>
    [DataContract(Name = "medicalNote")]
    public partial class MedicalNote : IEquatable<MedicalNote>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="MedicalNote" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected MedicalNote() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="MedicalNote" /> class.
        /// </summary>
        /// <param name="patientId">Identifiant partagé du patient concerné par l&#39;observation, a remplir obligatoirement si ce patient existe et est identifié dans le système emetteur,   Valorisé comme suit lors de sa création :  {OrgId émetteur}.patient.{n°patient unique dans le système émetteur}  OU, si un n°patient unique n&#39;existe pas dans le système émetteur : {ID émetteur}.{senderCaseId}.patient.{numéro d’ordre chronologique au dossier}.</param>
        /// <param name="varOperator">varOperator (required).</param>
        /// <param name="medicalNoteId">Identifiant partagé de l&#39;observation, généré une seule fois par le système du partenaire qui créé l&#39;observation Il est valorisé comme suit lors de sa création :  {OrgId émetteur}.medicalNote.{ID unique de l’observation dans le système émetteur}  OU - uniquement dans le cas où un ID unique de la note n&#39;est pas disponible dans le système :  {OrgId émetteur}.medicalNote.{senderCaseId}.{numéro chronologique de l’observation}  Cet identifiant a vocation à devenir obligatoire pour permettre les mises à jour, il est laissé en facultatif temporairement.  (required).</param>
        /// <param name="creation">A valoriser avec le groupe date heure de création de l&#39;observation.  L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé..</param>
        /// <param name="freetext">Champ libre qui permet de compléter les informations de nature médicales, faites par un ARM, un médecin ou un autre professionnel de santé. (required).</param>
        public MedicalNote(string patientId = default(string), Operator varOperator = default(Operator), string medicalNoteId = default(string), DateTime creation = default(DateTime), string freetext = default(string))
        {
            // to ensure "varOperator" is required (not null)
            if (varOperator == null)
            {
                throw new ArgumentNullException("varOperator is a required property for MedicalNote and cannot be null");
            }
            this.VarOperator = varOperator;
            // to ensure "medicalNoteId" is required (not null)
            if (medicalNoteId == null)
            {
                throw new ArgumentNullException("medicalNoteId is a required property for MedicalNote and cannot be null");
            }
            this.MedicalNoteId = medicalNoteId;
            // to ensure "freetext" is required (not null)
            if (freetext == null)
            {
                throw new ArgumentNullException("freetext is a required property for MedicalNote and cannot be null");
            }
            this.Freetext = freetext;
            this.PatientId = patientId;
            this.Creation = creation;
        }

        /// <summary>
        /// Identifiant partagé du patient concerné par l&#39;observation, a remplir obligatoirement si ce patient existe et est identifié dans le système emetteur,   Valorisé comme suit lors de sa création :  {OrgId émetteur}.patient.{n°patient unique dans le système émetteur}  OU, si un n°patient unique n&#39;existe pas dans le système émetteur : {ID émetteur}.{senderCaseId}.patient.{numéro d’ordre chronologique au dossier}
        /// </summary>
        /// <value>Identifiant partagé du patient concerné par l&#39;observation, a remplir obligatoirement si ce patient existe et est identifié dans le système emetteur,   Valorisé comme suit lors de sa création :  {OrgId émetteur}.patient.{n°patient unique dans le système émetteur}  OU, si un n°patient unique n&#39;existe pas dans le système émetteur : {ID émetteur}.{senderCaseId}.patient.{numéro d’ordre chronologique au dossier}</value>
        /// <example>example.json#/medicalNote/0/patientId</example>
        [DataMember(Name = "patientId", EmitDefaultValue = false)]
        public string PatientId { get; set; }

        /// <summary>
        /// Gets or Sets VarOperator
        /// </summary>
        [DataMember(Name = "operator", IsRequired = true, EmitDefaultValue = true)]
        public Operator VarOperator { get; set; }

        /// <summary>
        /// Identifiant partagé de l&#39;observation, généré une seule fois par le système du partenaire qui créé l&#39;observation Il est valorisé comme suit lors de sa création :  {OrgId émetteur}.medicalNote.{ID unique de l’observation dans le système émetteur}  OU - uniquement dans le cas où un ID unique de la note n&#39;est pas disponible dans le système :  {OrgId émetteur}.medicalNote.{senderCaseId}.{numéro chronologique de l’observation}  Cet identifiant a vocation à devenir obligatoire pour permettre les mises à jour, il est laissé en facultatif temporairement. 
        /// </summary>
        /// <value>Identifiant partagé de l&#39;observation, généré une seule fois par le système du partenaire qui créé l&#39;observation Il est valorisé comme suit lors de sa création :  {OrgId émetteur}.medicalNote.{ID unique de l’observation dans le système émetteur}  OU - uniquement dans le cas où un ID unique de la note n&#39;est pas disponible dans le système :  {OrgId émetteur}.medicalNote.{senderCaseId}.{numéro chronologique de l’observation}  Cet identifiant a vocation à devenir obligatoire pour permettre les mises à jour, il est laissé en facultatif temporairement. </value>
        /// <example>example.json#/medicalNote/0/medicalNoteId</example>
        [DataMember(Name = "medicalNoteId", IsRequired = true, EmitDefaultValue = true)]
        public string MedicalNoteId { get; set; }

        /// <summary>
        /// A valoriser avec le groupe date heure de création de l&#39;observation.  L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé.
        /// </summary>
        /// <value>A valoriser avec le groupe date heure de création de l&#39;observation.  L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé.</value>
        [DataMember(Name = "creation", EmitDefaultValue = false)]
        public DateTime Creation { get; set; }

        /// <summary>
        /// Champ libre qui permet de compléter les informations de nature médicales, faites par un ARM, un médecin ou un autre professionnel de santé.
        /// </summary>
        /// <value>Champ libre qui permet de compléter les informations de nature médicales, faites par un ARM, un médecin ou un autre professionnel de santé.</value>
        /// <example>example.json#/medicalNote/0/freetext</example>
        [DataMember(Name = "freetext", IsRequired = true, EmitDefaultValue = true)]
        public string Freetext { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class MedicalNote {\n");
            sb.Append("  PatientId: ").Append(PatientId).Append("\n");
            sb.Append("  VarOperator: ").Append(VarOperator).Append("\n");
            sb.Append("  MedicalNoteId: ").Append(MedicalNoteId).Append("\n");
            sb.Append("  Creation: ").Append(Creation).Append("\n");
            sb.Append("  Freetext: ").Append(Freetext).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }

        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public virtual string ToJson()
        {
            return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="input">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object input)
        {
            return this.Equals(input as MedicalNote);
        }

        /// <summary>
        /// Returns true if MedicalNote instances are equal
        /// </summary>
        /// <param name="input">Instance of MedicalNote to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(MedicalNote input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.PatientId == input.PatientId ||
                    (this.PatientId != null &&
                    this.PatientId.Equals(input.PatientId))
                ) && 
                (
                    this.VarOperator == input.VarOperator ||
                    (this.VarOperator != null &&
                    this.VarOperator.Equals(input.VarOperator))
                ) && 
                (
                    this.MedicalNoteId == input.MedicalNoteId ||
                    (this.MedicalNoteId != null &&
                    this.MedicalNoteId.Equals(input.MedicalNoteId))
                ) && 
                (
                    this.Creation == input.Creation ||
                    (this.Creation != null &&
                    this.Creation.Equals(input.Creation))
                ) && 
                (
                    this.Freetext == input.Freetext ||
                    (this.Freetext != null &&
                    this.Freetext.Equals(input.Freetext))
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            unchecked // Overflow is fine, just wrap
            {
                int hashCode = 41;
                if (this.PatientId != null)
                {
                    hashCode = (hashCode * 59) + this.PatientId.GetHashCode();
                }
                if (this.VarOperator != null)
                {
                    hashCode = (hashCode * 59) + this.VarOperator.GetHashCode();
                }
                if (this.MedicalNoteId != null)
                {
                    hashCode = (hashCode * 59) + this.MedicalNoteId.GetHashCode();
                }
                if (this.Creation != null)
                {
                    hashCode = (hashCode * 59) + this.Creation.GetHashCode();
                }
                if (this.Freetext != null)
                {
                    hashCode = (hashCode * 59) + this.Freetext.GetHashCode();
                }
                return hashCode;
            }
        }

        /// <summary>
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            if (this.PatientId != null) {
                // PatientId (string) pattern
                Regex regexPatientId = new Regex(@"^([\w-]+\.){3,4}patient(\.[\w-]+){1,2}$", RegexOptions.CultureInvariant);
                if (!regexPatientId.Match(this.PatientId).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for PatientId, must match a pattern of " + regexPatientId, new [] { "PatientId" });
                }
            }

            if (this.MedicalNoteId != null) {
                // MedicalNoteId (string) pattern
                Regex regexMedicalNoteId = new Regex(@"^([\w-]+\.){3,4}medicalNote(\.[\w-]+){1,2}$", RegexOptions.CultureInvariant);
                if (!regexMedicalNoteId.Match(this.MedicalNoteId).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for MedicalNoteId, must match a pattern of " + regexMedicalNoteId, new [] { "MedicalNoteId" });
                }
            }

            if (this.Creation != null) {
                // Creation (DateTime) pattern
                Regex regexCreation = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexCreation.Match(this.Creation).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for Creation, must match a pattern of " + regexCreation, new [] { "Creation" });
                }
            }

            yield break;
        }
    }

}
