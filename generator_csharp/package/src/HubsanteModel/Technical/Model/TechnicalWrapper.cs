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
using OpenAPIDateConverter = HubsanteModel/Technical.Client.OpenAPIDateConverter;

namespace HubsanteModel/Technical.Model
{
    /// <summary>
    /// TechnicalWrapper
    /// </summary>
    [DataContract(Name = "technicalWrapper")]
    public partial class TechnicalWrapper : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="TechnicalWrapper" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected TechnicalWrapper() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="TechnicalWrapper" /> class.
        /// </summary>
        /// <param name="technical">technical (required).</param>
        public TechnicalWrapper(Technical technical = default(Technical))
        {
            // to ensure "technical" is required (not null)
            if (technical == null)
            {
                throw new ArgumentNullException("technical is a required property for TechnicalWrapper and cannot be null");
            }
            this.Technical = technical;
        }

        /// <summary>
        /// Gets or Sets Technical
        /// </summary>
        [DataMember(Name = "technical", IsRequired = true, EmitDefaultValue = true)]
        public Technical Technical { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class TechnicalWrapper {\n");
            sb.Append("  Technical: ").Append(Technical).Append("\n");
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