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
    /// Identity
    /// </summary>
    [DataContract(Name = "Identity")]
    public partial class Identity : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Identity" /> class.
        /// </summary>
        /// <param name="strictFeatures">strictFeatures.</param>
        /// <param name="nonStrictFeatures">nonStrictFeatures.</param>
        public Identity(InsStrictFeatures strictFeatures = default(InsStrictFeatures), DetailedName nonStrictFeatures = default(DetailedName))
        {
            this.StrictFeatures = strictFeatures;
            this.NonStrictFeatures = nonStrictFeatures;
        }

        /// <summary>
        /// Gets or Sets StrictFeatures
        /// </summary>
        [DataMember(Name = "strictFeatures", EmitDefaultValue = false)]
        public InsStrictFeatures StrictFeatures { get; set; }

        /// <summary>
        /// Gets or Sets NonStrictFeatures
        /// </summary>
        [DataMember(Name = "nonStrictFeatures", EmitDefaultValue = false)]
        public DetailedName NonStrictFeatures { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Identity {\n");
            sb.Append("  StrictFeatures: ").Append(StrictFeatures).Append("\n");
            sb.Append("  NonStrictFeatures: ").Append(NonStrictFeatures).Append("\n");
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
