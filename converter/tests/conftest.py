import os
from unittest.mock import MagicMock, patch

# Disable OpenTelemetry tracing during tests (no exporter connections, no Flask
# instrumentation). Must be set before the app module is imported below.
os.environ.setdefault("OTEL_SDK_DISABLED", "true")

# Patch init_db before the app module is imported, so it doesn't attempt
# to connect to MongoDB during tests.
with patch("converter.database.init_db") as mock_init_db:
    mock_init_db.side_effect = lambda app: app.extensions.update(  # noqa: F811
        {"mongodb_client": MagicMock(), "mongodb_db": MagicMock()}
    )
    from converter.converter import app  # noqa: F401
