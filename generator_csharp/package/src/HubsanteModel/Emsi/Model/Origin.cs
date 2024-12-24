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
    /// Origin
    /// </summary>
    [DataContract(Name = "origin")]
    public partial class Origin : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Origin" /> class.
        /// </summary>
        /// <param name="oRGID">Optionnel, identifiant du service à l&#39;origine de l&#39;EMSI Se référer au DSF pour la structure normée des organisations Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*..</param>
        /// <param name="uSERID">Optionnel, identifiant de l&#39;opérateur du service à l&#39;origine de l&#39;EMSI, qui gère l&#39;opération.  Ce champ peut être différent du calltakerId du message RC-EDA. .</param>
        /// <param name="nAME">Optionnel, A constituer par le rédacteur pour être intelligible (exemple [structure] [code département]). Ce champ n&#39;est pas normé obligatoirement. Chaque service décide de la structure de son nom d&#39;origine..</param>
        public Origin(string oRGID = default(string), string uSERID = default(string), string nAME = default(string))
        {
            this.ORG_ID = oRGID;
            this.USER_ID = uSERID;
            this.NAME = nAME;
        }

        /// <summary>
        /// Optionnel, identifiant du service à l&#39;origine de l&#39;EMSI Se référer au DSF pour la structure normée des organisations Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*.
        /// </summary>
        /// <value>Optionnel, identifiant du service à l&#39;origine de l&#39;EMSI Se référer au DSF pour la structure normée des organisations Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*.</value>
        /*
        <example>example.json#/CONTEXT/ORIGIN/ORG_ID</example>
        */
        [DataMember(Name = "ORG_ID", EmitDefaultValue = false)]
        public string ORG_ID { get; set; }

        /// <summary>
        /// Optionnel, identifiant de l&#39;opérateur du service à l&#39;origine de l&#39;EMSI, qui gère l&#39;opération.  Ce champ peut être différent du calltakerId du message RC-EDA. 
        /// </summary>
        /// <value>Optionnel, identifiant de l&#39;opérateur du service à l&#39;origine de l&#39;EMSI, qui gère l&#39;opération.  Ce champ peut être différent du calltakerId du message RC-EDA. </value>
        /*
        <example>example.json#/CONTEXT/ORIGIN/USER_ID</example>
        */
        [DataMember(Name = "USER_ID", EmitDefaultValue = false)]
        public string USER_ID { get; set; }

        /// <summary>
        /// Optionnel, A constituer par le rédacteur pour être intelligible (exemple [structure] [code département]). Ce champ n&#39;est pas normé obligatoirement. Chaque service décide de la structure de son nom d&#39;origine.
        /// </summary>
        /// <value>Optionnel, A constituer par le rédacteur pour être intelligible (exemple [structure] [code département]). Ce champ n&#39;est pas normé obligatoirement. Chaque service décide de la structure de son nom d&#39;origine.</value>
        /*
        <example>example.json#/CONTEXT/ORIGIN/NAME</example>
        */
        [DataMember(Name = "NAME", EmitDefaultValue = false)]
        public string NAME { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Origin {\n");
            sb.Append("  ORG_ID: ").Append(ORG_ID).Append("\n");
            sb.Append("  USER_ID: ").Append(USER_ID).Append("\n");
            sb.Append("  NAME: ").Append(NAME).Append("\n");
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