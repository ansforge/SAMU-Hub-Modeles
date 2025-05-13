version_order_list = ["v1", "v2", "v3"]

class BaseMessageConverter:
    def __init__(self, message_type):
        self.message_type = message_type

    def convert(self, source_version, target_version, edxl_json):
        source_version_index = -1
        try:
            source_version_index = version_order_list.index(source_version)
        except ValueError:
            raise ValueError(f"Unknown source version {source_version}. Must be one of: {version_order_list}")
    
        target_version_index = -1
        try:
            target_version_index = version_order_list.index(target_version)
        except ValueError:
            raise ValueError(f"Unknown target version {target_version}. Must be one of: {version_order_list}")

        # No conversion needed
        if source_version_index == target_version_index:
            return edxl_json
        
        try:
            # Convert directly if version are consecutive
            if abs(source_version_index - target_version_index) == 1:
                if source_version_index < target_version_index:
                    return self.upgrade(source_version, source_version_index, edxl_json)
                else:
                    return self.downgrade(source_version, source_version_index, edxl_json)

            # Convert message to consecutive version
            version_delta = 1 if source_version_index < target_version_index else -1
            converted_edxl_json = self.convert(
                source_version,
                version_order_list[source_version_index + version_delta],
                edxl_json
            )

            # Recursively call convert with the new source_version
            return self.convert(
                version_order_list[source_version_index + version_delta],
                target_version, 
                converted_edxl_json
            )
        except ValueError as err:
            print(f"[ERROR] {err}")
            self.raise_conversion_not_implemented_error(source_version, target_version)
            

    def upgrade(self, source_version, source_version_index, edxl_json):
        if source_version == "v1":
            return self.convert_v1_to_v2(edxl_json)
        elif source_version == "v2":
            return self.convert_v2_to_v3(edxl_json)
        else:
            self.raise_conversion_impossible_error(source_version, version_order_list[source_version_index + 1])
    
    def downgrade(self, source_version, source_version_index, edxl_json):
        if source_version == "v2":
            return self.convert_v2_to_v1(edxl_json)
        elif source_version == "v3":
            return self.convert_v3_to_v2(edxl_json)
        else:
            self.raise_conversion_impossible_error(source_version, version_order_list[source_version_index - 1])

    def convert_v1_to_v2(self, edxl_json):
        self.raise_conversion_not_implemented_error("v1", "v2")
    
    def convert_v2_to_v1(self, edxl_json):
        self.raise_conversion_not_implemented_error("v2", "v1")

    def convert_v2_to_v3(self, edxl_json):
        self.raise_conversion_not_implemented_error("v2", "v3")
    
    def convert_v3_to_v2(self, edxl_json):
        self.raise_conversion_not_implemented_error("v3", "v2")

    def raise_conversion_not_implemented_error(self, source_version, target_version):
        raise ValueError(f"Version conversion from {source_version} to {target_version} for message type '{self.message_type}' is currently not implemented.")

    def raise_conversion_impossible_error(self, source_version, target_version):
        raise ValueError(f"Version conversion from {source_version} to {target_version} is not possible.")