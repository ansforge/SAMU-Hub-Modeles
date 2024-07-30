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
    /// PatientDetail
    /// </summary>
    [DataContract(Name = "patientDetail")]
    public partial class PatientDetail : IEquatable<PatientDetail>, IValidatableObject
    {
        /// <summary>
        /// A valoriser avec le niveau de soins spécifique au patient
        /// </summary>
        /// <value>A valoriser avec le niveau de soins spécifique au patient</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum CareLevelEnum
        {
            /// <summary>
            /// Enum R1 for value: R1
            /// </summary>
            [EnumMember(Value = "R1")]
            R1 = 1,

            /// <summary>
            /// Enum R2 for value: R2
            /// </summary>
            [EnumMember(Value = "R2")]
            R2 = 2,

            /// <summary>
            /// Enum R3 for value: R3
            /// </summary>
            [EnumMember(Value = "R3")]
            R3 = 3,

            /// <summary>
            /// Enum R4 for value: R4
            /// </summary>
            [EnumMember(Value = "R4")]
            R4 = 4
        }


        /// <summary>
        /// A valoriser avec le niveau de soins spécifique au patient
        /// </summary>
        /// <value>A valoriser avec le niveau de soins spécifique au patient</value>
        /// <example>example.json#/patient/0/detail/careLevel</example>
        [DataMember(Name = "careLevel", EmitDefaultValue = false)]
        public CareLevelEnum? CareLevel { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="PatientDetail" /> class.
        /// </summary>
        /// <param name="weight">A valoriser avec le poids en kilogrammes.</param>
        /// <param name="height">A valoriser avec la taille en centimètres du patient.</param>
        /// <param name="age">A valoriser avec l&#39;age du patient. Au format \&quot;Durée\&quot; de la norme ISO 8601 (https://fr.wikipedia.org/wiki/ISO_8601#Dur%C3%A9e) et en n&#39;utilisant qu&#39;une seule unité de durée (années, mois, semaines ou jours).</param>
        /// <param name="careLevel">A valoriser avec le niveau de soins spécifique au patient.</param>
        public PatientDetail(int weight = default(int), int height = default(int), string age = default(string), CareLevelEnum? careLevel = default(CareLevelEnum?))
        {
            this.Weight = weight;
            this.Height = height;
            this.Age = age;
            this.CareLevel = careLevel;
        }

        /// <summary>
        /// A valoriser avec le poids en kilogrammes
        /// </summary>
        /// <value>A valoriser avec le poids en kilogrammes</value>
        [DataMember(Name = "weight", EmitDefaultValue = false)]
        public int Weight { get; set; }

        /// <summary>
        /// A valoriser avec la taille en centimètres du patient
        /// </summary>
        /// <value>A valoriser avec la taille en centimètres du patient</value>
        [DataMember(Name = "height", EmitDefaultValue = false)]
        public int Height { get; set; }

        /// <summary>
        /// A valoriser avec l&#39;age du patient. Au format \&quot;Durée\&quot; de la norme ISO 8601 (https://fr.wikipedia.org/wiki/ISO_8601#Dur%C3%A9e) et en n&#39;utilisant qu&#39;une seule unité de durée (années, mois, semaines ou jours)
        /// </summary>
        /// <value>A valoriser avec l&#39;age du patient. Au format \&quot;Durée\&quot; de la norme ISO 8601 (https://fr.wikipedia.org/wiki/ISO_8601#Dur%C3%A9e) et en n&#39;utilisant qu&#39;une seule unité de durée (années, mois, semaines ou jours)</value>
        /// <example>example.json#/patient/0/detail/age</example>
        [DataMember(Name = "age", EmitDefaultValue = false)]
        public string Age { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class PatientDetail {\n");
            sb.Append("  Weight: ").Append(Weight).Append("\n");
            sb.Append("  Height: ").Append(Height).Append("\n");
            sb.Append("  Age: ").Append(Age).Append("\n");
            sb.Append("  CareLevel: ").Append(CareLevel).Append("\n");
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
            return this.Equals(input as PatientDetail);
        }

        /// <summary>
        /// Returns true if PatientDetail instances are equal
        /// </summary>
        /// <param name="input">Instance of PatientDetail to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(PatientDetail input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Weight == input.Weight ||
                    this.Weight.Equals(input.Weight)
                ) && 
                (
                    this.Height == input.Height ||
                    this.Height.Equals(input.Height)
                ) && 
                (
                    this.Age == input.Age ||
                    (this.Age != null &&
                    this.Age.Equals(input.Age))
                ) && 
                (
                    this.CareLevel == input.CareLevel ||
                    this.CareLevel.Equals(input.CareLevel)
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
                hashCode = (hashCode * 59) + this.Weight.GetHashCode();
                hashCode = (hashCode * 59) + this.Height.GetHashCode();
                if (this.Age != null)
                {
                    hashCode = (hashCode * 59) + this.Age.GetHashCode();
                }
                hashCode = (hashCode * 59) + this.CareLevel.GetHashCode();
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
            if (this.Age != null) {
                // Age (string) pattern
                Regex regexAge = new Regex(@"P[0-9]{1,3}[YMWD]", RegexOptions.CultureInvariant);
                if (!regexAge.Match(this.Age).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for Age, must match a pattern of " + regexAge, new [] { "Age" });
                }
            }

            yield break;
        }
    }

}
