import logging
import os
import threading

from prometheus_client import Gauge
from pymongo import monitoring

logger = logging.getLogger(__name__)

# Ensure the Prometheus multiprocess directory exists before creating the Gauge.
_multiproc_dir = os.getenv("PROMETHEUS_MULTIPROC_DIR")
if _multiproc_dir:
    os.makedirs(_multiproc_dir, exist_ok=True)

# "livemin": with several gunicorn workers, report 0 as soon as one live worker is down.
MONGODB_UP = Gauge(
    "converter_mongodb_up",
    "1 if the MongoDB connection is healthy, 0 otherwise",
    multiprocess_mode="livemin",
)


def _format_node(connection_id) -> str:
    if isinstance(connection_id, tuple) and len(connection_id) == 2:
        return f"{connection_id[0]}:{connection_id[1]}"
    return str(connection_id)


class MongoHeartbeatLogger(monitoring.ServerHeartbeatListener):
    """Logs MongoDB connection loss/recovery and exposes it as the converter_mongodb_up
    gauge, based on PyMongo's own background server monitoring, instead of polling
    MongoDB ourselves.

    Heartbeats are received from every node of the replica set. MongoDB is considered
    up as long as at least one node answers; a single unreachable node (e.g. during the
    managed backup) is only logged as a warning."""

    def __init__(self) -> None:
        self._lock = threading.Lock()
        self._nodes: dict[str, bool] = {}
        self._is_up = True
        self._established = False

    def started(self, event: monitoring.ServerHeartbeatStartedEvent) -> None:
        pass

    def succeeded(self, event: monitoring.ServerHeartbeatSucceededEvent) -> None:
        self._record(event.connection_id, True, None)

    def failed(self, event: monitoring.ServerHeartbeatFailedEvent) -> None:
        self._record(event.connection_id, False, event.reply)

    def _record(self, connection_id, node_up: bool, reply) -> None:
        node = _format_node(connection_id)
        with self._lock:
            previous = self._nodes.get(node)
            self._nodes[node] = node_up
            cluster_up = any(self._nodes.values())
            cluster_changed = cluster_up != self._is_up
            first_connection = cluster_up and not self._established
            self._established = self._established or cluster_up
            self._is_up = cluster_up
            nodes_state = {n: "UP" if up else "DOWN" for n, up in self._nodes.items()}
            MONGODB_UP.set(1 if cluster_up else 0)

        # A node seen for the first time as UP is not a change worth logging.
        node_changed = previous != node_up and not (previous is None and node_up)
        summary = ", ".join(f"{n}={s}" for n, s in nodes_state.items())

        if cluster_changed and cluster_up:
            logger.info(
                f"[MongoDB] Connection restored | nodes: {summary}",
                extra={"mongodb_status": "UP", "mongodb_nodes": nodes_state},
            )
        elif first_connection:
            logger.info(
                f"[MongoDB] Connection established | nodes: {summary}",
                extra={"mongodb_status": "UP", "mongodb_nodes": nodes_state},
            )
        elif cluster_changed:
            logger.error(
                f"[MongoDB] Connection lost: {reply} | nodes: {summary}",
                extra={"mongodb_status": "DOWN", "mongodb_nodes": nodes_state},
            )
        elif node_changed:
            all_up = all(s == "UP" for s in nodes_state.values())
            message = (
                f"[MongoDB] Node {node} restored | nodes: {summary}"
                if node_up
                else f"[MongoDB] Node {node} unreachable: {reply} | nodes: {summary}"
            )
            log = logger.info if all_up else logger.warning
            log(message, extra={"mongodb_nodes": nodes_state})


def register_mongodb_monitoring() -> None:
    """Register the heartbeat logger.

    Must be called before any MongoClient is created: PyMongo's monitoring listeners
    are process-global and only apply to clients created afterwards.
    """
    monitoring.register(MongoHeartbeatLogger())
