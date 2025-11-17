from converter.cisu.identical_cisu_converter import IdenticalCISUConverter

mock_message = {"message": {"content": "This is a mock CISU message.", "status": "200"}}


def test_from_rs_to_cisu():
    initial_message = mock_message.copy()
    converted_message = IdenticalCISUConverter.from_rs_to_cisu(initial_message)
    assert converted_message == mock_message


def test_from_cisu_to_rs():
    initial_message = mock_message.copy()
    converted_message = IdenticalCISUConverter.from_cisu_to_rs(initial_message)
    assert converted_message == mock_message
