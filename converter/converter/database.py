import os

from flask import Flask, current_app
from pymongo import MongoClient
from pymongo.database import Database


def init_db(app: Flask) -> None:
    uri = os.getenv("MONGODB_URI", "mongodb://localhost:27017")
    db_name = os.getenv("MONGODB_DATABASE", "hubsante")
    username = os.getenv("MONGODB_USERNAME", "converter")
    password = os.getenv("MONGODB_PASSWORD", "pswd")

    client: MongoClient = MongoClient(uri, username=username, password=password)
    app.extensions["mongodb_client"] = client
    app.extensions["mongodb_db"] = client[db_name]


def get_db() -> Database:
    return current_app.extensions["mongodb_db"]


def get_client() -> MongoClient:
    return current_app.extensions["mongodb_client"]
