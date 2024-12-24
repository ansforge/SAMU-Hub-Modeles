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
using OpenAPIDateConverter = HubsanteModel/Interventionreport.Client.OpenAPIDateConverter;

namespace HubsanteModel/Interventionreport.Model
{
    /// <summary>
    /// ExternalId
    /// </summary>
    [DataContract(Name = "externalId")]
    public partial class ExternalId : IValidatableObject
    {
        /// <summary>
        /// Type de l&#39;identifiant fourni
        /// </summary>
        /// <value>Type de l&#39;identifiant fourni</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum SourceEnum
        {
            /// <summary>
            /// Enum NIR for value: NIR
            /// </summary>
            [EnumMember(Value = "NIR")]
            NIR = 1,

            /// <summary>
            /// Enum SINUS for value: SINUS
            /// </summary>
            [EnumMember(Value = "SINUS")]
            SINUS = 2,

            /// <summary>
            /// Enum SIVIC for value: SI-VIC
            /// </summary>
            [EnumMember(Value = "SI-VIC")]
            SIVIC = 3,

            /// <summary>
            /// Enum DOSSARD for value: DOSSARD
            /// </summary>
            [EnumMember(Value = "DOSSARD")]
            DOSSARD = 4,

            /// <summary>
            /// Enum PLACE for value: PLACE
            /// </summary>
            [EnumMember(Value = "PLACE")]
            PLACE = 5
        }


        /// <summary>
        /// Type de l&#39;identifiant fourni
        /// </summary>
        /// <value>Type de l&#39;identifiant fourni</value>
        /*
        <example>example.json#/patient/externalId/0/source</example>
        */
        [DataMember(Name = "source", IsRequired = true, EmitDefaultValue = true)]
        public SourceEnum Source { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="ExternalId" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected ExternalId() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="ExternalId" /> class.
        /// </summary>
        /// <param name="source">Type de l&#39;identifiant fourni (required).</param>
        /// <param name="value">L&#39;identifiant en lui-même (required).</param>
        public ExternalId(SourceEnum source = default(SourceEnum), string value = default(string))
        {
            this.Source = source;
            // to ensure "value" is required (not null)
            if (value == null)
            {
                throw new ArgumentNullException("value is a required property for ExternalId and cannot be null");
            }
            this.Value = value;
        }

        /// <summary>
        /// L&#39;identifiant en lui-même
        /// </summary>
        /// <value>L&#39;identifiant en lui-même</value>
        /*
        <example>example.json#/patient/externalId/0/value</example>
        */
        [DataMember(Name = "value", IsRequired = true, EmitDefaultValue = true)]
        public string Value { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class ExternalId {\n");
            sb.Append("  Source: ").Append(Source).Append("\n");
            sb.Append("  Value: ").Append(Value).Append("\n");
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
            yield break;
        }
    }

}
