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
using OpenAPIDateConverter = HubsanteModel/Rpis.Client.OpenAPIDateConverter;

namespace HubsanteModel/Rpis.Model
{
    /// <summary>
    /// ResourceStatus
    /// </summary>
    [DataContract(Name = "resourceStatus")]
    public partial class ResourceStatus : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="ResourceStatus" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected ResourceStatus() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="ResourceStatus" /> class.
        /// </summary>
        /// <param name="departSmur">Date et heure à laquelle le SMUR quitte sa base.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss (required).</param>
        /// <param name="arrivedSmur">Date et heure à laquelle le SMUR arrive sur les lieux de l&#39;intervention.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss.</param>
        /// <param name="departLocation">Date et heure à laquelle le SMUR quitte les lieux de l&#39;intervention.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss.</param>
        /// <param name="arrivedDestination">Date et heure à laquelle le SMUR qui transporte arrive à destination.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss.</param>
        /// <param name="teamAvailable">Date et heure à laquelle le SMUR est disponible (dispose de tout les équipements pour faire une autre intervention).  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss (required).</param>
        /// <param name="returnSmur">Date et heure à laquelle le SMUR est de retour à la base.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss (required).</param>
        public ResourceStatus(DateTime departSmur = default(DateTime), DateTime arrivedSmur = default(DateTime), DateTime departLocation = default(DateTime), DateTime arrivedDestination = default(DateTime), DateTime teamAvailable = default(DateTime), DateTime returnSmur = default(DateTime))
        {
            this.DepartSmur = departSmur;
            this.TeamAvailable = teamAvailable;
            this.ReturnSmur = returnSmur;
            this.ArrivedSmur = arrivedSmur;
            this.DepartLocation = departLocation;
            this.ArrivedDestination = arrivedDestination;
        }

        /// <summary>
        /// Date et heure à laquelle le SMUR quitte sa base.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss
        /// </summary>
        /// <value>Date et heure à laquelle le SMUR quitte sa base.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss</value>
        [DataMember(Name = "departSmur", IsRequired = true, EmitDefaultValue = true)]
        public DateTime DepartSmur { get; set; }

        /// <summary>
        /// Date et heure à laquelle le SMUR arrive sur les lieux de l&#39;intervention.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss
        /// </summary>
        /// <value>Date et heure à laquelle le SMUR arrive sur les lieux de l&#39;intervention.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss</value>
        [DataMember(Name = "arrivedSmur", EmitDefaultValue = false)]
        public DateTime ArrivedSmur { get; set; }

        /// <summary>
        /// Date et heure à laquelle le SMUR quitte les lieux de l&#39;intervention.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss
        /// </summary>
        /// <value>Date et heure à laquelle le SMUR quitte les lieux de l&#39;intervention.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss</value>
        [DataMember(Name = "departLocation", EmitDefaultValue = false)]
        public DateTime DepartLocation { get; set; }

        /// <summary>
        /// Date et heure à laquelle le SMUR qui transporte arrive à destination.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss
        /// </summary>
        /// <value>Date et heure à laquelle le SMUR qui transporte arrive à destination.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss</value>
        [DataMember(Name = "arrivedDestination", EmitDefaultValue = false)]
        public DateTime ArrivedDestination { get; set; }

        /// <summary>
        /// Date et heure à laquelle le SMUR est disponible (dispose de tout les équipements pour faire une autre intervention).  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss
        /// </summary>
        /// <value>Date et heure à laquelle le SMUR est disponible (dispose de tout les équipements pour faire une autre intervention).  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss</value>
        [DataMember(Name = "teamAvailable", IsRequired = true, EmitDefaultValue = true)]
        public DateTime TeamAvailable { get; set; }

        /// <summary>
        /// Date et heure à laquelle le SMUR est de retour à la base.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss
        /// </summary>
        /// <value>Date et heure à laquelle le SMUR est de retour à la base.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss</value>
        [DataMember(Name = "returnSmur", IsRequired = true, EmitDefaultValue = true)]
        public DateTime ReturnSmur { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class ResourceStatus {\n");
            sb.Append("  DepartSmur: ").Append(DepartSmur).Append("\n");
            sb.Append("  ArrivedSmur: ").Append(ArrivedSmur).Append("\n");
            sb.Append("  DepartLocation: ").Append(DepartLocation).Append("\n");
            sb.Append("  ArrivedDestination: ").Append(ArrivedDestination).Append("\n");
            sb.Append("  TeamAvailable: ").Append(TeamAvailable).Append("\n");
            sb.Append("  ReturnSmur: ").Append(ReturnSmur).Append("\n");
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
            if (this.DepartSmur != null) {
                // DepartSmur (DateTime) pattern
                Regex regexDepartSmur = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexDepartSmur.Match(this.DepartSmur).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for DepartSmur, must match a pattern of " + regexDepartSmur, new [] { "DepartSmur" });
                }
            }

            if (this.ArrivedSmur != null) {
                // ArrivedSmur (DateTime) pattern
                Regex regexArrivedSmur = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexArrivedSmur.Match(this.ArrivedSmur).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for ArrivedSmur, must match a pattern of " + regexArrivedSmur, new [] { "ArrivedSmur" });
                }
            }

            if (this.DepartLocation != null) {
                // DepartLocation (DateTime) pattern
                Regex regexDepartLocation = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexDepartLocation.Match(this.DepartLocation).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for DepartLocation, must match a pattern of " + regexDepartLocation, new [] { "DepartLocation" });
                }
            }

            if (this.ArrivedDestination != null) {
                // ArrivedDestination (DateTime) pattern
                Regex regexArrivedDestination = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexArrivedDestination.Match(this.ArrivedDestination).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for ArrivedDestination, must match a pattern of " + regexArrivedDestination, new [] { "ArrivedDestination" });
                }
            }

            if (this.TeamAvailable != null) {
                // TeamAvailable (DateTime) pattern
                Regex regexTeamAvailable = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexTeamAvailable.Match(this.TeamAvailable).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for TeamAvailable, must match a pattern of " + regexTeamAvailable, new [] { "TeamAvailable" });
                }
            }

            if (this.ReturnSmur != null) {
                // ReturnSmur (DateTime) pattern
                Regex regexReturnSmur = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexReturnSmur.Match(this.ReturnSmur).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for ReturnSmur, must match a pattern of " + regexReturnSmur, new [] { "ReturnSmur" });
                }
            }

            yield break;
        }
    }

}