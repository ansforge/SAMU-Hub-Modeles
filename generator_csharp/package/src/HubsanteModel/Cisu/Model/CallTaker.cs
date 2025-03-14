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
using OpenAPIDateConverter = HubsanteModel/Cisu.Client.OpenAPIDateConverter;

namespace HubsanteModel/Cisu.Model
{
    /// <summary>
    /// CallTaker
    /// </summary>
    [DataContract(Name = "callTaker")]
    public partial class CallTaker : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="CallTaker" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected CallTaker() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="CallTaker" /> class.
        /// </summary>
        /// <param name="organization">Décrit la structure ou le service à laquelle est rattachée l&#39;agent (en fonction du niveau de précision disponible). Se référer au DSF pour la structure normée des organisations. Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*. (required).</param>
        /// <param name="controlRoom">Décrit le centre d&#39;appel auquel est rattaché l&#39;agent (required).</param>
        /// <param name="role">Décrit le rôle de l&#39;agent au sein du service selon la nomenclature PERSO (nomenclature SI-SAMU).</param>
        /// <param name="calltakerContact">calltakerContact.</param>
        /// <param name="calltakerId">Identifiant unique de l&#39;opérateur ayant traité l&#39;alerte (peut être un identifiant technique, un numéro de carte CPS etc).</param>
        public CallTaker(string organization = default(string), string controlRoom = default(string), string role = default(string), Contact calltakerContact = default(Contact), string calltakerId = default(string))
        {
            // to ensure "organization" is required (not null)
            if (organization == null)
            {
                throw new ArgumentNullException("organization is a required property for CallTaker and cannot be null");
            }
            this.Organization = organization;
            // to ensure "controlRoom" is required (not null)
            if (controlRoom == null)
            {
                throw new ArgumentNullException("controlRoom is a required property for CallTaker and cannot be null");
            }
            this.ControlRoom = controlRoom;
            this.Role = role;
            this.CalltakerContact = calltakerContact;
            this.CalltakerId = calltakerId;
        }

        /// <summary>
        /// Décrit la structure ou le service à laquelle est rattachée l&#39;agent (en fonction du niveau de précision disponible). Se référer au DSF pour la structure normée des organisations. Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*.
        /// </summary>
        /// <value>Décrit la structure ou le service à laquelle est rattachée l&#39;agent (en fonction du niveau de précision disponible). Se référer au DSF pour la structure normée des organisations. Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*.</value>
        /*
        <example>example.json#/initialAlert/callTaker/organization</example>
        */
        [DataMember(Name = "organization", IsRequired = true, EmitDefaultValue = true)]
        public string Organization { get; set; }

        /// <summary>
        /// Décrit le centre d&#39;appel auquel est rattaché l&#39;agent
        /// </summary>
        /// <value>Décrit le centre d&#39;appel auquel est rattaché l&#39;agent</value>
        /*
        <example>example.json#/initialAlert/callTaker/controlRoom</example>
        */
        [DataMember(Name = "controlRoom", IsRequired = true, EmitDefaultValue = true)]
        public string ControlRoom { get; set; }

        /// <summary>
        /// Décrit le rôle de l&#39;agent au sein du service selon la nomenclature PERSO (nomenclature SI-SAMU)
        /// </summary>
        /// <value>Décrit le rôle de l&#39;agent au sein du service selon la nomenclature PERSO (nomenclature SI-SAMU)</value>
        /*
        <example>example.json#/initialAlert/callTaker/role</example>
        */
        [DataMember(Name = "role", EmitDefaultValue = false)]
        public string Role { get; set; }

        /// <summary>
        /// Gets or Sets CalltakerContact
        /// </summary>
        [DataMember(Name = "calltakerContact", EmitDefaultValue = false)]
        public Contact CalltakerContact { get; set; }

        /// <summary>
        /// Identifiant unique de l&#39;opérateur ayant traité l&#39;alerte (peut être un identifiant technique, un numéro de carte CPS etc)
        /// </summary>
        /// <value>Identifiant unique de l&#39;opérateur ayant traité l&#39;alerte (peut être un identifiant technique, un numéro de carte CPS etc)</value>
        /*
        <example>example.json#/initialAlert/callTaker/calltakerId</example>
        */
        [DataMember(Name = "calltakerId", EmitDefaultValue = false)]
        public string CalltakerId { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class CallTaker {\n");
            sb.Append("  Organization: ").Append(Organization).Append("\n");
            sb.Append("  ControlRoom: ").Append(ControlRoom).Append("\n");
            sb.Append("  Role: ").Append(Role).Append("\n");
            sb.Append("  CalltakerContact: ").Append(CalltakerContact).Append("\n");
            sb.Append("  CalltakerId: ").Append(CalltakerId).Append("\n");
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
