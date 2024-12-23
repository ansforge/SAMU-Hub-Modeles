=begin
#OpenAPI

#OpenAPI

The version of the OpenAPI document: 0.0.1

Generated by: https://openapi-generator.tech
Generator version: 7.10.0

=end

require 'date'
require 'time'

module Rpis
  class Decision
    # Précise le type de moyen engagé dans l'intervention (SMUR, TSU, HOSPIT, etc.).  A valoriser par un code de la nomenclature SI-SAMU-TYPE_MOYEN.
    attr_accessor :resource_type

    # Précise le type de véhicule terrestre / aérien / maritime engagé dans l'intervention. A valoriser par un code de la nomenclature SI-SAMU-TYPE_VECTEUR.
    attr_accessor :vehicle_type

    # Type d’équipe (médical, paramédicale, secouriste). A valoriser par un code de la nomenclature SI-SAMU-NIVSOIN.
    attr_accessor :medical_level

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
        :'resource_type' => :'resourceType',
        :'vehicle_type' => :'vehicleType',
        :'medical_level' => :'medicalLevel'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'resource_type' => :'String',
        :'vehicle_type' => :'String',
        :'medical_level' => :'String'
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

      if attributes.key?(:'resource_type')
        self.resource_type = attributes[:'resource_type']
      else
        self.resource_type = nil
      end

      if attributes.key?(:'vehicle_type')
        self.vehicle_type = attributes[:'vehicle_type']
      else
        self.vehicle_type = nil
      end

      if attributes.key?(:'medical_level')
        self.medical_level = attributes[:'medical_level']
      else
        self.medical_level = nil
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @resource_type.nil?
        invalid_properties.push('invalid value for "resource_type", resource_type cannot be nil.')
      end

      if @vehicle_type.nil?
        invalid_properties.push('invalid value for "vehicle_type", vehicle_type cannot be nil.')
      end

      if @medical_level.nil?
        invalid_properties.push('invalid value for "medical_level", medical_level cannot be nil.')
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @resource_type.nil?
      resource_type_validator = EnumAttributeValidator.new('String', ["SMUR", "SMUR.ADULT", "SMUR.PED", "SMUR.UMH-S", "SMUR.CUMP", "HOSPIT", "LIBERAL", "LIBERAL.MG", "LIBERAL.PHARM", "LIBERAL.INF", "LIBERAL.KINE", "LIBERAL.SOS", "LIBERAL.MMG", "LIBERAL.MSPD", "LIBERAL.MCS", "LIBERAL.SPEMED", "LIBERAL.DENT", "LIBERAL.LABO", "LIBERAL.AUTREPRO", "TSU ", "SIS", "SIS.MEDSP", "SIS.ISP", "SIS.SP", "AASC", "FDO", "FDO.PN", "FDO.GEND", "FDO.PM", "FDO.DOUANES", "AUTRE", "AUTRE.ADM", "AUTRE.DAE", "AUTRE.AUTRE"])
      return false unless resource_type_validator.valid?(@resource_type)
      return false if @vehicle_type.nil?
      vehicle_type_validator = EnumAttributeValidator.new('String', ["AASC", "AASC.VLSC", "AASC.VPSP", "AASC.AUTRESC", "AUTREVEC", "AUTREVEC.APIED", "AUTREVEC.AVION", "AUTREVEC.PERSO", "AUTREVEC.TAXI", "AUTREVEC.TRAIN", "AUTREVEC.TRANSP", "AUTREVEC.AUTRE", "AUTREVEC.AUTRETRA", "FSI", "FSI.HELIFSI", "FSI.VLFSI", "FSI.FFSI", "FSI.VHFSI", "LIB", "LIB.MEDV", "LIB.INF", "LIB.AUTREPRO", "SIS", "SIS.DRAGON", "SIS.AVSC", "SIS.FEUSIS", "SIS.GRIMP", "SIS.NAVISIS", "SIS.PCSIS", "SIS.SRSIS", "SIS.VCH", "SIS.VLCG", "SIS.VLISP", "SIS.VLMSP", "SIS.VLSIS", "SIS.VPL", "SIS.VPMA", "SIS.VR", "SIS.VSAV", "SIS.MOYSSE", "SIS.AUTRESIS", "SMUR", "SMUR.VLM", "SMUR.VL", "SMUR.PSM1", "SMUR.PSM2", "SMUR.PSM3", "SMUR.PSMP", "SMUR.VPC", "SMUR.AR", "SMUR.AR-BAR", "SMUR.AR-PED", "SMUR.HELISMUR", "SMUR.HELISAN", "SMUR.AVSMUR", "SMUR.AVSAN", "SMUR.NAVISMUR", "TSU", "TSU.VSL", "TSU.AMB-GV", "TSU.AMB-PV", "TSU.AMB-BAR", "TSU.AMB"])
      return false unless vehicle_type_validator.valid?(@vehicle_type)
      return false if @medical_level.nil?
      medical_level_validator = EnumAttributeValidator.new('String', ["MED", "PARAMED", "SECOURS", "SANS"])
      return false unless medical_level_validator.valid?(@medical_level)
      true
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] resource_type Object to be assigned
    def resource_type=(resource_type)
      validator = EnumAttributeValidator.new('String', ["SMUR", "SMUR.ADULT", "SMUR.PED", "SMUR.UMH-S", "SMUR.CUMP", "HOSPIT", "LIBERAL", "LIBERAL.MG", "LIBERAL.PHARM", "LIBERAL.INF", "LIBERAL.KINE", "LIBERAL.SOS", "LIBERAL.MMG", "LIBERAL.MSPD", "LIBERAL.MCS", "LIBERAL.SPEMED", "LIBERAL.DENT", "LIBERAL.LABO", "LIBERAL.AUTREPRO", "TSU ", "SIS", "SIS.MEDSP", "SIS.ISP", "SIS.SP", "AASC", "FDO", "FDO.PN", "FDO.GEND", "FDO.PM", "FDO.DOUANES", "AUTRE", "AUTRE.ADM", "AUTRE.DAE", "AUTRE.AUTRE"])
      unless validator.valid?(resource_type)
        fail ArgumentError, "invalid value for \"resource_type\", must be one of #{validator.allowable_values}."
      end
      @resource_type = resource_type
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] vehicle_type Object to be assigned
    def vehicle_type=(vehicle_type)
      validator = EnumAttributeValidator.new('String', ["AASC", "AASC.VLSC", "AASC.VPSP", "AASC.AUTRESC", "AUTREVEC", "AUTREVEC.APIED", "AUTREVEC.AVION", "AUTREVEC.PERSO", "AUTREVEC.TAXI", "AUTREVEC.TRAIN", "AUTREVEC.TRANSP", "AUTREVEC.AUTRE", "AUTREVEC.AUTRETRA", "FSI", "FSI.HELIFSI", "FSI.VLFSI", "FSI.FFSI", "FSI.VHFSI", "LIB", "LIB.MEDV", "LIB.INF", "LIB.AUTREPRO", "SIS", "SIS.DRAGON", "SIS.AVSC", "SIS.FEUSIS", "SIS.GRIMP", "SIS.NAVISIS", "SIS.PCSIS", "SIS.SRSIS", "SIS.VCH", "SIS.VLCG", "SIS.VLISP", "SIS.VLMSP", "SIS.VLSIS", "SIS.VPL", "SIS.VPMA", "SIS.VR", "SIS.VSAV", "SIS.MOYSSE", "SIS.AUTRESIS", "SMUR", "SMUR.VLM", "SMUR.VL", "SMUR.PSM1", "SMUR.PSM2", "SMUR.PSM3", "SMUR.PSMP", "SMUR.VPC", "SMUR.AR", "SMUR.AR-BAR", "SMUR.AR-PED", "SMUR.HELISMUR", "SMUR.HELISAN", "SMUR.AVSMUR", "SMUR.AVSAN", "SMUR.NAVISMUR", "TSU", "TSU.VSL", "TSU.AMB-GV", "TSU.AMB-PV", "TSU.AMB-BAR", "TSU.AMB"])
      unless validator.valid?(vehicle_type)
        fail ArgumentError, "invalid value for \"vehicle_type\", must be one of #{validator.allowable_values}."
      end
      @vehicle_type = vehicle_type
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] medical_level Object to be assigned
    def medical_level=(medical_level)
      validator = EnumAttributeValidator.new('String', ["MED", "PARAMED", "SECOURS", "SANS"])
      unless validator.valid?(medical_level)
        fail ArgumentError, "invalid value for \"medical_level\", must be one of #{validator.allowable_values}."
      end
      @medical_level = medical_level
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          resource_type == o.resource_type &&
          vehicle_type == o.vehicle_type &&
          medical_level == o.medical_level
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [resource_type, vehicle_type, medical_level].hash
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