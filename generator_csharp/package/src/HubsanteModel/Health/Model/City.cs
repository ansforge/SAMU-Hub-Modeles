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
    /// City
    /// </summary>
    [DataContract(Name = "city")]
    public partial class City : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="City" /> class.
        /// </summary>
        /// <param name="name">A valoriser avec le nom officiel de la commune.</param>
        /// <param name="inseeCode">A valoriser avec le code INSEE de la commune actuelle sur la base du Code Officiel géographique en vigueur.  La valeur du code INSEE est obligatoire dès que le nom de la commune est renseigné (city.name)..</param>
        public City(string name = default(string), string inseeCode = default(string))
        {
            this.Name = name;
            this.InseeCode = inseeCode;
        }

        /// <summary>
        /// A valoriser avec le nom officiel de la commune
        /// </summary>
        /// <value>A valoriser avec le nom officiel de la commune</value>
        /*
        <example>example.json#/location/city/name</example>
        */
        [DataMember(Name = "name", EmitDefaultValue = false)]
        public string Name { get; set; }

        /// <summary>
        /// A valoriser avec le code INSEE de la commune actuelle sur la base du Code Officiel géographique en vigueur.  La valeur du code INSEE est obligatoire dès que le nom de la commune est renseigné (city.name).
        /// </summary>
        /// <value>A valoriser avec le code INSEE de la commune actuelle sur la base du Code Officiel géographique en vigueur.  La valeur du code INSEE est obligatoire dès que le nom de la commune est renseigné (city.name).</value>
        /*
        <example>example.json#/location/city/inseeCode</example>
        */
        [DataMember(Name = "inseeCode", EmitDefaultValue = false)]
        public string InseeCode { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class City {\n");
            sb.Append("  Name: ").Append(Name).Append("\n");
            sb.Append("  InseeCode: ").Append(InseeCode).Append("\n");
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
            if (this.InseeCode != null) {
                // InseeCode (string) pattern
                Regex regexInseeCode = new Regex(@"^[0-9]{5}$", RegexOptions.CultureInvariant);
                if (!regexInseeCode.Match(this.InseeCode).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for InseeCode, must match a pattern of " + regexInseeCode, new [] { "InseeCode" });
                }
            }

            yield break;
        }
    }

}
