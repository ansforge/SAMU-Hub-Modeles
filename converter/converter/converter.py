from flask import Flask, request, jsonify

from converter.conversion_strategy.cisu_conversion_strategy import cisu_conversion_strategy


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
    cisu_conversion = req_data.get('cisuConversion', False)

    if not source_version or not target_version or not edxl_json:
        return raise_error(
            f"Missing required fields: sourceVersion={source_version}, targetVersion={target_version}, edxl present={edxl_json is not None}"
        )

    if source_version != target_version:
        # ToDo: implement version conversion
        return raise_error(f"Source version {source_version} is not equal to target version {target_version}")

    if cisu_conversion:
        try:
            edxl_json = cisu_conversion_strategy(edxl_json, source_version)
        except ValueError as e:
            return raise_error(str(e))
        except Exception as e:
            return raise_error(str(e), 500)

    return jsonify({"edxl": edxl_json})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
