from typing import Dict, Any
import copy
import random
import string
from datetime import datetime
from .utils import add_object_to_initial_alert_notes, delete_paths, format_object, get_recipient, get_sender

class CISUConverterV3:
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
        "owner",
        "patient",
        "medicalNote",
        "decision",
        "perimeter",
        "interventionType",
        "qualification.origin",
        "qualification.details",
        "location.detailedAddress.highway",
        "location.geometry.point.isAml"
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
        output_usecase_json = copy.deepcopy(input_usecase_json)

        # - Updates
        # Set owner to target recipient
        output_usecase_json['owner'] = get_recipient(input_json)

        # Handle victims information
        if input_usecase_json.get('qualification', {}).get('victims'):
            victims_text = format_object(input_usecase_json['qualification']['victims'])
            add_object_to_initial_alert_notes(output_usecase_json, victims_text)

        # Location
        if input_usecase_json.get('location', {}).get('city', {}).get('detail'):
            output_usecase_json['location']['freetext']=input_usecase_json['location']['city']['detail']

        # Qualification - case detail priority
        if input_usecase_json.get('initialAlert', {}).get('reporting') == 'ATTENTION':
            if 'details' not in output_usecase_json['qualification']:
                output_usecase_json['qualification']['details']={}
            output_usecase_json['qualification']['details']['priority']= 'P1'

        # Initial Alert - free text information
        if input_usecase_json.get('initialAlert', {}).get('attachment'):
            attachments = format_object(input_usecase_json['initialAlert']['attachment'])
            add_object_to_initial_alert_notes(output_usecase_json,attachments)

        if input_usecase_json.get('initialAlert', {}).get('callTaker'):
            call_taker = format_object(input_usecase_json['initialAlert']['callTaker'])
            add_object_to_initial_alert_notes(output_usecase_json, call_taker)

        if input_usecase_json.get('initialAlert', {}).get('freetext'):
            description = format_object(input_usecase_json['initialAlert']['freetext'])
            add_object_to_initial_alert_notes(output_usecase_json, description)

        if input_usecase_json.get('newAlert'):
            new_alert = format_object(input_usecase_json.get('newAlert'))
            add_object_to_initial_alert_notes(output_usecase_json, new_alert)

        # - Deletions - must to be the last step
        delete_paths(output_usecase_json, cls.CISU_PATHS_TO_DELETE)

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
        output_usecase_json = copy.deepcopy(input_usecase_json)

        # - Deletions
        delete_paths(output_usecase_json, cls.HEALTH_PATHS_TO_DELETE)

        # - Updates
        # Victims
        nb_victims = len(input_usecase_json['patient']) if input_usecase_json['patient'] else 0
        output_usecase_json['qualification']['victims'] = {'count': '0' if nb_victims == 0 else ('1' if nb_victims == 1 else ('PLUSIEURS' if nb_victims < 5 else 'BEAUCOUP'))}

        # Country: based on INSEE code
        input_insee_code = input_usecase_json.get('location', {}).get('city', {}).get('inseeCode')
        if input_insee_code:
            # ToDo: get country from INSEE code | Ref.: https://www.insee.fr/fr/information/7766585#titre-bloc-25
            output_usecase_json['location']['country'] = 'FR'
        else:
            output_usecase_json['location']['country'] = 'FR' # Default value

        # Set reference version
        # ToDo: pass this by ConfigMap and based on the version of the model
        output_usecase_json['referenceVersion'] = "3.0"

        # CallTaker
        sender_id = get_sender(input_json)
        crra_code = sender_id[len("fr.health."):]  # fr.health.samu780(.xxx) -> samu780(.xxx)
        output_usecase_json['initialAlert']['callTaker'] = {
            'organization': sender_id,
            'controlRoom': crra_code.replace('.', '').title()  # samu780(.xxx) -> Samu780( Xxx)
        }

        # Generate unique IDs
        timestamp = datetime.now().strftime('%Y%m%d%H%M%S')
        random_str = ''.join(random.choices(string.ascii_lowercase + string.digits, k=4))

        if 'location' in output_usecase_json:
            output_usecase_json['location']['locID'] = f"LOC-{timestamp}-{random_str}"

        # InitialAlert
        if 'initialAlert' in output_usecase_json:
            # Set initialAlert ID, reception and reporting
            output_usecase_json['initialAlert']['id'] = f"INAL-{timestamp}-{random_str}"
            output_usecase_json['initialAlert']['reception'] = input_usecase_json.get('creation')
            output_usecase_json['initialAlert']['reporting'] = 'ATTENTION' if input_usecase_json.get('caseDetails', {}).get('priority') in ['P0', 'P1'] else 'STANDARD'
            # Copy output case qualification and location to initialAlert
            output_usecase_json['initialAlert']['qualification'] = copy.deepcopy(output_usecase_json.get('qualification'))
            output_usecase_json['initialAlert']['location'] = copy.deepcopy(output_usecase_json.get('location'))

        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCase'] = output_usecase_json
        return output_json
