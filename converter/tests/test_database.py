from flask import Flask

from converter.database import init_db


def test_init_db_success_logs_info_and_stores_extensions(mocker):
    mock_client_cls = mocker.patch("converter.database.MongoClient")
    mock_client = mock_client_cls.return_value
    logger_info = mocker.patch("converter.database.logger.info")
    logger_error = mocker.patch("converter.database.logger.error")

    app = Flask(__name__)
    init_db(app)

    assert app.extensions["mongodb_client"] is mock_client
    assert app.extensions["mongodb_db"] is mock_client.__getitem__.return_value
    logger_info.assert_called_once()
    logger_error.assert_not_called()


def test_init_db_does_not_raise_and_logs_error_on_connection_failure(mocker):
    mock_client_cls = mocker.patch("converter.database.MongoClient")
    mock_client = mock_client_cls.return_value
    mock_client.__getitem__.return_value.command.side_effect = Exception(
        "connection refused"
    )
    logger_error = mocker.patch("converter.database.logger.error")

    app = Flask(__name__)
    # Must not raise even though MongoDB is unreachable.
    init_db(app)

    assert app.extensions["mongodb_client"] is mock_client
    assert app.extensions["mongodb_db"] is mock_client.__getitem__.return_value
    logger_error.assert_called_once()
    assert "Failed to connect to MongoDB at startup" in logger_error.call_args[0][0]
