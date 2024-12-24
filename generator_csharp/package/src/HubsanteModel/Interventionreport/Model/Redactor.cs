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
using OpenAPIDateConverter = HubsanteModel/Interventionreport.Client.OpenAPIDateConverter;

namespace HubsanteModel/Interventionreport.Model
{
    /// <summary>
    /// Redactor
    /// </summary>
    [DataContract(Name = "redactor")]
    public partial class Redactor : IValidatableObject
    {
        /// <summary>
        /// A valoriser avec le rôle du rédacteur du bilan (ex. médecin, infirmier, ambulancier). 
        /// </summary>
        /// <value>A valoriser avec le rôle du rédacteur du bilan (ex. médecin, infirmier, ambulancier). </value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum RoleEnum
        {
            /// <summary>
            /// Enum AMBULANCIER for value: AMBULANCIER
            /// </summary>
            [EnumMember(Value = "AMBULANCIER")]
            AMBULANCIER = 1,

            /// <summary>
            /// Enum ARM for value: ARM
            /// </summary>
            [EnumMember(Value = "ARM")]
            ARM = 2,

            /// <summary>
            /// Enum INFIRMIER for value: INFIRMIER
            /// </summary>
            [EnumMember(Value = "INFIRMIER")]
            INFIRMIER = 3,

            /// <summary>
            /// Enum MEDECIN for value: MEDECIN
            /// </summary>
            [EnumMember(Value = "MEDECIN")]
            MEDECIN = 4,

            /// <summary>
            /// Enum PILOTE for value: PILOTE
            /// </summary>
            [EnumMember(Value = "PILOTE")]
            PILOTE = 5,

            /// <summary>
            /// Enum TCM for value: TCM
            /// </summary>
            [EnumMember(Value = "TCM")]
            TCM = 6,

            /// <summary>
            /// Enum AUTRE for value: AUTRE
            /// </summary>
            [EnumMember(Value = "AUTRE")]
            AUTRE = 7,

            /// <summary>
            /// Enum INCONNU for value: INCONNU
            /// </summary>
            [EnumMember(Value = "INCONNU")]
            INCONNU = 8
        }


        /// <summary>
        /// A valoriser avec le rôle du rédacteur du bilan (ex. médecin, infirmier, ambulancier). 
        /// </summary>
        /// <value>A valoriser avec le rôle du rédacteur du bilan (ex. médecin, infirmier, ambulancier). </value>
        /*
        <example>example.json#/redactor/role</example>
        */
        [DataMember(Name = "role", IsRequired = true, EmitDefaultValue = true)]
        public RoleEnum Role { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="Redactor" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Redactor() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Redactor" /> class.
        /// </summary>
        /// <param name="label">A valoriser avec le prénom et le nom du rédacteur, un numéro RPPS, un matricule, etc. .</param>
        /// <param name="role">A valoriser avec le rôle du rédacteur du bilan (ex. médecin, infirmier, ambulancier).  (required).</param>
        public Redactor(string label = default(string), RoleEnum role = default(RoleEnum))
        {
            this.Role = role;
            this.Label = label;
        }

        /// <summary>
        /// A valoriser avec le prénom et le nom du rédacteur, un numéro RPPS, un matricule, etc. 
        /// </summary>
        /// <value>A valoriser avec le prénom et le nom du rédacteur, un numéro RPPS, un matricule, etc. </value>
        /*
        <example>example.json#/redactor/label</example>
        */
        [DataMember(Name = "label", EmitDefaultValue = false)]
        public string Label { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Redactor {\n");
            sb.Append("  Label: ").Append(Label).Append("\n");
            sb.Append("  Role: ").Append(Role).Append("\n");
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