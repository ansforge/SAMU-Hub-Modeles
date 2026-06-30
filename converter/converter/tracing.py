import logging
import os

logger = logging.getLogger(__name__)

CASE_ID_ATTRIBUTE = "hubsante.case_id"


def is_tracing_enabled() -> bool:
    return os.getenv("OTEL_SDK_DISABLED", "false").strip().lower() != "true"


def configure_tracing(app) -> None:
    if not is_tracing_enabled():
        logger.info("OpenTelemetry tracing disabled via OTEL_SDK_DISABLED")
        return

    from opentelemetry import trace
    from opentelemetry.exporter.otlp.proto.http.trace_exporter import OTLPSpanExporter
    from opentelemetry.instrumentation.flask import FlaskInstrumentor
    from opentelemetry.instrumentation.pymongo import PymongoInstrumentor
    from opentelemetry.sdk.resources import SERVICE_NAME, SERVICE_VERSION, Resource
    from opentelemetry.sdk.trace import TracerProvider
    from opentelemetry.sdk.trace.export import BatchSpanProcessor

    resource = Resource.create(
        {
            SERVICE_NAME: os.getenv("OTEL_SERVICE_NAME", "converter"),
            SERVICE_VERSION: os.getenv("CONVERTER_VERSION", "unknown"),
        }
    )
    provider = TracerProvider(resource=resource)
    provider.add_span_processor(BatchSpanProcessor(OTLPSpanExporter()))
    trace.set_tracer_provider(provider)

    FlaskInstrumentor().instrument_app(app)
    PymongoInstrumentor().instrument()
    logger.info("OpenTelemetry tracing configured for service 'converter'")
