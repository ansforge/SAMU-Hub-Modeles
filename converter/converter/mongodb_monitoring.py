import logging

from prometheus_client import Gauge
from pymongo import monitoring

logger = logging.getLogger(__name__)

# "livemin": with several gunicorn workers, report 0 as soon as one live worker is down.
MONGODB_UP = Gauge(
    "converter_mongodb_up",
    "1 if the MongoDB connection is healthy, 0 otherwise",
    multiprocess_mode="livemin",
)


class MongoHeartbeatLogger(monitoring.ServerHeartbeatListener):
    """Logs MongoDB connection loss/recovery and exposes it as the converter_mongodb_up
    gauge, based on PyMongo's own background server monitoring, instead of polling
    MongoDB ourselves."""

    def __init__(self) -> None:
        self._is_up = True

    def started(self, event: monitoring.ServerHeartbeatStartedEvent) -> None:
        pass

    def succeeded(self, event: monitoring.ServerHeartbeatSucceededEvent) -> None:
        MONGODB_UP.set(1)
        if not self._is_up:
            logger.info("[MongoDB] Connection restored", extra={"mongodb_status": "UP"})
        self._is_up = True

    def failed(self, event: monitoring.ServerHeartbeatFailedEvent) -> None:
        MONGODB_UP.set(0)
        if self._is_up:
            logger.error(
                f"[MongoDB] Connection lost: {event.reply}",
                extra={"mongodb_status": "DOWN"},
            )
        self._is_up = False


def register_mongodb_monitoring() -> None:
    """Register the heartbeat logger.

    Must be called before any MongoClient is created: PyMongo's monitoring listeners
    are process-global and only apply to clients created afterwards.
    """
    monitoring.register(MongoHeartbeatLogger())
