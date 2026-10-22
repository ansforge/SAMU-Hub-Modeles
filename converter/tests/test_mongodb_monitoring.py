from unittest.mock import MagicMock

from converter.mongodb_monitoring import (
    MONGODB_UP,
    MongoHeartbeatLogger,
    is_mongodb_up,
)

NODE_1 = ("node1", 27017)
NODE_2 = ("node2", 27017)
NODE_3 = ("node3", 27017)


def _ok(node=NODE_1):
    return MagicMock(connection_id=node)


def _ko(node=NODE_1, reason="down"):
    return MagicMock(connection_id=node, reply=Exception(reason))


def _healthy_cluster(listener):
    for node in (NODE_1, NODE_2, NODE_3):
        listener.succeeded(_ok(node))


def test_heartbeat_logger_logs_error_on_first_failure(mocker):
    logger_error = mocker.patch("converter.mongodb_monitoring.logger.error")
    listener = MongoHeartbeatLogger()

    listener.failed(_ko(reason="connection refused"))

    logger_error.assert_called_once()
    assert "[MongoDB] Connection lost" in logger_error.call_args[0][0]
    assert logger_error.call_args.kwargs["extra"] == {
        "mongodb_status": "DOWN",
        "mongodb_nodes": {"node1:27017": "DOWN"},
    }


def test_heartbeat_logger_does_not_log_repeated_failures(mocker):
    logger_error = mocker.patch("converter.mongodb_monitoring.logger.error")
    logger_warning = mocker.patch("converter.mongodb_monitoring.logger.warning")
    listener = MongoHeartbeatLogger()

    listener.failed(_ko(reason="down"))
    listener.failed(_ko(reason="still down"))

    logger_error.assert_called_once()
    logger_warning.assert_not_called()


def test_heartbeat_logger_logs_info_when_connection_restored(mocker):
    logger_info = mocker.patch("converter.mongodb_monitoring.logger.info")
    listener = MongoHeartbeatLogger()
    listener.failed(_ko())

    listener.succeeded(_ok())

    logger_info.assert_called_once()
    assert "[MongoDB] Connection restored" in logger_info.call_args[0][0]
    assert logger_info.call_args.kwargs["extra"] == {
        "mongodb_status": "UP",
        "mongodb_nodes": {"node1:27017": "UP"},
    }


def test_heartbeat_logger_logs_connection_established_once(mocker):
    logger_info = mocker.patch("converter.mongodb_monitoring.logger.info")
    listener = MongoHeartbeatLogger()

    _healthy_cluster(listener)
    listener.succeeded(_ok(NODE_1))

    logger_info.assert_called_once()
    assert "[MongoDB] Connection established" in logger_info.call_args[0][0]
    assert logger_info.call_args.kwargs["extra"] == {
        "mongodb_status": "UP",
        "mongodb_nodes": {"node1:27017": "UP"},
    }


def test_heartbeat_logger_updates_mongodb_up_gauge():
    listener = MongoHeartbeatLogger()

    listener.failed(_ko())
    assert MONGODB_UP._value.get() == 0

    listener.succeeded(_ok())
    assert MONGODB_UP._value.get() == 1


def test_is_mongodb_up_follows_heartbeats():
    listener = MongoHeartbeatLogger()

    listener.failed(_ko())
    assert is_mongodb_up() is False

    listener.succeeded(_ok())
    assert is_mongodb_up() is True


def test_single_node_failure_keeps_mongodb_up_and_logs_all_nodes(mocker):
    logger_error = mocker.patch("converter.mongodb_monitoring.logger.error")
    logger_warning = mocker.patch("converter.mongodb_monitoring.logger.warning")
    listener = MongoHeartbeatLogger()
    _healthy_cluster(listener)

    listener.failed(_ko(NODE_2, "connection refused"))

    assert MONGODB_UP._value.get() == 1
    assert is_mongodb_up() is True
    logger_error.assert_not_called()
    logger_warning.assert_called_once()
    message = logger_warning.call_args[0][0]
    assert "Node node2:27017 unreachable" in message
    assert "node1:27017=UP, node2:27017=DOWN, node3:27017=UP" in message
    assert logger_warning.call_args.kwargs["extra"] == {
        "mongodb_nodes": {
            "node1:27017": "UP",
            "node2:27017": "DOWN",
            "node3:27017": "UP",
        }
    }


def test_other_nodes_succeeding_does_not_flap_gauge_or_log(mocker):
    logger_warning = mocker.patch("converter.mongodb_monitoring.logger.warning")
    logger_error = mocker.patch("converter.mongodb_monitoring.logger.error")
    listener = MongoHeartbeatLogger()
    _healthy_cluster(listener)

    listener.failed(_ko(NODE_2))
    listener.succeeded(_ok(NODE_1))
    listener.failed(_ko(NODE_2))
    listener.succeeded(_ok(NODE_3))

    assert MONGODB_UP._value.get() == 1
    logger_warning.assert_called_once()
    logger_error.assert_not_called()


def test_all_nodes_failing_sets_mongodb_down_and_logs_once(mocker):
    logger_error = mocker.patch("converter.mongodb_monitoring.logger.error")
    listener = MongoHeartbeatLogger()
    _healthy_cluster(listener)

    listener.failed(_ko(NODE_1))
    listener.failed(_ko(NODE_2))
    assert MONGODB_UP._value.get() == 1
    listener.failed(_ko(NODE_3))

    assert MONGODB_UP._value.get() == 0
    assert is_mongodb_up() is False
    logger_error.assert_called_once()
    assert (
        "node1:27017=DOWN, node2:27017=DOWN, node3:27017=DOWN"
        in logger_error.call_args[0][0]
    )


def test_node_recovery_logs_info_when_all_nodes_up(mocker):
    logger_info = mocker.patch("converter.mongodb_monitoring.logger.info")
    listener = MongoHeartbeatLogger()
    _healthy_cluster(listener)
    logger_info.reset_mock()
    listener.failed(_ko(NODE_2))

    listener.succeeded(_ok(NODE_2))

    logger_info.assert_called_once()
    message = logger_info.call_args[0][0]
    assert "Node node2:27017 restored" in message
    assert "node1:27017=UP, node2:27017=UP, node3:27017=UP" in message
    assert MONGODB_UP._value.get() == 1


def test_cluster_recovers_when_one_node_comes_back(mocker):
    logger_info = mocker.patch("converter.mongodb_monitoring.logger.info")
    listener = MongoHeartbeatLogger()
    _healthy_cluster(listener)
    logger_info.reset_mock()
    for node in (NODE_1, NODE_2, NODE_3):
        listener.failed(_ko(node))
    assert MONGODB_UP._value.get() == 0

    listener.succeeded(_ok(NODE_3))

    assert MONGODB_UP._value.get() == 1
    logger_info.assert_called_once()
    assert "[MongoDB] Connection restored" in logger_info.call_args[0][0]
    assert logger_info.call_args.kwargs["extra"]["mongodb_status"] == "UP"
