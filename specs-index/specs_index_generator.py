import json
from pathlib import Path

from jsonref import replace_refs


SCHEMA_DIR = Path(__file__).resolve().parent.parent / "src/main/resources/json-schema"
MESSAGE_INDEX_PATH = (
    Path(__file__).resolve().parent.parent
    / "src/main/resources/sample/examples/field-index.json"
)

EXCLUDED_SCHEMAS = {
    "EDXL-DE-envelope-only",
    "EDXL-DE-full",
    "RC-DE",
    "TECHNICAL",
    "TECHNICAL_NOREQ",
    "customContent",
}


def feed_index(
    title: str, schema_title: str, schema_id: str, index: dict, field: str, path: str
):
    occurrence = {
        "schema": schema_id,
        "path": path,
        "schemaLabel": title,
        "schemaTitle": schema_title,
    }
    occurrences = index.setdefault(field, [])
    if occurrence not in occurrences:
        occurrences.append(occurrence)


def browse_fields(
    title: str, schema_id: str, obj: dict, index: dict, path: str | None
):
    for field, value in obj.get("properties", {}).items():
        child_path = f"{path}.{field}" if path else field
        feed_index(title, value.get("title"), schema_id, index, field, child_path)
        if value.get("type") == "array":
            value = value.get("items", {})
        if value.get("type") == "object":
            browse_fields(title, schema_id, value, index, child_path)


def get_schema_index(schemas: list[dict]) -> dict:
    index = {}
    for schema in schemas:
        schema_id = schema["x-id"].split(".schema.json")[0]
        browse_fields(schema.get("title"), schema_id, schema, index, None)
    return index


def get_schemas() -> list[dict]:
    return [
        replace_refs(json.loads(file.read_text(encoding="utf-8")))
        for file in sorted(SCHEMA_DIR.glob("*.schema.json"))
        if file.name.removesuffix(".schema.json") not in EXCLUDED_SCHEMAS
    ]


def main():
    schema_index = get_schema_index(get_schemas())
    MESSAGE_INDEX_PATH.write_text(
        json.dumps(schema_index, ensure_ascii=False, indent=2), encoding="utf-8"
    )
    print(f"{len(schema_index)} fields indexed in {MESSAGE_INDEX_PATH}")


if __name__ == "__main__":
    main()
