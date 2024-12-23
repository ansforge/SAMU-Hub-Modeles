=begin
#OpenAPI

#OpenAPI

The version of the OpenAPI document: 0.0.1

Generated by: https://openapi-generator.tech
Generator version: 7.10.0

=end

require 'date'
require 'time'

module Cisu
  class Alert
    # Identifiant technique unique de l'alerte. Il doit pouvoir être généré automatiquement par le système émetteur et ne doit pas avoir de signification / utilisation particulière par les différents systèmes pour garantir leur découplage. Voir la description de l'identifiant de l'affaire pour voir le format. Lorsqu’une alerte est générée dans NexSIS et crée une affaire, elle est qualifiée d’Alerte Initiale. a) Si cette dernière concerne un partenaire (caractère médical pour la Santé par exemple), elle est relayée seule dans le message. Il y’a un seul objet initialAlert. b) Sinon, une autre alerte liée à la même affaire peut être déclarée ultérieurement, concernant cette fois le partenaire. Lorsqu’elle est déclarée cette Nouvelle Alerte est relayée avec l’Alerte Initiale pour partager un contexte commun. Dans le message de création d’affaire il y’a deux objets alerte : initialAlert et newAlert. Le rattachement des messages à une affaire doivent s'appuyer sur les caseId et non les alertId qui peuvent varier d'un système à l'autre.
    attr_accessor :id

    # A valoriser avec le groupe date heure de réception de l'alerte/appel
    attr_accessor :reception

    # Permet d'attirer l'attention des forces partenaires sur une affaire pour le faire sortir du lot. Eventuellement automatisé en fonction des critères saisis et de leur paramétrage, ou renseigné par l'opérateur.  Prend les valeurs définies dans la nomenclature CISU : - standard : STANDARD - signalé : ATTENTION Les systèmes peuvent proposer des fonctionnalités faisant ressortir les dossiers avec le libellé ATTENTION
    attr_accessor :reporting

    attr_accessor :notes

    attr_accessor :caller

    attr_accessor :location

    attr_accessor :qualification

    attr_accessor :call_taker

    attr_accessor :attachment

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
        :'id' => :'id',
        :'reception' => :'reception',
        :'reporting' => :'reporting',
        :'notes' => :'notes',
        :'caller' => :'caller',
        :'location' => :'location',
        :'qualification' => :'qualification',
        :'call_taker' => :'callTaker',
        :'attachment' => :'attachment'
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
        :'reception' => :'Time',
        :'reporting' => :'String',
        :'notes' => :'Array<Notes>',
        :'caller' => :'Caller',
        :'location' => :'Location',
        :'qualification' => :'Qualification',
        :'call_taker' => :'CallTaker',
        :'attachment' => :'Array<Attachment>'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Cisu::Alert` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Cisu::Alert`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'id')
        self.id = attributes[:'id']
      else
        self.id = nil
      end

      if attributes.key?(:'reception')
        self.reception = attributes[:'reception']
      else
        self.reception = nil
      end

      if attributes.key?(:'reporting')
        self.reporting = attributes[:'reporting']
      else
        self.reporting = nil
      end

      if attributes.key?(:'notes')
        if (value = attributes[:'notes']).is_a?(Array)
          self.notes = value
        end
      end

      if attributes.key?(:'caller')
        self.caller = attributes[:'caller']
      else
        self.caller = nil
      end

      if attributes.key?(:'location')
        self.location = attributes[:'location']
      else
        self.location = nil
      end

      if attributes.key?(:'qualification')
        self.qualification = attributes[:'qualification']
      else
        self.qualification = nil
      end

      if attributes.key?(:'call_taker')
        self.call_taker = attributes[:'call_taker']
      else
        self.call_taker = nil
      end

      if attributes.key?(:'attachment')
        if (value = attributes[:'attachment']).is_a?(Array)
          self.attachment = value
        end
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

      if @reception.nil?
        invalid_properties.push('invalid value for "reception", reception cannot be nil.')
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if @reception !~ pattern
        invalid_properties.push("invalid value for \"reception\", must conform to the pattern #{pattern}.")
      end

      if @reporting.nil?
        invalid_properties.push('invalid value for "reporting", reporting cannot be nil.')
      end

      if @caller.nil?
        invalid_properties.push('invalid value for "caller", caller cannot be nil.')
      end

      if @location.nil?
        invalid_properties.push('invalid value for "location", location cannot be nil.')
      end

      if @qualification.nil?
        invalid_properties.push('invalid value for "qualification", qualification cannot be nil.')
      end

      if @call_taker.nil?
        invalid_properties.push('invalid value for "call_taker", call_taker cannot be nil.')
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @id.nil?
      return false if @reception.nil?
      return false if @reception !~ Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      return false if @reporting.nil?
      reporting_validator = EnumAttributeValidator.new('String', ["STANDARD", "ATTENTION"])
      return false unless reporting_validator.valid?(@reporting)
      return false if @caller.nil?
      return false if @location.nil?
      return false if @qualification.nil?
      return false if @call_taker.nil?
      true
    end

    # Custom attribute writer method with validation
    # @param [Object] reception Value to be assigned
    def reception=(reception)
      if reception.nil?
        fail ArgumentError, 'reception cannot be nil'
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if reception !~ pattern
        fail ArgumentError, "invalid value for \"reception\", must conform to the pattern #{pattern}."
      end

      @reception = reception
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] reporting Object to be assigned
    def reporting=(reporting)
      validator = EnumAttributeValidator.new('String', ["STANDARD", "ATTENTION"])
      unless validator.valid?(reporting)
        fail ArgumentError, "invalid value for \"reporting\", must be one of #{validator.allowable_values}."
      end
      @reporting = reporting
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          id == o.id &&
          reception == o.reception &&
          reporting == o.reporting &&
          notes == o.notes &&
          caller == o.caller &&
          location == o.location &&
          qualification == o.qualification &&
          call_taker == o.call_taker &&
          attachment == o.attachment
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [id, reception, reporting, notes, caller, location, qualification, call_taker, attachment].hash
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
        klass = Cisu.const_get(type)
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
