import logging
import os
from opentelemetry import trace
from opentelemetry.exporter.otlp.proto.http.trace_exporter import OTLPSpanExporter
from opentelemetry.instrumentation.flask import FlaskInstrumentor
from opentelemetry.instrumentation.pymongo import PymongoInstrumentor
from opentelemetry.instrumentation.utils import suppress_instrumentation
from opentelemetry.sdk.resources import SERVICE_NAME, SERVICE_VERSION, Resource
from opentelemetry.sdk.trace import TracerProvider
from opentelemetry.sdk.trace.export import BatchSpanProcessor

from converter.utils import (
    extract_case_id,
    extract_message_content,
    extract_message_type_from_message_content,
    get_recipient,
    get_sender,
)

logger = logging.getLogger(__name__)

CASE_ID_ATTRIBUTE = "hubsante.case_id"
SENDER_ATTRIBUTE = "hubsante.sender"
RECIPIENT_ATTRIBUTE = "hubsante.recipient"
USE_CASE_ATTRIBUTE = "hubsante.use_case"
DISTRIBUTION_ID_ATTRIBUTE = "hubsante.distribution_id"

# Regexes matched against the request URL: probe/scrape endpoints get no Flask span.
EXCLUDED_URLS = "/health,/metrics"

untraced = suppress_instrumentation


def is_tracing_enabled() -> bool:
    return os.getenv("OTEL_SDK_DISABLED", "false").strip().lower() != "true"


def tag_current_span(edxl_json) -> None:

    span = trace.get_current_span()

    def use_case():
        return extract_message_type_from_message_content(
            extract_message_content(edxl_json)
        )

    def distribution_id():
        return edxl_json.get("distributionID")

    for attribute, getter in (
        (SENDER_ATTRIBUTE, lambda: get_sender(edxl_json)),
        (RECIPIENT_ATTRIBUTE, lambda: get_recipient(edxl_json)),
        (USE_CASE_ATTRIBUTE, use_case),
        (CASE_ID_ATTRIBUTE, lambda: extract_case_id(edxl_json)),
        (DISTRIBUTION_ID_ATTRIBUTE, distribution_id),
    ):
        try:
            value = getter()
        except Exception:
            value = None
        if value:
            span.set_attribute(attribute, value)


def configure_tracing(app) -> None:
    if not is_tracing_enabled():
        logger.info("OpenTelemetry tracing disabled via OTEL_SDK_DISABLED")
        return

    resource = Resource.create(
        {
            SERVICE_NAME: os.getenv("OTEL_SERVICE_NAME", "converter"),
            SERVICE_VERSION: os.getenv("CONVERTER_VERSION", "unknown"),
        }
    )
    provider = TracerProvider(resource=resource)
    provider.add_span_processor(BatchSpanProcessor(OTLPSpanExporter()))
    trace.set_tracer_provider(provider)

    FlaskInstrumentor().instrument_app(app, excluded_urls=EXCLUDED_URLS)
    PymongoInstrumentor().instrument()
    logger.info(
        f"OpenTelemetry tracing configured for service '{resource.attributes.get(SERVICE_NAME)}'"
    )
