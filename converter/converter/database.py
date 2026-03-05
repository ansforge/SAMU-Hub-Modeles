import logging
import os

from flask import Flask, current_app
from pymongo import MongoClient, timeout
from pymongo.database import Database

logger = logging.getLogger(__name__)


def init_db(app: Flask) -> None:
    uri = os.getenv("MONGODB_URI", "mongodb://localhost:27017")
    db_name = os.getenv("MONGODB_DATABASE", "hubsante")
    username = os.getenv("MONGODB_USERNAME", "hubsante_ro")
    password = os.getenv("MONGODB_PASSWORD", "hubsante_ro")

    client: MongoClient = MongoClient(
        uri, username=username, password=password, authSource=db_name
    )
    db = client[db_name]

    try:
        with timeout(5):
            db.command("ping")
            logger.info(f"Successfully connected to MongoDB using user {username}")
    except Exception as e:
        logger.error(f"Failed to connect to MongoDB: {e}")
        raise

    app.extensions["mongodb_client"] = client
    app.extensions["mongodb_db"] = db


def get_db() -> Database:
    return current_app.extensions["mongodb_db"]


def get_client() -> MongoClient:
    return current_app.extensions["mongodb_client"]
