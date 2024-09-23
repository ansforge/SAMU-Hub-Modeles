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
    /// ExternalInfo
    /// </summary>
    [DataContract(Name = "externalInfo")]
    public partial class ExternalInfo : IEquatable<ExternalInfo>, IValidatableObject
    {
        /// <summary>
        /// A valoriser avec le système fournissant le localisant
        /// </summary>
        /// <value>A valoriser avec le système fournissant le localisant</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum FreetextEnum
        {
            /// <summary>
            /// Enum BAN for value: BAN
            /// </summary>
            [EnumMember(Value = "BAN")]
            BAN = 1,

            /// <summary>
            /// Enum IGN for value: IGN
            /// </summary>
            [EnumMember(Value = "IGN")]
            IGN = 2,

            /// <summary>
            /// Enum NEXSIS for value: NEXSIS
            /// </summary>
            [EnumMember(Value = "NEXSIS")]
            NEXSIS = 3
        }


        /// <summary>
        /// A valoriser avec le système fournissant le localisant
        /// </summary>
        /// <value>A valoriser avec le système fournissant le localisant</value>
        /// <example>example.json#/location/externalInfo/0/freetext</example>
        [DataMember(Name = "freetext", IsRequired = true, EmitDefaultValue = true)]
        public FreetextEnum Freetext { get; set; }
        /// <summary>
        /// A valoriser avec la définition du type d&#39;objet dans le système  Exemple : SIG NexSIS / OSM ont plusieurs types de données (EGA, POI, tronçon de route, …)
        /// </summary>
        /// <value>A valoriser avec la définition du type d&#39;objet dans le système  Exemple : SIG NexSIS / OSM ont plusieurs types de données (EGA, POI, tronçon de route, …)</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum TypeEnum
        {
            /// <summary>
            /// Enum MANUEL for value: MANUEL
            /// </summary>
            [EnumMember(Value = "MANUEL")]
            MANUEL = 1,

            /// <summary>
            /// Enum CARTE for value: CARTE
            /// </summary>
            [EnumMember(Value = "CARTE")]
            CARTE = 2,

            /// <summary>
            /// Enum AUTRE for value: AUTRE
            /// </summary>
            [EnumMember(Value = "AUTRE")]
            AUTRE = 3,

            /// <summary>
            /// Enum PHOTO for value: PHOTO
            /// </summary>
            [EnumMember(Value = "PHOTO")]
            PHOTO = 4,

            /// <summary>
            /// Enum SITEINTERNET for value: SITE_INTERNET
            /// </summary>
            [EnumMember(Value = "SITE_INTERNET")]
            SITEINTERNET = 5
        }


        /// <summary>
        /// A valoriser avec la définition du type d&#39;objet dans le système  Exemple : SIG NexSIS / OSM ont plusieurs types de données (EGA, POI, tronçon de route, …)
        /// </summary>
        /// <value>A valoriser avec la définition du type d&#39;objet dans le système  Exemple : SIG NexSIS / OSM ont plusieurs types de données (EGA, POI, tronçon de route, …)</value>
        /// <example>example.json#/location/externalInfo/0/type</example>
        [DataMember(Name = "type", EmitDefaultValue = false)]
        public TypeEnum? Type { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="ExternalInfo" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected ExternalInfo() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="ExternalInfo" /> class.
        /// </summary>
        /// <param name="freetext">A valoriser avec le système fournissant le localisant (required).</param>
        /// <param name="type">A valoriser avec la définition du type d&#39;objet dans le système  Exemple : SIG NexSIS / OSM ont plusieurs types de données (EGA, POI, tronçon de route, …).</param>
        /// <param name="uri">Identifiant dans le système concerné (required).</param>
        public ExternalInfo(FreetextEnum freetext = default(FreetextEnum), TypeEnum? type = default(TypeEnum?), string uri = default(string))
        {
            this.Freetext = freetext;
            // to ensure "uri" is required (not null)
            if (uri == null)
            {
                throw new ArgumentNullException("uri is a required property for ExternalInfo and cannot be null");
            }
            this.Uri = uri;
            this.Type = type;
        }

        /// <summary>
        /// Identifiant dans le système concerné
        /// </summary>
        /// <value>Identifiant dans le système concerné</value>
        /// <example>example.json#/location/externalInfo/0/uri</example>
        [DataMember(Name = "uri", IsRequired = true, EmitDefaultValue = true)]
        public string Uri { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class ExternalInfo {\n");
            sb.Append("  Freetext: ").Append(Freetext).Append("\n");
            sb.Append("  Type: ").Append(Type).Append("\n");
            sb.Append("  Uri: ").Append(Uri).Append("\n");
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
            return this.Equals(input as ExternalInfo);
        }

        /// <summary>
        /// Returns true if ExternalInfo instances are equal
        /// </summary>
        /// <param name="input">Instance of ExternalInfo to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(ExternalInfo input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Freetext == input.Freetext ||
                    this.Freetext.Equals(input.Freetext)
                ) && 
                (
                    this.Type == input.Type ||
                    this.Type.Equals(input.Type)
                ) && 
                (
                    this.Uri == input.Uri ||
                    (this.Uri != null &&
                    this.Uri.Equals(input.Uri))
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
                hashCode = (hashCode * 59) + this.Freetext.GetHashCode();
                hashCode = (hashCode * 59) + this.Type.GetHashCode();
                if (this.Uri != null)
                {
                    hashCode = (hashCode * 59) + this.Uri.GetHashCode();
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
            yield break;
        }
    }

}