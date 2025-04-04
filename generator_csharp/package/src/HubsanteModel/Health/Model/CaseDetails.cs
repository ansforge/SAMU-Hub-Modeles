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
    /// CaseDetails
    /// </summary>
    [DataContract(Name = "caseDetails")]
    public partial class CaseDetails : IValidatableObject
    {
        /// <summary>
        /// A valoriser avec l&#39;état du dossier dans le système émetteur Spécificité 15-15 : peut être ignoré en réception, partagé à titre indicatif uniquement Spécificité 15-SMUR : à utiliser à minima pour transmettre le statut CLOTURE à la tablette
        /// </summary>
        /// <value>A valoriser avec l&#39;état du dossier dans le système émetteur Spécificité 15-15 : peut être ignoré en réception, partagé à titre indicatif uniquement Spécificité 15-SMUR : à utiliser à minima pour transmettre le statut CLOTURE à la tablette</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum StatusEnum
        {
            /// <summary>
            /// Enum PROGRAM for value: PROGRAM
            /// </summary>
            [EnumMember(Value = "PROGRAM")]
            PROGRAM = 1,

            /// <summary>
            /// Enum ACTIF for value: ACTIF
            /// </summary>
            [EnumMember(Value = "ACTIF")]
            ACTIF = 2,

            /// <summary>
            /// Enum ACHEVE for value: ACHEVE
            /// </summary>
            [EnumMember(Value = "ACHEVE")]
            ACHEVE = 3,

            /// <summary>
            /// Enum VALIDE for value: VALIDE
            /// </summary>
            [EnumMember(Value = "VALIDE")]
            VALIDE = 4,

            /// <summary>
            /// Enum CLOTURE for value: CLOTURE
            /// </summary>
            [EnumMember(Value = "CLOTURE")]
            CLOTURE = 5,

            /// <summary>
            /// Enum CLASSE for value: CLASSE
            /// </summary>
            [EnumMember(Value = "CLASSE")]
            CLASSE = 6,

            /// <summary>
            /// Enum ARCHIVE for value: ARCHIVE
            /// </summary>
            [EnumMember(Value = "ARCHIVE")]
            ARCHIVE = 7
        }


        /// <summary>
        /// A valoriser avec l&#39;état du dossier dans le système émetteur Spécificité 15-15 : peut être ignoré en réception, partagé à titre indicatif uniquement Spécificité 15-SMUR : à utiliser à minima pour transmettre le statut CLOTURE à la tablette
        /// </summary>
        /// <value>A valoriser avec l&#39;état du dossier dans le système émetteur Spécificité 15-15 : peut être ignoré en réception, partagé à titre indicatif uniquement Spécificité 15-SMUR : à utiliser à minima pour transmettre le statut CLOTURE à la tablette</value>
        /*
        <example>example.json#/qualification/details/status</example>
        */
        [DataMember(Name = "status", EmitDefaultValue = false)]
        public StatusEnum? Status { get; set; }
        /// <summary>
        /// Décrit le type de professionnel médical à qui le dossier est attribué : médecin généraliste, médecin urgentiste etc.
        /// </summary>
        /// <value>Décrit le type de professionnel médical à qui le dossier est attribué : médecin généraliste, médecin urgentiste etc.</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum AttributionEnum
        {
            /// <summary>
            /// Enum DRM for value: DRM
            /// </summary>
            [EnumMember(Value = "DRM")]
            DRM = 1,

            /// <summary>
            /// Enum DRMMRU for value: DRM.MRU
            /// </summary>
            [EnumMember(Value = "DRM.MRU")]
            DRMMRU = 2,

            /// <summary>
            /// Enum DRMMRUMU for value: DRM.MRU.MU
            /// </summary>
            [EnumMember(Value = "DRM.MRU.MU")]
            DRMMRUMU = 3,

            /// <summary>
            /// Enum DRMMRUINDISPMU for value: DRM.MRU.INDISPMU
            /// </summary>
            [EnumMember(Value = "DRM.MRU.INDISPMU")]
            DRMMRUINDISPMU = 4,

            /// <summary>
            /// Enum DRMMRUSSE for value: DRM.MRU.SSE
            /// </summary>
            [EnumMember(Value = "DRM.MRU.SSE")]
            DRMMRUSSE = 5,

            /// <summary>
            /// Enum DRMMRUPLANBLAN for value: DRM.MRU.PLANBLAN
            /// </summary>
            [EnumMember(Value = "DRM.MRU.PLANBLAN")]
            DRMMRUPLANBLAN = 6,

            /// <summary>
            /// Enum DRMMRUPCSAMU for value: DRM.MRU.PCSAMU
            /// </summary>
            [EnumMember(Value = "DRM.MRU.PCSAMU")]
            DRMMRUPCSAMU = 7,

            /// <summary>
            /// Enum DRMSPE for value: DRM.SPE
            /// </summary>
            [EnumMember(Value = "DRM.SPE")]
            DRMSPE = 8,

            /// <summary>
            /// Enum DRMSPEDENT for value: DRM.SPE.DENT
            /// </summary>
            [EnumMember(Value = "DRM.SPE.DENT")]
            DRMSPEDENT = 9,

            /// <summary>
            /// Enum DRMSPEGERIA for value: DRM.SPE.GERIA
            /// </summary>
            [EnumMember(Value = "DRM.SPE.GERIA")]
            DRMSPEGERIA = 10,

            /// <summary>
            /// Enum DRMSPEPEDIA for value: DRM.SPE.PEDIA
            /// </summary>
            [EnumMember(Value = "DRM.SPE.PEDIA")]
            DRMSPEPEDIA = 11,

            /// <summary>
            /// Enum DRMSPEOBST for value: DRM.SPE.OBST
            /// </summary>
            [EnumMember(Value = "DRM.SPE.OBST")]
            DRMSPEOBST = 12,

            /// <summary>
            /// Enum DRMSPEPSY for value: DRM.SPE.PSY
            /// </summary>
            [EnumMember(Value = "DRM.SPE.PSY")]
            DRMSPEPSY = 13,

            /// <summary>
            /// Enum DRMSPETOXICOL for value: DRM.SPE.TOXICOL
            /// </summary>
            [EnumMember(Value = "DRM.SPE.TOXICOL")]
            DRMSPETOXICOL = 14,

            /// <summary>
            /// Enum DRMSPEAUTRESPE for value: DRM.SPE.AUTRESPE
            /// </summary>
            [EnumMember(Value = "DRM.SPE.AUTRESPE")]
            DRMSPEAUTRESPE = 15,

            /// <summary>
            /// Enum DRMMRL for value: DRM.MRL
            /// </summary>
            [EnumMember(Value = "DRM.MRL")]
            DRMMRL = 16,

            /// <summary>
            /// Enum DRMMRLMG for value: DRM.MRL.MG
            /// </summary>
            [EnumMember(Value = "DRM.MRL.MG")]
            DRMMRLMG = 17,

            /// <summary>
            /// Enum DRMMRLINDISPMG for value: DRM.MRL.INDISPMG
            /// </summary>
            [EnumMember(Value = "DRM.MRL.INDISPMG")]
            DRMMRLINDISPMG = 18,

            /// <summary>
            /// Enum DRMMRLABSML for value: DRM.MRL.ABSML
            /// </summary>
            [EnumMember(Value = "DRM.MRL.ABSML")]
            DRMMRLABSML = 19,

            /// <summary>
            /// Enum DR for value: DR
            /// </summary>
            [EnumMember(Value = "DR")]
            DR = 20,

            /// <summary>
            /// Enum DRDREG for value: DR.DREG
            /// </summary>
            [EnumMember(Value = "DR.DREG")]
            DRDREG = 21,

            /// <summary>
            /// Enum DRDREGDRARM for value: DR.DREG.DRARM
            /// </summary>
            [EnumMember(Value = "DR.DREG.DRARM")]
            DRDREGDRARM = 22,

            /// <summary>
            /// Enum DRDREGDRDAC for value: DR.DREG.DRDAC
            /// </summary>
            [EnumMember(Value = "DR.DREG.DRDAC")]
            DRDREGDRDAC = 23,

            /// <summary>
            /// Enum DRDREGDRMED for value: DR.DREG.DRMED
            /// </summary>
            [EnumMember(Value = "DR.DREG.DRMED")]
            DRDREGDRMED = 24,

            /// <summary>
            /// Enum DRDREGDRPHARMA for value: DR.DREG.DRPHARMA
            /// </summary>
            [EnumMember(Value = "DR.DREG.DRPHARMA")]
            DRDREGDRPHARMA = 25,

            /// <summary>
            /// Enum DRDREGDRDENT for value: DR.DREG.DRDENT
            /// </summary>
            [EnumMember(Value = "DR.DREG.DRDENT")]
            DRDREGDRDENT = 26,

            /// <summary>
            /// Enum DRDREGDRINFO for value: DR.DREG.DRINFO
            /// </summary>
            [EnumMember(Value = "DR.DREG.DRINFO")]
            DRDREGDRINFO = 27,

            /// <summary>
            /// Enum DRDREGDOSSIS for value: DR.DREG.DOS-SIS
            /// </summary>
            [EnumMember(Value = "DR.DREG.DOS-SIS")]
            DRDREGDOSSIS = 28,

            /// <summary>
            /// Enum DRDREGDOSFDO for value: DR.DREG.DOS-FDO
            /// </summary>
            [EnumMember(Value = "DR.DREG.DOS-FDO")]
            DRDREGDOSFDO = 29,

            /// <summary>
            /// Enum D for value: D
            /// </summary>
            [EnumMember(Value = "D")]
            D = 30,

            /// <summary>
            /// Enum DDMALV for value: D.D-MALV
            /// </summary>
            [EnumMember(Value = "D.D-MALV")]
            DDMALV = 31,

            /// <summary>
            /// Enum DDMALVERR for value: D.D-MALV.ERR
            /// </summary>
            [EnumMember(Value = "D.D-MALV.ERR")]
            DDMALVERR = 32,

            /// <summary>
            /// Enum DDMALVNRP for value: D.D-MALV.NRP
            /// </summary>
            [EnumMember(Value = "D.D-MALV.NRP")]
            DDMALVNRP = 33,

            /// <summary>
            /// Enum DDMALVMALV for value: D.D-MALV.MALV
            /// </summary>
            [EnumMember(Value = "D.D-MALV.MALV")]
            DDMALVMALV = 34,

            /// <summary>
            /// Enum DDMALVFAX for value: D.D-MALV.FAX
            /// </summary>
            [EnumMember(Value = "D.D-MALV.FAX")]
            DDMALVFAX = 35,

            /// <summary>
            /// Enum DDMALVITERATIF for value: D.D-MALV.ITERATIF
            /// </summary>
            [EnumMember(Value = "D.D-MALV.ITERATIF")]
            DDMALVITERATIF = 36,

            /// <summary>
            /// Enum DDIDENT for value: D.D-IDENT
            /// </summary>
            [EnumMember(Value = "D.D-IDENT")]
            DDIDENT = 37,

            /// <summary>
            /// Enum DDIDENTADMIN for value: D.D-IDENT.ADMIN
            /// </summary>
            [EnumMember(Value = "D.D-IDENT.ADMIN")]
            DDIDENTADMIN = 38,

            /// <summary>
            /// Enum DDIDENTPERSO for value: D.D-IDENT.PERSO
            /// </summary>
            [EnumMember(Value = "D.D-IDENT.PERSO")]
            DDIDENTPERSO = 39,

            /// <summary>
            /// Enum DDIDENTAUTRE for value: D.D-IDENT.AUTRE
            /// </summary>
            [EnumMember(Value = "D.D-IDENT.AUTRE")]
            DDIDENTAUTRE = 40
        }


        /// <summary>
        /// Décrit le type de professionnel médical à qui le dossier est attribué : médecin généraliste, médecin urgentiste etc.
        /// </summary>
        /// <value>Décrit le type de professionnel médical à qui le dossier est attribué : médecin généraliste, médecin urgentiste etc.</value>
        /*
        <example>example.json#/qualification/details/attribution</example>
        */
        [DataMember(Name = "attribution", EmitDefaultValue = false)]
        public AttributionEnum? Attribution { get; set; }
        /// <summary>
        /// Décrit la priorité de régulation médicale du dossier : P0, P1, P2, P3
        /// </summary>
        /// <value>Décrit la priorité de régulation médicale du dossier : P0, P1, P2, P3</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum PriorityEnum
        {
            /// <summary>
            /// Enum P0 for value: P0
            /// </summary>
            [EnumMember(Value = "P0")]
            P0 = 1,

            /// <summary>
            /// Enum P1 for value: P1
            /// </summary>
            [EnumMember(Value = "P1")]
            P1 = 2,

            /// <summary>
            /// Enum P2 for value: P2
            /// </summary>
            [EnumMember(Value = "P2")]
            P2 = 3,

            /// <summary>
            /// Enum P3 for value: P3
            /// </summary>
            [EnumMember(Value = "P3")]
            P3 = 4,

            /// <summary>
            /// Enum NR for value: NR
            /// </summary>
            [EnumMember(Value = "NR")]
            NR = 5
        }


        /// <summary>
        /// Décrit la priorité de régulation médicale du dossier : P0, P1, P2, P3
        /// </summary>
        /// <value>Décrit la priorité de régulation médicale du dossier : P0, P1, P2, P3</value>
        /*
        <example>example.json#/qualification/details/priority</example>
        */
        [DataMember(Name = "priority", EmitDefaultValue = false)]
        public PriorityEnum? Priority { get; set; }
        /// <summary>
        /// Décrit le niveau de soins global du dossier identifié au cours de l&#39;acte de régulation médicale : s&#39;il y a plusieurs niveaux de soins différents pour chaque patient, on indique ici le niveau le plus grave. cf.nomenclature associée.
        /// </summary>
        /// <value>Décrit le niveau de soins global du dossier identifié au cours de l&#39;acte de régulation médicale : s&#39;il y a plusieurs niveaux de soins différents pour chaque patient, on indique ici le niveau le plus grave. cf.nomenclature associée.</value>
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
        /// Décrit le niveau de soins global du dossier identifié au cours de l&#39;acte de régulation médicale : s&#39;il y a plusieurs niveaux de soins différents pour chaque patient, on indique ici le niveau le plus grave. cf.nomenclature associée.
        /// </summary>
        /// <value>Décrit le niveau de soins global du dossier identifié au cours de l&#39;acte de régulation médicale : s&#39;il y a plusieurs niveaux de soins différents pour chaque patient, on indique ici le niveau le plus grave. cf.nomenclature associée.</value>
        /*
        <example>example.json#/qualification/details/careLevel</example>
        */
        [DataMember(Name = "careLevel", EmitDefaultValue = false)]
        public CareLevelEnum? CareLevel { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="CaseDetails" /> class.
        /// </summary>
        /// <param name="status">A valoriser avec l&#39;état du dossier dans le système émetteur Spécificité 15-15 : peut être ignoré en réception, partagé à titre indicatif uniquement Spécificité 15-SMUR : à utiliser à minima pour transmettre le statut CLOTURE à la tablette.</param>
        /// <param name="attribution">Décrit le type de professionnel médical à qui le dossier est attribué : médecin généraliste, médecin urgentiste etc..</param>
        /// <param name="priority">Décrit la priorité de régulation médicale du dossier : P0, P1, P2, P3.</param>
        /// <param name="careLevel">Décrit le niveau de soins global du dossier identifié au cours de l&#39;acte de régulation médicale : s&#39;il y a plusieurs niveaux de soins différents pour chaque patient, on indique ici le niveau le plus grave. cf.nomenclature associée..</param>
        public CaseDetails(StatusEnum? status = default(StatusEnum?), AttributionEnum? attribution = default(AttributionEnum?), PriorityEnum? priority = default(PriorityEnum?), CareLevelEnum? careLevel = default(CareLevelEnum?))
        {
            this.Status = status;
            this.Attribution = attribution;
            this.Priority = priority;
            this.CareLevel = careLevel;
        }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class CaseDetails {\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
            sb.Append("  Attribution: ").Append(Attribution).Append("\n");
            sb.Append("  Priority: ").Append(Priority).Append("\n");
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
