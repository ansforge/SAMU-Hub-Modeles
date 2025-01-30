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
  class Coord
    # A valoriser avec la latitude du point clé de la localisation - dans le système de coordonnées EPSG-4326 (indiquant l'utilisation de WGS-84) 
    attr_accessor :lat

    # A valoriser avec la longitude du point clé de la localisation - dans le système de coordonnées EPSG-4326 (indiquant l'utilisation de WGS-84) 
    attr_accessor :lon

    # A valoriser avec l'altitude du point clé de la localisation, en mètres.  Spécificité 15-18 :  ignoré côté NexSIS. 
    attr_accessor :height

    # A valoriser avec le cap, en degré
    attr_accessor :heading

    # Vitesse en km/h, notamment fournie par eCall, tel, nouveau AML, …
    attr_accessor :speed

    # Indique via une nomenclature le niveau de précision des coordonnées fournies par le système emetteur. VILLE : Précision à l'échelle de la ville,  RUE : Précision à l'échelle de la rue,  ADRESSE : Adresse précise,  EXACTE : Point coordonnée GPS exact,  INCONNUE : Précision de la localisation non évaluable par l'émetteur
    attr_accessor :precision

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
        :'lat' => :'lat',
        :'lon' => :'lon',
        :'height' => :'height',
        :'heading' => :'heading',
        :'speed' => :'speed',
        :'precision' => :'precision'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'lat' => :'Float',
        :'lon' => :'Float',
        :'height' => :'Float',
        :'heading' => :'Float',
        :'speed' => :'Float',
        :'precision' => :'String'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Cisu::Coord` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Cisu::Coord`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'lat')
        self.lat = attributes[:'lat']
      else
        self.lat = nil
      end

      if attributes.key?(:'lon')
        self.lon = attributes[:'lon']
      else
        self.lon = nil
      end

      if attributes.key?(:'height')
        self.height = attributes[:'height']
      end

      if attributes.key?(:'heading')
        self.heading = attributes[:'heading']
      end

      if attributes.key?(:'speed')
        self.speed = attributes[:'speed']
      end

      if attributes.key?(:'precision')
        self.precision = attributes[:'precision']
      else
        self.precision = nil
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @lat.nil?
        invalid_properties.push('invalid value for "lat", lat cannot be nil.')
      end

      if @lon.nil?
        invalid_properties.push('invalid value for "lon", lon cannot be nil.')
      end

      if @precision.nil?
        invalid_properties.push('invalid value for "precision", precision cannot be nil.')
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @lat.nil?
      return false if @lon.nil?
      return false if @precision.nil?
      precision_validator = EnumAttributeValidator.new('String', ["VILLE", "RUE", "ADRESSE", "EXACTE", "INCONNUE"])
      return false unless precision_validator.valid?(@precision)
      true
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] precision Object to be assigned
    def precision=(precision)
      validator = EnumAttributeValidator.new('String', ["VILLE", "RUE", "ADRESSE", "EXACTE", "INCONNUE"])
      unless validator.valid?(precision)
        fail ArgumentError, "invalid value for \"precision\", must be one of #{validator.allowable_values}."
      end
      @precision = precision
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          lat == o.lat &&
          lon == o.lon &&
          height == o.height &&
          heading == o.heading &&
          speed == o.speed &&
          precision == o.precision
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [lat, lon, height, heading, speed, precision].hash
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
