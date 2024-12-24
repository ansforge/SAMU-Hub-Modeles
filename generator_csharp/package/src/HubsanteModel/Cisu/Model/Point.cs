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
using OpenAPIDateConverter = HubsanteModel/Cisu.Client.OpenAPIDateConverter;

namespace HubsanteModel/Cisu.Model
{
    /// <summary>
    /// Point
    /// </summary>
    [DataContract(Name = "point")]
    public partial class Point : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Point" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Point() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Point" /> class.
        /// </summary>
        /// <param name="coord">coord (required).</param>
        public Point(Coord coord = default(Coord))
        {
            // to ensure "coord" is required (not null)
            if (coord == null)
            {
                throw new ArgumentNullException("coord is a required property for Point and cannot be null");
            }
            this.Coord = coord;
        }

        /// <summary>
        /// Gets or Sets Coord
        /// </summary>
        [DataMember(Name = "coord", IsRequired = true, EmitDefaultValue = true)]
        public Coord Coord { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Point {\n");
            sb.Append("  Coord: ").Append(Coord).Append("\n");
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
