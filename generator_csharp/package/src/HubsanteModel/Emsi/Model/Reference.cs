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
    /// Reference
    /// </summary>
    [DataContract(Name = "reference")]
    public partial class Reference : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Reference" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Reference() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Reference" /> class.
        /// </summary>
        /// <param name="oRGID">Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*. NB : ce champ (EVENT.REFERENCE.ORG_ID) ne peut pas être le même que le champ CONTEXT.LINK.ID ou EVENT.ID (required).</param>
        /// <param name="oTHEREVENTID">oTHEREVENTID (required).</param>
        public Reference(string oRGID = default(string), List<string> oTHEREVENTID = default(List<string>))
        {
            // to ensure "oRGID" is required (not null)
            if (oRGID == null)
            {
                throw new ArgumentNullException("oRGID is a required property for Reference and cannot be null");
            }
            this.ORG_ID = oRGID;
            // to ensure "oTHEREVENTID" is required (not null)
            if (oTHEREVENTID == null)
            {
                throw new ArgumentNullException("oTHEREVENTID is a required property for Reference and cannot be null");
            }
            this.OTHER_EVENT_ID = oTHEREVENTID;
        }

        /// <summary>
        /// Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*. NB : ce champ (EVENT.REFERENCE.ORG_ID) ne peut pas être le même que le champ CONTEXT.LINK.ID ou EVENT.ID
        /// </summary>
        /// <value>Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*. NB : ce champ (EVENT.REFERENCE.ORG_ID) ne peut pas être le même que le champ CONTEXT.LINK.ID ou EVENT.ID</value>
        /*
        <example>example.json#/EVENT/REFERENCE/0/ORG_ID</example>
        */
        [DataMember(Name = "ORG_ID", IsRequired = true, EmitDefaultValue = true)]
        public string ORG_ID { get; set; }

        /// <summary>
        /// Gets or Sets OTHER_EVENT_ID
        /// </summary>
        [DataMember(Name = "OTHER_EVENT_ID", IsRequired = true, EmitDefaultValue = true)]
        public List<string> OTHER_EVENT_ID { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Reference {\n");
            sb.Append("  ORG_ID: ").Append(ORG_ID).Append("\n");
            sb.Append("  OTHER_EVENT_ID: ").Append(OTHER_EVENT_ID).Append("\n");
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
