=begin
#OpenAPI

#OpenAPI

The version of the OpenAPI document: 0.0.1

Generated by: https://openapi-generator.tech
Generator version: 7.10.0

=end

require 'date'
require 'time'

module Health
  class LocationKind
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Health::LocationKind` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Health::LocationKind`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
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
      code_validator = EnumAttributeValidator.new('String', ["L01.00.00", "L01.01.00", "L01.01.01", "L01.01.02", "L01.01.03", "L01.01.04", "L01.02.00", "L01.02.01", "L01.02.02", "L01.02.03", "L01.02.04", "L01.02.05", "L01.02.06", "L01.02.07", "L01.02.08", "L01.02.09", "L01.02.10", "L01.02.11", "L01.02.12", "L01.03.00", "L01.03.01", "L01.03.02", "L01.03.03", "L01.04.00", "L02.00.00", "L02.01.00", "L02.02.00", "L02.02.01", "L02.02.02", "L02.02.03", "L02.02.04", "L02.02.05", "L02.03.00", "L02.03.01", "L02.03.02", "L02.03.03", "L02.04.00", "L02.05.00", "L02.05.01", "L02.05.02", "L02.05.03", "L02.05.04", "L02.05.05", "L02.05.06", "L02.05.07", "L02.05.08", "L02.05.09", "L02.05.10", "L02.05.11", "L02.05.12", "L02.05.13", "L02.05.14", "L02.05.15", "L02.05.16", "L02.06.00", "L02.06.01", "L02.06.02", "L02.06.03", "L02.06.04", "L02.06.05", "L02.06.06", "L02.06.07", "L02.06.08", "L02.07.00", "L02.07.01", "L02.07.02", "L02.08.00", "L03.00.00", "L03.01.00", "L03.02.00", "L03.03.00", "L03.04.00", "L03.05.00", "L04.00.00", "L04.01.00", "L04.02.00", "L04.02.01", "L04.02.02", "L04.02.03", "L04.03.00", "L04.03.01", "L04.03.02", "L04.03.03", "L04.04.00", "L04.05.00", "L04.06.00", "L04.06.01", "L04.06.02", "L04.06.03", "L04.06.04", "L04.06.05", "L04.07.00", "L04.07.01", "L04.07.02", "L04.07.03", "L04.08.00", "L04.08.01", "L04.08.02", "L04.09.00", "L04.09.01", "L04.09.02", "L04.10.00", "L04.11.00", "L04.11.01", "L04.11.02", "L04.11.03", "L04.11.04", "L04.12.00", "L04.12.01", "L04.12.02", "L04.12.03", "L04.12.04", "L04.13.00", "L04.13.01", "L04.13.02", "L04.13.03", "L04.13.04", "L04.14.00", "L04.14.01", "L04.14.02", "L04.15.00", "L04.16.00", "L05.00.00", "L05.01.00", "L05.01.01", "L05.01.02", "L05.01.03", "L05.01.04", "L05.02.00", "L05.02.01", "L05.02.02", "L05.02.03", "L05.02.04", "L05.03.00", "L05.03.01", "L05.03.02", "L05.04.00", "L05.04.01", "L05.04.02", "L05.04.03", "L05.04.04", "L05.04.05", "L05.04.06", "L05.05.00", "L05.06.00", "L05.07.00", "L06.00.00", "L06.01.00", "L06.01.01", "L06.01.02", "L06.01.03", "L06.01.04", "L06.01.05", "L06.01.06", "L06.01.07", "L06.01.08", "L06.02.00", "L06.03.00", "L06.03.01", "L06.03.02", "L06.03.03", "L06.03.04", "L06.03.05", "L06.04.00", "L06.05.00", "L06.05.01", "L06.05.02", "L06.06.00", "L06.06.01", "L06.06.02", "L06.06.03", "L06.06.04", "L06.07.00", "L06.07.01", "L06.07.02", "L07.00.00", "L07.01.00", "L07.01.01", "L07.02.00"])
      return false unless code_validator.valid?(@code)
      return false if @label.nil?
      true
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] code Object to be assigned
    def code=(code)
      validator = EnumAttributeValidator.new('String', ["L01.00.00", "L01.01.00", "L01.01.01", "L01.01.02", "L01.01.03", "L01.01.04", "L01.02.00", "L01.02.01", "L01.02.02", "L01.02.03", "L01.02.04", "L01.02.05", "L01.02.06", "L01.02.07", "L01.02.08", "L01.02.09", "L01.02.10", "L01.02.11", "L01.02.12", "L01.03.00", "L01.03.01", "L01.03.02", "L01.03.03", "L01.04.00", "L02.00.00", "L02.01.00", "L02.02.00", "L02.02.01", "L02.02.02", "L02.02.03", "L02.02.04", "L02.02.05", "L02.03.00", "L02.03.01", "L02.03.02", "L02.03.03", "L02.04.00", "L02.05.00", "L02.05.01", "L02.05.02", "L02.05.03", "L02.05.04", "L02.05.05", "L02.05.06", "L02.05.07", "L02.05.08", "L02.05.09", "L02.05.10", "L02.05.11", "L02.05.12", "L02.05.13", "L02.05.14", "L02.05.15", "L02.05.16", "L02.06.00", "L02.06.01", "L02.06.02", "L02.06.03", "L02.06.04", "L02.06.05", "L02.06.06", "L02.06.07", "L02.06.08", "L02.07.00", "L02.07.01", "L02.07.02", "L02.08.00", "L03.00.00", "L03.01.00", "L03.02.00", "L03.03.00", "L03.04.00", "L03.05.00", "L04.00.00", "L04.01.00", "L04.02.00", "L04.02.01", "L04.02.02", "L04.02.03", "L04.03.00", "L04.03.01", "L04.03.02", "L04.03.03", "L04.04.00", "L04.05.00", "L04.06.00", "L04.06.01", "L04.06.02", "L04.06.03", "L04.06.04", "L04.06.05", "L04.07.00", "L04.07.01", "L04.07.02", "L04.07.03", "L04.08.00", "L04.08.01", "L04.08.02", "L04.09.00", "L04.09.01", "L04.09.02", "L04.10.00", "L04.11.00", "L04.11.01", "L04.11.02", "L04.11.03", "L04.11.04", "L04.12.00", "L04.12.01", "L04.12.02", "L04.12.03", "L04.12.04", "L04.13.00", "L04.13.01", "L04.13.02", "L04.13.03", "L04.13.04", "L04.14.00", "L04.14.01", "L04.14.02", "L04.15.00", "L04.16.00", "L05.00.00", "L05.01.00", "L05.01.01", "L05.01.02", "L05.01.03", "L05.01.04", "L05.02.00", "L05.02.01", "L05.02.02", "L05.02.03", "L05.02.04", "L05.03.00", "L05.03.01", "L05.03.02", "L05.04.00", "L05.04.01", "L05.04.02", "L05.04.03", "L05.04.04", "L05.04.05", "L05.04.06", "L05.05.00", "L05.06.00", "L05.07.00", "L06.00.00", "L06.01.00", "L06.01.01", "L06.01.02", "L06.01.03", "L06.01.04", "L06.01.05", "L06.01.06", "L06.01.07", "L06.01.08", "L06.02.00", "L06.03.00", "L06.03.01", "L06.03.02", "L06.03.03", "L06.03.04", "L06.03.05", "L06.04.00", "L06.05.00", "L06.05.01", "L06.05.02", "L06.06.00", "L06.06.01", "L06.06.02", "L06.06.03", "L06.06.04", "L06.07.00", "L06.07.01", "L06.07.02", "L07.00.00", "L07.01.00", "L07.01.01", "L07.02.00"])
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
