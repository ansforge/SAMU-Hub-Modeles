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
using OpenAPIDateConverter = HubsanteModel/Emsi.Client.OpenAPIDateConverter;

namespace HubsanteModel/Emsi.Model
{
    /// <summary>
    /// Emsi
    /// </summary>
    [DataContract(Name = "emsi")]
    public partial class Emsi : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Emsi" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Emsi() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Emsi" /> class.
        /// </summary>
        /// <param name="cONTEXT">cONTEXT (required).</param>
        /// <param name="eVENT">eVENT (required).</param>
        /// <param name="mISSION">mISSION.</param>
        /// <param name="rESOURCE">rESOURCE.</param>
        public Emsi(Context cONTEXT = default(Context), Event eVENT = default(Event), List<Mission> mISSION = default(List<Mission>), List<Resource> rESOURCE = default(List<Resource>))
        {
            // to ensure "cONTEXT" is required (not null)
            if (cONTEXT == null)
            {
                throw new ArgumentNullException("cONTEXT is a required property for Emsi and cannot be null");
            }
            this.CONTEXT = cONTEXT;
            // to ensure "eVENT" is required (not null)
            if (eVENT == null)
            {
                throw new ArgumentNullException("eVENT is a required property for Emsi and cannot be null");
            }
            this.EVENT = eVENT;
            this.MISSION = mISSION;
            this.RESOURCE = rESOURCE;
        }

        /// <summary>
        /// Gets or Sets CONTEXT
        /// </summary>
        [DataMember(Name = "CONTEXT", IsRequired = true, EmitDefaultValue = true)]
        public Context CONTEXT { get; set; }

        /// <summary>
        /// Gets or Sets EVENT
        /// </summary>
        [DataMember(Name = "EVENT", IsRequired = true, EmitDefaultValue = true)]
        public Event EVENT { get; set; }

        /// <summary>
        /// Gets or Sets MISSION
        /// </summary>
        [DataMember(Name = "MISSION", EmitDefaultValue = false)]
        public List<Mission> MISSION { get; set; }

        /// <summary>
        /// Gets or Sets RESOURCE
        /// </summary>
        [DataMember(Name = "RESOURCE", EmitDefaultValue = false)]
        public List<Resource> RESOURCE { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Emsi {\n");
            sb.Append("  CONTEXT: ").Append(CONTEXT).Append("\n");
            sb.Append("  EVENT: ").Append(EVENT).Append("\n");
            sb.Append("  MISSION: ").Append(MISSION).Append("\n");
            sb.Append("  RESOURCE: ").Append(RESOURCE).Append("\n");
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
