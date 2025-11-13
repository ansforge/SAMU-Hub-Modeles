from flask import Flask, request, jsonify
import logging
from converter.conversion_strategy.conversion_strategy import conversion_strategy
from .logging_config import configure_logging


configure_logging()

app = Flask(__name__)
logger = logging.getLogger(__name__)


def raise_error(message, code: int = 400):
    logger.error(message)
    return jsonify({"error": message}), code


@app.route("/convert", methods=["POST"])
def convert():
    if not request.is_json:
        return raise_error("Content-Type must be application/json")

    req_data = request.get_json()
    logger.debug(f"Received conversion request: {req_data}")
    source_version = req_data.get("sourceVersion")
    target_version = req_data.get("targetVersion")
    edxl_json = req_data.get("edxl")
    is_cisu_conversion = req_data.get("cisuConversion", False)

    if not source_version or not target_version or not edxl_json:
        return raise_error(
            f"Missing required fields: sourceVersion={source_version}, targetVersion={target_version}, edxl present={edxl_json is not None}"
        )

    try:
        edxl_json = conversion_strategy(
            edxl_json, source_version, target_version, is_cisu_conversion
        )
    except ValueError as e:
        return raise_error(str(e))
    except Exception as e:
        return raise_error(str(e), 500)

    return jsonify({"edxl": edxl_json})


@app.route("/health", methods=["GET"])
def health_check():
    return jsonify(
        {
            "status": "UP",
        }
    ), 200


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080)
