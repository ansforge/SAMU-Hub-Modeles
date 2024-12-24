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
    /// HealthMotive
    /// </summary>
    [DataContract(Name = "healthMotive")]
    public partial class HealthMotive : IValidatableObject
    {
        /// <summary>
        /// A valoriser avec le code de la nomenclature associée
        /// </summary>
        /// <value>A valoriser avec le code de la nomenclature associée</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum CodeEnum
        {
            /// <summary>
            /// Enum M0100 for value: M01.00
            /// </summary>
            [EnumMember(Value = "M01.00")]
            M0100 = 1,

            /// <summary>
            /// Enum M0101 for value: M01.01
            /// </summary>
            [EnumMember(Value = "M01.01")]
            M0101 = 2,

            /// <summary>
            /// Enum M0102 for value: M01.02
            /// </summary>
            [EnumMember(Value = "M01.02")]
            M0102 = 3,

            /// <summary>
            /// Enum M0103 for value: M01.03
            /// </summary>
            [EnumMember(Value = "M01.03")]
            M0103 = 4,

            /// <summary>
            /// Enum M0200 for value: M02.00
            /// </summary>
            [EnumMember(Value = "M02.00")]
            M0200 = 5,

            /// <summary>
            /// Enum M0201 for value: M02.01
            /// </summary>
            [EnumMember(Value = "M02.01")]
            M0201 = 6,

            /// <summary>
            /// Enum M0202 for value: M02.02
            /// </summary>
            [EnumMember(Value = "M02.02")]
            M0202 = 7,

            /// <summary>
            /// Enum M0203 for value: M02.03
            /// </summary>
            [EnumMember(Value = "M02.03")]
            M0203 = 8,

            /// <summary>
            /// Enum M0204 for value: M02.04
            /// </summary>
            [EnumMember(Value = "M02.04")]
            M0204 = 9,

            /// <summary>
            /// Enum M0205 for value: M02.05
            /// </summary>
            [EnumMember(Value = "M02.05")]
            M0205 = 10,

            /// <summary>
            /// Enum M0206 for value: M02.06
            /// </summary>
            [EnumMember(Value = "M02.06")]
            M0206 = 11,

            /// <summary>
            /// Enum M0207 for value: M02.07
            /// </summary>
            [EnumMember(Value = "M02.07")]
            M0207 = 12,

            /// <summary>
            /// Enum M0208 for value: M02.08
            /// </summary>
            [EnumMember(Value = "M02.08")]
            M0208 = 13,

            /// <summary>
            /// Enum M0209 for value: M02.09
            /// </summary>
            [EnumMember(Value = "M02.09")]
            M0209 = 14,

            /// <summary>
            /// Enum M0210 for value: M02.10
            /// </summary>
            [EnumMember(Value = "M02.10")]
            M0210 = 15,

            /// <summary>
            /// Enum M0300 for value: M03.00
            /// </summary>
            [EnumMember(Value = "M03.00")]
            M0300 = 16,

            /// <summary>
            /// Enum M0301 for value: M03.01
            /// </summary>
            [EnumMember(Value = "M03.01")]
            M0301 = 17,

            /// <summary>
            /// Enum M0302 for value: M03.02
            /// </summary>
            [EnumMember(Value = "M03.02")]
            M0302 = 18,

            /// <summary>
            /// Enum M0303 for value: M03.03
            /// </summary>
            [EnumMember(Value = "M03.03")]
            M0303 = 19,

            /// <summary>
            /// Enum M0304 for value: M03.04
            /// </summary>
            [EnumMember(Value = "M03.04")]
            M0304 = 20,

            /// <summary>
            /// Enum M0305 for value: M03.05
            /// </summary>
            [EnumMember(Value = "M03.05")]
            M0305 = 21,

            /// <summary>
            /// Enum M0306 for value: M03.06
            /// </summary>
            [EnumMember(Value = "M03.06")]
            M0306 = 22,

            /// <summary>
            /// Enum M0307 for value: M03.07
            /// </summary>
            [EnumMember(Value = "M03.07")]
            M0307 = 23,

            /// <summary>
            /// Enum M0308 for value: M03.08
            /// </summary>
            [EnumMember(Value = "M03.08")]
            M0308 = 24,

            /// <summary>
            /// Enum M0309 for value: M03.09
            /// </summary>
            [EnumMember(Value = "M03.09")]
            M0309 = 25,

            /// <summary>
            /// Enum M0310 for value: M03.10
            /// </summary>
            [EnumMember(Value = "M03.10")]
            M0310 = 26,

            /// <summary>
            /// Enum M0311 for value: M03.11
            /// </summary>
            [EnumMember(Value = "M03.11")]
            M0311 = 27,

            /// <summary>
            /// Enum M0312 for value: M03.12
            /// </summary>
            [EnumMember(Value = "M03.12")]
            M0312 = 28,

            /// <summary>
            /// Enum M0313 for value: M03.13
            /// </summary>
            [EnumMember(Value = "M03.13")]
            M0313 = 29,

            /// <summary>
            /// Enum M0314 for value: M03.14
            /// </summary>
            [EnumMember(Value = "M03.14")]
            M0314 = 30,

            /// <summary>
            /// Enum M0315 for value: M03.15
            /// </summary>
            [EnumMember(Value = "M03.15")]
            M0315 = 31,

            /// <summary>
            /// Enum M0316 for value: M03.16
            /// </summary>
            [EnumMember(Value = "M03.16")]
            M0316 = 32,

            /// <summary>
            /// Enum M0317 for value: M03.17
            /// </summary>
            [EnumMember(Value = "M03.17")]
            M0317 = 33,

            /// <summary>
            /// Enum M0318 for value: M03.18
            /// </summary>
            [EnumMember(Value = "M03.18")]
            M0318 = 34,

            /// <summary>
            /// Enum M0319 for value: M03.19
            /// </summary>
            [EnumMember(Value = "M03.19")]
            M0319 = 35,

            /// <summary>
            /// Enum M0320 for value: M03.20
            /// </summary>
            [EnumMember(Value = "M03.20")]
            M0320 = 36,

            /// <summary>
            /// Enum M0321 for value: M03.21
            /// </summary>
            [EnumMember(Value = "M03.21")]
            M0321 = 37,

            /// <summary>
            /// Enum M0322 for value: M03.22
            /// </summary>
            [EnumMember(Value = "M03.22")]
            M0322 = 38,

            /// <summary>
            /// Enum M0400 for value: M04.00
            /// </summary>
            [EnumMember(Value = "M04.00")]
            M0400 = 39,

            /// <summary>
            /// Enum M0401 for value: M04.01
            /// </summary>
            [EnumMember(Value = "M04.01")]
            M0401 = 40,

            /// <summary>
            /// Enum M0402 for value: M04.02
            /// </summary>
            [EnumMember(Value = "M04.02")]
            M0402 = 41,

            /// <summary>
            /// Enum M0403 for value: M04.03
            /// </summary>
            [EnumMember(Value = "M04.03")]
            M0403 = 42,

            /// <summary>
            /// Enum M0404 for value: M04.04
            /// </summary>
            [EnumMember(Value = "M04.04")]
            M0404 = 43,

            /// <summary>
            /// Enum M0500 for value: M05.00
            /// </summary>
            [EnumMember(Value = "M05.00")]
            M0500 = 44,

            /// <summary>
            /// Enum M0501 for value: M05.01
            /// </summary>
            [EnumMember(Value = "M05.01")]
            M0501 = 45,

            /// <summary>
            /// Enum M0502 for value: M05.02
            /// </summary>
            [EnumMember(Value = "M05.02")]
            M0502 = 46,

            /// <summary>
            /// Enum M0600 for value: M06.00
            /// </summary>
            [EnumMember(Value = "M06.00")]
            M0600 = 47,

            /// <summary>
            /// Enum M0601 for value: M06.01
            /// </summary>
            [EnumMember(Value = "M06.01")]
            M0601 = 48,

            /// <summary>
            /// Enum M0602 for value: M06.02
            /// </summary>
            [EnumMember(Value = "M06.02")]
            M0602 = 49,

            /// <summary>
            /// Enum M0603 for value: M06.03
            /// </summary>
            [EnumMember(Value = "M06.03")]
            M0603 = 50,

            /// <summary>
            /// Enum M0604 for value: M06.04
            /// </summary>
            [EnumMember(Value = "M06.04")]
            M0604 = 51,

            /// <summary>
            /// Enum M0700 for value: M07.00
            /// </summary>
            [EnumMember(Value = "M07.00")]
            M0700 = 52
        }


        /// <summary>
        /// A valoriser avec le code de la nomenclature associée
        /// </summary>
        /// <value>A valoriser avec le code de la nomenclature associée</value>
        /*
        <example>example.json#/qualification/healthMotive/code</example>
        */
        [DataMember(Name = "code", IsRequired = true, EmitDefaultValue = true)]
        public CodeEnum Code { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="HealthMotive" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected HealthMotive() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="HealthMotive" /> class.
        /// </summary>
        /// <param name="code">A valoriser avec le code de la nomenclature associée (required).</param>
        /// <param name="label">A valoriser avec le libellé de la nomenclature associée. Dans le cas où un système n&#39;est pas en mesure de reconnaître un code, il peut choisir d&#39;afficher le libellé qui est obligatoirement fourni avec le code. (required).</param>
        public HealthMotive(CodeEnum code = default(CodeEnum), string label = default(string))
        {
            this.Code = code;
            // to ensure "label" is required (not null)
            if (label == null)
            {
                throw new ArgumentNullException("label is a required property for HealthMotive and cannot be null");
            }
            this.Label = label;
        }

        /// <summary>
        /// A valoriser avec le libellé de la nomenclature associée. Dans le cas où un système n&#39;est pas en mesure de reconnaître un code, il peut choisir d&#39;afficher le libellé qui est obligatoirement fourni avec le code.
        /// </summary>
        /// <value>A valoriser avec le libellé de la nomenclature associée. Dans le cas où un système n&#39;est pas en mesure de reconnaître un code, il peut choisir d&#39;afficher le libellé qui est obligatoirement fourni avec le code.</value>
        /*
        <example>example.json#/qualification/healthMotive/label</example>
        */
        [DataMember(Name = "label", IsRequired = true, EmitDefaultValue = true)]
        public string Label { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class HealthMotive {\n");
            sb.Append("  Code: ").Append(Code).Append("\n");
            sb.Append("  Label: ").Append(Label).Append("\n");
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
