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
    /// CreateCaseHealth
    /// </summary>
    [DataContract(Name = "createCaseHealth")]
    public partial class CreateCaseHealth : IEquatable<CreateCaseHealth>, IValidatableObject
    {
        /// <summary>
        /// Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être adressé/affiché, lorsque celle-ci est spécifique ou dédiée.
        /// </summary>
        /// <value>Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être adressé/affiché, lorsque celle-ci est spécifique ou dédiée.</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum PerimeterEnum
        {
            /// <summary>
            /// Enum AMU for value: AMU
            /// </summary>
            [EnumMember(Value = "AMU")]
            AMU = 1,

            /// <summary>
            /// Enum NEONAT for value: NEONAT
            /// </summary>
            [EnumMember(Value = "NEONAT")]
            NEONAT = 2,

            /// <summary>
            /// Enum PSY for value: PSY
            /// </summary>
            [EnumMember(Value = "PSY")]
            PSY = 3,

            /// <summary>
            /// Enum SNP for value: SNP
            /// </summary>
            [EnumMember(Value = "SNP")]
            SNP = 4
        }


        /// <summary>
        /// Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être adressé/affiché, lorsque celle-ci est spécifique ou dédiée.
        /// </summary>
        /// <value>Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être adressé/affiché, lorsque celle-ci est spécifique ou dédiée.</value>
        /// <example>example.json#/perimeter</example>
        [DataMember(Name = "perimeter", EmitDefaultValue = false)]
        public PerimeterEnum? Perimeter { get; set; }
        /// <summary>
        /// A valoriser en indiquant s&#39;il s&#39;agit d&#39;un dossier dit primaire (première intervention urgente) ou secondaire (par exemple TIH)
        /// </summary>
        /// <value>A valoriser en indiquant s&#39;il s&#39;agit d&#39;un dossier dit primaire (première intervention urgente) ou secondaire (par exemple TIH)</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum InterventionTypeEnum
        {
            /// <summary>
            /// Enum T1 for value: T1
            /// </summary>
            [EnumMember(Value = "T1")]
            T1 = 1,

            /// <summary>
            /// Enum T2INTER for value: T2-INTER
            /// </summary>
            [EnumMember(Value = "T2-INTER")]
            T2INTER = 2,

            /// <summary>
            /// Enum T2INTRA for value: T2-INTRA
            /// </summary>
            [EnumMember(Value = "T2-INTRA")]
            T2INTRA = 3,

            /// <summary>
            /// Enum T3 for value: T3
            /// </summary>
            [EnumMember(Value = "T3")]
            T3 = 4,

            /// <summary>
            /// Enum T4 for value: T4
            /// </summary>
            [EnumMember(Value = "T4")]
            T4 = 5
        }


        /// <summary>
        /// A valoriser en indiquant s&#39;il s&#39;agit d&#39;un dossier dit primaire (première intervention urgente) ou secondaire (par exemple TIH)
        /// </summary>
        /// <value>A valoriser en indiquant s&#39;il s&#39;agit d&#39;un dossier dit primaire (première intervention urgente) ou secondaire (par exemple TIH)</value>
        /// <example>example.json#/interventionType</example>
        [DataMember(Name = "interventionType", EmitDefaultValue = false)]
        public InterventionTypeEnum? InterventionType { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="CreateCaseHealth" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected CreateCaseHealth() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="CreateCaseHealth" /> class.
        /// </summary>
        /// <param name="caseId">Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système. (required).</param>
        /// <param name="senderCaseId">A valoriser avec le numéro du dossier dans le SI de l&#39;émetteur du message. .</param>
        /// <param name="creation">A valoriser avec le groupe date heure de création du dossier/affaire.  Spécificité 15-18 : A valoriser avec le groupe date heure de début de partage lié à la création de l&#39;affaire (et donc de génération du caseId).  Lors de l&#39;ajout d&#39;une nouvelle alerte, la valeur de ce champ ne doit pas être modifiée.   L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé. Il doit être renseigné à la fin du processus de la  création de la première alerte. (required).</param>
        /// <param name="perimeter">Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être adressé/affiché, lorsque celle-ci est spécifique ou dédiée..</param>
        /// <param name="interventionType">A valoriser en indiquant s&#39;il s&#39;agit d&#39;un dossier dit primaire (première intervention urgente) ou secondaire (par exemple TIH).</param>
        /// <param name="qualification">qualification (required).</param>
        /// <param name="location">location (required).</param>
        /// <param name="initialAlert">initialAlert.</param>
        /// <param name="owner">Attribut qui permet de transférer la prise en charge d&#39;un dossier à un autre CRAA A valoriser avec l&#39;identifiant de l&#39;organisation concerné (orgId &#x3D; {pays}.{domaine}.{organisation}) (required).</param>
        /// <param name="patient">patient.</param>
        /// <param name="medicalNote">medicalNote.</param>
        /// <param name="decision">decision.</param>
        /// <param name="additionalInformation">additionalInformation.</param>
        public CreateCaseHealth(string caseId = default(string), string senderCaseId = default(string), DateTime creation = default(DateTime), PerimeterEnum? perimeter = default(PerimeterEnum?), InterventionTypeEnum? interventionType = default(InterventionTypeEnum?), Qualification qualification = default(Qualification), Location location = default(Location), Alert initialAlert = default(Alert), string owner = default(string), List<Patient> patient = default(List<Patient>), List<MedicalNote> medicalNote = default(List<MedicalNote>), List<Decision> decision = default(List<Decision>), AdditionalInformation additionalInformation = default(AdditionalInformation))
        {
            // to ensure "caseId" is required (not null)
            if (caseId == null)
            {
                throw new ArgumentNullException("caseId is a required property for CreateCaseHealth and cannot be null");
            }
            this.CaseId = caseId;
            this.Creation = creation;
            // to ensure "qualification" is required (not null)
            if (qualification == null)
            {
                throw new ArgumentNullException("qualification is a required property for CreateCaseHealth and cannot be null");
            }
            this.Qualification = qualification;
            // to ensure "location" is required (not null)
            if (location == null)
            {
                throw new ArgumentNullException("location is a required property for CreateCaseHealth and cannot be null");
            }
            this.Location = location;
            // to ensure "owner" is required (not null)
            if (owner == null)
            {
                throw new ArgumentNullException("owner is a required property for CreateCaseHealth and cannot be null");
            }
            this.Owner = owner;
            this.SenderCaseId = senderCaseId;
            this.Perimeter = perimeter;
            this.InterventionType = interventionType;
            this.InitialAlert = initialAlert;
            this.Patient = patient;
            this.MedicalNote = medicalNote;
            this.Decision = decision;
            this.AdditionalInformation = additionalInformation;
        }

        /// <summary>
        /// Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système.
        /// </summary>
        /// <value>Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système.</value>
        /// <example>example.json#/caseId</example>
        [DataMember(Name = "caseId", IsRequired = true, EmitDefaultValue = true)]
        public string CaseId { get; set; }

        /// <summary>
        /// A valoriser avec le numéro du dossier dans le SI de l&#39;émetteur du message. 
        /// </summary>
        /// <value>A valoriser avec le numéro du dossier dans le SI de l&#39;émetteur du message. </value>
        /// <example>example.json#/senderCaseId</example>
        [DataMember(Name = "senderCaseId", EmitDefaultValue = false)]
        public string SenderCaseId { get; set; }

        /// <summary>
        /// A valoriser avec le groupe date heure de création du dossier/affaire.  Spécificité 15-18 : A valoriser avec le groupe date heure de début de partage lié à la création de l&#39;affaire (et donc de génération du caseId).  Lors de l&#39;ajout d&#39;une nouvelle alerte, la valeur de ce champ ne doit pas être modifiée.   L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé. Il doit être renseigné à la fin du processus de la  création de la première alerte.
        /// </summary>
        /// <value>A valoriser avec le groupe date heure de création du dossier/affaire.  Spécificité 15-18 : A valoriser avec le groupe date heure de début de partage lié à la création de l&#39;affaire (et donc de génération du caseId).  Lors de l&#39;ajout d&#39;une nouvelle alerte, la valeur de ce champ ne doit pas être modifiée.   L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé. Il doit être renseigné à la fin du processus de la  création de la première alerte.</value>
        [DataMember(Name = "creation", IsRequired = true, EmitDefaultValue = true)]
        public DateTime Creation { get; set; }

        /// <summary>
        /// Gets or Sets Qualification
        /// </summary>
        [DataMember(Name = "qualification", IsRequired = true, EmitDefaultValue = true)]
        public Qualification Qualification { get; set; }

        /// <summary>
        /// Gets or Sets Location
        /// </summary>
        [DataMember(Name = "location", IsRequired = true, EmitDefaultValue = true)]
        public Location Location { get; set; }

        /// <summary>
        /// Gets or Sets InitialAlert
        /// </summary>
        [DataMember(Name = "initialAlert", EmitDefaultValue = false)]
        public Alert InitialAlert { get; set; }

        /// <summary>
        /// Attribut qui permet de transférer la prise en charge d&#39;un dossier à un autre CRAA A valoriser avec l&#39;identifiant de l&#39;organisation concerné (orgId &#x3D; {pays}.{domaine}.{organisation})
        /// </summary>
        /// <value>Attribut qui permet de transférer la prise en charge d&#39;un dossier à un autre CRAA A valoriser avec l&#39;identifiant de l&#39;organisation concerné (orgId &#x3D; {pays}.{domaine}.{organisation})</value>
        /// <example>example.json#/owner</example>
        [DataMember(Name = "owner", IsRequired = true, EmitDefaultValue = true)]
        public string Owner { get; set; }

        /// <summary>
        /// Gets or Sets Patient
        /// </summary>
        [DataMember(Name = "patient", EmitDefaultValue = false)]
        public List<Patient> Patient { get; set; }

        /// <summary>
        /// Gets or Sets MedicalNote
        /// </summary>
        [DataMember(Name = "medicalNote", EmitDefaultValue = false)]
        public List<MedicalNote> MedicalNote { get; set; }

        /// <summary>
        /// Gets or Sets Decision
        /// </summary>
        [DataMember(Name = "decision", EmitDefaultValue = false)]
        public List<Decision> Decision { get; set; }

        /// <summary>
        /// Gets or Sets AdditionalInformation
        /// </summary>
        [DataMember(Name = "additionalInformation", EmitDefaultValue = false)]
        public AdditionalInformation AdditionalInformation { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class CreateCaseHealth {\n");
            sb.Append("  CaseId: ").Append(CaseId).Append("\n");
            sb.Append("  SenderCaseId: ").Append(SenderCaseId).Append("\n");
            sb.Append("  Creation: ").Append(Creation).Append("\n");
            sb.Append("  Perimeter: ").Append(Perimeter).Append("\n");
            sb.Append("  InterventionType: ").Append(InterventionType).Append("\n");
            sb.Append("  Qualification: ").Append(Qualification).Append("\n");
            sb.Append("  Location: ").Append(Location).Append("\n");
            sb.Append("  InitialAlert: ").Append(InitialAlert).Append("\n");
            sb.Append("  Owner: ").Append(Owner).Append("\n");
            sb.Append("  Patient: ").Append(Patient).Append("\n");
            sb.Append("  MedicalNote: ").Append(MedicalNote).Append("\n");
            sb.Append("  Decision: ").Append(Decision).Append("\n");
            sb.Append("  AdditionalInformation: ").Append(AdditionalInformation).Append("\n");
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
            return this.Equals(input as CreateCaseHealth);
        }

        /// <summary>
        /// Returns true if CreateCaseHealth instances are equal
        /// </summary>
        /// <param name="input">Instance of CreateCaseHealth to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(CreateCaseHealth input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.CaseId == input.CaseId ||
                    (this.CaseId != null &&
                    this.CaseId.Equals(input.CaseId))
                ) && 
                (
                    this.SenderCaseId == input.SenderCaseId ||
                    (this.SenderCaseId != null &&
                    this.SenderCaseId.Equals(input.SenderCaseId))
                ) && 
                (
                    this.Creation == input.Creation ||
                    (this.Creation != null &&
                    this.Creation.Equals(input.Creation))
                ) && 
                (
                    this.Perimeter == input.Perimeter ||
                    this.Perimeter.Equals(input.Perimeter)
                ) && 
                (
                    this.InterventionType == input.InterventionType ||
                    this.InterventionType.Equals(input.InterventionType)
                ) && 
                (
                    this.Qualification == input.Qualification ||
                    (this.Qualification != null &&
                    this.Qualification.Equals(input.Qualification))
                ) && 
                (
                    this.Location == input.Location ||
                    (this.Location != null &&
                    this.Location.Equals(input.Location))
                ) && 
                (
                    this.InitialAlert == input.InitialAlert ||
                    (this.InitialAlert != null &&
                    this.InitialAlert.Equals(input.InitialAlert))
                ) && 
                (
                    this.Owner == input.Owner ||
                    (this.Owner != null &&
                    this.Owner.Equals(input.Owner))
                ) && 
                (
                    this.Patient == input.Patient ||
                    this.Patient != null &&
                    input.Patient != null &&
                    this.Patient.SequenceEqual(input.Patient)
                ) && 
                (
                    this.MedicalNote == input.MedicalNote ||
                    this.MedicalNote != null &&
                    input.MedicalNote != null &&
                    this.MedicalNote.SequenceEqual(input.MedicalNote)
                ) && 
                (
                    this.Decision == input.Decision ||
                    this.Decision != null &&
                    input.Decision != null &&
                    this.Decision.SequenceEqual(input.Decision)
                ) && 
                (
                    this.AdditionalInformation == input.AdditionalInformation ||
                    (this.AdditionalInformation != null &&
                    this.AdditionalInformation.Equals(input.AdditionalInformation))
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
                if (this.CaseId != null)
                {
                    hashCode = (hashCode * 59) + this.CaseId.GetHashCode();
                }
                if (this.SenderCaseId != null)
                {
                    hashCode = (hashCode * 59) + this.SenderCaseId.GetHashCode();
                }
                if (this.Creation != null)
                {
                    hashCode = (hashCode * 59) + this.Creation.GetHashCode();
                }
                hashCode = (hashCode * 59) + this.Perimeter.GetHashCode();
                hashCode = (hashCode * 59) + this.InterventionType.GetHashCode();
                if (this.Qualification != null)
                {
                    hashCode = (hashCode * 59) + this.Qualification.GetHashCode();
                }
                if (this.Location != null)
                {
                    hashCode = (hashCode * 59) + this.Location.GetHashCode();
                }
                if (this.InitialAlert != null)
                {
                    hashCode = (hashCode * 59) + this.InitialAlert.GetHashCode();
                }
                if (this.Owner != null)
                {
                    hashCode = (hashCode * 59) + this.Owner.GetHashCode();
                }
                if (this.Patient != null)
                {
                    hashCode = (hashCode * 59) + this.Patient.GetHashCode();
                }
                if (this.MedicalNote != null)
                {
                    hashCode = (hashCode * 59) + this.MedicalNote.GetHashCode();
                }
                if (this.Decision != null)
                {
                    hashCode = (hashCode * 59) + this.Decision.GetHashCode();
                }
                if (this.AdditionalInformation != null)
                {
                    hashCode = (hashCode * 59) + this.AdditionalInformation.GetHashCode();
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
            if (this.CaseId != null) {
                // CaseId (string) pattern
                Regex regexCaseId = new Regex(@"^fr(\.[\w-]+){3,4}$", RegexOptions.CultureInvariant);
                if (!regexCaseId.Match(this.CaseId).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for CaseId, must match a pattern of " + regexCaseId, new [] { "CaseId" });
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

            if (this.Owner != null) {
                // Owner (string) pattern
                Regex regexOwner = new Regex(@"^fr(\.[\w-]+){2,3}$", RegexOptions.CultureInvariant);
                if (!regexOwner.Match(this.Owner).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for Owner, must match a pattern of " + regexOwner, new [] { "Owner" });
                }
            }

            yield break;
        }
    }

}
