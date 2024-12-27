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
```

### Running the Service

Development mode:
```bash
python -m flask run
```

Production mode (using Gunicorn):
```bash
gunicorn -w 4 -b 0.0.0.0:8080 converter:app
```

### API Endpoints

#### Convert CISU to Health Format
```bash
curl -X POST http://localhost:8080/convert-cisu \
  -H "Content-Type: application/json" \
  -d @sample.json \
  --data-urlencode "direction=forward"
```

#### Convert Health to CISU Format
```bash
curl -X POST http://localhost:8080/convert-cisu \
  -H "Content-Type: application/json" \
  -d @sample.json \
  --data-urlencode "direction=backward"
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
