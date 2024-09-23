=begin


Generated by: https://openapi-generator.tech
OpenAPI Generator version: 7.1.0

=end

require 'date'
require 'time'

module Health
  class WhatsHappen
    # A valoriser avec le code de la nomenclature associée
    attr_accessor :code

    # A valoriser avec le libellé de la nomenclature associée. Dans le cas où un système n'est pas en mesure de reconnaître un code, il peut choisir d'afficher le libellé qui est obligatoirement fourni avec le code.
    attr_accessor :label

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
        :'code' => :'code',
        :'label' => :'label'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'code' => :'String',
        :'label' => :'String'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Health::WhatsHappen` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Health::WhatsHappen`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'code')
        self.code = attributes[:'code']
      else
        self.code = nil
      end

      if attributes.key?(:'label')
        self.label = attributes[:'label']
      else
        self.label = nil
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @code.nil?
        invalid_properties.push('invalid value for "code", code cannot be nil.')
      end

      if @label.nil?
        invalid_properties.push('invalid value for "label", label cannot be nil.')
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @code.nil?
      code_validator = EnumAttributeValidator.new('String', ["C01.00.00", "C01.01.00", "C01.01.01", "C01.01.02", "C01.01.03", "C01.01.04", "C01.01.05", "C01.01.06", "C01.02.00", "C01.02.01", "C01.02.02", "C01.03.00", "C01.03.01", "C01.03.02", "C01.04.00", "C01.04.01", "C01.04.02", "C01.04.03", "C01.04.04", "C01.05.00", "C02.00.00", "C02.01.00", "C02.02.00", "C02.03.00", "C02.03.01", "C02.03.02", "C02.04.00", "C02.04.01", "C02.04.02", "C02.04.03", "C02.05.00", "C02.05.01", "C02.05.02", "C02.05.03", "C02.06.00", "C02.06.01", "C02.07.00", "C02.07.01", "C02.07.02", "C02.07.03", "C02.07.04", "C02.07.05", "C02.08.00", "C02.08.01", "C02.08.02", "C02.08.03", "C02.08.04", "C02.08.05", "C02.08.06", "C02.08.07", "C02.08.08", "C02.09.00", "C02.09.01", "C02.09.02", "C02.09.03", "C02.09.04", "C02.09.05", "C02.09.06", "C02.09.07", "C02.10.00", "C02.11.00", "C02.11.01", "C02.11.02", "C02.12.00", "C02.13.00", "C02.13.01", "C02.13.02", "C02.13.03", "C02.13.04", "C02.13.05", "C02.13.06", "C02.13.07", "C02.13.08", "C02.14.00", "C02.14.01", "C02.14.02", "C02.14.03", "C02.14.04", "C02.15.00", "C02.15.01", "C02.15.02", "C02.15.03", "C02.15.04", "C02.15.05", "C02.15.06", "C02.16.00", "C02.16.01", "C02.16.02", "C02.16.03", "C03.00.00", "C03.01.00", "C03.01.01", "C03.01.02", "C03.01.03", "C03.01.04", "C03.01.05", "C03.02.00", "C03.02.01", "C03.02.02", "C03.02.03", "C03.02.04", "C03.02.05", "C03.02.06", "C03.02.07", "C03.02.08", "C03.02.09", "C03.02.10", "C03.02.11", "C03.02.12", "C03.02.13", "C03.02.14", "C03.02.15", "C03.03.00", "C03.03.01", "C03.03.02", "C03.04.00", "C03.04.01", "C03.04.02", "C03.05.00", "C03.06.00", "C03.07.00", "C03.08.00", "C03.09.00", "C03.10.00", "C03.11.00", "C03.12.00", "C03.13.00", "C03.14.00", "C03.15.00", "C04.00.00", "C04.01.00", "C04.01.01", "C04.01.02", "C04.01.03", "C04.01.04", "C04.01.05", "C04.01.06", "C04.01.07", "C04.01.08", "C04.01.09", "C04.01.10", "C04.01.11", "C04.02.00", "C04.02.01", "C04.02.02", "C04.02.03", "C04.02.04", "C04.03.00", "C04.04.00", "C04.05.00", "C04.06.00", "C04.07.00", "C04.07.01", "C04.07.02", "C04.07.03", "C04.07.04", "C04.08.00", "C04.09.00", "C05.00.00", "C05.00.01", "C05.00.02", "C05.00.03", "C05.00.04", "C05.00.05", "C06.00.00", "C06.01.00", "C06.02.00", "C06.03.00", "C06.03.01", "C06.03.02", "C06.03.03", "C06.03.04", "C06.03.05", "C06.03.06", "C06.04.00", "C06.04.01", "C06.04.02", "C06.05.00", "C06.06.00", "C06.06.01", "C06.07.00", "C06.07.01", "C06.07.02", "C06.08.00", "C06.08.01", "C06.08.02", "C06.08.03", "C06.08.04", "C06.08.05", "C06.08.06", "C07.00.00", "C07.01.00", "C07.02.00", "C07.03.00", "C07.03.01", "C07.03.02", "C07.03.03", "C07.03.04", "C07.03.05", "C07.04.00", "C07.04.01", "C07.04.02", "C07.04.03", "C07.04.04", "C07.05.00", "C07.06.00", "C07.07.00", "C07.07.01", "C07.07.02", "C07.07.03", "C07.07.04", "C07.07.05", "C07.08.00", "C07.08.01", "C07.08.02", "C07.08.03", "C07.09.00", "C07.09.01", "C07.09.02", "C07.09.03", "C07.09.05", "C07.10.00", "C07.11.00", "C07.12.00", "C07.13.00", "C07.13.01", "C07.13.02", "C07.13.03", "C07.13.04", "C07.13.05", "C07.13.06", "C07.13.07", "C08.00.00", "C08.01.00", "C08.02.00", "C08.03.00", "C08.04.00", "C08.05.00", "C08.06.00", "C08.07.00", "C08.08.00", "C08.08.01", "C08.08.02", "C08.09.00", "C08.10.00", "C08.10.01", "C09.00.00", "C09.01.00", "C09.01.01", "C09.01.02", "C09.01.03", "C09.01.04", "C09.02.00", "C09.03.00", "C09.03.01", "C09.04.00", "C09.04.01", "C09.04.02", "C09.05.00", "C09.06.00", "C09.07.00", "C09.08.00", "C10.00.00", "C10.01.00", "C10.01.01", "C10.01.02", "C10.01.03", "C10.01.04", "C10.01.05", "C10.01.06", "C10.01.07", "C10.01.08", "C10.02.00", "C10.02.01", "C10.02.02", "C10.03.00", "C10.03.01", "C10.03.02", "C10.04.00", "C10.04.01", "C10.04.02", "C10.05.00", "C10.06.00", "C10.07.00", "C10.08.00", "C11.00.00", "C11.01.00", "C11.02.00", "C11.02.01", "C11.02.02", "C11.03.00", "C11.03.01", "C11.03.02", "C11.04.00", "C11.05.00", "C11.05.01", "C11.05.02", "C11.05.03", "C11.06.00"])
      return false unless code_validator.valid?(@code)
      return false if @label.nil?
      true
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] code Object to be assigned
    def code=(code)
      validator = EnumAttributeValidator.new('String', ["C01.00.00", "C01.01.00", "C01.01.01", "C01.01.02", "C01.01.03", "C01.01.04", "C01.01.05", "C01.01.06", "C01.02.00", "C01.02.01", "C01.02.02", "C01.03.00", "C01.03.01", "C01.03.02", "C01.04.00", "C01.04.01", "C01.04.02", "C01.04.03", "C01.04.04", "C01.05.00", "C02.00.00", "C02.01.00", "C02.02.00", "C02.03.00", "C02.03.01", "C02.03.02", "C02.04.00", "C02.04.01", "C02.04.02", "C02.04.03", "C02.05.00", "C02.05.01", "C02.05.02", "C02.05.03", "C02.06.00", "C02.06.01", "C02.07.00", "C02.07.01", "C02.07.02", "C02.07.03", "C02.07.04", "C02.07.05", "C02.08.00", "C02.08.01", "C02.08.02", "C02.08.03", "C02.08.04", "C02.08.05", "C02.08.06", "C02.08.07", "C02.08.08", "C02.09.00", "C02.09.01", "C02.09.02", "C02.09.03", "C02.09.04", "C02.09.05", "C02.09.06", "C02.09.07", "C02.10.00", "C02.11.00", "C02.11.01", "C02.11.02", "C02.12.00", "C02.13.00", "C02.13.01", "C02.13.02", "C02.13.03", "C02.13.04", "C02.13.05", "C02.13.06", "C02.13.07", "C02.13.08", "C02.14.00", "C02.14.01", "C02.14.02", "C02.14.03", "C02.14.04", "C02.15.00", "C02.15.01", "C02.15.02", "C02.15.03", "C02.15.04", "C02.15.05", "C02.15.06", "C02.16.00", "C02.16.01", "C02.16.02", "C02.16.03", "C03.00.00", "C03.01.00", "C03.01.01", "C03.01.02", "C03.01.03", "C03.01.04", "C03.01.05", "C03.02.00", "C03.02.01", "C03.02.02", "C03.02.03", "C03.02.04", "C03.02.05", "C03.02.06", "C03.02.07", "C03.02.08", "C03.02.09", "C03.02.10", "C03.02.11", "C03.02.12", "C03.02.13", "C03.02.14", "C03.02.15", "C03.03.00", "C03.03.01", "C03.03.02", "C03.04.00", "C03.04.01", "C03.04.02", "C03.05.00", "C03.06.00", "C03.07.00", "C03.08.00", "C03.09.00", "C03.10.00", "C03.11.00", "C03.12.00", "C03.13.00", "C03.14.00", "C03.15.00", "C04.00.00", "C04.01.00", "C04.01.01", "C04.01.02", "C04.01.03", "C04.01.04", "C04.01.05", "C04.01.06", "C04.01.07", "C04.01.08", "C04.01.09", "C04.01.10", "C04.01.11", "C04.02.00", "C04.02.01", "C04.02.02", "C04.02.03", "C04.02.04", "C04.03.00", "C04.04.00", "C04.05.00", "C04.06.00", "C04.07.00", "C04.07.01", "C04.07.02", "C04.07.03", "C04.07.04", "C04.08.00", "C04.09.00", "C05.00.00", "C05.00.01", "C05.00.02", "C05.00.03", "C05.00.04", "C05.00.05", "C06.00.00", "C06.01.00", "C06.02.00", "C06.03.00", "C06.03.01", "C06.03.02", "C06.03.03", "C06.03.04", "C06.03.05", "C06.03.06", "C06.04.00", "C06.04.01", "C06.04.02", "C06.05.00", "C06.06.00", "C06.06.01", "C06.07.00", "C06.07.01", "C06.07.02", "C06.08.00", "C06.08.01", "C06.08.02", "C06.08.03", "C06.08.04", "C06.08.05", "C06.08.06", "C07.00.00", "C07.01.00", "C07.02.00", "C07.03.00", "C07.03.01", "C07.03.02", "C07.03.03", "C07.03.04", "C07.03.05", "C07.04.00", "C07.04.01", "C07.04.02", "C07.04.03", "C07.04.04", "C07.05.00", "C07.06.00", "C07.07.00", "C07.07.01", "C07.07.02", "C07.07.03", "C07.07.04", "C07.07.05", "C07.08.00", "C07.08.01", "C07.08.02", "C07.08.03", "C07.09.00", "C07.09.01", "C07.09.02", "C07.09.03", "C07.09.05", "C07.10.00", "C07.11.00", "C07.12.00", "C07.13.00", "C07.13.01", "C07.13.02", "C07.13.03", "C07.13.04", "C07.13.05", "C07.13.06", "C07.13.07", "C08.00.00", "C08.01.00", "C08.02.00", "C08.03.00", "C08.04.00", "C08.05.00", "C08.06.00", "C08.07.00", "C08.08.00", "C08.08.01", "C08.08.02", "C08.09.00", "C08.10.00", "C08.10.01", "C09.00.00", "C09.01.00", "C09.01.01", "C09.01.02", "C09.01.03", "C09.01.04", "C09.02.00", "C09.03.00", "C09.03.01", "C09.04.00", "C09.04.01", "C09.04.02", "C09.05.00", "C09.06.00", "C09.07.00", "C09.08.00", "C10.00.00", "C10.01.00", "C10.01.01", "C10.01.02", "C10.01.03", "C10.01.04", "C10.01.05", "C10.01.06", "C10.01.07", "C10.01.08", "C10.02.00", "C10.02.01", "C10.02.02", "C10.03.00", "C10.03.01", "C10.03.02", "C10.04.00", "C10.04.01", "C10.04.02", "C10.05.00", "C10.06.00", "C10.07.00", "C10.08.00", "C11.00.00", "C11.01.00", "C11.02.00", "C11.02.01", "C11.02.02", "C11.03.00", "C11.03.01", "C11.03.02", "C11.04.00", "C11.05.00", "C11.05.01", "C11.05.02", "C11.05.03", "C11.06.00"])
      unless validator.valid?(code)
        fail ArgumentError, "invalid value for \"code\", must be one of #{validator.allowable_values}."
      end
      @code = code
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          code == o.code &&
          label == o.label
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [code, label].hash
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