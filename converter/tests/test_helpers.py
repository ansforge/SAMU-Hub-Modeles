import json
from pathlib import Path
from typing import Dict, Any, Optional
from jsonschema import validate
from requests_cache import CachedSession


session = CachedSession(
    cache_name="schemas_and_samples_cache",
    expire_after=600,  # 10 minutes
)


class TestHelper:
    @staticmethod
    def load_schema(schema_name: str) -> Dict[str, Any]:
        """Load a JSON schema file from the schema directory

        Args:
            schema_name: Name of the schema file

        Returns:
            Dict containing the schema
        """
        schema_dir = "../src/main/resources/json-schema"
        return TestHelper.load_json_file(f"{schema_dir}/{schema_name}")

    @staticmethod
    def load_json_file(file_path: str) -> Dict[str, Any]:
        """Load JSON from file"""
        if file_path.startswith("https://"):
            return TestHelper.load_json_file_online(file_path)
        else:
            return TestHelper.load_json_file_local(file_path)

    @staticmethod
    def load_json_file_local(file_path: str) -> Dict[str, Any]:
        """Load JSON from file"""
        with open(file_path, "r", encoding="utf-8") as f:
            return json.load(f)

    @staticmethod
    def load_json_file_online(file_path: str) -> Dict[str, Any]:
        """Load JSON from Github repository"""
        response = session.get(file_path)
        response.raise_for_status()
        return json.loads(response.text)

    @staticmethod
    def get_json_files(directory: str, tag: Optional[str] = None) -> list:
        """Get all JSON files (name & path) from the specified directory"""
        if tag is not None:
            return TestHelper.get_json_files_online(directory, tag)
        else:
            return TestHelper.get_json_files_local(directory)

    @staticmethod
    def get_json_files_local(directory: str) -> list:
        """Get all JSON files (name & path) from the specified directory"""
        path = Path(f"../src/main/resources/sample/examples/{directory}")
        usecase_files = list(
            map(
                lambda file: {"name": file.name, "path": str(file)}, path.glob("*.json")
            )
        )
        assert len(usecase_files) > 0, f"No JSON files found in {path}"
        return usecase_files

    @staticmethod
    def get_json_files_online(directory: str, tag: str) -> list:
        """Get all JSON files (name & path) from Github repository

        Args:
            directory: Directory name under sample/examples/
            tag: Git tag/branch to use

        Returns:
            List of file paths from Github
        """
        base_url = f"https://raw.githubusercontent.com/ansforge/SAMU-Hub-Modeles/{tag}/src/main/resources/sample/examples"
        api_url = f"https://api.github.com/repos/ansforge/SAMU-Hub-Modeles/contents/src/main/resources/sample/examples/{directory}?ref={tag}"

        response = session.get(api_url)
        response.raise_for_status()

        files = []
        for file in response.json():
            if file["name"].endswith(".json"):
                files.append(
                    {
                        "name": file["name"],
                        "path": f"{base_url}/{directory}/{file['name']}",
                    }
                )

        assert len(files) > 0, f"No JSON files found in {api_url}"
        return files

    @staticmethod
    def combine_edxl_envelope_and_message(
        base_envelope_path: str, message_content: Dict[str, Any]
    ) -> Dict[str, Any]:
        """Create an EDXL json by combining a base envelope with message content

        Args:
            base_envelope_path: Path to the base EDXL envelope request JSON file
            message_content: Content to be inserted into the message

        Returns:
            Dict containing the complete EDXL request
        """
        edxl_json = TestHelper.load_json_file(base_envelope_path)["edxl"]
        edxl_json["content"][0]["jsonContent"]["embeddedJsonContent"]["message"].update(
            message_content
        )
        return edxl_json

    @staticmethod
    def create_edxl_json_from_schema(
        envelope_path: str, content_schema: str
    ) -> Dict[str, Any]:
        """Create an EDXL json by combining an envelope with a message content

        Args:
            envelope_path: Path to the base EDXL envelope request JSON file
            content_schema: Name of the content schema -> will fetch an example in its examples directory

        Returns:
            Dict containing the complete EDXL json
        """
        usecase_file = next(TestHelper.get_json_files(content_schema).__iter__())
        usecase_content = TestHelper.load_json_file(usecase_file["path"])
        return TestHelper.combine_edxl_envelope_and_message(
            envelope_path, usecase_content
        )

    @staticmethod
    def create_edxl_json_from_sample(
        envelope_path: str, usecase_file: str
    ) -> Dict[str, Any]:
        """Create an EDXL json by combining an envelope with a message content

        Args:
            envelope_path: Path to the base EDXL envelope request JSON file
            usecase_file: Path to the usecase file

        Returns:
            Dict containing the complete EDXL json
        """
        return TestHelper.combine_edxl_envelope_and_message(
            envelope_path, TestHelper.load_json_file(usecase_file)
        )

    @staticmethod
    def conversion_tests_runner(
        sample_dir: str,
        envelope_file: str,
        converter_method,
        target_schema: dict,
        additional_validation=None,
        online_tag=None,
    ):
        """Generic test method for conversions

        Args:
            sample_dir: Directory containing sample files
            envelope_file: Base envelope file to use
            converter_method: Method to use for conversion
            target_schema: Schema to validate against
            additional_validation: Optional function for additional validation
        """
        # Get all test case files (local or online depending on tag specified or not)
        usecase_files = TestHelper.get_json_files(sample_dir, tag=online_tag)

        for usecase_file in usecase_files:
            print(f"Testing conversion of {usecase_file['name']}")
            edxl_json = TestHelper.create_edxl_json_from_sample(
                envelope_file, usecase_file["path"]
            )
            # Perform conversion
            result = converter_method(edxl_json)

            # Extract and validate the converted message
            usecase_name = target_schema["title"]
            converted_message = result["content"][0]["jsonContent"][
                "embeddedJsonContent"
            ]["message"][usecase_name]
            validate(instance=converted_message, schema=target_schema)

            # Run additional validation if provided
            if additional_validation:
                additional_validation(converted_message)


def get_file_endpoint(version_tag: str, message_type: str) -> str:
    return f"https://raw.githubusercontent.com/ansforge/SAMU-Hub-Modeles/{version_tag}/src/main/resources/json-schema/{message_type}.schema.json"
