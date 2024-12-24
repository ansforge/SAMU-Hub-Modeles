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
    /// GeoResourcesRequestWrapper
    /// </summary>
    [DataContract(Name = "geoResourcesRequestWrapper")]
    public partial class GeoResourcesRequestWrapper : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="GeoResourcesRequestWrapper" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected GeoResourcesRequestWrapper() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="GeoResourcesRequestWrapper" /> class.
        /// </summary>
        /// <param name="geoResourcesRequest">geoResourcesRequest (required).</param>
        public GeoResourcesRequestWrapper(GeoResourcesRequest geoResourcesRequest = default(GeoResourcesRequest))
        {
            // to ensure "geoResourcesRequest" is required (not null)
            if (geoResourcesRequest == null)
            {
                throw new ArgumentNullException("geoResourcesRequest is a required property for GeoResourcesRequestWrapper and cannot be null");
            }
            this.GeoResourcesRequest = geoResourcesRequest;
        }

        /// <summary>
        /// Gets or Sets GeoResourcesRequest
        /// </summary>
        [DataMember(Name = "geoResourcesRequest", IsRequired = true, EmitDefaultValue = true)]
        public GeoResourcesRequest GeoResourcesRequest { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class GeoResourcesRequestWrapper {\n");
            sb.Append("  GeoResourcesRequest: ").Append(GeoResourcesRequest).Append("\n");
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