from flask import Flask, request, jsonify, g
import logging
import os
from prometheus_flask_exporter.multiprocess import GunicornInternalPrometheusMetrics
from prometheus_flask_exporter import PrometheusMetrics

from converter.conversion_strategy.conversion_strategy import conversion_strategy
from converter.utils import (
    get_sender,
    get_recipient,
    extract_message_type_from_message_content,
    extract_message_content,
)
from converter.logging_config import configure_logging, LoggingKeys
from converter.database import init_db, get_client

configure_logging()

app = Flask(__name__)
init_db(app)

is_prod = os.getenv("FLASK_ENV") == "production"

if is_prod:
    metrics = GunicornInternalPrometheusMetrics(app)
else:
    metrics = PrometheusMetrics(app)

logger = logging.getLogger(__name__)


def raise_error(message, code: int = 400):
    logger.error(message)
    return jsonify({"error": message}), code


def extract_message_type_from_payload():
    try:
        data = request.get_json(silent=True) or {}
        edxl_json = data.get("edxl")
        message_content = extract_message_content(edxl_json)
        return extract_message_type_from_message_content(message_content)
    except Exception:
        return "unknownMessageType"


@app.route("/convert", methods=["POST"])
@metrics.do_not_track()
@metrics.histogram(
    "conversion_duration_seconds",
    "The number of seconds it took to the /convert endpoint to answer",
    labels={
        "status": lambda r: r.status_code,
        "message_type": extract_message_type_from_payload,
    },
)
def convert():
    if not request.is_json:
        return raise_error("Content-Type must be application/json")

    req_data = request.get_json()
    logger.debug(f"Received conversion request: {req_data}")
    source_version = req_data.get("sourceVersion")
    target_version = req_data.get("targetVersion")
    edxl_json = req_data.get("edxl")
    is_cisu_conversion = req_data.get("cisuConversion", False)

    # Store data in request context to be used in logs
    try:
        setattr(g, LoggingKeys.DISTRIBUTION_ID.value, edxl_json.get("distributionID"))
        setattr(g, LoggingKeys.SENDER_ID.value, get_sender(edxl_json))
        setattr(g, LoggingKeys.RECIPIENT_ID.value, get_recipient(edxl_json))
        message_content = extract_message_content(edxl_json)
        setattr(
            g,
            LoggingKeys.MESSAGE_TYPE.value,
            extract_message_type_from_message_content(message_content),
        )
    except Exception:
        pass

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
