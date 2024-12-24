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
    /// GeneralPractitioner
    /// </summary>
    [DataContract(Name = "generalPractitioner")]
    public partial class GeneralPractitioner : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="GeneralPractitioner" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected GeneralPractitioner() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="GeneralPractitioner" /> class.
        /// </summary>
        /// <param name="detailedName">detailedName (required).</param>
        /// <param name="rppsId">Numéro RPPS du médecin traitant.</param>
        /// <param name="contact">contact.</param>
        public GeneralPractitioner(DetailedName detailedName = default(DetailedName), string rppsId = default(string), List<PersonalContact> contact = default(List<PersonalContact>))
        {
            // to ensure "detailedName" is required (not null)
            if (detailedName == null)
            {
                throw new ArgumentNullException("detailedName is a required property for GeneralPractitioner and cannot be null");
            }
            this.DetailedName = detailedName;
            this.RppsId = rppsId;
            this.Contact = contact;
        }

        /// <summary>
        /// Gets or Sets DetailedName
        /// </summary>
        [DataMember(Name = "detailedName", IsRequired = true, EmitDefaultValue = true)]
        public DetailedName DetailedName { get; set; }

        /// <summary>
        /// Numéro RPPS du médecin traitant
        /// </summary>
        /// <value>Numéro RPPS du médecin traitant</value>
        /*
        <example>example.json#/patient/0/administrativeFile/generalPractitioner/rppsId</example>
        */
        [DataMember(Name = "rppsId", EmitDefaultValue = false)]
        public string RppsId { get; set; }

        /// <summary>
        /// Gets or Sets Contact
        /// </summary>
        [DataMember(Name = "contact", EmitDefaultValue = false)]
        public List<PersonalContact> Contact { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class GeneralPractitioner {\n");
            sb.Append("  DetailedName: ").Append(DetailedName).Append("\n");
            sb.Append("  RppsId: ").Append(RppsId).Append("\n");
            sb.Append("  Contact: ").Append(Contact).Append("\n");
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
