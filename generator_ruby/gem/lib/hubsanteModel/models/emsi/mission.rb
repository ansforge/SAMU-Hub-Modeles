=begin
#OpenAPI

#OpenAPI

The version of the OpenAPI document: 0.0.1

Generated by: https://openapi-generator.tech
Generator version: 7.10.0

=end

require 'date'
require 'time'

module Emsi
  class Mission
    # Le champ MISSION TYPE permet d'identifier l'effet à obtenir souhaité à partir de la combinaison du code ACTOR et du code TYPE. => La table de transcodage permettant d'identifier les concourants et les effets à obtenir à partir d'un code EMSI est fournie en annexe \"Référentiel Effets à Obtenir - correspondance EMSI\". Dans le cadre d'une réponse à DC : - reprendre le type de la DC si le code réponse choisi est vien \"VALIDE\" Dans le cadre d'une mission décrivant les opérations en cours : - reprendre la nomenclature EMSI pour caractériser la mission en cours.
    attr_accessor :type

    # Contient des commentaires relatifs aux objectifs et  moyens sollicités dans le cadre de la demande de concours. Les équipements supplémentaires souhaités ou le nom/ prénom des patients à prendre en charge peuvent être explicitement indiqués ici.
    attr_accessor :freetext

    # Contient un identifiant de demande de concours unique. Cet identifiant sera réutilisable par le partenaire pour répondre à cette demande. Identifiant unique de la mission dans le système du partenaire la conduisant.
    attr_accessor :id

    # Indique l'organisation du partenaire concerné par la Demande de Concours (voir DSF). Le code CRRA ou le code du SIS peut être utilisé. Indique l'organisation du service réalisant la mission.  Dans le cas d'une réponse, c'est l'organisation du concourant qui doit être indiquée. Se référer au DSF pour la structure normée des organisations Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*.
    attr_accessor :org_id

    # Le nom de la mission est construit à partir de l'expression régulière suivante : \"#DEMANDE_CONCOURS#\"{libelle_cadre_conventionnel}\"#\"{code_cadre_conventionnel}\"#\" où le code_cadre_conventionnel est issue d'une nomenclature CISU-Cadre Conventionnel (A Venir) NB : ce champ est détourné par rapport au standard EMSI pour permettre l'expression d'une demande de concours et indiquer le cadre conventionnel dans lequel elle est effectuée. Pour une réponse à demande de concours : - Le nom de la mission est construit à partir de l'expression régulière suivante : \"#REPONSE_DEMANDE_CONCOURS#\"{code_reponse}\"#\" où le code_reponse peut prendre les valeurs ACCEPTE, REFUS, PARTIELLE, DIVERGENTE - sinon libre
    attr_accessor :name

    # Les valeurs possibles avec lesquelles valoriser ce champ sont détaillées au sein d'une nomenclature EMSI - ABO : mission refusée (ABOrted) - CANCLD : mission annulée (CANCeLeD)** - NST : mission non débuté pour le métier (Not STarted) - IPR :  mission débuté pour le métier (In PRogress). la valeur IPR peut être suivi d'une valeur numérique de 00 à 100 (IPRnn) spécifiant le degré d'avancement de la mission. Ce principe n'est pas retenu au sein de NexSIS qui ne transmettra pas d'indication sur le degré d'avancement de la mission via ce champ. - PAU : événement arrêté, en pause pour métier, pas de besoin supplémentaire - COM : événement terminé pour le métier (COMplete) Le status de la mission et celui des RESSOURCE associées doit être cohérent et transcodable avec un status ANTARES (voir DSF)  Dans le cas d'un objet MISSION générique de réponse à demande de concours, le champ doit être valorisé à \"NST\"
    attr_accessor :status

    # - Dans le cadre d'une réponse à Demande de Concours Horraire cible pour l'arrivée sur les lieux décrites (peut diverger de l'horaire demandé) - Dans le cadre d'une mission décrivant les opérations en cours : Horaire effectif de début de la mission
    attr_accessor :start_time

    # A valoriser selon la catégorie de mission : - Dans le cadre d'une mission de réponse à demande de concours : ne pas renseigner - Dans le cadre d'une mission décrivant les opérations en cours :  Si c'est un déplacement, l'heure d'arrivée, si c'est une prise en charge patient/victime, la fin de la prise en charge.
    attr_accessor :end_time

    attr_accessor :resource_id

    attr_accessor :parent_mission_id

    attr_accessor :child_mission_id

    # - Dans le cas d'une mission générique de réponse à demande de concours, indiquer l'ID de la mission générique utilisée pour modéliser la demande de concours - Dans le cas d'une mission déclenchée dans le cadre d'une réponse à demande de concours, l'ID de la mission générique de réponse peut être utilisée dans ce champ pour indiquer qu'elle est liée à une réponse
    attr_accessor :main_mission_id

    attr_accessor :position

    # Indique une échelle de priorité pour la demande de concours. Dans le cadre du standard EMSI, cette échelle doit être comprise entre 0 et 5. Ce champ peut ne pas être interprété ni alimenté par les LRMs. Dans le cadre d'un échange des opérations, optionnel. Le champ peut ne pas être émis ni interprété.
    attr_accessor :priority

    class EnumAttributeValidator
      attr_reader :datatype
      attr_reader :allowable_values

      def initialize(datatype, allowable_values)
        @allowable_values = allowable_values.map do |value|
          case datatype.to_s
          when /Integer/i
            value.to_i
          when /Float/i
            value.to_f
          else
            value
          end
        end
      end

      def valid?(value)
        !value || allowable_values.include?(value)
      end
    end

    # Attribute mapping from ruby-style variable name to JSON key.
    def self.attribute_map
      {
        :'type' => :'TYPE',
        :'freetext' => :'FREETEXT',
        :'id' => :'ID',
        :'org_id' => :'ORG_ID',
        :'name' => :'NAME',
        :'status' => :'STATUS',
        :'start_time' => :'START_TIME',
        :'end_time' => :'END_TIME',
        :'resource_id' => :'RESOURCE_ID',
        :'parent_mission_id' => :'PARENT_MISSION_ID',
        :'child_mission_id' => :'CHILD_MISSION_ID',
        :'main_mission_id' => :'MAIN_MISSION_ID',
        :'position' => :'POSITION',
        :'priority' => :'PRIORITY'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'type' => :'String',
        :'freetext' => :'String',
        :'id' => :'String',
        :'org_id' => :'String',
        :'name' => :'String',
        :'status' => :'String',
        :'start_time' => :'Time',
        :'end_time' => :'Time',
        :'resource_id' => :'Array<String>',
        :'parent_mission_id' => :'Array<String>',
        :'child_mission_id' => :'Array<String>',
        :'main_mission_id' => :'String',
        :'position' => :'Position',
        :'priority' => :'String'
      }
    end

    # List of attributes with nullable: true
    def self.openapi_nullable
      Set.new([
      ])
    end

    # Initializes the object
    # @param [Hash] attributes Model attributes in the form of hash
    def initialize(attributes = {})
      if (!attributes.is_a?(Hash))
        fail ArgumentError, "The input argument (attributes) must be a hash in `Emsi::Mission` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Emsi::Mission`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'type')
        self.type = attributes[:'type']
      else
        self.type = nil
      end

      if attributes.key?(:'freetext')
        self.freetext = attributes[:'freetext']
      end

      if attributes.key?(:'id')
        self.id = attributes[:'id']
      else
        self.id = nil
      end

      if attributes.key?(:'org_id')
        self.org_id = attributes[:'org_id']
      end

      if attributes.key?(:'name')
        self.name = attributes[:'name']
      else
        self.name = nil
      end

      if attributes.key?(:'status')
        self.status = attributes[:'status']
      else
        self.status = nil
      end

      if attributes.key?(:'start_time')
        self.start_time = attributes[:'start_time']
      end

      if attributes.key?(:'end_time')
        self.end_time = attributes[:'end_time']
      end

      if attributes.key?(:'resource_id')
        if (value = attributes[:'resource_id']).is_a?(Array)
          self.resource_id = value
        end
      end

      if attributes.key?(:'parent_mission_id')
        if (value = attributes[:'parent_mission_id']).is_a?(Array)
          self.parent_mission_id = value
        end
      end

      if attributes.key?(:'child_mission_id')
        if (value = attributes[:'child_mission_id']).is_a?(Array)
          self.child_mission_id = value
        end
      end

      if attributes.key?(:'main_mission_id')
        self.main_mission_id = attributes[:'main_mission_id']
      end

      if attributes.key?(:'position')
        self.position = attributes[:'position']
      end

      if attributes.key?(:'priority')
        self.priority = attributes[:'priority']
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @type.nil?
        invalid_properties.push('invalid value for "type", type cannot be nil.')
      end

      if @id.nil?
        invalid_properties.push('invalid value for "id", id cannot be nil.')
      end

      if @name.nil?
        invalid_properties.push('invalid value for "name", name cannot be nil.')
      end

      if @status.nil?
        invalid_properties.push('invalid value for "status", status cannot be nil.')
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if !@start_time.nil? && @start_time !~ pattern
        invalid_properties.push("invalid value for \"start_time\", must conform to the pattern #{pattern}.")
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if !@end_time.nil? && @end_time !~ pattern
        invalid_properties.push("invalid value for \"end_time\", must conform to the pattern #{pattern}.")
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @type.nil?
      type_validator = EnumAttributeValidator.new('String', ["SAV/ASC", "FR_MED/REGLTN", "GEN/SUPRTN", "SAV/AR/FR_MED", "SAV/AR/FR_PARAMD", "SAV", "GEN/TRNSPN", "SAV/SARCSL", "SAV/ASC/FR_PPL/LIFT", "GEN/RECVRY", "SAV/RHD", "FFST/FR_FIRE", "FSTT/RRHAZ/FR_CO", "CBRN/TSA", "INT/RECCE/FR_SMLL", "FSTT/TA", "SAV/AR/FR_PPL/GRP", "INT/RECCE", "GEN/TRNSPN/FR_SECNDRY", "OPR/LOG", "SAV/AR/FR_PPL/OBS", "FSTT/TA/FR_CLRACCSS"])
      return false unless type_validator.valid?(@type)
      return false if @id.nil?
      return false if @name.nil?
      return false if @status.nil?
      status_validator = EnumAttributeValidator.new('String', ["ABO", "NST", "CANCLD", "COM", "IPR", "PAU"])
      return false unless status_validator.valid?(@status)
      return false if !@start_time.nil? && @start_time !~ Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      return false if !@end_time.nil? && @end_time !~ Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      priority_validator = EnumAttributeValidator.new('String', ["0", "1", "2", "3", "4", "5"])
      return false unless priority_validator.valid?(@priority)
      true
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] type Object to be assigned
    def type=(type)
      validator = EnumAttributeValidator.new('String', ["SAV/ASC", "FR_MED/REGLTN", "GEN/SUPRTN", "SAV/AR/FR_MED", "SAV/AR/FR_PARAMD", "SAV", "GEN/TRNSPN", "SAV/SARCSL", "SAV/ASC/FR_PPL/LIFT", "GEN/RECVRY", "SAV/RHD", "FFST/FR_FIRE", "FSTT/RRHAZ/FR_CO", "CBRN/TSA", "INT/RECCE/FR_SMLL", "FSTT/TA", "SAV/AR/FR_PPL/GRP", "INT/RECCE", "GEN/TRNSPN/FR_SECNDRY", "OPR/LOG", "SAV/AR/FR_PPL/OBS", "FSTT/TA/FR_CLRACCSS"])
      unless validator.valid?(type)
        fail ArgumentError, "invalid value for \"type\", must be one of #{validator.allowable_values}."
      end
      @type = type
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] status Object to be assigned
    def status=(status)
      validator = EnumAttributeValidator.new('String', ["ABO", "NST", "CANCLD", "COM", "IPR", "PAU"])
      unless validator.valid?(status)
        fail ArgumentError, "invalid value for \"status\", must be one of #{validator.allowable_values}."
      end
      @status = status
    end

    # Custom attribute writer method with validation
    # @param [Object] start_time Value to be assigned
    def start_time=(start_time)
      if start_time.nil?
        fail ArgumentError, 'start_time cannot be nil'
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if start_time !~ pattern
        fail ArgumentError, "invalid value for \"start_time\", must conform to the pattern #{pattern}."
      end

      @start_time = start_time
    end

    # Custom attribute writer method with validation
    # @param [Object] end_time Value to be assigned
    def end_time=(end_time)
      if end_time.nil?
        fail ArgumentError, 'end_time cannot be nil'
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if end_time !~ pattern
        fail ArgumentError, "invalid value for \"end_time\", must conform to the pattern #{pattern}."
      end

      @end_time = end_time
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] priority Object to be assigned
    def priority=(priority)
      validator = EnumAttributeValidator.new('String', ["0", "1", "2", "3", "4", "5"])
      unless validator.valid?(priority)
        fail ArgumentError, "invalid value for \"priority\", must be one of #{validator.allowable_values}."
      end
      @priority = priority
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          type == o.type &&
          freetext == o.freetext &&
          id == o.id &&
          org_id == o.org_id &&
          name == o.name &&
          status == o.status &&
          start_time == o.start_time &&
          end_time == o.end_time &&
          resource_id == o.resource_id &&
          parent_mission_id == o.parent_mission_id &&
          child_mission_id == o.child_mission_id &&
          main_mission_id == o.main_mission_id &&
          position == o.position &&
          priority == o.priority
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [type, freetext, id, org_id, name, status, start_time, end_time, resource_id, parent_mission_id, child_mission_id, main_mission_id, position, priority].hash
    end

    # Builds the object from hash
    # @param [Hash] attributes Model attributes in the form of hash
    # @return [Object] Returns the model itself
    def self.build_from_hash(attributes)
      return nil unless attributes.is_a?(Hash)
      attributes = attributes.transform_keys(&:to_sym)
      transformed_hash = {}
      openapi_types.each_pair do |key, type|
        if attributes.key?(attribute_map[key]) && attributes[attribute_map[key]].nil?
          transformed_hash["#{key}"] = nil
        elsif type =~ /\AArray<(.*)>/i
          # check to ensure the input is an array given that the attribute
          # is documented as an array but the input is not
          if attributes[attribute_map[key]].is_a?(Array)
            transformed_hash["#{key}"] = attributes[attribute_map[key]].map { |v| _deserialize($1, v) }
          end
        elsif !attributes[attribute_map[key]].nil?
          transformed_hash["#{key}"] = _deserialize(type, attributes[attribute_map[key]])
        end
      end
      new(transformed_hash)
    end

    # Deserializes the data based on type
    # @param string type Data type
    # @param string value Value to be deserialized
    # @return [Object] Deserialized data
    def self._deserialize(type, value)
      case type.to_sym
      when :Time
        Time.parse(value)
      when :Date
        Date.parse(value)
      when :String
        value.to_s
      when :Integer
        value.to_i
      when :Float
        value.to_f
      when :Boolean
        if value.to_s =~ /\A(true|t|yes|y|1)\z/i
          true
        else
          false
        end
      when :Object
        # generic object (usually a Hash), return directly
        value
      when /\AArray<(?<inner_type>.+)>\z/
        inner_type = Regexp.last_match[:inner_type]
        value.map { |v| _deserialize(inner_type, v) }
      when /\AHash<(?<k_type>.+?), (?<v_type>.+)>\z/
        k_type = Regexp.last_match[:k_type]
        v_type = Regexp.last_match[:v_type]
        {}.tap do |hash|
          value.each do |k, v|
            hash[_deserialize(k_type, k)] = _deserialize(v_type, v)
          end
        end
      else # model
        # models (e.g. Pet) or oneOf
        klass = Emsi.const_get(type)
        klass.respond_to?(:openapi_any_of) || klass.respond_to?(:openapi_one_of) ? klass.build(value) : klass.build_from_hash(value)
      end
    end

    # Returns the string representation of the object
    # @return [String] String presentation of the object
    def to_s
      to_hash.to_s
    end

    # to_body is an alias to to_hash (backward compatibility)
    # @return [Hash] Returns the object in the form of hash
    def to_body
      to_hash
    end

    # Returns the object in the form of hash
    # @return [Hash] Returns the object in the form of hash
    def to_hash
      hash = {}
      self.class.attribute_map.each_pair do |attr, param|
        value = self.send(attr)
        if value.nil?
          is_nullable = self.class.openapi_nullable.include?(attr)
          next if !is_nullable || (is_nullable && !instance_variable_defined?(:"@#{attr}"))
        end

        hash[param] = _to_hash(value)
      end
      hash
    end

    # Outputs non-array value in the form of hash
    # For object, use to_hash. Otherwise, just return the value
    # @param [Object] value Any valid value
    # @return [Hash] Returns the value in the form of hash
    def _to_hash(value)
      if value.is_a?(Array)
        value.compact.map { |v| _to_hash(v) }
      elsif value.is_a?(Hash)
        {}.tap do |hash|
          value.each { |k, v| hash[k] = _to_hash(v) }
        end
      elsif value.respond_to? :to_hash
        value.to_hash
      else
        value
      end
    end

  end

end
