import logging
from pythonjsonlogger.json import JsonFormatter
from flask import has_request_context, g


# Using filter to add context variable: https://docs.python.org/3/howto/logging-cookbook.html#using-filters-to-impart-contextual-information
class DistributionContextFilter(logging.Filter):
    def filter(self, record):
        if has_request_context():
            record.distributionId = getattr(g, "distributionId", None)
        return True


def configure_logging():
    root = logging.getLogger()
    for h in root.handlers[:]:
        root.removeHandler(h)

    handler = logging.StreamHandler()

    formatter = JsonFormatter(
        "%(asctime)s %(levelname)s %(message)s %(distributionId)s",
        rename_fields={
            "asctime": "timestamp",
            "levelname": "level",
        },
    )
    handler.setFormatter(formatter)
    handler.addFilter(DistributionContextFilter())

    root.addHandler(handler)
    root.setLevel(logging.INFO)

    root.propagate = True
