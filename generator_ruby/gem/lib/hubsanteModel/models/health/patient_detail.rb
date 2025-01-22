=begin
#OpenAPI

#OpenAPI

The version of the OpenAPI document: 0.0.1

Generated by: https://openapi-generator.tech
Generator version: 7.11.0

=end

require 'date'
require 'time'

module Health
  class PatientDetail
    # A valoriser avec le poids en kilogrammes
    attr_accessor :weight

    # A valoriser avec la taille en centimètres du patient
    attr_accessor :height

    # A valoriser avec l'age du patient. Au format \"Durée\" de la norme ISO 8601 (https://fr.wikipedia.org/wiki/ISO_8601#Dur%C3%A9e) et en n'utilisant qu'une seule unité de durée (années, mois, semaines ou jours)
    attr_accessor :age

    # A valoriser avec le niveau de soins spécifique au patient
    attr_accessor :care_level

    # Texte libre  pour décrire les antécédents du patient.  Si ce n'est pas géré de manière structurés : à afficher dans une note liée au patient en réception. 
    attr_accessor :medical_history

    # Texte libre  pour décrire les traitements du patient. Si ce n'est pas géré de manière structurés : à afficher dans une note liée au patient en réception. 
    attr_accessor :treatment

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
        :'weight' => :'weight',
        :'height' => :'height',
        :'age' => :'age',
        :'care_level' => :'careLevel',
        :'medical_history' => :'medicalHistory',
        :'treatment' => :'treatment'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'weight' => :'Float',
        :'height' => :'Float',
        :'age' => :'String',
        :'care_level' => :'String',
        :'medical_history' => :'String',
        :'treatment' => :'String'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Health::PatientDetail` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Health::PatientDetail`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'weight')
        self.weight = attributes[:'weight']
      end

      if attributes.key?(:'height')
        self.height = attributes[:'height']
      end

      if attributes.key?(:'age')
        self.age = attributes[:'age']
      end

      if attributes.key?(:'care_level')
        self.care_level = attributes[:'care_level']
      end

      if attributes.key?(:'medical_history')
        self.medical_history = attributes[:'medical_history']
      end

      if attributes.key?(:'treatment')
        self.treatment = attributes[:'treatment']
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      pattern = Regexp.new(/^P[0-9]{1,3}[YMWD]$/)
      if !@age.nil? && @age !~ pattern
        invalid_properties.push("invalid value for \"age\", must conform to the pattern #{pattern}.")
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if !@age.nil? && @age !~ Regexp.new(/^P[0-9]{1,3}[YMWD]$/)
      care_level_validator = EnumAttributeValidator.new('String', ["R1", "R2", "R3", "R4"])
      return false unless care_level_validator.valid?(@care_level)
      true
    end

    # Custom attribute writer method with validation
    # @param [Object] age Value to be assigned
    def age=(age)
      if age.nil?
        fail ArgumentError, 'age cannot be nil'
      end

      pattern = Regexp.new(/^P[0-9]{1,3}[YMWD]$/)
      if age !~ pattern
        fail ArgumentError, "invalid value for \"age\", must conform to the pattern #{pattern}."
      end

      @age = age
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] care_level Object to be assigned
    def care_level=(care_level)
      validator = EnumAttributeValidator.new('String', ["R1", "R2", "R3", "R4"])
      unless validator.valid?(care_level)
        fail ArgumentError, "invalid value for \"care_level\", must be one of #{validator.allowable_values}."
      end
      @care_level = care_level
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          weight == o.weight &&
          height == o.height &&
          age == o.age &&
          care_level == o.care_level &&
          medical_history == o.medical_history &&
          treatment == o.treatment
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [weight, height, age, care_level, medical_history, treatment].hash
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
        klass = Health.const_get(type)
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
