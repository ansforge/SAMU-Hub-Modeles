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
    /// Highway
    /// </summary>
    [DataContract(Name = "highway")]
    public partial class Highway : IEquatable<Highway>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Highway" /> class.
        /// </summary>
        /// <param name="name">A valoriser avec le nom de l&#39;autoroute, de la voie ferrée ou voie navigable..</param>
        /// <param name="pk">A valoriser avec le point kilométrique de l&#39;autoroute, de la voie ferrée ou voie navigable. .</param>
        /// <param name="direction">A valoriser avec le sens de l&#39;autoroute..</param>
        public Highway(string name = default(string), string pk = default(string), string direction = default(string))
        {
            this.Name = name;
            this.Pk = pk;
            this.Direction = direction;
        }

        /// <summary>
        /// A valoriser avec le nom de l&#39;autoroute, de la voie ferrée ou voie navigable.
        /// </summary>
        /// <value>A valoriser avec le nom de l&#39;autoroute, de la voie ferrée ou voie navigable.</value>
        /// <example>example.json#/location/detailedAddress/highway/name</example>
        [DataMember(Name = "name", EmitDefaultValue = false)]
        public string Name { get; set; }

        /// <summary>
        /// A valoriser avec le point kilométrique de l&#39;autoroute, de la voie ferrée ou voie navigable. 
        /// </summary>
        /// <value>A valoriser avec le point kilométrique de l&#39;autoroute, de la voie ferrée ou voie navigable. </value>
        /// <example>example.json#/location/detailedAddress/highway/pk</example>
        [DataMember(Name = "pk", EmitDefaultValue = false)]
        public string Pk { get; set; }

        /// <summary>
        /// A valoriser avec le sens de l&#39;autoroute.
        /// </summary>
        /// <value>A valoriser avec le sens de l&#39;autoroute.</value>
        /// <example>example.json#/location/detailedAddress/highway/direction</example>
        [DataMember(Name = "direction", EmitDefaultValue = false)]
        public string Direction { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Highway {\n");
            sb.Append("  Name: ").Append(Name).Append("\n");
            sb.Append("  Pk: ").Append(Pk).Append("\n");
            sb.Append("  Direction: ").Append(Direction).Append("\n");
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
            return this.Equals(input as Highway);
        }

        /// <summary>
        /// Returns true if Highway instances are equal
        /// </summary>
        /// <param name="input">Instance of Highway to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Highway input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Name == input.Name ||
                    (this.Name != null &&
                    this.Name.Equals(input.Name))
                ) && 
                (
                    this.Pk == input.Pk ||
                    (this.Pk != null &&
                    this.Pk.Equals(input.Pk))
                ) && 
                (
                    this.Direction == input.Direction ||
                    (this.Direction != null &&
                    this.Direction.Equals(input.Direction))
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
                if (this.Name != null)
                {
                    hashCode = (hashCode * 59) + this.Name.GetHashCode();
                }
                if (this.Pk != null)
                {
                    hashCode = (hashCode * 59) + this.Pk.GetHashCode();
                }
                if (this.Direction != null)
                {
                    hashCode = (hashCode * 59) + this.Direction.GetHashCode();
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
            yield break;
        }
    }

}