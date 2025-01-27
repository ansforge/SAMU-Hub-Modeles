# CISU-Health Converter

A Python service that converts between CISU and Health message formats.

## Overview

This service provides REST endpoints to convert emergency messages between different formats:
- CISU (Common Information Space for Emergency Units) format
- Health format (used by SAMU)

## Project Structure converter/
├── converter/ # Source code
│ ├── init.py
│ ├── converter.py # Main Flask application
│ ├── cisu_converter.py # CISU conversion logic
│ └── utils.py # Utility functions
├── tests/ # Test files
│ ├── init.py
│ └── test_utils.py
├── Dockerfile # Container definition
├── requirements.txt # Dependencies
├── setup.py # Package configuration
└── pytest.ini # Test configuration

## Installation

### Development Setup

1. Create and activate a virtual environment (recommended):
```bash
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
```

2. Install the package in development mode:
```bash
pip install -e .
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
pytest

# Run specific test file
pytest tests/test_utils.py

# Run specific test
pytest tests/test_utils.py -k test_format_object_primitive

# Run with prints visible | Ref.: https://stackoverflow.com/a/59156707/10115198
pytest -rP
```

### Running the Service

Development mode:
```bash
# In converter/
FLASK_APP=converter.converter FLASK_ENV=development FLASK_DEBUG=1 flask run --port 8080
```

Production mode (using Gunicorn):
```bash
gunicorn -w 4 -b 0.0.0.0:8080 converter.converter:app
```

### API Endpoints

#### Convert CISU to Health Format
```bash
# Based on https://github.com/ansforge/SAMU-Hub-Sante/blob/main/web/lrm/client/constants.js#L5C30-L45C2
curl -X POST http://localhost:8080/convert-cisu \
  -H "Content-Type: application/json" \
  -d "$(jq --argjson usecase "$(cat ../src/main/resources/sample/examples/RC-EDA/RC-EDA-FemmeEnceinte-DelphineVigneau.json)" '.edxl.content[0].jsonContent.embeddedJsonContent.message |= (. + $usecase)' tests/edxl_envelope_fire_to_health.json)"
```

#### Convert Health to CISU Format
```bash
# Based on https://github.com/ansforge/SAMU-Hub-Sante/blob/main/web/lrm/client/constants.js#L5C30-L45C2
curl -X POST http://localhost:8080/convert-cisu \
  -H "Content-Type: application/json" \
  -d "$(jq --argjson usecase "$(cat ../src/main/resources/sample/examples/RS-EDA/RS-EDA-SMUR_FemmeEnceinte_DelphineVigneau.01.json)" '.edxl.content[0].jsonContent.embeddedJsonContent.message |= (. + $usecase)' tests/edxl_envelope_health_to_fire.json)"
```

## Development

### Code Quality

The project uses:
- pytest for testing
- pytest-cov for coverage reporting
- GitHub Actions for CI/CD

### Adding New Features

1. Write tests in `tests/`
2. Implement feature in `converter/`
3. Run tests to ensure coverage
4. Submit PR

### Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Run tests
5. Submit a pull request

## License

[Add license information]

## Contact

[Add contact information]
