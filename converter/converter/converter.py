from flask import Flask, request, jsonify
import json
from .cisu_converter import CISUConverter

app = Flask(__name__)

def convert_json_forward(input_json):
    """Convert JSON in forward direction applying business rules"""
    try:
        return CISUConverter.forward(input_json)
    except Exception as e:
        # Log error here if needed
        raise ValueError(f"Failed to convert CISU format: {str(e)}")

def convert_json_backward(input_json):
    """Convert JSON in backward direction applying business rules"""
    # Deep copy to avoid modifying input
    output = json.loads(json.dumps(input_json))
    
    # Apply reverse business logic transformations
    if 'status' in output:
        # Reverse status mapping
        status_mapping = {
            'NOUVEAU': 'NEW',
            'EN_COURS': 'IN_PROGRESS',
            'TERMINE': 'COMPLETED'
        }
        output['status'] = status_mapping.get(output['status'], output['status'])
        
    if 'priority' in output:
        # Convert priority back to English scale
        priority_mapping = {
            'P3': 'LOW',
            'P2': 'MEDIUM',
            'P1': 'HIGH'
        }
        output['priority'] = priority_mapping.get(output['priority'], output['priority'])

    return output

@app.route('/convert-version', methods=['POST'])
def convert_version():
    """Convert version endpoint"""
    if not request.is_json:
        return jsonify({'error': 'Content-Type must be application/json'}), 400
        
    data = request.get_json()
    return jsonify(data)

@app.route('/convert-cisu', methods=['POST'])
def convert_cisu():
    """CISU conversion endpoint: back and forth between CISU and Health"""
    if not request.is_json:
        return jsonify({'error': 'Content-Type must be application/json'}), 400
        
    data = request.get_json()
    direction = request.args.get('direction', 'forward')
    
    try:
        if direction == 'forward':
            result = convert_json_forward(data)
        elif direction == 'backward':
            result = convert_json_backward(data)
        else:
            return jsonify({'error': 'Invalid direction parameter'}), 400
            
        return jsonify(result)
        
    except Exception as e:
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000) 