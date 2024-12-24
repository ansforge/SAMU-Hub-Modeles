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
using OpenAPIDateConverter = HubsanteModel/Geolocation.Client.OpenAPIDateConverter;

namespace HubsanteModel/Geolocation.Model
{
    /// <summary>
    /// GeoResourcesDetailsWrapper
    /// </summary>
    [DataContract(Name = "geoResourcesDetailsWrapper")]
    public partial class GeoResourcesDetailsWrapper : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="GeoResourcesDetailsWrapper" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected GeoResourcesDetailsWrapper() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="GeoResourcesDetailsWrapper" /> class.
        /// </summary>
        /// <param name="geoResourcesDetails">geoResourcesDetails (required).</param>
        public GeoResourcesDetailsWrapper(GeoResourcesDetails geoResourcesDetails = default(GeoResourcesDetails))
        {
            // to ensure "geoResourcesDetails" is required (not null)
            if (geoResourcesDetails == null)
            {
                throw new ArgumentNullException("geoResourcesDetails is a required property for GeoResourcesDetailsWrapper and cannot be null");
            }
            this.GeoResourcesDetails = geoResourcesDetails;
        }

        /// <summary>
        /// Gets or Sets GeoResourcesDetails
        /// </summary>
        [DataMember(Name = "geoResourcesDetails", IsRequired = true, EmitDefaultValue = true)]
        public GeoResourcesDetails GeoResourcesDetails { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class GeoResourcesDetailsWrapper {\n");
            sb.Append("  GeoResourcesDetails: ").Append(GeoResourcesDetails).Append("\n");
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