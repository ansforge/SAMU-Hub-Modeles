import logging
import os
from pythonjsonlogger.json import JsonFormatter
from flask import has_request_context, g
from enum import Enum


class LoggingKeys(Enum):
    DISTRIBUTION_ID = "distributionId"
    SENDER_ID = "senderId"
    RECIPIENT_ID = "recipientId"
    MESSAGE_TYPE = "messageType"


# Using filter to add context variable: https://docs.python.org/3/howto/logging-cookbook.html#using-filters-to-impart-contextual-information
class DistributionContextFilter(logging.Filter):
    def filter(self, record):
        if has_request_context():
            for key in LoggingKeys:
                setattr(record, key.value, getattr(g, key.value, None))
        return True


def configure_logging():
    root = logging.getLogger()
    for h in root.handlers[:]:
        root.removeHandler(h)

    handler = logging.StreamHandler()

    formatter = JsonFormatter(
        "%(asctime)s %(levelname)s %(message)s",
        rename_fields={
            "asctime": "timestamp",
            "levelname": "level",
        },
    )
    handler.setFormatter(formatter)
    handler.addFilter(DistributionContextFilter())

    root.addHandler(handler)

    log_level = os.getenv("LOG_LEVEL", logging.getLevelName(logging.INFO)).upper()
    root.setLevel(log_level)

    root.propagate = True
