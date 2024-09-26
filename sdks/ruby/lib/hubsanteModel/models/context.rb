=begin


Generated by: https://openapi-generator.tech
OpenAPI Generator version: 7.1.0

=end

require 'date'
require 'time'

module Emsi
  class Context
    # A constituer par le rédacteur du présent EMSI pour être unique, il est préconisé de reprendre la valeur du champ messageId de l'entête RC-DE.
    attr_accessor :id

    # Valeur constante dans le cadre des échanges LRM-NexSIS : ACTUAL
    attr_accessor :mode

    # - A valoriser avec la valeur \"ALERT\" lors du premier échange entre systèmes. - A valoriser avec la valeur constante \"UPDATE\" ensuite. Peut ne pas être interprété par les LRM.
    attr_accessor :msgtype

    # Obligatoire dans le cadre d'une demande de concours, contient la date de création de la demande de concours dans le système du partenaire requérant. A valoriser avec le même horaire que dateTimeSent dans le message RC-DE associé. Dans le cadre d'une demande de concours, obligatoire. Ce champ est valorisée avec l'heure de création de la demande de concours chez le partenaire emetteur. L'heure d'envoi du message peut être obtenue via l'enveloppe EDXL-DE (se référer au DST)
    attr_accessor :creation

    attr_accessor :link

    # A valoriser avec la valeur constante \"OPR\" dans le cadre d'un message EMSI, incluant une mission OPG
    attr_accessor :level

    # Optionnel  Dans NexSIS ;  Les messages transmis par NexSIS auront un champ valorisé avec systématiquement le même code: \"RESTRC\"=restricted Les LRM doivent également renseigner la valeur \"RESTRC\"
    attr_accessor :seclass

    # Texte libre, optionnel  Dans NexSIS; Fonction de l'événement générateur RG 1 : la valeur de <context><freetext> reste à  'Création d'un événement opérationnel EMSI' & version & 'suite à réception d'une affaire*' dans le cadre de la création d'une opération commune (conforme RG 2 de NEXSIS-6618) RG 3 : les événements générateurs sont ceux définis au sein de NEXSIS-6619 RG 1 de traçabilité  ( input = <Evenement à l'origine> = CREATION_OPERATION / MAJ_MODIFICATION_ETAT_OPERATION / AJOUT_RESSOURCE / RETRAIT_RESSOURCE / MAJ_ETAT_SITUATION_RESSOURCE / MAJ_LOCALISATION_ADRESSE) auxquels seront ajoutés  les éventuels événements à venir.
    attr_accessor :freetext

    attr_accessor :origin

    attr_accessor :external_info

    # Niveau d'urgence pour l'affaire en cours Dans le cadre des échanges LRM-NexSIS, optionnel
    attr_accessor :urgency

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
        :'id' => :'ID',
        :'mode' => :'MODE',
        :'msgtype' => :'MSGTYPE',
        :'creation' => :'CREATION',
        :'link' => :'LINK',
        :'level' => :'LEVEL',
        :'seclass' => :'SECLASS',
        :'freetext' => :'FREETEXT',
        :'origin' => :'ORIGIN',
        :'external_info' => :'EXTERNAL_INFO',
        :'urgency' => :'URGENCY'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'id' => :'String',
        :'mode' => :'String',
        :'msgtype' => :'String',
        :'creation' => :'Time',
        :'link' => :'Array<Link>',
        :'level' => :'String',
        :'seclass' => :'String',
        :'freetext' => :'String',
        :'origin' => :'Origin',
        :'external_info' => :'Array<ExternalInfo>',
        :'urgency' => :'String'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Emsi::Context` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Emsi::Context`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'id')
        self.id = attributes[:'id']
      else
        self.id = nil
      end

      if attributes.key?(:'mode')
        self.mode = attributes[:'mode']
      else
        self.mode = nil
      end

      if attributes.key?(:'msgtype')
        self.msgtype = attributes[:'msgtype']
      else
        self.msgtype = nil
      end

      if attributes.key?(:'creation')
        self.creation = attributes[:'creation']
      end

      if attributes.key?(:'link')
        if (value = attributes[:'link']).is_a?(Array)
          self.link = value
        end
      end

      if attributes.key?(:'level')
        self.level = attributes[:'level']
      end

      if attributes.key?(:'seclass')
        self.seclass = attributes[:'seclass']
      end

      if attributes.key?(:'freetext')
        self.freetext = attributes[:'freetext']
      end

      if attributes.key?(:'origin')
        self.origin = attributes[:'origin']
      end

      if attributes.key?(:'external_info')
        if (value = attributes[:'external_info']).is_a?(Array)
          self.external_info = value
        end
      end

      if attributes.key?(:'urgency')
        self.urgency = attributes[:'urgency']
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @id.nil?
        invalid_properties.push('invalid value for "id", id cannot be nil.')
      end

      if @mode.nil?
        invalid_properties.push('invalid value for "mode", mode cannot be nil.')
      end

      if @msgtype.nil?
        invalid_properties.push('invalid value for "msgtype", msgtype cannot be nil.')
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if !@creation.nil? && @creation !~ pattern
        invalid_properties.push("invalid value for \"creation\", must conform to the pattern #{pattern}.")
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @id.nil?
      return false if @mode.nil?
      mode_validator = EnumAttributeValidator.new('String', ["ACTUAL", "EXERCS", "SYSTEM", "TEST"])
      return false unless mode_validator.valid?(@mode)
      return false if @msgtype.nil?
      msgtype_validator = EnumAttributeValidator.new('String', ["ACK", "ALERT", "CANCEL", "ERROR", "UPDATE"])
      return false unless msgtype_validator.valid?(@msgtype)
      return false if !@creation.nil? && @creation !~ Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      level_validator = EnumAttributeValidator.new('String', ["STRTGC", "OPR", "TACTCL"])
      return false unless level_validator.valid?(@level)
      seclass_validator = EnumAttributeValidator.new('String', ["CONFID", "RESTRC", "SECRET", "TOPSRT", "UNCLAS", "UNMARK"])
      return false unless seclass_validator.valid?(@seclass)
      urgency_validator = EnumAttributeValidator.new('String', ["URGENT", "NOT_URGENT"])
      return false unless urgency_validator.valid?(@urgency)
      true
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] mode Object to be assigned
    def mode=(mode)
      validator = EnumAttributeValidator.new('String', ["ACTUAL", "EXERCS", "SYSTEM", "TEST"])
      unless validator.valid?(mode)
        fail ArgumentError, "invalid value for \"mode\", must be one of #{validator.allowable_values}."
      end
      @mode = mode
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] msgtype Object to be assigned
    def msgtype=(msgtype)
      validator = EnumAttributeValidator.new('String', ["ACK", "ALERT", "CANCEL", "ERROR", "UPDATE"])
      unless validator.valid?(msgtype)
        fail ArgumentError, "invalid value for \"msgtype\", must be one of #{validator.allowable_values}."
      end
      @msgtype = msgtype
    end

    # Custom attribute writer method with validation
    # @param [Object] creation Value to be assigned
    def creation=(creation)
      if creation.nil?
        fail ArgumentError, 'creation cannot be nil'
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if creation !~ pattern
        fail ArgumentError, "invalid value for \"creation\", must conform to the pattern #{pattern}."
      end

      @creation = creation
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] level Object to be assigned
    def level=(level)
      validator = EnumAttributeValidator.new('String', ["STRTGC", "OPR", "TACTCL"])
      unless validator.valid?(level)
        fail ArgumentError, "invalid value for \"level\", must be one of #{validator.allowable_values}."
      end
      @level = level
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] seclass Object to be assigned
    def seclass=(seclass)
      validator = EnumAttributeValidator.new('String', ["CONFID", "RESTRC", "SECRET", "TOPSRT", "UNCLAS", "UNMARK"])
      unless validator.valid?(seclass)
        fail ArgumentError, "invalid value for \"seclass\", must be one of #{validator.allowable_values}."
      end
      @seclass = seclass
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] urgency Object to be assigned
    def urgency=(urgency)
      validator = EnumAttributeValidator.new('String', ["URGENT", "NOT_URGENT"])
      unless validator.valid?(urgency)
        fail ArgumentError, "invalid value for \"urgency\", must be one of #{validator.allowable_values}."
      end
      @urgency = urgency
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          id == o.id &&
          mode == o.mode &&
          msgtype == o.msgtype &&
          creation == o.creation &&
          link == o.link &&
          level == o.level &&
          seclass == o.seclass &&
          freetext == o.freetext &&
          origin == o.origin &&
          external_info == o.external_info &&
          urgency == o.urgency
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [id, mode, msgtype, creation, link, level, seclass, freetext, origin, external_info, urgency].hash
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