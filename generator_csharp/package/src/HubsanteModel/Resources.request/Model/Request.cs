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
using OpenAPIDateConverter = HubsanteModel/Resources.request.Client.OpenAPIDateConverter;

namespace HubsanteModel/Resources.request.Model
{
    /// <summary>
    /// Request
    /// </summary>
    [DataContract(Name = "request")]
    public partial class Request : IValidatableObject
    {
        /// <summary>
        /// A valoriser avec le cadre conventionnel de la demande. Cf nomenclature associée
        /// </summary>
        /// <value>A valoriser avec le cadre conventionnel de la demande. Cf nomenclature associée</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum ConventionEnum
        {
            /// <summary>
            /// Enum DRSIS for value: DRSIS
            /// </summary>
            [EnumMember(Value = "DRSIS")]
            DRSIS = 1,

            /// <summary>
            /// Enum MISSION for value: MISSION
            /// </summary>
            [EnumMember(Value = "MISSION")]
            MISSION = 2,

            /// <summary>
            /// Enum ITSP for value: ITSP
            /// </summary>
            [EnumMember(Value = "ITSP")]
            ITSP = 3,

            /// <summary>
            /// Enum CARENCE for value: CARENCE
            /// </summary>
            [EnumMember(Value = "CARENCE")]
            CARENCE = 4,

            /// <summary>
            /// Enum CONVENT for value: CONVENT
            /// </summary>
            [EnumMember(Value = "CONVENT")]
            CONVENT = 5,

            /// <summary>
            /// Enum SPE for value: SPE
            /// </summary>
            [EnumMember(Value = "SPE")]
            SPE = 6,

            /// <summary>
            /// Enum HORS for value: HORS
            /// </summary>
            [EnumMember(Value = "HORS")]
            HORS = 7,

            /// <summary>
            /// Enum AUTRE1 for value: AUTRE1
            /// </summary>
            [EnumMember(Value = "AUTRE1")]
            AUTRE1 = 8,

            /// <summary>
            /// Enum AUTRE2 for value: AUTRE2
            /// </summary>
            [EnumMember(Value = "AUTRE2")]
            AUTRE2 = 9,

            /// <summary>
            /// Enum AUTRE3 for value: AUTRE3
            /// </summary>
            [EnumMember(Value = "AUTRE3")]
            AUTRE3 = 10
        }


        /// <summary>
        /// A valoriser avec le cadre conventionnel de la demande. Cf nomenclature associée
        /// </summary>
        /// <value>A valoriser avec le cadre conventionnel de la demande. Cf nomenclature associée</value>
        /*
        <example>example.json#/request/convention</example>
        */
        [DataMember(Name = "convention", EmitDefaultValue = false)]
        public ConventionEnum? Convention { get; set; }
        /// <summary>
        /// A valoriser avec le motif de la demande de ressource auprès du partenaire. Cf Nomenclature associée.
        /// </summary>
        /// <value>A valoriser avec le motif de la demande de ressource auprès du partenaire. Cf Nomenclature associée.</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum PurposeEnum
        {
            /// <summary>
            /// Enum SAP for value: SAP
            /// </summary>
            [EnumMember(Value = "SAP")]
            SAP = 1,

            /// <summary>
            /// Enum REGUL for value: REGUL
            /// </summary>
            [EnumMember(Value = "REGUL")]
            REGUL = 2,

            /// <summary>
            /// Enum CUMP for value: CUMP
            /// </summary>
            [EnumMember(Value = "CUMP")]
            CUMP = 3,

            /// <summary>
            /// Enum SMUR for value: SMUR
            /// </summary>
            [EnumMember(Value = "SMUR")]
            SMUR = 4,

            /// <summary>
            /// Enum MG for value: MG
            /// </summary>
            [EnumMember(Value = "MG")]
            MG = 5,

            /// <summary>
            /// Enum PARAMED for value: PARAMED
            /// </summary>
            [EnumMember(Value = "PARAMED")]
            PARAMED = 6,

            /// <summary>
            /// Enum SAMU for value: SAMU
            /// </summary>
            [EnumMember(Value = "SAMU")]
            SAMU = 7,

            /// <summary>
            /// Enum RELEVE for value: RELEVE
            /// </summary>
            [EnumMember(Value = "RELEVE")]
            RELEVE = 8,

            /// <summary>
            /// Enum NOVI for value: NOVI
            /// </summary>
            [EnumMember(Value = "NOVI")]
            NOVI = 9,

            /// <summary>
            /// Enum TIH for value: TIH
            /// </summary>
            [EnumMember(Value = "TIH")]
            TIH = 10,

            /// <summary>
            /// Enum BRANCARD for value: BRANCARD
            /// </summary>
            [EnumMember(Value = "BRANCARD")]
            BRANCARD = 11,

            /// <summary>
            /// Enum BARIA for value: BARIA
            /// </summary>
            [EnumMember(Value = "BARIA")]
            BARIA = 12
        }


        /// <summary>
        /// A valoriser avec le motif de la demande de ressource auprès du partenaire. Cf Nomenclature associée.
        /// </summary>
        /// <value>A valoriser avec le motif de la demande de ressource auprès du partenaire. Cf Nomenclature associée.</value>
        /*
        <example>example.json#/request/purpose</example>
        */
        [DataMember(Name = "purpose", IsRequired = true, EmitDefaultValue = true)]
        public PurposeEnum Purpose { get; set; }
        /// <summary>
        /// A valoriser avec le délai d&#39;intervention maximum souhaité (cf. nomenclature associée)
        /// </summary>
        /// <value>A valoriser avec le délai d&#39;intervention maximum souhaité (cf. nomenclature associée)</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum DeadlineEnum
        {
            /// <summary>
            /// Enum DEL0 for value: DEL0
            /// </summary>
            [EnumMember(Value = "DEL0")]
            DEL0 = 1,

            /// <summary>
            /// Enum ASAP for value: ASAP
            /// </summary>
            [EnumMember(Value = "ASAP")]
            ASAP = 2,

            /// <summary>
            /// Enum _30M for value: 30M
            /// </summary>
            [EnumMember(Value = "30M")]
            _30M = 3,

            /// <summary>
            /// Enum _45M for value: 45M
            /// </summary>
            [EnumMember(Value = "45M")]
            _45M = 4,

            /// <summary>
            /// Enum _1H for value: 1H
            /// </summary>
            [EnumMember(Value = "1H")]
            _1H = 5,

            /// <summary>
            /// Enum _2H for value: 2H
            /// </summary>
            [EnumMember(Value = "2H")]
            _2H = 6,

            /// <summary>
            /// Enum _4H for value: 4H
            /// </summary>
            [EnumMember(Value = "4H")]
            _4H = 7,

            /// <summary>
            /// Enum _8H for value: 8H
            /// </summary>
            [EnumMember(Value = "8H")]
            _8H = 8,

            /// <summary>
            /// Enum _12H for value: 12H
            /// </summary>
            [EnumMember(Value = "12H")]
            _12H = 9,

            /// <summary>
            /// Enum _24H for value: 24H
            /// </summary>
            [EnumMember(Value = "24H")]
            _24H = 10,

            /// <summary>
            /// Enum RDV for value: RDV
            /// </summary>
            [EnumMember(Value = "RDV")]
            RDV = 11
        }


        /// <summary>
        /// A valoriser avec le délai d&#39;intervention maximum souhaité (cf. nomenclature associée)
        /// </summary>
        /// <value>A valoriser avec le délai d&#39;intervention maximum souhaité (cf. nomenclature associée)</value>
        /*
        <example>example.json#/request/deadline</example>
        */
        [DataMember(Name = "deadline", EmitDefaultValue = false)]
        public DeadlineEnum? Deadline { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="Request" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Request() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Request" /> class.
        /// </summary>
        /// <param name="requestId">Identifiant unique partagé de la demande de ressource,  généré une seule fois par le système du partenaire qui émet la demande  Il est valorisé comme suit lors de sa création :  {orgID}.request.{ID unique de la demande dans le système émetteur}  OU - uniquement si un ID unique de la demande n&#39;est pas disponible :  {OrgId émetteur}.request.{senderCaseId}.{numéro d’ordre chronologique} (required).</param>
        /// <param name="datetime">A valoriser avec le groupe date heure de création de la demande (required).</param>
        /// <param name="convention">A valoriser avec le cadre conventionnel de la demande. Cf nomenclature associée.</param>
        /// <param name="purpose">A valoriser avec le motif de la demande de ressource auprès du partenaire. Cf Nomenclature associée. (required).</param>
        /// <param name="deadline">A valoriser avec le délai d&#39;intervention maximum souhaité (cf. nomenclature associée).</param>
        /// <param name="freetext">Texte libre permettant de détailler la demande.</param>
        public Request(string requestId = default(string), DateTime datetime = default(DateTime), ConventionEnum? convention = default(ConventionEnum?), PurposeEnum purpose = default(PurposeEnum), DeadlineEnum? deadline = default(DeadlineEnum?), string freetext = default(string))
        {
            // to ensure "requestId" is required (not null)
            if (requestId == null)
            {
                throw new ArgumentNullException("requestId is a required property for Request and cannot be null");
            }
            this.RequestId = requestId;
            this.Datetime = datetime;
            this.Purpose = purpose;
            this.Convention = convention;
            this.Deadline = deadline;
            this.Freetext = freetext;
        }

        /// <summary>
        /// Identifiant unique partagé de la demande de ressource,  généré une seule fois par le système du partenaire qui émet la demande  Il est valorisé comme suit lors de sa création :  {orgID}.request.{ID unique de la demande dans le système émetteur}  OU - uniquement si un ID unique de la demande n&#39;est pas disponible :  {OrgId émetteur}.request.{senderCaseId}.{numéro d’ordre chronologique}
        /// </summary>
        /// <value>Identifiant unique partagé de la demande de ressource,  généré une seule fois par le système du partenaire qui émet la demande  Il est valorisé comme suit lors de sa création :  {orgID}.request.{ID unique de la demande dans le système émetteur}  OU - uniquement si un ID unique de la demande n&#39;est pas disponible :  {OrgId émetteur}.request.{senderCaseId}.{numéro d’ordre chronologique}</value>
        /*
        <example>example.json#/request/requestId</example>
        */
        [DataMember(Name = "requestId", IsRequired = true, EmitDefaultValue = true)]
        public string RequestId { get; set; }

        /// <summary>
        /// A valoriser avec le groupe date heure de création de la demande
        /// </summary>
        /// <value>A valoriser avec le groupe date heure de création de la demande</value>
        [DataMember(Name = "datetime", IsRequired = true, EmitDefaultValue = true)]
        public DateTime Datetime { get; set; }

        /// <summary>
        /// Texte libre permettant de détailler la demande
        /// </summary>
        /// <value>Texte libre permettant de détailler la demande</value>
        /*
        <example>example.json#/request/freetext</example>
        */
        [DataMember(Name = "freetext", EmitDefaultValue = false)]
        public string Freetext { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Request {\n");
            sb.Append("  RequestId: ").Append(RequestId).Append("\n");
            sb.Append("  Datetime: ").Append(Datetime).Append("\n");
            sb.Append("  Convention: ").Append(Convention).Append("\n");
            sb.Append("  Purpose: ").Append(Purpose).Append("\n");
            sb.Append("  Deadline: ").Append(Deadline).Append("\n");
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
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            if (this.RequestId != null) {
                // RequestId (string) pattern
                Regex regexRequestId = new Regex(@"^([\w-]+\.){3,4}request(\.[\w-]+){1,2}$", RegexOptions.CultureInvariant);
                if (!regexRequestId.Match(this.RequestId).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for RequestId, must match a pattern of " + regexRequestId, new [] { "RequestId" });
                }
            }

            if (this.Datetime != null) {
                // Datetime (DateTime) pattern
                Regex regexDatetime = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexDatetime.Match(this.Datetime).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for Datetime, must match a pattern of " + regexDatetime, new [] { "Datetime" });
                }
            }

            yield break;
        }
    }

}