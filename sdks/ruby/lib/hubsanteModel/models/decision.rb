=begin


Generated by: https://openapi-generator.tech
OpenAPI Generator version: 7.1.0

=end

require 'date'
require 'time'

module Rpis
  class Decision
    # Précise le type de moyen engagé dans l'intervention (SMUR, TSU, HOSPIT, etc.).  A valoriser par un code de la nomenclature SI SAMU-TYPE_MOYEN.
    attr_accessor :resource_category

    # Précise le type de véhicule terrestre / aérien / maritime engagé dans l'intervention. A valoriser par un code de la nomenclature CISU-TYPE_VECTEUR.
    attr_accessor :resource_type

    # Type d’équipe (médical, paramédicale, secouriste). A valoriser par un code de la nomenclature SI-SAMU-NIVSOIN.
    attr_accessor :team_care

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
        :'resource_category' => :'resourceCategory',
        :'resource_type' => :'resourceType',
        :'team_care' => :'teamCare'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'resource_category' => :'String',
        :'resource_type' => :'String',
        :'team_care' => :'String'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Rpis::Decision` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Rpis::Decision`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'resource_category')
        self.resource_category = attributes[:'resource_category']
      else
        self.resource_category = nil
      end

      if attributes.key?(:'resource_type')
        self.resource_type = attributes[:'resource_type']
      else
        self.resource_type = nil
      end

      if attributes.key?(:'team_care')
        self.team_care = attributes[:'team_care']
      else
        self.team_care = nil
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @resource_category.nil?
        invalid_properties.push('invalid value for "resource_category", resource_category cannot be nil.')
      end

      if @resource_type.nil?
        invalid_properties.push('invalid value for "resource_type", resource_type cannot be nil.')
      end

      if @team_care.nil?
        invalid_properties.push('invalid value for "team_care", team_care cannot be nil.')
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @resource_category.nil?
      resource_category_validator = EnumAttributeValidator.new('String', ["SMUR", "HOSPIT", "LIB", "TSU ", "SIS", "AASC", "FDO", "AUTRE"])
      return false unless resource_category_validator.valid?(@resource_category)
      return false if @resource_type.nil?
      resource_type_validator = EnumAttributeValidator.new('String', ["AASC", "VLSC", "VPSP", "AUTRESC", "AUTREVEC", "TAXI", "TRANSP", "TRAIN", "AVION", "PERSO", "APIED", "AUTRE", "AUTRETRA", "FSI", "HELIFSI", "VLFSI", "FFSI", "VHFSI", "LIB", "MEDV", "INF", "AUTREPRO", "SIS", "VSAV", "GRIMP", "VPL", "SRSIS", "FEUSIS", "VPMA", "VCH", "VR", "PCSIS", "VLISP", "VLMSP", "VLCG", "VLSIS", "DRAGON", "AVSC", "MOYSSE", "AUTRESIS", "NAVISIS", "SMUR", "VLM", "VL", "PSM1", "PSM2", "PSM3", "PSMP", "VPC", "AR", "AR-BAR", "AR-PED", "HELISMUR", "HELISAN", "AVSMUR", "AVSAN", "NAVISMUR", "TSU", "VSL", "AMB-GV", "AMB-PV", "AMB-BAR", "AMB"])
      return false unless resource_type_validator.valid?(@resource_type)
      return false if @team_care.nil?
      team_care_validator = EnumAttributeValidator.new('String', ["MED", "PARAMED", "SECOURS"])
      return false unless team_care_validator.valid?(@team_care)
      true
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] resource_category Object to be assigned
    def resource_category=(resource_category)
      validator = EnumAttributeValidator.new('String', ["SMUR", "HOSPIT", "LIB", "TSU ", "SIS", "AASC", "FDO", "AUTRE"])
      unless validator.valid?(resource_category)
        fail ArgumentError, "invalid value for \"resource_category\", must be one of #{validator.allowable_values}."
      end
      @resource_category = resource_category
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] resource_type Object to be assigned
    def resource_type=(resource_type)
      validator = EnumAttributeValidator.new('String', ["AASC", "VLSC", "VPSP", "AUTRESC", "AUTREVEC", "TAXI", "TRANSP", "TRAIN", "AVION", "PERSO", "APIED", "AUTRE", "AUTRETRA", "FSI", "HELIFSI", "VLFSI", "FFSI", "VHFSI", "LIB", "MEDV", "INF", "AUTREPRO", "SIS", "VSAV", "GRIMP", "VPL", "SRSIS", "FEUSIS", "VPMA", "VCH", "VR", "PCSIS", "VLISP", "VLMSP", "VLCG", "VLSIS", "DRAGON", "AVSC", "MOYSSE", "AUTRESIS", "NAVISIS", "SMUR", "VLM", "VL", "PSM1", "PSM2", "PSM3", "PSMP", "VPC", "AR", "AR-BAR", "AR-PED", "HELISMUR", "HELISAN", "AVSMUR", "AVSAN", "NAVISMUR", "TSU", "VSL", "AMB-GV", "AMB-PV", "AMB-BAR", "AMB"])
      unless validator.valid?(resource_type)
        fail ArgumentError, "invalid value for \"resource_type\", must be one of #{validator.allowable_values}."
      end
      @resource_type = resource_type
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] team_care Object to be assigned
    def team_care=(team_care)
      validator = EnumAttributeValidator.new('String', ["MED", "PARAMED", "SECOURS"])
      unless validator.valid?(team_care)
        fail ArgumentError, "invalid value for \"team_care\", must be one of #{validator.allowable_values}."
      end
      @team_care = team_care
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          resource_category == o.resource_category &&
          resource_type == o.resource_type &&
          team_care == o.team_care
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [resource_category, resource_type, team_care].hash
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
        klass = Rpis.const_get(type)
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
