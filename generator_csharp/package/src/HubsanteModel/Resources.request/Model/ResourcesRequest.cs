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
    /// ResourcesRequest
    /// </summary>
    [DataContract(Name = "resourcesRequest")]
    public partial class ResourcesRequest : IValidatableObject
    {
        /// <summary>
        /// A valoriser avec l&#39;état d&#39;annulation de la demande le cas échéant
        /// </summary>
        /// <value>A valoriser avec l&#39;état d&#39;annulation de la demande le cas échéant</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum StatusEnum
        {
            /// <summary>
            /// Enum ANNULEE for value: ANNULEE
            /// </summary>
            [EnumMember(Value = "ANNULEE")]
            ANNULEE = 1
        }


        /// <summary>
        /// A valoriser avec l&#39;état d&#39;annulation de la demande le cas échéant
        /// </summary>
        /// <value>A valoriser avec l&#39;état d&#39;annulation de la demande le cas échéant</value>
        /*
        <example>example.json#/status</example>
        */
        [DataMember(Name = "status", EmitDefaultValue = false)]
        public StatusEnum? Status { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="ResourcesRequest" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected ResourcesRequest() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="ResourcesRequest" /> class.
        /// </summary>
        /// <param name="caseId">A valoriser avec l&#39;identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système. (required).</param>
        /// <param name="request">request (required).</param>
        /// <param name="status">A valoriser avec l&#39;état d&#39;annulation de la demande le cas échéant.</param>
        public ResourcesRequest(string caseId = default(string), Request request = default(Request), StatusEnum? status = default(StatusEnum?))
        {
            // to ensure "caseId" is required (not null)
            if (caseId == null)
            {
                throw new ArgumentNullException("caseId is a required property for ResourcesRequest and cannot be null");
            }
            this.CaseId = caseId;
            // to ensure "request" is required (not null)
            if (request == null)
            {
                throw new ArgumentNullException("request is a required property for ResourcesRequest and cannot be null");
            }
            this.Request = request;
            this.Status = status;
        }

        /// <summary>
        /// A valoriser avec l&#39;identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système.
        /// </summary>
        /// <value>A valoriser avec l&#39;identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système.</value>
        /*
        <example>example.json#/caseId</example>
        */
        [DataMember(Name = "caseId", IsRequired = true, EmitDefaultValue = true)]
        public string CaseId { get; set; }

        /// <summary>
        /// Gets or Sets Request
        /// </summary>
        [DataMember(Name = "request", IsRequired = true, EmitDefaultValue = true)]
        public Request Request { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class ResourcesRequest {\n");
            sb.Append("  CaseId: ").Append(CaseId).Append("\n");
            sb.Append("  Request: ").Append(Request).Append("\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
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

            yield break;
        }
    }

}
