import logging
import os

from flask import Flask, current_app
from pymongo import MongoClient, timeout, uri_parser
from pymongo.database import Database

from converter.mongodb_monitoring import register_mongodb_monitoring

logger = logging.getLogger(__name__)

# Registered once at import. Applies to all MongoClients created afterwards.
register_mongodb_monitoring()


def init_db(app: Flask) -> None:
    uri = os.getenv(
        "MONGODB_URI",
        "mongodb://hubsante_ro:hubsante_ro@localhost:27017/hubsante?authSource=hubsante",
    )
    parsed_uri = uri_parser.parse_uri(uri)

    db_name = parsed_uri["database"]
    if db_name is None:
        logger.error("Failed to parse db_name from provided uri")
        raise Exception("Missing db_name in uri")

    username = parsed_uri["username"]

    client: MongoClient = MongoClient(uri)

    db = client[db_name]

    _ping(db, username)

    app.extensions["mongodb_client"] = client
    app.extensions["mongodb_db"] = db


def _ping(db: Database, username: str | None) -> bool:
    """Check the MongoDB connection, logging the outcome. Returns whether it succeeded."""
    try:
        with timeout(5):
            db.command("ping")
            connection_message = "[MongoDB] Connected successfully"
            if username is not None:
                connection_message = f"{connection_message} using user {username}"
            logger.info(connection_message, extra={"mongodb_status": "UP"})
            return True
    except Exception as e:
        # The MongoDB connection is not required for the app to start
        logger.error(
            f"[MongoDB] Connection failed at startup: {e}. The application will "
            "start anyway and MongoDB-dependent features will be unavailable until "
            "the connection is restored.",
            extra={"mongodb_status": "DOWN"},
        )
        return False


def get_db() -> Database:
    return current_app.extensions["mongodb_db"]


def get_client() -> MongoClient:
    return current_app.extensions["mongodb_client"]
