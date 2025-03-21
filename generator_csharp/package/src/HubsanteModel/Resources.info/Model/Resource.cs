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
using OpenAPIDateConverter = HubsanteModel/Resources.info.Client.OpenAPIDateConverter;

namespace HubsanteModel/Resources.info.Model
{
    /// <summary>
    /// Resource
    /// </summary>
    [DataContract(Name = "resource")]
    public partial class Resource : IValidatableObject
    {
        /// <summary>
        /// A valoriser avec le type de vecteur mobilisé : cf. nomenclature associée
        /// </summary>
        /// <value>A valoriser avec le type de vecteur mobilisé : cf. nomenclature associée</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum VehicleTypeEnum
        {
            /// <summary>
            /// Enum AASC for value: AASC
            /// </summary>
            [EnumMember(Value = "AASC")]
            AASC = 1,

            /// <summary>
            /// Enum AASCVLSC for value: AASC.VLSC
            /// </summary>
            [EnumMember(Value = "AASC.VLSC")]
            AASCVLSC = 2,

            /// <summary>
            /// Enum AASCVPSP for value: AASC.VPSP
            /// </summary>
            [EnumMember(Value = "AASC.VPSP")]
            AASCVPSP = 3,

            /// <summary>
            /// Enum AASCAUTRESC for value: AASC.AUTRESC
            /// </summary>
            [EnumMember(Value = "AASC.AUTRESC")]
            AASCAUTRESC = 4,

            /// <summary>
            /// Enum AUTREVEC for value: AUTREVEC
            /// </summary>
            [EnumMember(Value = "AUTREVEC")]
            AUTREVEC = 5,

            /// <summary>
            /// Enum AUTREVECAPIED for value: AUTREVEC.APIED
            /// </summary>
            [EnumMember(Value = "AUTREVEC.APIED")]
            AUTREVECAPIED = 6,

            /// <summary>
            /// Enum AUTREVECAVION for value: AUTREVEC.AVION
            /// </summary>
            [EnumMember(Value = "AUTREVEC.AVION")]
            AUTREVECAVION = 7,

            /// <summary>
            /// Enum AUTREVECPERSO for value: AUTREVEC.PERSO
            /// </summary>
            [EnumMember(Value = "AUTREVEC.PERSO")]
            AUTREVECPERSO = 8,

            /// <summary>
            /// Enum AUTREVECTAXI for value: AUTREVEC.TAXI
            /// </summary>
            [EnumMember(Value = "AUTREVEC.TAXI")]
            AUTREVECTAXI = 9,

            /// <summary>
            /// Enum AUTREVECTRAIN for value: AUTREVEC.TRAIN
            /// </summary>
            [EnumMember(Value = "AUTREVEC.TRAIN")]
            AUTREVECTRAIN = 10,

            /// <summary>
            /// Enum AUTREVECTRANSP for value: AUTREVEC.TRANSP
            /// </summary>
            [EnumMember(Value = "AUTREVEC.TRANSP")]
            AUTREVECTRANSP = 11,

            /// <summary>
            /// Enum AUTREVECAUTRE for value: AUTREVEC.AUTRE
            /// </summary>
            [EnumMember(Value = "AUTREVEC.AUTRE")]
            AUTREVECAUTRE = 12,

            /// <summary>
            /// Enum AUTREVECAUTRETRA for value: AUTREVEC.AUTRETRA
            /// </summary>
            [EnumMember(Value = "AUTREVEC.AUTRETRA")]
            AUTREVECAUTRETRA = 13,

            /// <summary>
            /// Enum FSI for value: FSI
            /// </summary>
            [EnumMember(Value = "FSI")]
            FSI = 14,

            /// <summary>
            /// Enum FSIHELIFSI for value: FSI.HELIFSI
            /// </summary>
            [EnumMember(Value = "FSI.HELIFSI")]
            FSIHELIFSI = 15,

            /// <summary>
            /// Enum FSIVLFSI for value: FSI.VLFSI
            /// </summary>
            [EnumMember(Value = "FSI.VLFSI")]
            FSIVLFSI = 16,

            /// <summary>
            /// Enum FSIFFSI for value: FSI.FFSI
            /// </summary>
            [EnumMember(Value = "FSI.FFSI")]
            FSIFFSI = 17,

            /// <summary>
            /// Enum FSIVHFSI for value: FSI.VHFSI
            /// </summary>
            [EnumMember(Value = "FSI.VHFSI")]
            FSIVHFSI = 18,

            /// <summary>
            /// Enum LIB for value: LIB
            /// </summary>
            [EnumMember(Value = "LIB")]
            LIB = 19,

            /// <summary>
            /// Enum LIBMEDV for value: LIB.MEDV
            /// </summary>
            [EnumMember(Value = "LIB.MEDV")]
            LIBMEDV = 20,

            /// <summary>
            /// Enum LIBINF for value: LIB.INF
            /// </summary>
            [EnumMember(Value = "LIB.INF")]
            LIBINF = 21,

            /// <summary>
            /// Enum LIBAUTREPRO for value: LIB.AUTREPRO
            /// </summary>
            [EnumMember(Value = "LIB.AUTREPRO")]
            LIBAUTREPRO = 22,

            /// <summary>
            /// Enum SIS for value: SIS
            /// </summary>
            [EnumMember(Value = "SIS")]
            SIS = 23,

            /// <summary>
            /// Enum SISDRAGON for value: SIS.DRAGON
            /// </summary>
            [EnumMember(Value = "SIS.DRAGON")]
            SISDRAGON = 24,

            /// <summary>
            /// Enum SISAVSC for value: SIS.AVSC
            /// </summary>
            [EnumMember(Value = "SIS.AVSC")]
            SISAVSC = 25,

            /// <summary>
            /// Enum SISFEUSIS for value: SIS.FEUSIS
            /// </summary>
            [EnumMember(Value = "SIS.FEUSIS")]
            SISFEUSIS = 26,

            /// <summary>
            /// Enum SISGRIMP for value: SIS.GRIMP
            /// </summary>
            [EnumMember(Value = "SIS.GRIMP")]
            SISGRIMP = 27,

            /// <summary>
            /// Enum SISNAVISIS for value: SIS.NAVISIS
            /// </summary>
            [EnumMember(Value = "SIS.NAVISIS")]
            SISNAVISIS = 28,

            /// <summary>
            /// Enum SISPCSIS for value: SIS.PCSIS
            /// </summary>
            [EnumMember(Value = "SIS.PCSIS")]
            SISPCSIS = 29,

            /// <summary>
            /// Enum SISSRSIS for value: SIS.SRSIS
            /// </summary>
            [EnumMember(Value = "SIS.SRSIS")]
            SISSRSIS = 30,

            /// <summary>
            /// Enum SISVCH for value: SIS.VCH
            /// </summary>
            [EnumMember(Value = "SIS.VCH")]
            SISVCH = 31,

            /// <summary>
            /// Enum SISVLCG for value: SIS.VLCG
            /// </summary>
            [EnumMember(Value = "SIS.VLCG")]
            SISVLCG = 32,

            /// <summary>
            /// Enum SISVLISP for value: SIS.VLISP
            /// </summary>
            [EnumMember(Value = "SIS.VLISP")]
            SISVLISP = 33,

            /// <summary>
            /// Enum SISVLMSP for value: SIS.VLMSP
            /// </summary>
            [EnumMember(Value = "SIS.VLMSP")]
            SISVLMSP = 34,

            /// <summary>
            /// Enum SISVLSIS for value: SIS.VLSIS
            /// </summary>
            [EnumMember(Value = "SIS.VLSIS")]
            SISVLSIS = 35,

            /// <summary>
            /// Enum SISVPL for value: SIS.VPL
            /// </summary>
            [EnumMember(Value = "SIS.VPL")]
            SISVPL = 36,

            /// <summary>
            /// Enum SISVPMA for value: SIS.VPMA
            /// </summary>
            [EnumMember(Value = "SIS.VPMA")]
            SISVPMA = 37,

            /// <summary>
            /// Enum SISVR for value: SIS.VR
            /// </summary>
            [EnumMember(Value = "SIS.VR")]
            SISVR = 38,

            /// <summary>
            /// Enum SISVSAV for value: SIS.VSAV
            /// </summary>
            [EnumMember(Value = "SIS.VSAV")]
            SISVSAV = 39,

            /// <summary>
            /// Enum SISMOYSSE for value: SIS.MOYSSE
            /// </summary>
            [EnumMember(Value = "SIS.MOYSSE")]
            SISMOYSSE = 40,

            /// <summary>
            /// Enum SISAUTRESIS for value: SIS.AUTRESIS
            /// </summary>
            [EnumMember(Value = "SIS.AUTRESIS")]
            SISAUTRESIS = 41,

            /// <summary>
            /// Enum SMUR for value: SMUR
            /// </summary>
            [EnumMember(Value = "SMUR")]
            SMUR = 42,

            /// <summary>
            /// Enum SMURVLM for value: SMUR.VLM
            /// </summary>
            [EnumMember(Value = "SMUR.VLM")]
            SMURVLM = 43,

            /// <summary>
            /// Enum SMURVL for value: SMUR.VL
            /// </summary>
            [EnumMember(Value = "SMUR.VL")]
            SMURVL = 44,

            /// <summary>
            /// Enum SMURPSM1 for value: SMUR.PSM1
            /// </summary>
            [EnumMember(Value = "SMUR.PSM1")]
            SMURPSM1 = 45,

            /// <summary>
            /// Enum SMURPSM2 for value: SMUR.PSM2
            /// </summary>
            [EnumMember(Value = "SMUR.PSM2")]
            SMURPSM2 = 46,

            /// <summary>
            /// Enum SMURPSM3 for value: SMUR.PSM3
            /// </summary>
            [EnumMember(Value = "SMUR.PSM3")]
            SMURPSM3 = 47,

            /// <summary>
            /// Enum SMURPSMP for value: SMUR.PSMP
            /// </summary>
            [EnumMember(Value = "SMUR.PSMP")]
            SMURPSMP = 48,

            /// <summary>
            /// Enum SMURVPC for value: SMUR.VPC
            /// </summary>
            [EnumMember(Value = "SMUR.VPC")]
            SMURVPC = 49,

            /// <summary>
            /// Enum SMURAR for value: SMUR.AR
            /// </summary>
            [EnumMember(Value = "SMUR.AR")]
            SMURAR = 50,

            /// <summary>
            /// Enum SMURARBAR for value: SMUR.AR-BAR
            /// </summary>
            [EnumMember(Value = "SMUR.AR-BAR")]
            SMURARBAR = 51,

            /// <summary>
            /// Enum SMURARPED for value: SMUR.AR-PED
            /// </summary>
            [EnumMember(Value = "SMUR.AR-PED")]
            SMURARPED = 52,

            /// <summary>
            /// Enum SMURHELISMUR for value: SMUR.HELISMUR
            /// </summary>
            [EnumMember(Value = "SMUR.HELISMUR")]
            SMURHELISMUR = 53,

            /// <summary>
            /// Enum SMURHELISAN for value: SMUR.HELISAN
            /// </summary>
            [EnumMember(Value = "SMUR.HELISAN")]
            SMURHELISAN = 54,

            /// <summary>
            /// Enum SMURAVSMUR for value: SMUR.AVSMUR
            /// </summary>
            [EnumMember(Value = "SMUR.AVSMUR")]
            SMURAVSMUR = 55,

            /// <summary>
            /// Enum SMURAVSAN for value: SMUR.AVSAN
            /// </summary>
            [EnumMember(Value = "SMUR.AVSAN")]
            SMURAVSAN = 56,

            /// <summary>
            /// Enum SMURNAVISMUR for value: SMUR.NAVISMUR
            /// </summary>
            [EnumMember(Value = "SMUR.NAVISMUR")]
            SMURNAVISMUR = 57,

            /// <summary>
            /// Enum TSU for value: TSU
            /// </summary>
            [EnumMember(Value = "TSU")]
            TSU = 58,

            /// <summary>
            /// Enum TSUVSL for value: TSU.VSL
            /// </summary>
            [EnumMember(Value = "TSU.VSL")]
            TSUVSL = 59,

            /// <summary>
            /// Enum TSUAMBGV for value: TSU.AMB-GV
            /// </summary>
            [EnumMember(Value = "TSU.AMB-GV")]
            TSUAMBGV = 60,

            /// <summary>
            /// Enum TSUAMBPV for value: TSU.AMB-PV
            /// </summary>
            [EnumMember(Value = "TSU.AMB-PV")]
            TSUAMBPV = 61,

            /// <summary>
            /// Enum TSUAMBBAR for value: TSU.AMB-BAR
            /// </summary>
            [EnumMember(Value = "TSU.AMB-BAR")]
            TSUAMBBAR = 62,

            /// <summary>
            /// Enum TSUAMB for value: TSU.AMB
            /// </summary>
            [EnumMember(Value = "TSU.AMB")]
            TSUAMB = 63
        }


        /// <summary>
        /// A valoriser avec le type de vecteur mobilisé : cf. nomenclature associée
        /// </summary>
        /// <value>A valoriser avec le type de vecteur mobilisé : cf. nomenclature associée</value>
        /*
        <example>example.json#/resource/0/vehicleType</example>
        */
        [DataMember(Name = "vehicleType", IsRequired = true, EmitDefaultValue = true)]
        public VehicleTypeEnum VehicleType { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="Resource" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Resource() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Resource" /> class.
        /// </summary>
        /// <param name="datetime">A valoriser avec la date et heure d&#39;engagement de la ressource/du vecteur (required).</param>
        /// <param name="resourceId">A valoriser avec l&#39;identifiant partagé unique de la ressource engagée, normé comme suit : {orgID}.resource.{ID unique de la ressource partagée} OU - uniquement dans le cas où un ID unique de ressource ne peut pas être garanti par l&#39;organisation propriétaire : {orgID}.resource.{sendercaseId}.{n° d’ordre chronologique de la ressource} (required).</param>
        /// <param name="requestId">A valoriser avec l&#39;identifiant unique partagé de la demande de ressource (si la ressource a été engagée suite à une demande de ressource), normé comme suit : {orgID}.request.{ID unique de la demande dans le système émetteur} OU - si un ID unique de la demande n&#39;était pas disponible :  {OrgId émetteur}.request.{senderCaseId}.{numéro d’ordre chronologique}.</param>
        /// <param name="missionId">A valoriser avec le numéro de mission unique du central d’appel (PSAP, …) qui a déclenché le vecteur.</param>
        /// <param name="orgId">A valoriser avec l&#39;identifiant de l&#39;organisation à laquelle appartient la ressource, normé comme suit :  {pays}.{domaine}.{organisation}.</param>
        /// <param name="patientId">Identifiant partagé du patient qui est transporté. Ce n&#39;est à remplir que lorsque l&#39;on sait quel vecteur transporte quel patient.  Il est valorisé comme suit lors de sa création :  {OrgId émetteur}.patient.{n°patient unique dans le système émetteur}  OU, si un n°patient unique n&#39;existe pas dans le système émetteur : {ID émetteur}.{senderCaseId}.patient.{numéro d’ordre chronologique au dossier}.</param>
        /// <param name="centerName">A valoriser avec le lieu de garage principal.</param>
        /// <param name="vehicleType">A valoriser avec le type de vecteur mobilisé : cf. nomenclature associée (required).</param>
        /// <param name="name">A valoriser avec le nom donné à la ressource par l’organisation d’appartenance.</param>
        /// <param name="centerCity">A valoriser avec le code INSEE de la commune du centre d&#39;affectation.</param>
        /// <param name="team">team.</param>
        /// <param name="state">state.</param>
        /// <param name="contact">contact.</param>
        /// <param name="freetext">freetext.</param>
        public Resource(DateTime datetime = default(DateTime), string resourceId = default(string), string requestId = default(string), string missionId = default(string), string orgId = default(string), string patientId = default(string), string centerName = default(string), VehicleTypeEnum vehicleType = default(VehicleTypeEnum), string name = default(string), string centerCity = default(string), Team team = default(Team), List<State> state = default(List<State>), Contact contact = default(Contact), List<string> freetext = default(List<string>))
        {
            this.Datetime = datetime;
            // to ensure "resourceId" is required (not null)
            if (resourceId == null)
            {
                throw new ArgumentNullException("resourceId is a required property for Resource and cannot be null");
            }
            this.ResourceId = resourceId;
            this.VehicleType = vehicleType;
            this.RequestId = requestId;
            this.MissionId = missionId;
            this.OrgId = orgId;
            this.PatientId = patientId;
            this.CenterName = centerName;
            this.Name = name;
            this.CenterCity = centerCity;
            this.Team = team;
            this.State = state;
            this.Contact = contact;
            this.Freetext = freetext;
        }

        /// <summary>
        /// A valoriser avec la date et heure d&#39;engagement de la ressource/du vecteur
        /// </summary>
        /// <value>A valoriser avec la date et heure d&#39;engagement de la ressource/du vecteur</value>
        [DataMember(Name = "datetime", IsRequired = true, EmitDefaultValue = true)]
        public DateTime Datetime { get; set; }

        /// <summary>
        /// A valoriser avec l&#39;identifiant partagé unique de la ressource engagée, normé comme suit : {orgID}.resource.{ID unique de la ressource partagée} OU - uniquement dans le cas où un ID unique de ressource ne peut pas être garanti par l&#39;organisation propriétaire : {orgID}.resource.{sendercaseId}.{n° d’ordre chronologique de la ressource}
        /// </summary>
        /// <value>A valoriser avec l&#39;identifiant partagé unique de la ressource engagée, normé comme suit : {orgID}.resource.{ID unique de la ressource partagée} OU - uniquement dans le cas où un ID unique de ressource ne peut pas être garanti par l&#39;organisation propriétaire : {orgID}.resource.{sendercaseId}.{n° d’ordre chronologique de la ressource}</value>
        /*
        <example>example.json#/resource/0/resourceId</example>
        */
        [DataMember(Name = "resourceId", IsRequired = true, EmitDefaultValue = true)]
        public string ResourceId { get; set; }

        /// <summary>
        /// A valoriser avec l&#39;identifiant unique partagé de la demande de ressource (si la ressource a été engagée suite à une demande de ressource), normé comme suit : {orgID}.request.{ID unique de la demande dans le système émetteur} OU - si un ID unique de la demande n&#39;était pas disponible :  {OrgId émetteur}.request.{senderCaseId}.{numéro d’ordre chronologique}
        /// </summary>
        /// <value>A valoriser avec l&#39;identifiant unique partagé de la demande de ressource (si la ressource a été engagée suite à une demande de ressource), normé comme suit : {orgID}.request.{ID unique de la demande dans le système émetteur} OU - si un ID unique de la demande n&#39;était pas disponible :  {OrgId émetteur}.request.{senderCaseId}.{numéro d’ordre chronologique}</value>
        /*
        <example>example.json#/resource/0/requestId</example>
        */
        [DataMember(Name = "requestId", EmitDefaultValue = false)]
        public string RequestId { get; set; }

        /// <summary>
        /// A valoriser avec le numéro de mission unique du central d’appel (PSAP, …) qui a déclenché le vecteur
        /// </summary>
        /// <value>A valoriser avec le numéro de mission unique du central d’appel (PSAP, …) qui a déclenché le vecteur</value>
        /*
        <example>example.json#/resource/0/missionId</example>
        */
        [DataMember(Name = "missionId", EmitDefaultValue = false)]
        public string MissionId { get; set; }

        /// <summary>
        /// A valoriser avec l&#39;identifiant de l&#39;organisation à laquelle appartient la ressource, normé comme suit :  {pays}.{domaine}.{organisation}
        /// </summary>
        /// <value>A valoriser avec l&#39;identifiant de l&#39;organisation à laquelle appartient la ressource, normé comme suit :  {pays}.{domaine}.{organisation}</value>
        /*
        <example>example.json#/resource/0/orgId</example>
        */
        [DataMember(Name = "orgId", EmitDefaultValue = false)]
        public string OrgId { get; set; }

        /// <summary>
        /// Identifiant partagé du patient qui est transporté. Ce n&#39;est à remplir que lorsque l&#39;on sait quel vecteur transporte quel patient.  Il est valorisé comme suit lors de sa création :  {OrgId émetteur}.patient.{n°patient unique dans le système émetteur}  OU, si un n°patient unique n&#39;existe pas dans le système émetteur : {ID émetteur}.{senderCaseId}.patient.{numéro d’ordre chronologique au dossier}
        /// </summary>
        /// <value>Identifiant partagé du patient qui est transporté. Ce n&#39;est à remplir que lorsque l&#39;on sait quel vecteur transporte quel patient.  Il est valorisé comme suit lors de sa création :  {OrgId émetteur}.patient.{n°patient unique dans le système émetteur}  OU, si un n°patient unique n&#39;existe pas dans le système émetteur : {ID émetteur}.{senderCaseId}.patient.{numéro d’ordre chronologique au dossier}</value>
        /*
        <example>example.json#/resource/0/patientId</example>
        */
        [DataMember(Name = "patientId", EmitDefaultValue = false)]
        public string PatientId { get; set; }

        /// <summary>
        /// A valoriser avec le lieu de garage principal
        /// </summary>
        /// <value>A valoriser avec le lieu de garage principal</value>
        /*
        <example>example.json#/resource/0/centerName</example>
        */
        [DataMember(Name = "centerName", EmitDefaultValue = false)]
        public string CenterName { get; set; }

        /// <summary>
        /// A valoriser avec le nom donné à la ressource par l’organisation d’appartenance
        /// </summary>
        /// <value>A valoriser avec le nom donné à la ressource par l’organisation d’appartenance</value>
        /*
        <example>example.json#/resource/0/name</example>
        */
        [DataMember(Name = "name", EmitDefaultValue = false)]
        public string Name { get; set; }

        /// <summary>
        /// A valoriser avec le code INSEE de la commune du centre d&#39;affectation
        /// </summary>
        /// <value>A valoriser avec le code INSEE de la commune du centre d&#39;affectation</value>
        /*
        <example>example.json#/resource/0/centerCity</example>
        */
        [DataMember(Name = "centerCity", EmitDefaultValue = false)]
        public string CenterCity { get; set; }

        /// <summary>
        /// Gets or Sets Team
        /// </summary>
        [DataMember(Name = "team", EmitDefaultValue = false)]
        public Team Team { get; set; }

        /// <summary>
        /// Gets or Sets State
        /// </summary>
        [DataMember(Name = "state", EmitDefaultValue = false)]
        public List<State> State { get; set; }

        /// <summary>
        /// Gets or Sets Contact
        /// </summary>
        [DataMember(Name = "contact", EmitDefaultValue = false)]
        public Contact Contact { get; set; }

        /// <summary>
        /// Gets or Sets Freetext
        /// </summary>
        [DataMember(Name = "freetext", EmitDefaultValue = false)]
        public List<string> Freetext { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class Resource {\n");
            sb.Append("  Datetime: ").Append(Datetime).Append("\n");
            sb.Append("  ResourceId: ").Append(ResourceId).Append("\n");
            sb.Append("  RequestId: ").Append(RequestId).Append("\n");
            sb.Append("  MissionId: ").Append(MissionId).Append("\n");
            sb.Append("  OrgId: ").Append(OrgId).Append("\n");
            sb.Append("  PatientId: ").Append(PatientId).Append("\n");
            sb.Append("  CenterName: ").Append(CenterName).Append("\n");
            sb.Append("  VehicleType: ").Append(VehicleType).Append("\n");
            sb.Append("  Name: ").Append(Name).Append("\n");
            sb.Append("  CenterCity: ").Append(CenterCity).Append("\n");
            sb.Append("  Team: ").Append(Team).Append("\n");
            sb.Append("  State: ").Append(State).Append("\n");
            sb.Append("  Contact: ").Append(Contact).Append("\n");
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
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            if (this.Datetime != null) {
                // Datetime (DateTime) pattern
                Regex regexDatetime = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexDatetime.Match(this.Datetime).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for Datetime, must match a pattern of " + regexDatetime, new [] { "Datetime" });
                }
            }

            if (this.ResourceId != null) {
                // ResourceId (string) pattern
                Regex regexResourceId = new Regex(@"^([\w-]+\.){3,4}resource(\.[\w-]+){1,2}$", RegexOptions.CultureInvariant);
                if (!regexResourceId.Match(this.ResourceId).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for ResourceId, must match a pattern of " + regexResourceId, new [] { "ResourceId" });
                }
            }

            if (this.RequestId != null) {
                // RequestId (string) pattern
                Regex regexRequestId = new Regex(@"^([\w-]+\.){3,4}request(\.[\w-]+){1,2}$", RegexOptions.CultureInvariant);
                if (!regexRequestId.Match(this.RequestId).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for RequestId, must match a pattern of " + regexRequestId, new [] { "RequestId" });
                }
            }

            if (this.CenterCity != null) {
                // CenterCity (string) pattern
                Regex regexCenterCity = new Regex(@"^[0-9]{5}$", RegexOptions.CultureInvariant);
                if (!regexCenterCity.Match(this.CenterCity).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for CenterCity, must match a pattern of " + regexCenterCity, new [] { "CenterCity" });
                }
            }

            yield break;
        }
    }

}
