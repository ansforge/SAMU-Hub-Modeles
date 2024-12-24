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
    /// LevelThreeData
    /// </summary>
    [DataContract(Name = "levelThreeData")]
    public partial class LevelThreeData : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="LevelThreeData" /> class.
        /// </summary>
        /// <param name="stringLevel4">String field at level 4.</param>
        public LevelThreeData(string stringLevel4 = default(string))
        {
            this.StringLevel4 = stringLevel4;
        }

        /// <summary>
        /// String field at level 4
        /// </summary>
        /// <value>String field at level 4</value>
        /*
        <example>example.json#/objectLevel1/object1Level2/object1Level3/stringLevel4</example>
        */
        [DataMember(Name = "stringLevel4", EmitDefaultValue = false)]
        public string StringLevel4 { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class LevelThreeData {\n");
            sb.Append("  StringLevel4: ").Append(StringLevel4).Append("\n");
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
