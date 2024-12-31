from flask import Flask, request, jsonify

from .utils import get_recipient, get_sender
from .cisu_converter import CISUConverterV3

app = Flask(__name__)

def raise_error(message, code: int = 400):
    """Helper function to log and return error responses"""
    print(f"[ERROR] {message}")
    return jsonify({'error': message}), code

# @app.route('/convert-version', methods=['POST'])
# def convert_version():
#     """Convert version endpoint"""
#     if not request.is_json:
#         return jsonify({'error': 'Content-Type must be application/json'}), 400
        
#     data = request.get_json()
#     return jsonify(data)

@app.route('/convert', methods=['POST'])
def convert():
    if not request.is_json:
        return raise_error('Content-Type must be application/json')

    req_data = request.get_json()
    source_version = req_data.get('sourceVersion')
    target_version = req_data.get('targetVersion')
    edxl_json = req_data.get('edxl')
    cisu_conversion = req_data.get('cisuConversion', False)

    if not source_version or not target_version or not edxl_json:
        return raise_error(
            f"Missing required fields: sourceVersion={source_version}, targetVersion={target_version}, edxl present={edxl_json is not None}"
        )

    if cisu_conversion:
        try:
            edxl_json = convert_cisu(edxl_json, source_version)
        except ValueError as e:
            return raise_error(str(e))
        except Exception as e:
            return raise_error(str(e), 500)

    if source_version != target_version:
        # ToDo: implement version conversion
        return raise_error(f"Source version {source_version} is not equal to target version {target_version}")

    return jsonify({"edxl": edxl_json})


def convert_cisu(edxl_json, version):
    """CISU conversion endpoint: back and forth between CISU and Health"""
    TO_CISU = "to_CISU"
    FROM_CISU = "from_CISU"
    converters = {
        'v3': CISUConverterV3
    }
    
    # Compute direction based on sender / recipient
    sender = get_sender(edxl_json)
    recipient = get_recipient(edxl_json)
    if sender.startswith('fr.health') and recipient.startswith('fr.health'):
        raise ValueError(f'Both sender and recipient are health: {sender} -> {recipient}')
    elif sender.startswith('fr.health'):
        direction = TO_CISU
    else:
        direction = FROM_CISU

    if version not in converters:
        raise ValueError(f"Invalid version {version} for CISU conversion")
    converter = converters[version]
    print(f"Converting {direction} {version}")
    
    if direction == TO_CISU:
        return converter.to_cisu(edxl_json)
    elif direction == FROM_CISU:
        return converter.from_cisu(edxl_json)
    else:
        raise ValueError('Invalid direction parameter')

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
