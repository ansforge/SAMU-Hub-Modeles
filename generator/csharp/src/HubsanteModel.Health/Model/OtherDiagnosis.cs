/*
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
using OpenAPIDateConverter = HubsanteModel.Health.Client.OpenAPIDateConverter;

namespace HubsanteModel.Health.Model
{
    /// <summary>
    /// OtherDiagnosis
    /// </summary>
    [DataContract(Name = "otherDiagnosis")]
    public partial class OtherDiagnosis : IEquatable<OtherDiagnosis>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="OtherDiagnosis" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected OtherDiagnosis() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="OtherDiagnosis" /> class.
        /// </summary>
        /// <param name="code">A valoriser avec le code de la nomenclature associée (required).</param>
        /// <param name="label">A valoriser avec le libellé de la nomenclature associée. Dans le cas où un système n&#39;est pas en mesure de reconnaître un code, il peut choisir d&#39;afficher le libellé qui est obligatoirement fourni avec le code. (required).</param>
        public OtherDiagnosis(string code = default(string), string label = default(string))
        {
            // to ensure "code" is required (not null)
            if (code == null)
            {
                throw new ArgumentNullException("code is a required property for OtherDiagnosis and cannot be null");
            }
            this.Code = code;
            // to ensure "label" is required (not null)
            if (label == null)
            {
                throw new ArgumentNullException("label is a required property for OtherDiagnosis and cannot be null");
            }
            this.Label = label;
        }

        /// <summary>
        /// A valoriser avec le code de la nomenclature associée
        /// </summary>
        /// <value>A valoriser avec le code de la nomenclature associée</value>
        /// <example>example.json#/patient/0/hypothesis/otherDiagnosis/0/code</example>
        [DataMember(Name = "code", IsRequired = true, EmitDefaultValue = true)]
        public string Code { get; set; }

        /// <summary>
        /// A valoriser avec le libellé de la nomenclature associée. Dans le cas où un système n&#39;est pas en mesure de reconnaître un code, il peut choisir d&#39;afficher le libellé qui est obligatoirement fourni avec le code.
        /// </summary>
        /// <value>A valoriser avec le libellé de la nomenclature associée. Dans le cas où un système n&#39;est pas en mesure de reconnaître un code, il peut choisir d&#39;afficher le libellé qui est obligatoirement fourni avec le code.</value>
        /// <example>example.json#/patient/0/hypothesis/otherDiagnosis/0/label</example>
        [DataMember(Name = "label", IsRequired = true, EmitDefaultValue = true)]
        public string Label { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class OtherDiagnosis {\n");
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
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="input">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object input)
        {
            return this.Equals(input as OtherDiagnosis);
        }

        /// <summary>
        /// Returns true if OtherDiagnosis instances are equal
        /// </summary>
        /// <param name="input">Instance of OtherDiagnosis to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(OtherDiagnosis input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Code == input.Code ||
                    (this.Code != null &&
                    this.Code.Equals(input.Code))
                ) && 
                (
                    this.Label == input.Label ||
                    (this.Label != null &&
                    this.Label.Equals(input.Label))
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            unchecked // Overflow is fine, just wrap
            {
                int hashCode = 41;
                if (this.Code != null)
                {
                    hashCode = (hashCode * 59) + this.Code.GetHashCode();
                }
                if (this.Label != null)
                {
                    hashCode = (hashCode * 59) + this.Label.GetHashCode();
                }
                return hashCode;
            }
        }

        /// <summary>
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            if (this.Code != null) {
                // Code (string) pattern
                Regex regexCode = new Regex(@"^[A-Z]\d{2}(\.[\d\+\-]{1,3})?$", RegexOptions.CultureInvariant);
                if (!regexCode.Match(this.Code).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for Code, must match a pattern of " + regexCode, new [] { "Code" });
                }
            }

            yield break;
        }
    }

}
