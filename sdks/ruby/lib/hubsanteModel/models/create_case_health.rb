=begin


Generated by: https://openapi-generator.tech
OpenAPI Generator version: 7.1.0

=end

require 'date'
require 'time'

module Health
  class CreateCaseHealth
    # Identifiant partagé de l'affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l'ensemble des systèmes : le numéro de dossier fourni par celui qui génère l'identifiant partagé doit donc être un numéro unique dans son système.
    attr_accessor :case_id

    # A valoriser avec le numéro du dossier dans le SI de l'émetteur du message. 
    attr_accessor :sender_case_id

    # A valoriser avec le groupe date heure de création du dossier/affaire.  Spécificité 15-18 : A valoriser avec le groupe date heure de début de partage lié à la création de l'affaire (et donc de génération du caseId).  Lors de l'ajout d'une nouvelle alerte, la valeur de ce champ ne doit pas être modifiée.   L'indicateur de fuseau horaire Z ne doit pas être utilisé. Il doit être renseigné à la fin du processus de la  création de la première alerte.
    attr_accessor :creation

    # Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être adressé/affiché, lorsque celle-ci est spécifique ou dédiée.
    attr_accessor :perimeter

    # A valoriser en indiquant s'il s'agit d'un dossier dit primaire (première intervention urgente) ou secondaire (par exemple TIH)
    attr_accessor :intervention_type

    attr_accessor :qualification

    attr_accessor :location

    attr_accessor :initial_alert

    # Attribut qui permet de transférer la prise en charge d'un dossier à un autre CRAA A valoriser avec l'identifiant de l'organisation concerné (orgId = {pays}.{domaine}.{organisation})
    attr_accessor :owner

    attr_accessor :patient

    attr_accessor :medical_note

    attr_accessor :decision

    attr_accessor :additional_information

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
        :'case_id' => :'caseId',
        :'sender_case_id' => :'senderCaseId',
        :'creation' => :'creation',
        :'perimeter' => :'perimeter',
        :'intervention_type' => :'interventionType',
        :'qualification' => :'qualification',
        :'location' => :'location',
        :'initial_alert' => :'initialAlert',
        :'owner' => :'owner',
        :'patient' => :'patient',
        :'medical_note' => :'medicalNote',
        :'decision' => :'decision',
        :'additional_information' => :'additionalInformation'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'case_id' => :'String',
        :'sender_case_id' => :'String',
        :'creation' => :'Time',
        :'perimeter' => :'String',
        :'intervention_type' => :'String',
        :'qualification' => :'Qualification',
        :'location' => :'Location',
        :'initial_alert' => :'Alert',
        :'owner' => :'String',
        :'patient' => :'Array<Patient>',
        :'medical_note' => :'Array<MedicalNote>',
        :'decision' => :'Array<Decision>',
        :'additional_information' => :'AdditionalInformation'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Health::CreateCaseHealth` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Health::CreateCaseHealth`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'case_id')
        self.case_id = attributes[:'case_id']
      else
        self.case_id = nil
      end

      if attributes.key?(:'sender_case_id')
        self.sender_case_id = attributes[:'sender_case_id']
      end

      if attributes.key?(:'creation')
        self.creation = attributes[:'creation']
      else
        self.creation = nil
      end

      if attributes.key?(:'perimeter')
        self.perimeter = attributes[:'perimeter']
      end

      if attributes.key?(:'intervention_type')
        self.intervention_type = attributes[:'intervention_type']
      end

      if attributes.key?(:'qualification')
        self.qualification = attributes[:'qualification']
      else
        self.qualification = nil
      end

      if attributes.key?(:'location')
        self.location = attributes[:'location']
      else
        self.location = nil
      end

      if attributes.key?(:'initial_alert')
        self.initial_alert = attributes[:'initial_alert']
      end

      if attributes.key?(:'owner')
        self.owner = attributes[:'owner']
      else
        self.owner = nil
      end

      if attributes.key?(:'patient')
        if (value = attributes[:'patient']).is_a?(Array)
          self.patient = value
        end
      end

      if attributes.key?(:'medical_note')
        if (value = attributes[:'medical_note']).is_a?(Array)
          self.medical_note = value
        end
      end

      if attributes.key?(:'decision')
        if (value = attributes[:'decision']).is_a?(Array)
          self.decision = value
        end
      end

      if attributes.key?(:'additional_information')
        self.additional_information = attributes[:'additional_information']
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @case_id.nil?
        invalid_properties.push('invalid value for "case_id", case_id cannot be nil.')
      end

      pattern = Regexp.new(/^fr(\.[\w-]+){3,4}$/)
      if @case_id !~ pattern
        invalid_properties.push("invalid value for \"case_id\", must conform to the pattern #{pattern}.")
      end

      if @creation.nil?
        invalid_properties.push('invalid value for "creation", creation cannot be nil.')
      end

      pattern = Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      if @creation !~ pattern
        invalid_properties.push("invalid value for \"creation\", must conform to the pattern #{pattern}.")
      end

      if @qualification.nil?
        invalid_properties.push('invalid value for "qualification", qualification cannot be nil.')
      end

      if @location.nil?
        invalid_properties.push('invalid value for "location", location cannot be nil.')
      end

      if @owner.nil?
        invalid_properties.push('invalid value for "owner", owner cannot be nil.')
      end

      pattern = Regexp.new(/^fr(\.[\w-]+){2,3}$/)
      if @owner !~ pattern
        invalid_properties.push("invalid value for \"owner\", must conform to the pattern #{pattern}.")
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @case_id.nil?
      return false if @case_id !~ Regexp.new(/^fr(\.[\w-]+){3,4}$/)
      return false if @creation.nil?
      return false if @creation !~ Regexp.new(/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/)
      perimeter_validator = EnumAttributeValidator.new('String', ["AMU", "NEONAT", "PSY", "SNP"])
      return false unless perimeter_validator.valid?(@perimeter)
      intervention_type_validator = EnumAttributeValidator.new('String', ["T1", "T2-INTER", "T2-INTRA", "T3", "T4"])
      return false unless intervention_type_validator.valid?(@intervention_type)
      return false if @qualification.nil?
      return false if @location.nil?
      return false if @owner.nil?
      return false if @owner !~ Regexp.new(/^fr(\.[\w-]+){2,3}$/)
      true
    end

    # Custom attribute writer method with validation
    # @param [Object] case_id Value to be assigned
    def case_id=(case_id)
      if case_id.nil?
        fail ArgumentError, 'case_id cannot be nil'
      end

      pattern = Regexp.new(/^fr(\.[\w-]+){3,4}$/)
      if case_id !~ pattern
        fail ArgumentError, "invalid value for \"case_id\", must conform to the pattern #{pattern}."
      end

      @case_id = case_id
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
    # @param [Object] perimeter Object to be assigned
    def perimeter=(perimeter)
      validator = EnumAttributeValidator.new('String', ["AMU", "NEONAT", "PSY", "SNP"])
      unless validator.valid?(perimeter)
        fail ArgumentError, "invalid value for \"perimeter\", must be one of #{validator.allowable_values}."
      end
      @perimeter = perimeter
    end

    # Custom attribute writer method checking allowed values (enum).
    # @param [Object] intervention_type Object to be assigned
    def intervention_type=(intervention_type)
      validator = EnumAttributeValidator.new('String', ["T1", "T2-INTER", "T2-INTRA", "T3", "T4"])
      unless validator.valid?(intervention_type)
        fail ArgumentError, "invalid value for \"intervention_type\", must be one of #{validator.allowable_values}."
      end
      @intervention_type = intervention_type
    end

    # Custom attribute writer method with validation
    # @param [Object] owner Value to be assigned
    def owner=(owner)
      if owner.nil?
        fail ArgumentError, 'owner cannot be nil'
      end

      pattern = Regexp.new(/^fr(\.[\w-]+){2,3}$/)
      if owner !~ pattern
        fail ArgumentError, "invalid value for \"owner\", must conform to the pattern #{pattern}."
      end

      @owner = owner
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          case_id == o.case_id &&
          sender_case_id == o.sender_case_id &&
          creation == o.creation &&
          perimeter == o.perimeter &&
          intervention_type == o.intervention_type &&
          qualification == o.qualification &&
          location == o.location &&
          initial_alert == o.initial_alert &&
          owner == o.owner &&
          patient == o.patient &&
          medical_note == o.medical_note &&
          decision == o.decision &&
          additional_information == o.additional_information
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [case_id, sender_case_id, creation, perimeter, intervention_type, qualification, location, initial_alert, owner, patient, medical_note, decision, additional_information].hash
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