import logging
from pythonjsonlogger.json import JsonFormatter


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

    root.addHandler(handler)
    root.setLevel(logging.INFO)

    root.propagate = True
