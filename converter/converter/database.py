import logging
import os

from flask import Flask, current_app
from pymongo import MongoClient, timeout, uri_parser
from pymongo.database import Database

logger = logging.getLogger(__name__)


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

    try:
        with timeout(5):
            db.command("ping")
            connection_message = "Successfully connected to MongoDB"
            if username is not None:
                connection_message = f"{connection_message} using user {username}"
            logger.info(connection_message)
    except Exception as e:
        logger.error(f"Failed to connect to MongoDB: {e}")
        raise

    app.extensions["mongodb_client"] = client
    app.extensions["mongodb_db"] = db


def get_db() -> Database:
    return current_app.extensions["mongodb_db"]


def get_client() -> MongoClient:
    return current_app.extensions["mongodb_client"]
