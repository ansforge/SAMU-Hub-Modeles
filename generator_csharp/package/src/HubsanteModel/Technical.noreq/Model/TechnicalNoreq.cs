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
using OpenAPIDateConverter = HubsanteModel/Technical.noreq.Client.OpenAPIDateConverter;

namespace HubsanteModel/Technical.noreq.Model
{
    /// <summary>
    /// TechnicalNoreq
    /// </summary>
    [DataContract(Name = "technicalNoreq")]
    public partial class TechnicalNoreq : IValidatableObject
    {
        /// <summary>
        /// This is an enumeration
        /// </summary>
        /// <value>This is an enumeration</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum EnumerationFieldEnum
        {
            /// <summary>
            /// Enum _1 for value: ENUM_VALUE_1
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_1")]
            _1 = 1,

            /// <summary>
            /// Enum _2 for value: ENUM_VALUE_2
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_2")]
            _2 = 2,

            /// <summary>
            /// Enum _3 for value: ENUM_VALUE_3
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_3")]
            _3 = 3,

            /// <summary>
            /// Enum _4 for value: ENUM_VALUE_4
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_4")]
            _4 = 4,

            /// <summary>
            /// Enum _5 for value: ENUM_VALUE_5
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_5")]
            _5 = 5
        }


        /// <summary>
        /// This is an enumeration
        /// </summary>
        /// <value>This is an enumeration</value>
        /*
        <example>example.json#/enumerationField</example>
        */
        [DataMember(Name = "enumerationField", EmitDefaultValue = false)]
        public EnumerationFieldEnum? EnumerationField { get; set; }
        /// <summary>
        /// This is an array of enumerations
        /// </summary>
        /// <value>This is an array of enumerations</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum EnumArrayFieldEnum
        {
            /// <summary>
            /// Enum _10 for value: ENUM_VALUE_10
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_10")]
            _10 = 1,

            /// <summary>
            /// Enum _20 for value: ENUM_VALUE_20
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_20")]
            _20 = 2,

            /// <summary>
            /// Enum _30 for value: ENUM_VALUE_30
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_30")]
            _30 = 3,

            /// <summary>
            /// Enum _40 for value: ENUM_VALUE_40
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_40")]
            _40 = 4,

            /// <summary>
            /// Enum _50 for value: ENUM_VALUE_50
            /// </summary>
            [EnumMember(Value = "ENUM_VALUE_50")]
            _50 = 5
        }

        /// <summary>
        /// Enum from extenal nomenclature file
        /// </summary>
        /// <value>Enum from extenal nomenclature file</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum NomenclatureFieldEnum
        {
            /// <summary>
            /// Enum M for value: M
            /// </summary>
            [EnumMember(Value = "M")]
            M = 1,

            /// <summary>
            /// Enum F for value: F
            /// </summary>
            [EnumMember(Value = "F")]
            F = 2,

            /// <summary>
            /// Enum O for value: O
            /// </summary>
            [EnumMember(Value = "O")]
            O = 3,

            /// <summary>
            /// Enum UN for value: UN
            /// </summary>
            [EnumMember(Value = "UN")]
            UN = 4
        }


        /// <summary>
        /// Enum from extenal nomenclature file
        /// </summary>
        /// <value>Enum from extenal nomenclature file</value>
        /*
        <example>example.json#/nomenclatureField</example>
        */
        [DataMember(Name = "nomenclatureField", EmitDefaultValue = false)]
        public NomenclatureFieldEnum? NomenclatureField { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="TechnicalNoreq" /> class.
        /// </summary>
        /// <param name="optionalStringField">This field is optional.</param>
        /// <param name="enumerationField">This is an enumeration.</param>
        /// <param name="integerField">This is an integer.</param>
        /// <param name="numberField">This is a number.</param>
        /// <param name="booleanField">This is a boolean.</param>
        /// <param name="objectField">objectField.</param>
        /// <param name="arrayField">arrayField.</param>
        /// <param name="enumArrayField">enumArrayField.</param>
        /// <param name="arrayWithMaxLength">arrayWithMaxLength.</param>
        /// <param name="phoneNumberField">Phone number with regex.</param>
        /// <param name="dateField">Date.</param>
        /// <param name="emailField">Email with regex.</param>
        /// <param name="datetimeField">Datetime.</param>
        /// <param name="objectLevel1">objectLevel1.</param>
        /// <param name="nomenclatureField">Enum from extenal nomenclature file.</param>
        public TechnicalNoreq(string optionalStringField = default(string), EnumerationFieldEnum? enumerationField = default(EnumerationFieldEnum?), int integerField = default(int), decimal numberField = default(decimal), bool booleanField = default(bool), TechnicalObject objectField = default(TechnicalObject), List<string> arrayField = default(List<string>), List<EnumArrayFieldEnum> enumArrayField = default(List<EnumArrayFieldEnum>), List<string> arrayWithMaxLength = default(List<string>), string phoneNumberField = default(string), string dateField = default(string), string emailField = default(string), DateTime datetimeField = default(DateTime), LevelOneData objectLevel1 = default(LevelOneData), NomenclatureFieldEnum? nomenclatureField = default(NomenclatureFieldEnum?))
        {
            this.OptionalStringField = optionalStringField;
            this.EnumerationField = enumerationField;
            this.IntegerField = integerField;
            this.NumberField = numberField;
            this.BooleanField = booleanField;
            this.ObjectField = objectField;
            this.ArrayField = arrayField;
            this.EnumArrayField = enumArrayField;
            this.ArrayWithMaxLength = arrayWithMaxLength;
            this.PhoneNumberField = phoneNumberField;
            this.DateField = dateField;
            this.EmailField = emailField;
            this.DatetimeField = datetimeField;
            this.ObjectLevel1 = objectLevel1;
            this.NomenclatureField = nomenclatureField;
        }

        /// <summary>
        /// This field is optional
        /// </summary>
        /// <value>This field is optional</value>
        /*
        <example>example.json#/optionalStringField</example>
        */
        [DataMember(Name = "optionalStringField", EmitDefaultValue = false)]
        public string OptionalStringField { get; set; }

        /// <summary>
        /// This is an integer
        /// </summary>
        /// <value>This is an integer</value>
        [DataMember(Name = "integerField", EmitDefaultValue = false)]
        public int IntegerField { get; set; }

        /// <summary>
        /// This is a number
        /// </summary>
        /// <value>This is a number</value>
        [DataMember(Name = "numberField", EmitDefaultValue = false)]
        public decimal NumberField { get; set; }

        /// <summary>
        /// This is a boolean
        /// </summary>
        /// <value>This is a boolean</value>
        /*
        <example>false</example>
        */
        [DataMember(Name = "booleanField", EmitDefaultValue = true)]
        public bool BooleanField { get; set; }

        /// <summary>
        /// Gets or Sets ObjectField
        /// </summary>
        [DataMember(Name = "objectField", EmitDefaultValue = false)]
        public TechnicalObject ObjectField { get; set; }

        /// <summary>
        /// Gets or Sets ArrayField
        /// </summary>
        [DataMember(Name = "arrayField", EmitDefaultValue = false)]
        public List<string> ArrayField { get; set; }

        /// <summary>
        /// Gets or Sets EnumArrayField
        /// </summary>
        [DataMember(Name = "enumArrayField", EmitDefaultValue = false)]
        public List<TechnicalNoreq.EnumArrayFieldEnum> EnumArrayField { get; set; }

        /// <summary>
        /// Gets or Sets ArrayWithMaxLength
        /// </summary>
        [DataMember(Name = "arrayWithMaxLength", EmitDefaultValue = false)]
        public List<string> ArrayWithMaxLength { get; set; }

        /// <summary>
        /// Phone number with regex
        /// </summary>
        /// <value>Phone number with regex</value>
        /*
        <example>example.json#/phoneNumberField</example>
        */
        [DataMember(Name = "phoneNumberField", EmitDefaultValue = false)]
        public string PhoneNumberField { get; set; }

        /// <summary>
        /// Date
        /// </summary>
        /// <value>Date</value>
        /*
        <example>example.json#/dateField</example>
        */
        [DataMember(Name = "dateField", EmitDefaultValue = false)]
        public string DateField { get; set; }

        /// <summary>
        /// Email with regex
        /// </summary>
        /// <value>Email with regex</value>
        /*
        <example>example.json#/emailField</example>
        */
        [DataMember(Name = "emailField", EmitDefaultValue = false)]
        public string EmailField { get; set; }

        /// <summary>
        /// Datetime
        /// </summary>
        /// <value>Datetime</value>
        [DataMember(Name = "datetimeField", EmitDefaultValue = false)]
        public DateTime DatetimeField { get; set; }

        /// <summary>
        /// Gets or Sets ObjectLevel1
        /// </summary>
        [DataMember(Name = "objectLevel1", EmitDefaultValue = false)]
        public LevelOneData ObjectLevel1 { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class TechnicalNoreq {\n");
            sb.Append("  OptionalStringField: ").Append(OptionalStringField).Append("\n");
            sb.Append("  EnumerationField: ").Append(EnumerationField).Append("\n");
            sb.Append("  IntegerField: ").Append(IntegerField).Append("\n");
            sb.Append("  NumberField: ").Append(NumberField).Append("\n");
            sb.Append("  BooleanField: ").Append(BooleanField).Append("\n");
            sb.Append("  ObjectField: ").Append(ObjectField).Append("\n");
            sb.Append("  ArrayField: ").Append(ArrayField).Append("\n");
            sb.Append("  EnumArrayField: ").Append(EnumArrayField).Append("\n");
            sb.Append("  ArrayWithMaxLength: ").Append(ArrayWithMaxLength).Append("\n");
            sb.Append("  PhoneNumberField: ").Append(PhoneNumberField).Append("\n");
            sb.Append("  DateField: ").Append(DateField).Append("\n");
            sb.Append("  EmailField: ").Append(EmailField).Append("\n");
            sb.Append("  DatetimeField: ").Append(DatetimeField).Append("\n");
            sb.Append("  ObjectLevel1: ").Append(ObjectLevel1).Append("\n");
            sb.Append("  NomenclatureField: ").Append(NomenclatureField).Append("\n");
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
            if (this.PhoneNumberField != null) {
                // PhoneNumberField (string) pattern
                Regex regexPhoneNumberField = new Regex(@"^\+?[0-9]{2,14}$", RegexOptions.CultureInvariant);
                if (!regexPhoneNumberField.Match(this.PhoneNumberField).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for PhoneNumberField, must match a pattern of " + regexPhoneNumberField, new [] { "PhoneNumberField" });
                }
            }

            if (this.DateField != null) {
                // DateField (string) pattern
                Regex regexDateField = new Regex(@"^\d{4}-\d{2}-\d{2}$", RegexOptions.CultureInvariant);
                if (!regexDateField.Match(this.DateField).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for DateField, must match a pattern of " + regexDateField, new [] { "DateField" });
                }
            }

            if (this.EmailField != null) {
                // EmailField (string) pattern
                Regex regexEmailField = new Regex(@"^[\w\-\.]+@([\w\-]+\.)+[\w\-]{2,4}$", RegexOptions.CultureInvariant);
                if (!regexEmailField.Match(this.EmailField).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for EmailField, must match a pattern of " + regexEmailField, new [] { "EmailField" });
                }
            }

            if (this.DatetimeField != null) {
                // DatetimeField (DateTime) pattern
                Regex regexDatetimeField = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexDatetimeField.Match(this.DatetimeField).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for DatetimeField, must match a pattern of " + regexDatetimeField, new [] { "DatetimeField" });
                }
            }

            yield break;
        }
    }

}
