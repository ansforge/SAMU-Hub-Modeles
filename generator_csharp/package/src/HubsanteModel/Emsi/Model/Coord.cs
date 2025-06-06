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
    /// Coord
    /// </summary>
    [DataContract(Name = "coord")]
    public partial class Coord : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Coord" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Coord() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Coord" /> class.
        /// </summary>
        /// <param name="lAT">dernière coordonnée x  connue de la ressource, entre −90 and +90 (required).</param>
        /// <param name="lONG">Optionnel. Dans le cas où aucun LOC_ID n&#39;est transféré, permet de localiser le lieu d&#39;intervention souhaité dernière coordonnée y  connue de la ressource entre −180 and +180 (required).</param>
        /// <param name="hEIGHT">Optionnel. Dans le cas où aucun LOC_ID n&#39;est transféré, permet de localiser le lieu d&#39;intervention souhaité dernière coordonnée z  connue de la ressource, en mètres sans bornes .</param>
        public Coord(decimal lAT = default(decimal), decimal lONG = default(decimal), decimal hEIGHT = default(decimal))
        {
            this.LAT = lAT;
            this.LONG = lONG;
            this.HEIGHT = hEIGHT;
        }

        /// <summary>
        /// dernière coordonnée x  connue de la ressource, entre −90 and +90
        /// </summary>
        /// <value>dernière coordonnée x  connue de la ressource, entre −90 and +90</value>
        [DataMember(Name = "LAT", IsRequired = true, EmitDefaultValue = true)]
        public decimal LAT { get; set; }

        /// <summary>
        /// Optionnel. Dans le cas où aucun LOC_ID n&#39;est transféré, permet de localiser le lieu d&#39;intervention souhaité dernière coordonnée y  connue de la ressource entre −180 and +180
        /// </summary>
        /// <value>Optionnel. Dans le cas où aucun LOC_ID n&#39;est transféré, permet de localiser le lieu d&#39;intervention souhaité dernière coordonnée y  connue de la ressource entre −180 and +180</value>
        [DataMember(Name = "LONG", IsRequired = true, EmitDefaultValue = true)]
        public decimal LONG { get; set; }

        /// <summary>
        /// Optionnel. Dans le cas où aucun LOC_ID n&#39;est transféré, permet de localiser le lieu d&#39;intervention souhaité dernière coordonnée z  connue de la ressource, en mètres sans bornes 
        /// </summary>
        /// <value>Optionnel. Dans le cas où aucun LOC_ID n&#39;est transféré, permet de localiser le lieu d&#39;intervention souhaité dernière coordonnée z  connue de la ressource, en mètres sans bornes </value>
        [DataMember(Name = "HEIGHT", EmitDefaultValue = false)]
        public decimal HEIGHT { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Coord {\n");
            sb.Append("  LAT: ").Append(LAT).Append("\n");
            sb.Append("  LONG: ").Append(LONG).Append("\n");
            sb.Append("  HEIGHT: ").Append(HEIGHT).Append("\n");
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
