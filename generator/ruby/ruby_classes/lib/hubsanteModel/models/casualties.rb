=begin


Generated by: https://openapi-generator.tech
OpenAPI Generator version: 7.1.0

=end

require 'date'
require 'time'

module Emsi
  class Casualties
    # Le champ doit être renseigné mais peut ne pas être interprété
    attr_accessor :context

    # Optionnel
    attr_accessor :datime

    # Optionnel
    attr_accessor :decont

    # Optionnel, Triage victime au sens EMSI
    attr_accessor :triagered

    # Optionnel
    attr_accessor :triageyellow

    # Optionnel
    attr_accessor :triagegreen

    # Optionnel
    attr_accessor :triageblack

    # Optionnel
    attr_accessor :missing

    # Attribute mapping from ruby-style variable name to JSON key.
    def self.attribute_map
      {
        :'context' => :'CONTEXT',
        :'datime' => :'DATIME',
        :'decont' => :'DECONT',
        :'triagered' => :'TRIAGERED',
        :'triageyellow' => :'TRIAGEYELLOW',
        :'triagegreen' => :'TRIAGEGREEN',
        :'triageblack' => :'TRIAGEBLACK',
        :'missing' => :'MISSING'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'context' => :'String',
        :'datime' => :'Time',
        :'decont' => :'Integer',
        :'triagered' => :'Integer',
        :'triageyellow' => :'Integer',
        :'triagegreen' => :'Integer',
        :'triageblack' => :'Integer',
        :'missing' => :'Integer'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Emsi::Casualties` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Emsi::Casualties`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'context')
        self.context = attributes[:'context']
      else
        self.context = nil
      end

      if attributes.key?(:'datime')
        self.datime = attributes[:'datime']
      end

      if attributes.key?(:'decont')
        self.decont = attributes[:'decont']
      end

      if attributes.key?(:'triagered')
        self.triagered = attributes[:'triagered']
      end

      if attributes.key?(:'triageyellow')
        self.triageyellow = attributes[:'triageyellow']
      end

      if attributes.key?(:'triagegreen')
        self.triagegreen = attributes[:'triagegreen']
      end

      if attributes.key?(:'triageblack')
        self.triageblack = attributes[:'triageblack']
      end

      if attributes.key?(:'missing')
        self.missing = attributes[:'missing']
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @context.nil?
        invalid_properties.push('invalid value for "context", context cannot be nil.')
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if !@datime.nil? && @datime !~ pattern
        invalid_properties.push("invalid value for \"datime\", must conform to the pattern #{pattern}.")
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @context.nil?
      return false if !@datime.nil? && @datime !~ Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      true
    end

    # Custom attribute writer method with validation
    # @param [Object] datime Value to be assigned
    def datime=(datime)
      if datime.nil?
        fail ArgumentError, 'datime cannot be nil'
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if datime !~ pattern
        fail ArgumentError, "invalid value for \"datime\", must conform to the pattern #{pattern}."
      end

      @datime = datime
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          context == o.context &&
          datime == o.datime &&
          decont == o.decont &&
          triagered == o.triagered &&
          triageyellow == o.triageyellow &&
          triagegreen == o.triagegreen &&
          triageblack == o.triageblack &&
          missing == o.missing
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [context, datime, decont, triagered, triageyellow, triagegreen, triageblack, missing].hash
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
