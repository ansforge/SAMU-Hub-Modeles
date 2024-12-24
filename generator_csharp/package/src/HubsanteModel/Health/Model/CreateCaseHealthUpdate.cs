/*
 * OpenAPI
 *
 * OpenAPI
 *
 * The version of the OpenAPI document: 0.0.1
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
using OpenAPIDateConverter = HubsanteModel/Health.Client.OpenAPIDateConverter;

namespace HubsanteModel/Health.Model
{
    /// <summary>
    /// CreateCaseHealthUpdate
    /// </summary>
    [DataContract(Name = "createCaseHealthUpdate")]
    public partial class CreateCaseHealthUpdate : IValidatableObject
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
        /*
        <example>example.json#/perimeter</example>
        */
        [DataMember(Name = "perimeter", EmitDefaultValue = false)]
        public PerimeterEnum? Perimeter { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="CreateCaseHealthUpdate" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected CreateCaseHealthUpdate() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="CreateCaseHealthUpdate" /> class.
        /// </summary>
        /// <param name="caseId">Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système. (required).</param>
        /// <param name="senderCaseId">A valoriser avec le numéro du dossier dans le SI de l&#39;émetteur du message. .</param>
        /// <param name="perimeter">Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être adressé/affiché, lorsque celle-ci est spécifique ou dédiée..</param>
        /// <param name="qualification">qualification.</param>
        /// <param name="location">location.</param>
        /// <param name="initialAlert">initialAlert.</param>
        /// <param name="owner">Attribut qui permet de transférer la prise en charge d&#39;un dossier à un autre CRAA A valoriser avec l&#39;identifiant de l&#39;organisation concerné (orgId &#x3D; {pays}.{domaine}.{organisation}).</param>
        /// <param name="patient">patient.</param>
        /// <param name="medicalNote">medicalNote.</param>
        /// <param name="decision">decision.</param>
        /// <param name="freetext">Champ libre qui permet de concaténer en une seule note toutes les autres valeurs modifiées dans le dossier, ne figurant pas de manière structurée dans le RS-EDA-MAJ..</param>
        /// <param name="additionalInformation">additionalInformation.</param>
        public CreateCaseHealthUpdate(string caseId = default(string), string senderCaseId = default(string), PerimeterEnum? perimeter = default(PerimeterEnum?), Qualification qualification = default(Qualification), Location location = default(Location), Alert initialAlert = default(Alert), string owner = default(string), List<Patient> patient = default(List<Patient>), List<MedicalNote> medicalNote = default(List<MedicalNote>), List<Decision> decision = default(List<Decision>), string freetext = default(string), AdditionalInformation additionalInformation = default(AdditionalInformation))
        {
            // to ensure "caseId" is required (not null)
            if (caseId == null)
            {
                throw new ArgumentNullException("caseId is a required property for CreateCaseHealthUpdate and cannot be null");
            }
            this.CaseId = caseId;
            this.SenderCaseId = senderCaseId;
            this.Perimeter = perimeter;
            this.Qualification = qualification;
            this.Location = location;
            this.InitialAlert = initialAlert;
            this.Owner = owner;
            this.Patient = patient;
            this.MedicalNote = medicalNote;
            this.Decision = decision;
            this.Freetext = freetext;
            this.AdditionalInformation = additionalInformation;
        }

        /// <summary>
        /// Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système.
        /// </summary>
        /// <value>Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système.</value>
        /*
        <example>example.json#/caseId</example>
        */
        [DataMember(Name = "caseId", IsRequired = true, EmitDefaultValue = true)]
        public string CaseId { get; set; }

        /// <summary>
        /// A valoriser avec le numéro du dossier dans le SI de l&#39;émetteur du message. 
        /// </summary>
        /// <value>A valoriser avec le numéro du dossier dans le SI de l&#39;émetteur du message. </value>
        /*
        <example>example.json#/senderCaseId</example>
        */
        [DataMember(Name = "senderCaseId", EmitDefaultValue = false)]
        public string SenderCaseId { get; set; }

        /// <summary>
        /// Gets or Sets Qualification
        /// </summary>
        [DataMember(Name = "qualification", EmitDefaultValue = false)]
        public Qualification Qualification { get; set; }

        /// <summary>
        /// Gets or Sets Location
        /// </summary>
        [DataMember(Name = "location", EmitDefaultValue = false)]
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
        /*
        <example>example.json#/owner</example>
        */
        [DataMember(Name = "owner", EmitDefaultValue = false)]
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
        /// Champ libre qui permet de concaténer en une seule note toutes les autres valeurs modifiées dans le dossier, ne figurant pas de manière structurée dans le RS-EDA-MAJ.
        /// </summary>
        /// <value>Champ libre qui permet de concaténer en une seule note toutes les autres valeurs modifiées dans le dossier, ne figurant pas de manière structurée dans le RS-EDA-MAJ.</value>
        /*
        <example>example.json#/freetext</example>
        */
        [DataMember(Name = "freetext", EmitDefaultValue = false)]
        public string Freetext { get; set; }

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
            sb.Append("class CreateCaseHealthUpdate {\n");
            sb.Append("  CaseId: ").Append(CaseId).Append("\n");
            sb.Append("  SenderCaseId: ").Append(SenderCaseId).Append("\n");
            sb.Append("  Perimeter: ").Append(Perimeter).Append("\n");
            sb.Append("  Qualification: ").Append(Qualification).Append("\n");
            sb.Append("  Location: ").Append(Location).Append("\n");
            sb.Append("  InitialAlert: ").Append(InitialAlert).Append("\n");
            sb.Append("  Owner: ").Append(Owner).Append("\n");
            sb.Append("  Patient: ").Append(Patient).Append("\n");
            sb.Append("  MedicalNote: ").Append(MedicalNote).Append("\n");
            sb.Append("  Decision: ").Append(Decision).Append("\n");
            sb.Append("  Freetext: ").Append(Freetext).Append("\n");
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
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            if (this.CaseId != null) {
                // CaseId (string) pattern
                Regex regexCaseId = new Regex(@"^fr(\.[\w-]+){3,4}$", RegexOptions.CultureInvariant);
                if (!regexCaseId.Match(this.CaseId).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for CaseId, must match a pattern of " + regexCaseId, new [] { "CaseId" });
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
