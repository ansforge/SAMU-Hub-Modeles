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
    /// ResidentialAddress
    /// </summary>
    [DataContract(Name = "residentialAddress")]
    public partial class ResidentialAddress : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="ResidentialAddress" /> class.
        /// </summary>
        /// <param name="inseeCode">Code INSEE de la commune actuelle sur la base du Code Officiel géographique en vigueur. Obligatoire si le nom de la commune est renseigné. Le Code INSEE peut également précisé le pays de résidence, si étranger. .</param>
        /// <param name="city">Nom officiel de la commune actuelle.</param>
        public ResidentialAddress(string inseeCode = default(string), string city = default(string))
        {
            this.InseeCode = inseeCode;
            this.City = city;
        }

        /// <summary>
        /// Code INSEE de la commune actuelle sur la base du Code Officiel géographique en vigueur. Obligatoire si le nom de la commune est renseigné. Le Code INSEE peut également précisé le pays de résidence, si étranger. 
        /// </summary>
        /// <value>Code INSEE de la commune actuelle sur la base du Code Officiel géographique en vigueur. Obligatoire si le nom de la commune est renseigné. Le Code INSEE peut également précisé le pays de résidence, si étranger. </value>
        /*
        <example>example.json#/patient/residentialAddress/inseeCode</example>
        */
        [DataMember(Name = "inseeCode", EmitDefaultValue = false)]
        public string InseeCode { get; set; }

        /// <summary>
        /// Nom officiel de la commune actuelle
        /// </summary>
        /// <value>Nom officiel de la commune actuelle</value>
        /*
        <example>example.json#/patient/residentialAddress/city</example>
        */
        [DataMember(Name = "city", EmitDefaultValue = false)]
        public string City { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class ResidentialAddress {\n");
            sb.Append("  InseeCode: ").Append(InseeCode).Append("\n");
            sb.Append("  City: ").Append(City).Append("\n");
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
