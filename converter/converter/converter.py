from flask import Flask, request, jsonify

from converter.conversion_strategy.conversion_strategy import conversion_strategy

app = Flask(__name__)

def raise_error(message, code: int = 400):
    """Helper function to log and return error responses"""
    print(f"[ERROR] {message}")
    return jsonify({'error': message}), code

@app.route('/convert', methods=['POST'])
def convert():
    if not request.is_json:
        return raise_error('Content-Type must be application/json')

    req_data = request.get_json()
    source_version = req_data.get('sourceVersion')
    target_version = req_data.get('targetVersion')
    edxl_json = req_data.get('edxl')
    is_cisu_conversion = req_data.get('cisuConversion', False)

    if not source_version or not target_version or not edxl_json:
        return raise_error(
            f"Missing required fields: sourceVersion={source_version}, targetVersion={target_version}, edxl present={edxl_json is not None}"
        )

    try:
        edxl_json = conversion_strategy(edxl_json, source_version, target_version, is_cisu_conversion)
    except ValueError as e:
        return raise_error(str(e))
    except Exception as e:
        return raise_error(str(e), 500)

    return jsonify({"edxl": edxl_json})

@app.route('/health', methods=['GET'])
def health_check():
    converter_name = "SAMU Hub Converter"
    up_status = "UP"
    down_status = "DOWN"
    try:
        health_data = {
            "status": up_status,
            "service": converter_name,
        }
        return jsonify(health_data), 200
    except Exception as e:
        error_data = {
            "status": down_status,
            "service": converter_name,
            "error": str(e)
        }
        return jsonify(error_data), 503

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
