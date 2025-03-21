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
using OpenAPIDateConverter = HubsanteModel/Rcde.Client.OpenAPIDateConverter;

namespace HubsanteModel/Rcde.Model
{
    /// <summary>
    /// DistributionElement
    /// </summary>
    [DataContract(Name = "distributionElement")]
    public partial class DistributionElement : IValidatableObject
    {
        /// <summary>
        /// Prend la valeur &lt;distributionKind de l&#39;enveloppe EDXL (voir DST)
        /// </summary>
        /// <value>Prend la valeur &lt;distributionKind de l&#39;enveloppe EDXL (voir DST)</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum KindEnum
        {
            /// <summary>
            /// Enum Report for value: Report
            /// </summary>
            [EnumMember(Value = "Report")]
            Report = 1,

            /// <summary>
            /// Enum Update for value: Update
            /// </summary>
            [EnumMember(Value = "Update")]
            Update = 2,

            /// <summary>
            /// Enum Cancel for value: Cancel
            /// </summary>
            [EnumMember(Value = "Cancel")]
            Cancel = 3,

            /// <summary>
            /// Enum Ack for value: Ack
            /// </summary>
            [EnumMember(Value = "Ack")]
            Ack = 4,

            /// <summary>
            /// Enum Error for value: Error
            /// </summary>
            [EnumMember(Value = "Error")]
            Error = 5
        }


        /// <summary>
        /// Prend la valeur &lt;distributionKind de l&#39;enveloppe EDXL (voir DST)
        /// </summary>
        /// <value>Prend la valeur &lt;distributionKind de l&#39;enveloppe EDXL (voir DST)</value>
        /*
        <example>example.json#/kind</example>
        */
        [DataMember(Name = "kind", IsRequired = true, EmitDefaultValue = true)]
        public KindEnum Kind { get; set; }
        /// <summary>
        /// Prend la valeur &lt;distributionStatus&gt; de l&#39;enveloppe EDXL (voir DST)
        /// </summary>
        /// <value>Prend la valeur &lt;distributionStatus&gt; de l&#39;enveloppe EDXL (voir DST)</value>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum StatusEnum
        {
            /// <summary>
            /// Enum Actual for value: Actual
            /// </summary>
            [EnumMember(Value = "Actual")]
            Actual = 1,

            /// <summary>
            /// Enum Exercise for value: Exercise
            /// </summary>
            [EnumMember(Value = "Exercise")]
            Exercise = 2,

            /// <summary>
            /// Enum System for value: System
            /// </summary>
            [EnumMember(Value = "System")]
            System = 3
        }


        /// <summary>
        /// Prend la valeur &lt;distributionStatus&gt; de l&#39;enveloppe EDXL (voir DST)
        /// </summary>
        /// <value>Prend la valeur &lt;distributionStatus&gt; de l&#39;enveloppe EDXL (voir DST)</value>
        /*
        <example>example.json#/status</example>
        */
        [DataMember(Name = "status", IsRequired = true, EmitDefaultValue = true)]
        public StatusEnum Status { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="DistributionElement" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected DistributionElement()
        {
            this.AdditionalProperties = new Dictionary<string, object>();
        }
        /// <summary>
        /// Initializes a new instance of the <see cref="DistributionElement" /> class.
        /// </summary>
        /// <param name="messageId">Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système. (required).</param>
        /// <param name="sender">sender (required).</param>
        /// <param name="sentAt">Groupe date heure de début de partage lié à l&#39;envoi du message. Il doit  être cohérent avec le champ &lt;dateTimeSent&gt; de l&#39;enveloppe EDXL (voir DST).  L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé. Le fuseau horaire pour UTC doit être représenté par &#39;-00:00&#39; (required).</param>
        /// <param name="kind">Prend la valeur &lt;distributionKind de l&#39;enveloppe EDXL (voir DST) (required).</param>
        /// <param name="status">Prend la valeur &lt;distributionStatus&gt; de l&#39;enveloppe EDXL (voir DST) (required).</param>
        /// <param name="recipient">recipient (required).</param>
        public DistributionElement(string messageId = default(string), Sender sender = default(Sender), DateTime sentAt = default(DateTime), KindEnum kind = default(KindEnum), StatusEnum status = default(StatusEnum), List<Recipient> recipient = default(List<Recipient>))
        {
            // to ensure "messageId" is required (not null)
            if (messageId == null)
            {
                throw new ArgumentNullException("messageId is a required property for DistributionElement and cannot be null");
            }
            this.MessageId = messageId;
            // to ensure "sender" is required (not null)
            if (sender == null)
            {
                throw new ArgumentNullException("sender is a required property for DistributionElement and cannot be null");
            }
            this.Sender = sender;
            this.SentAt = sentAt;
            this.Kind = kind;
            this.Status = status;
            // to ensure "recipient" is required (not null)
            if (recipient == null)
            {
                throw new ArgumentNullException("recipient is a required property for DistributionElement and cannot be null");
            }
            this.Recipient = recipient;
            this.AdditionalProperties = new Dictionary<string, object>();
        }

        /// <summary>
        /// Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système.
        /// </summary>
        /// <value>Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par celui qui génère l&#39;identifiant partagé doit donc être un numéro unique dans son système.</value>
        /*
        <example>example.json#/messageId</example>
        */
        [DataMember(Name = "messageId", IsRequired = true, EmitDefaultValue = true)]
        public string MessageId { get; set; }

        /// <summary>
        /// Gets or Sets Sender
        /// </summary>
        [DataMember(Name = "sender", IsRequired = true, EmitDefaultValue = true)]
        public Sender Sender { get; set; }

        /// <summary>
        /// Groupe date heure de début de partage lié à l&#39;envoi du message. Il doit  être cohérent avec le champ &lt;dateTimeSent&gt; de l&#39;enveloppe EDXL (voir DST).  L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé. Le fuseau horaire pour UTC doit être représenté par &#39;-00:00&#39;
        /// </summary>
        /// <value>Groupe date heure de début de partage lié à l&#39;envoi du message. Il doit  être cohérent avec le champ &lt;dateTimeSent&gt; de l&#39;enveloppe EDXL (voir DST).  L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé. Le fuseau horaire pour UTC doit être représenté par &#39;-00:00&#39;</value>
        [DataMember(Name = "sentAt", IsRequired = true, EmitDefaultValue = true)]
        public DateTime SentAt { get; set; }

        /// <summary>
        /// Gets or Sets Recipient
        /// </summary>
        [DataMember(Name = "recipient", IsRequired = true, EmitDefaultValue = true)]
        public List<Recipient> Recipient { get; set; }

        /// <summary>
        /// Gets or Sets additional properties
        /// </summary>
        [JsonExtensionData]
        public IDictionary<string, object> AdditionalProperties { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class DistributionElement {\n");
            sb.Append("  MessageId: ").Append(MessageId).Append("\n");
            sb.Append("  Sender: ").Append(Sender).Append("\n");
            sb.Append("  SentAt: ").Append(SentAt).Append("\n");
            sb.Append("  Kind: ").Append(Kind).Append("\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
            sb.Append("  Recipient: ").Append(Recipient).Append("\n");
            sb.Append("  AdditionalProperties: ").Append(AdditionalProperties).Append("\n");
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
            if (this.SentAt != null) {
                // SentAt (DateTime) pattern
                Regex regexSentAt = new Regex(@"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", RegexOptions.CultureInvariant);
                if (!regexSentAt.Match(this.SentAt).Success)
                {
                    yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for SentAt, must match a pattern of " + regexSentAt, new [] { "SentAt" });
                }
            }

            yield break;
        }
    }

}
