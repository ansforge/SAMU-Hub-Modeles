from flask import Flask, request, jsonify
import json

from .utils import get_recipient, get_sender
from .cisu_converter import CISUConverter

app = Flask(__name__)

@app.route('/convert-version', methods=['POST'])
def convert_version():
    """Convert version endpoint"""
    if not request.is_json:
        return jsonify({'error': 'Content-Type must be application/json'}), 400
        
    data = request.get_json()
    return jsonify(data)

@app.route('/convert-cisu', methods=['POST'])
def convert_cisu():
    TO_CISU = "to_CISU"
    FROM_CISU = "from_CISU"

    """CISU conversion endpoint: back and forth between CISU and Health"""
    if not request.is_json:
        return jsonify({'error': 'Content-Type must be application/json'}), 400
    
    try:
        edxl_json = request.get_json()['edxl']
    except KeyError:
        return jsonify({'error': 'Message key not found'}), 400
    
    # Compute direction based on sender / recipient
    sender = get_sender(edxl_json)
    recipient = get_recipient(edxl_json)
    if sender.startswith('fr.health') and recipient.startswith('fr.health'):
        return jsonify({'error': 'Both sender and recipient are health'}), 400
    elif recipient.startswith('fr.fire'):
        direction = TO_CISU
    else:
        direction = FROM_CISU
    
    print(f"Converting {direction}")
    try:
        if direction == TO_CISU:
            result = CISUConverter.to_cisu(edxl_json)
        elif direction == FROM_CISU:
            result = CISUConverter.from_cisu(edxl_json)
        else:
            return jsonify({'error': 'Invalid direction parameter'}), 400
            
        return jsonify({'edxl': result})
        
    except Exception as e:
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080) 