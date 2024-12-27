from typing import Dict, Any
import json
import copy
from hubsante_model import CreateCaseWrapper, CreateCaseHealth
from .utils import delete_paths, format_object

class CISUConverter:
    """Handles CISU format conversions"""
    
    PATHS_TO_DELETE = [
        "qualification.victims",
        "attachment",
        "referenceVersion", 
        "freetext",
        "location.geometry.point.coord.heading",
        "location.geometry.point.coord.speed",
        "location.geometry.sketch",
        "location.country",
        "location.ID",
        "location.locLabel",
        "location.city.detail",
        "initialAlert.id",
        "initialAlert.reporting",
        "initialAlert.qualification",
        "initialAlert.location",
        "initialAlert.callTaker",
        "newAlert"
    ]

    @classmethod
    def forward(cls, input_json: Dict[str, Any], owner: str = 'fr.health.samu950') -> Dict[str, Any]:
        """
        Convert from CISU to Health format
        
        Args:
            input_json: Input CISU JSON
            owner: Owner identifier
            
        Returns:
            Converted Health format JSON
        """
        # Create independent copy
        if 'createCase' not in input_json:
            raise ValueError("Input JSON must contain 'createCase' key")
            
        create_case = input_json['createCase']
        output_json = copy.deepcopy(create_case)
        
        # Parse input with model for validation
        input_message = CreateCaseWrapper.from_dict(input_json).create_case
        
        # - Deletions
        delete_paths(output_json, cls.PATHS_TO_DELETE)
        
        # - Updates
        # Set owner
        output_json['owner'] = owner
            
        # Handle victims information
        if ('qualification' in create_case and 
            'victims' in create_case['qualification'] and 
            'initialAlert' in create_case):
            
            if 'notes' not in output_json['initialAlert']:
                output_json['initialAlert']['notes'] = []
                
            victims_text = format_object(input_message.qualification.victims)
            output_json['initialAlert']['notes'].append({"freetext": victims_text})

        # ToDo: implement all rules

        # Validate output with model
        CreateCaseHealth.from_dict(output_json)
        
        return output_json 