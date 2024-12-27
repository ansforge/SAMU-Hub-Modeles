from typing import Dict, Any
import json
import copy
from hubsante_model import CreateCase, CreateCaseHealth
from .utils import delete_paths, format_object, get_recipient

class CISUConverter:
    """Handles CISU format conversions"""
    
    CISU_PATHS_TO_DELETE = [
        "qualification.victims",
        "referenceVersion", 
        "freetext",
        "location.geometry.point.coord.heading",
        "location.geometry.point.coord.speed",
        "location.geometry.sketch",
        "location.country",
        "location.locID",
        "location.locLabel",
        "location.city.detail",
        "initialAlert.id",
        "initialAlert.attachment",
        "initialAlert.reporting",
        "initialAlert.qualification",
        "initialAlert.location",
        "initialAlert.callTaker",
        "newAlert"
    ]

    HEALTH_PATHS_TO_DELETE = [
        "owner"
    ]

    @classmethod
    def from_cisu(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        """
        Convert from CISU to Health format
        
        Args:
            input_json: Input EDXL CISU JSON
            
        Returns:
            Converted EDXL Health JSON
        """
        # Create independent envelope copy without usecase for output
        output_json = copy.deepcopy(input_json)
        if 'createCase' not in input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {}):
            raise ValueError("Input JSON must contain 'createCase' key")
        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCase']
            
        # Create independent usecase copy for output
        input_usecase_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCase']
        # - Parse input with model for validation and easier manipulation
        input_usecase = CreateCase.from_dict(input_usecase_json)
        output_usecase_json = copy.deepcopy(input_usecase_json)

        # - Deletions
        delete_paths(output_usecase_json, cls.CISU_PATHS_TO_DELETE)
        
        # - Updates
        # Set owner to target recipient
        output_usecase_json['owner'] = get_recipient(input_json)
            
        # Handle victims information
        if ('qualification' in input_usecase and 
            'victims' in input_usecase['qualification'] and 
            'initialAlert' in input_usecase):
            
            if 'notes' not in output_json['initialAlert']:
                output_usecase_json['initialAlert']['notes'] = []
                
            victims_text = format_object(input_usecase.qualification.victims)
            output_usecase_json['initialAlert']['notes'].append({"freetext": victims_text})

        # ToDo: implement all rules

        # Validate output with model
        CreateCaseHealth.from_dict(output_usecase_json)
        
        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth'] = output_usecase_json
        return output_json

    @classmethod
    def to_cisu(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        """
        Convert from Health to CISU format
        
        Args:
            input_json: Input EDXL Health JSON
            
        Returns:
            Converted EDXL CISU JSON
        """
        # Create independent envelope copy without usecase for output
        output_json = copy.deepcopy(input_json)
        if 'createCaseHealth' not in input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {}):
            raise ValueError("Input JSON must contain 'createCaseHealth' key")
        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']
            
        # Create independent usecase copy for output
        input_usecase_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']
        # - Parse input with model for validation and easier manipulation
        input_usecase = CreateCaseHealth.from_dict(input_usecase_json)
        output_usecase_json = copy.deepcopy(input_usecase_json)

        # - Deletions
        delete_paths(output_usecase_json, cls.HEALTH_PATHS_TO_DELETE)
        
        # - Updates  
        # ToDo: implement all rules (deletions and updates)

        # Validate output with model
        CreateCase.from_dict(output_usecase_json)
        
        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCase'] = output_usecase_json
        return output_json
