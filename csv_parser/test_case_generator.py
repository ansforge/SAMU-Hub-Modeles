import unicodedata

import pandas as pd
import warnings

# Improving panda printing | Ref.: https://stackoverflow.com/a/11711637
pd.set_option('display.max_rows', 500)
pd.set_option('display.max_columns', 500)
pd.set_option('display.width', 1000)

# Ignoring Openpyxl Excel's warnings | Ref.: https://stackoverflow.com/a/64420416
warnings.filterwarnings('ignore', category=UserWarning, module='openpyxl')

SOURCE_FILES_DIRECTORY_PATH = "./test-case-sources"
SOURCE_FILE_EXTENSION = "xlsx"
OUTPUT_DIRECTORY_PATH = "./out"
OUTPUT_FILE = "test_cases.json"
END_DESCRIPTOR = "End"
CHECKED_OVERRIDE_DESCRIPTOR = "X"
SEND_INTERACTION_DESCRIPTOR = "Envoi"
RECEIVE_INTERACTION_DESCRIPTOR = "Réception"

# This function generates a json file that contains test case per sheet in test_cases.xlsx, saving it to the
# /out folder under the name test_cases.json
def run(perimeters):
    # Define the json array that will be saved
    test_cases = []

    # Iterate over each perimeter
    for perimeter in perimeters:
        # Load the test cases excel file
        test_cases_df = pd.read_excel(get_source_file_path(perimeter["file"]), header=None, sheet_name=None)

        # Create an object with the perimeter name in the json
        perimeter_object = {
            "categoryLabel": perimeter["name"],
            "testCases": []
        }

        # Each test case is stored in a separate sheet in the excel file, so we iterate over each sheet
        for sheet, test_case_df in test_cases_df.items():
            # Create test case object
            test_case = {}
            # Read only the useful rows from the excel. Test case starts at row 8 (headers) and ends at the last row
            test_case_inner_df = pd.read_excel(get_source_file_path(perimeter["file"]), sheet_name=sheet, skiprows=7, dtype=str)
            # Test case name is located in the cell F3
            test_case["label"] = f"{test_case_df.iloc[2, 5]} - {test_case_df.iloc[4, 5]}"
            # Test case description is located in the cell F4
            test_case["description"] = test_case_df.iloc[3, 5]
            # Create steps array in test_case object
            test_case["steps"] = []
            # The beginning of each test case step is marked by the type of the step in the column A, and the
            # end either by the beginning of another step or by the last row in the sheet, containing value 'End'
            for _, row in test_case_inner_df.iterrows():
                # 'End' marks the end of the test case
                if row["Pas de test"] == END_DESCRIPTOR:
                    break
                # Else if the value is nan, if the "Sur" column is checked ("X"), add the value in "Path" to the 
                # idOverrideProperties list, else to the ignoredProperties list.
                elif pd.isna(row["Pas de test"]):
                    # Take the last step in the list
                    currrent_step = test_case["steps"][-1]
                    if row["Sur"] == CHECKED_OVERRIDE_DESCRIPTOR:
                        # Create the idOverrideProperties array if it does not exist yet
                        if currrent_step.get("idOverrideProperties") == None:
                            currrent_step["idOverrideProperties"] = [row["Path"]]
                        else:
                            currrent_step["idOverrideProperties"].append(row["Path"])
                    else:
                        currrent_step["ignoredProperties"].append(row["Path"])

                # Else, if the value is not nan, add a new step in the test case.
                else:
                    test_case["steps"].append({
                        "id" : row["Pas de test"],
                        "type": get_type(row["Sens"]),
                        "label": row["Sens"] + " " + row["Modèle"],
                        "description": row["Description"],
                        "file": normalize_path(row["JSON exemple"]),
                        "model": row["Modèle"],
                        "ignoredProperties": []
                    })

            # Add the test case object to the perimeter object
            perimeter_object["testCases"].append(test_case)
        # Add the perimeter object to the test cases array
        test_cases.append(perimeter_object)
    # Convert object to json
    # We use pandas to convert the array to json, as it handles the conversion of NaN values to null
    test_cases_json = pd.DataFrame(test_cases).to_json(orient='records', indent=2, force_ascii=False)
    # Save the test cases array to a json file, overwriting the previous file
    with open(f'{OUTPUT_DIRECTORY_PATH}/{OUTPUT_FILE}', 'w', encoding='utf-8') as file:
        file.write(test_cases_json)
    print('Test cases generated.')
    return test_cases

def normalize_path(text):
    # We normalize the path to remove any accents and replace spaces with underscores
    return ''.join(char for char in unicodedata.normalize('NFD', text) if unicodedata.category(char) != 'Mn').replace(' ', '_')

def get_type(type_in_french):
    if type_in_french == SEND_INTERACTION_DESCRIPTOR:
        return "send"
    elif type_in_french == RECEIVE_INTERACTION_DESCRIPTOR:
        return "receive"

def get_source_file_path(source_file_name):
    return f'{SOURCE_FILES_DIRECTORY_PATH}/{source_file_name}.{SOURCE_FILE_EXTENSION}'