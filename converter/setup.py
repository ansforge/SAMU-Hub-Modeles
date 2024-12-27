from setuptools import setup, find_packages

setup(
    name="converter",
    version="0.1.0",
    packages=find_packages(),
    install_requires=[
        "Flask==2.2.5",
        "Werkzeug==3.0.6",
        "requests==2.32.2",
        "gunicorn==23.0.0",
        "hubsante_model==0.1.1",
        "typing-extensions>=4.5.0",
    ],
    extras_require={
        "test": [
            "pytest>=7.0.0",
            "pytest-cov>=4.1.0",
        ],
    },
) 