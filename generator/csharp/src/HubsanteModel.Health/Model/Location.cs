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
    /// Location
    /// </summary>
    [DataContract(Name = "location")]
    public partial class Location : IEquatable<Location>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Location" /> class.
        /// </summary>
        /// <param name="name">A valoriser avec le nom de lieu : nom commercial, nom d&#39;établissement, forêt de Fontainebleau, lac du Der, etc..</param>
        /// <param name="externalLocationId">externalLocationId.</param>
        /// <param name="detailedAddress">detailedAddress.</param>
        /// <param name="city">city.</param>
        /// <param name="access">access.</param>
        /// <param name="geometry">geometry.</param>
        /// <param name="externalInfo">externalInfo.</param>
        /// <param name="freetext">Champ libre qui permet de compléter les informations liées à la localisation.  Spécificités 15-15 : En envoi, il est souhaitable de mapper ici toute valeur en lien avec la localisation de l&#39;intervention qui ne pourrait pas être transmise de manière structurée dans l&#39;objet location.  En réception, il est très important d&#39;intégrer et d&#39;afficher la valeur de cet attribut, qui est suceptible de contenir des informations d&#39;accès importantes..</param>
        public Location(string name = default(string), List<ExternalLocationId> externalLocationId = default(List<ExternalLocationId>), DetailedAddress detailedAddress = default(DetailedAddress), City city = default(City), Access access = default(Access), Geometry geometry = default(Geometry), List<ExternalInfo> externalInfo = default(List<ExternalInfo>), string freetext = default(string))
        {
            this.Name = name;
            this.ExternalLocationId = externalLocationId;
            this.DetailedAddress = detailedAddress;
            this.City = city;
            this.Access = access;
            this.Geometry = geometry;
            this.ExternalInfo = externalInfo;
            this.Freetext = freetext;
        }

        /// <summary>
        /// A valoriser avec le nom de lieu : nom commercial, nom d&#39;établissement, forêt de Fontainebleau, lac du Der, etc.
        /// </summary>
        /// <value>A valoriser avec le nom de lieu : nom commercial, nom d&#39;établissement, forêt de Fontainebleau, lac du Der, etc.</value>
        /// <example>example.json#/location/name</example>
        [DataMember(Name = "name", EmitDefaultValue = false)]
        public string Name { get; set; }

        /// <summary>
        /// Gets or Sets ExternalLocationId
        /// </summary>
        [DataMember(Name = "externalLocationId", EmitDefaultValue = false)]
        public List<ExternalLocationId> ExternalLocationId { get; set; }

        /// <summary>
        /// Gets or Sets DetailedAddress
        /// </summary>
        [DataMember(Name = "detailedAddress", EmitDefaultValue = false)]
        public DetailedAddress DetailedAddress { get; set; }

        /// <summary>
        /// Gets or Sets City
        /// </summary>
        [DataMember(Name = "city", EmitDefaultValue = false)]
        public City City { get; set; }

        /// <summary>
        /// Gets or Sets Access
        /// </summary>
        [DataMember(Name = "access", EmitDefaultValue = false)]
        public Access Access { get; set; }

        /// <summary>
        /// Gets or Sets Geometry
        /// </summary>
        [DataMember(Name = "geometry", EmitDefaultValue = false)]
        public Geometry Geometry { get; set; }

        /// <summary>
        /// Gets or Sets ExternalInfo
        /// </summary>
        [DataMember(Name = "externalInfo", EmitDefaultValue = false)]
        public List<ExternalInfo> ExternalInfo { get; set; }

        /// <summary>
        /// Champ libre qui permet de compléter les informations liées à la localisation.  Spécificités 15-15 : En envoi, il est souhaitable de mapper ici toute valeur en lien avec la localisation de l&#39;intervention qui ne pourrait pas être transmise de manière structurée dans l&#39;objet location.  En réception, il est très important d&#39;intégrer et d&#39;afficher la valeur de cet attribut, qui est suceptible de contenir des informations d&#39;accès importantes.
        /// </summary>
        /// <value>Champ libre qui permet de compléter les informations liées à la localisation.  Spécificités 15-15 : En envoi, il est souhaitable de mapper ici toute valeur en lien avec la localisation de l&#39;intervention qui ne pourrait pas être transmise de manière structurée dans l&#39;objet location.  En réception, il est très important d&#39;intégrer et d&#39;afficher la valeur de cet attribut, qui est suceptible de contenir des informations d&#39;accès importantes.</value>
        /// <example>example.json#/location/freetext</example>
        [DataMember(Name = "freetext", EmitDefaultValue = false)]
        public string Freetext { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Location {\n");
            sb.Append("  Name: ").Append(Name).Append("\n");
            sb.Append("  ExternalLocationId: ").Append(ExternalLocationId).Append("\n");
            sb.Append("  DetailedAddress: ").Append(DetailedAddress).Append("\n");
            sb.Append("  City: ").Append(City).Append("\n");
            sb.Append("  Access: ").Append(Access).Append("\n");
            sb.Append("  Geometry: ").Append(Geometry).Append("\n");
            sb.Append("  ExternalInfo: ").Append(ExternalInfo).Append("\n");
            sb.Append("  Freetext: ").Append(Freetext).Append("\n");
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
            return this.Equals(input as Location);
        }

        /// <summary>
        /// Returns true if Location instances are equal
        /// </summary>
        /// <param name="input">Instance of Location to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Location input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Name == input.Name ||
                    (this.Name != null &&
                    this.Name.Equals(input.Name))
                ) && 
                (
                    this.ExternalLocationId == input.ExternalLocationId ||
                    this.ExternalLocationId != null &&
                    input.ExternalLocationId != null &&
                    this.ExternalLocationId.SequenceEqual(input.ExternalLocationId)
                ) && 
                (
                    this.DetailedAddress == input.DetailedAddress ||
                    (this.DetailedAddress != null &&
                    this.DetailedAddress.Equals(input.DetailedAddress))
                ) && 
                (
                    this.City == input.City ||
                    (this.City != null &&
                    this.City.Equals(input.City))
                ) && 
                (
                    this.Access == input.Access ||
                    (this.Access != null &&
                    this.Access.Equals(input.Access))
                ) && 
                (
                    this.Geometry == input.Geometry ||
                    (this.Geometry != null &&
                    this.Geometry.Equals(input.Geometry))
                ) && 
                (
                    this.ExternalInfo == input.ExternalInfo ||
                    this.ExternalInfo != null &&
                    input.ExternalInfo != null &&
                    this.ExternalInfo.SequenceEqual(input.ExternalInfo)
                ) && 
                (
                    this.Freetext == input.Freetext ||
                    (this.Freetext != null &&
                    this.Freetext.Equals(input.Freetext))
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
                if (this.Name != null)
                {
                    hashCode = (hashCode * 59) + this.Name.GetHashCode();
                }
                if (this.ExternalLocationId != null)
                {
                    hashCode = (hashCode * 59) + this.ExternalLocationId.GetHashCode();
                }
                if (this.DetailedAddress != null)
                {
                    hashCode = (hashCode * 59) + this.DetailedAddress.GetHashCode();
                }
                if (this.City != null)
                {
                    hashCode = (hashCode * 59) + this.City.GetHashCode();
                }
                if (this.Access != null)
                {
                    hashCode = (hashCode * 59) + this.Access.GetHashCode();
                }
                if (this.Geometry != null)
                {
                    hashCode = (hashCode * 59) + this.Geometry.GetHashCode();
                }
                if (this.ExternalInfo != null)
                {
                    hashCode = (hashCode * 59) + this.ExternalInfo.GetHashCode();
                }
                if (this.Freetext != null)
                {
                    hashCode = (hashCode * 59) + this.Freetext.GetHashCode();
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
