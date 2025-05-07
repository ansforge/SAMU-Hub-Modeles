from typing import Dict, Any

class ReferenceConverter:

    @classmethod
    def upgrade(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        return input_json

    @classmethod
    def downgrade(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        return input_json