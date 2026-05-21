from flask import Flask, request, jsonify, g
import logging
import os
from prometheus_flask_exporter.multiprocess import GunicornInternalPrometheusMetrics
from prometheus_flask_exporter import PrometheusMetrics
from pymongo import timeout
from pydantic import BaseModel, ConfigDict, Field, ValidationError
from typing import Any

from converter.conversion_strategy.conversion_strategy import conversion_strategy
from converter.utils import (
    get_sender,
    get_recipient,
    extract_message_type_from_message_content,
    extract_message_content,
)
from converter.logging_config import configure_logging, LoggingKeys
from converter.database import init_db, get_db
from converter.constants import ConversionType

configure_logging()

app = Flask(__name__)
init_db(app)

is_prod = os.getenv("FLASK_ENV") == "production"

if is_prod:
    metrics = GunicornInternalPrometheusMetrics(app)
else:
    metrics = PrometheusMetrics(app)

logger = logging.getLogger(__name__)


class ConvertRequest(BaseModel):
    model_config = ConfigDict(extra="forbid")
    source_version: str = Field(alias="sourceVersion")
    target_version: str = Field(alias="targetVersion")
    edxl: dict[str, Any]
    type: ConversionType


def raise_error(message, code: int = 400):
    logger.error(message)
    return jsonify({"error": message}), code


def format_validation_error(e):
    errors = e.errors()
    missing = [err["loc"][0] for err in errors if err["type"] == "missing"]
    if missing:
        return f"Missing required fields: {', '.join(str(f) for f in missing)}"

    extra = [err["loc"][0] for err in errors if err["type"] == "extra_forbidden"]
    if extra:
        return f"Unknown fields: {', '.join(str(f) for f in extra)}"

    for err in errors:
        if err["loc"][0] == "type":
            return f"Conversion type must be one of {[t.value for t in ConversionType]}"

    return "Invalid request payload"


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
    try:
        req_data = ConvertRequest.model_validate(request.get_json())
    except ValidationError as e:
        return raise_error(format_validation_error(e))

    logger.debug(f"Received conversion request: {req_data}")

    source_version = req_data.source_version
    target_version = req_data.target_version
    edxl_json = req_data.edxl
    conversion_type = req_data.type

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

    try:
        converted_messages = conversion_strategy(
            edxl_json, source_version, target_version, conversion_type
        )
    except ValueError as e:
        return raise_error(str(e))
    except Exception as e:
        return raise_error(str(e), 500)

    return jsonify({"converted_messages": converted_messages})


@app.route("/health", methods=["GET"])
def health_check():
    try:
        with timeout(5):
            get_db().command("ping")
            db_status = "UP"
    except Exception:
        db_status = "DOWN"

    status = "UP" if db_status == "UP" else "DEGRADED"
    return jsonify(
        {
            "status": status,
            "components": {
                "mongodb": db_status,
            },
        }
    ), 200


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080)
