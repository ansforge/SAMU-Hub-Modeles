## Overview

This Python service provides REST endpoints used to convert:

- Emergency messages between different formats: CISU (Common Information Space for Emergency Units) and Health (used by SAMU)
- Health messages in different versions.

## Installation

### Development Setup

1. Create and activate a virtual environment (recommended):

```bash
uv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
```

2. Install the package in development mode:

```bash
uv sync
```

### Production Setup

Using Docker:

```bash
docker build -t cisu-converter .
docker run -p 8080:8080 cisu-converter
```

## Usage

### Running Tests

```bash
# Run all tests with coverage
uv run pytest
# Run specific test file
uv run pytest tests/test_utils.py

# Run specific test
uv run pytest tests/test_utils.py -k test_format_object_primitive

# Run with prints visible | Ref.: https://stackoverflow.com/a/59156707/10115198
uv run pytest -rP
```

Note : the tests download files (json samples & schemas) using the Github API. To avoid hammering the API leading to tests failure, a cache system has been added for the tests runner. To invalidate the cache and download the files again, delete the `schemas_and_samples_cache.sqlite` file at the root of the repository.

#### Snapshot Tests

Converter outputs are pinned with snapshot tests powered by [syrupy](https://github.com/syrupy-project/syrupy). Each snapshot test serializes the converted message and asserts it equals `snapshot`. Snapshots are stored as `.ambr` files in a `__snapshots__/` directory next to each test module; syrupy links a test to its snapshot by the test file path plus the `Class.method` name, so renaming a test class or method orphans its snapshot. After a deliberate change to a converter's output, update the recorded snapshots and review the diff before committing:

```bash
# Update all snapshots
uv run pytest --snapshot-update
# Update only the snapshots for a given test module
uv run pytest tests/cisu/test_create_case_converter.py --snapshot-update
# List snapshots that are no longer used by any test
uv run pytest --snapshot-details
```

### Running the Service

Development mode:

```bash
# In converter/, run the commands:
FLASK_APP=converter.converter \
FLASK_ENV=development \
FLASK_DEBUG=1 \
uv run python -m flask run --port 8083
# in a Linux environment, add --host 0.0.0.0
```

*Notes :*

- enable prometheus metrics, add `DEBUG_METRICS=1` in the above command.
- utiliser le port 8083 pour lancer le converter avec la configuration par défaut du setup de dev local

Production mode (using Gunicorn):

```bash
# In converter/, run the commands:
mkdir -p ./tmp/prometheus_metrics

PROMETHEUS_MULTIPROC_DIR=./tmp/prometheus_metrics gunicorn -c gunicorn.conf.py -w 4 -b 0.0.0.0:8080 converter.converter:app
```

### Controlling Logging Level

Set the `LOG_LEVEL` environment variable to one of the following values: `DEBUG`, `INFO`, `WARNING`, `ERROR`, `CRITICAL`. The default level is `INFO`.

### API Endpoints

#### Convert CISU to Health Format

```bash
# Based on https://github.com/ansforge/SAMU-Hub-Sante/blob/main/web/lrm/client/constants.js#L5C30-L45C2
curl -X POST http://localhost:8080/convert \
  -H "Content-Type: application/json" \
  -d "$(jq --argjson usecase "$(cat ../src/main/resources/sample/examples/RC-EDA/RC-EDA-FemmeEnceinte-DelphineVigneau.json)" '.sourceVersion = "v3" | .targetVersion = "v3" | .cisuConversion = true | .edxl.content[0].jsonContent.embeddedJsonContent.message |= (. + $usecase)' tests/fixtures/EDXL/edxl_envelope_fire_to_health.json)"
```

#### Convert Health to CISU Format

```bash
# Based on https://github.com/ansforge/SAMU-Hub-Sante/blob/main/web/lrm/client/constants.js#L5C30-L45C2
curl -X POST http://localhost:8080/convert \
  -H "Content-Type: application/json" \
  -d "$(jq --argjson usecase "$(cat ../src/main/resources/sample/examples/RS-EDA/RS-EDA-SMUR_FemmeEnceinte_DelphineVigneau.01.json)" '.sourceVersion = "v3" | .targetVersion = "v3" | .cisuConversion = true | .edxl.content[0].jsonContent.embeddedJsonContent.message |= (. + $usecase)' tests/fixtures/EDXL/edxl_envelope_health_to_fire.json)"
```
