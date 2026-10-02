from unittest.mock import MagicMock

from converter.mongodb_monitoring import MongoHeartbeatLogger


def test_heartbeat_logger_logs_error_on_first_failure(mocker):
    logger_error = mocker.patch("converter.mongodb_monitoring.logger.error")
    listener = MongoHeartbeatLogger()

    listener.failed(MagicMock(reply=Exception("connection refused")))

    logger_error.assert_called_once()
    assert "[MongoDB] Connection lost" in logger_error.call_args[0][0]
    assert logger_error.call_args.kwargs["extra"] == {"mongodb_status": "DOWN"}


def test_heartbeat_logger_does_not_log_repeated_failures(mocker):
    logger_error = mocker.patch("converter.mongodb_monitoring.logger.error")
    listener = MongoHeartbeatLogger()

    listener.failed(MagicMock(reply=Exception("down")))
    listener.failed(MagicMock(reply=Exception("still down")))

    logger_error.assert_called_once()


def test_heartbeat_logger_logs_info_when_connection_restored(mocker):
    logger_info = mocker.patch("converter.mongodb_monitoring.logger.info")
    listener = MongoHeartbeatLogger()
    listener._is_up = False

    listener.succeeded(MagicMock())

    logger_info.assert_called_once_with(
        "[MongoDB] Connection restored", extra={"mongodb_status": "UP"}
    )


def test_heartbeat_logger_does_not_log_when_already_up(mocker):
    logger_info = mocker.patch("converter.mongodb_monitoring.logger.info")
    listener = MongoHeartbeatLogger()

    listener.succeeded(MagicMock())

    logger_info.assert_not_called()
