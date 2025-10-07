from typing import Dict, Any

from converter.utils import get_field_value, update_json_value, delete_paths
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.conversion_mixin import ConversionMixin
from converter.versions.geo_positions_update.geo_positions_update_constants import (
    GeoPositionsUpdateConstants,
)
from converter.versions.utils import convert_to_float, convert_to_str


class GeoPositionsUpdateConverter(BaseMessageConverter, ConversionMixin):
    @staticmethod
    def get_message_type():
        return "geoPositionsUpdate"

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)
        delete_paths(output_use_case_json, ["position[].receptionDatetime"])

        geo_positions = get_field_value(
            output_use_case_json, GeoPositionsUpdateConstants.POSITION_PATH
        )
        new_geo_positions = []
        for position in geo_positions:
            coord = position.get(GeoPositionsUpdateConstants.COORD_KEY, [])
            if len(coord) > 0:
                coord_value = coord[0]
            else:
                coord_value = None

            new_position: Dict[str, Any] = {
                **position,
                GeoPositionsUpdateConstants.COORD_KEY: coord_value,
            }

            cap_str = position.get(GeoPositionsUpdateConstants.CAP_KEY)
            cap_float = convert_to_float(cap_str)

            if cap_float is not None:
                new_position[GeoPositionsUpdateConstants.CAP_KEY] = cap_str
            else:
                new_position.pop(GeoPositionsUpdateConstants.CAP_KEY, None)

            new_geo_positions.append(new_position)

        update_json_value(
            output_use_case_json,
            GeoPositionsUpdateConstants.POSITION_PATH,
            new_geo_positions,
        )

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        geo_positions = get_field_value(
            output_use_case_json, GeoPositionsUpdateConstants.POSITION_PATH
        )
        new_geo_positions = []
        for position in geo_positions:
            coordinates_array = []
            if GeoPositionsUpdateConstants.COORD_KEY in position:
                coordinates_array.append(
                    position[GeoPositionsUpdateConstants.COORD_KEY]
                )
            new_position: Dict[str, Any] = {
                **position,
                GeoPositionsUpdateConstants.COORD_KEY: coordinates_array,
            }

            cap_float = position.get(GeoPositionsUpdateConstants.CAP_KEY)
            cap_str = convert_to_str(cap_float)
            if cap_str is not None:
                new_position[GeoPositionsUpdateConstants.CAP_KEY] = cap_str
            else:
                new_position.pop(GeoPositionsUpdateConstants.CAP_KEY, None)

            new_geo_positions.append(new_position)

        update_json_value(
            output_use_case_json,
            GeoPositionsUpdateConstants.POSITION_PATH,
            new_geo_positions,
        )

        return cls.format_output_json(output_json, output_use_case_json)
