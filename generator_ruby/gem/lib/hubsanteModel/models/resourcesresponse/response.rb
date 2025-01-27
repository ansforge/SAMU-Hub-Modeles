=begin
#OpenAPI

#OpenAPI

The version of the OpenAPI document: 0.0.1

Generated by: https://openapi-generator.tech
Generator version: 7.11.0

=end

require 'date'
require 'time'

module Resourcesresponse
  class Response
    # Groupe date heure de début de la demande
    attr_accessor :datetime

    # A valoriser avec la réponse apportée. Cf Nomenclature associée ACCEPTEE, REFUSEE, PARTIELLE, DIFFEREE
    attr_accessor :answer

    # A valoriser avec le délai de réponse auquel s'engage l'expéditeur (cf. nomenclature)  Cas particulier : en cas de réponse \"Partielle\" car le délai souhaité ne peut pas être respecté,  à valoriser obligatoirement avec le délai de réponse maximum auquel s'engage l'expéditeur de la réponse, 
    attr_accessor :deadline

    # Commentaire libre permettant d'apporter toutes précisions utiles à la réponse. Le motif de refus est notifié dans ce champ.
    attr_accessor :freetext

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
        :'datetime' => :'datetime',
        :'answer' => :'answer',
        :'deadline' => :'deadline',
        :'freetext' => :'freetext'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'datetime' => :'Time',
        :'answer' => :'String',
        :'deadline' => :'String',
        :'freetext' => :'String'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Resourcesresponse::Response` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Resourcesresponse::Response`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'datetime')
        self.datetime = attributes[:'datetime']
      else
        self.datetime = nil
      end

      if attributes.key?(:'answer')
        self.answer = attributes[:'answer']
      else
        self.answer = nil
      end

      if attributes.key?(:'deadline')
        self.deadline = attributes[:'deadline']
      end

      if attributes.key?(:'freetext')
        self.freetext = attributes[:'freetext']
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @datetime.nil?
        invalid_properties.push('invalid value for "datetime", datetime cannot be nil.')
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if @datetime !~ pattern
        invalid_properties.push("invalid value for \"datetime\", must conform to the pattern #{pattern}.")
      end

      if @answer.nil?
        invalid_properties.push('invalid value for "answer", answer cannot be nil.')
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @datetime.nil?
      return false if @datetime !~ Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      return false if @answer.nil?
      answer_validator = EnumAttributeValidator.new('String', ["ACCEPTEE", "PARTIELLE", "REFUSEE", "DIFFEREE"])
      return false unless answer_validator.valid?(@answer)
      deadline_validator = EnumAttributeValidator.new('String', ["DEL0", "ASAP", "30M", "45M", "1H", "2H", "4H", "8H", "12H", "24H", "RDV"])
      return false unless deadline_validator.valid?(@deadline)
      true
    end

    # Custom attribute writer method with validation
    # @param [Object] datetime Value to be assigned
    def datetime=(datetime)
      if datetime.nil?
        fail ArgumentError, 'datetime cannot be nil'
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if datetime !~ pattern
        fail ArgumentError, "invalid value for \"datetime\", must conform to the pattern #{pattern}."
      end

      @datetime = datetime
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] answer Object to be assigned
    def answer=(answer)
      validator = EnumAttributeValidator.new('String', ["ACCEPTEE", "PARTIELLE", "REFUSEE", "DIFFEREE"])
      unless validator.valid?(answer)
        fail ArgumentError, "invalid value for \"answer\", must be one of #{validator.allowable_values}."
      end
      @answer = answer
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] deadline Object to be assigned
    def deadline=(deadline)
      validator = EnumAttributeValidator.new('String', ["DEL0", "ASAP", "30M", "45M", "1H", "2H", "4H", "8H", "12H", "24H", "RDV"])
      unless validator.valid?(deadline)
        fail ArgumentError, "invalid value for \"deadline\", must be one of #{validator.allowable_values}."
      end
      @deadline = deadline
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          datetime == o.datetime &&
          answer == o.answer &&
          deadline == o.deadline &&
          freetext == o.freetext
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [datetime, answer, deadline, freetext].hash
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
        klass = Resourcesresponse.const_get(type)
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
