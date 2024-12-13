import unicodedata

import pandas as pd
import warnings

# Improving panda printing | Ref.: https://stackoverflow.com/a/11711637
pd.set_option('display.max_rows', 500)
pd.set_option('display.max_columns', 500)
pd.set_option('display.width', 1000)

# Ignoring Openpyxl Excel's warnings | Ref.: https://stackoverflow.com/a/64420416
warnings.filterwarnings('ignore', category=UserWarning, module='openpyxl')


# This function generates a json file that contains test case per sheet in test_cases.xlsx, saving it to the
# /out folder under the name test_cases.json
def run(perimeters):
    # Define the json array that will be saved
    test_cases = []

    # Iterate over each perimeter
    for perimeter in perimeters:
        # Load the test cases excel file
        test_cases_df = pd.read_excel(f'./test-case-sources/{perimeter["file"]}.xlsx', header=None, sheet_name=None)

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
            test_case_inner_df = pd.read_excel(f'./test-case-sources/{perimeter["file"]}.xlsx', sheet_name=sheet, skiprows=7, dtype=str)
            r_type = sheet.split(" ")[-1]
            # Test case name is located in the cell F3
            test_case["label"] = f"{test_case_df.iloc[2, 5]} {r_type}"
            # Test case description is located in the cell F4
            test_case["description"] = test_case_df.iloc[3, 5]
            # Create steps array in test_case object
            test_case["steps"] = []
            # The beginning of each test case step is marked by the type of the step in the column A, and the
            # end either by the beginning of another step or by the last row in the sheet, containing value 'End'
            for _, row in test_case_inner_df.iterrows():
                # 'End' marks the end of the test case
                if row["Pas de test"] == "End":
                    break
                # Else if the value is nan
                elif pd.isna(row["Pas de test"]):
                    if row["Sur"] == "X":
                        if test_case["steps"][-1].get("idOverrideProperties") == None:
                            test_case["steps"][-1]["idOverrideProperties"] = [row["Path"]]
                        else:
                            test_case["steps"][-1]["idOverrideProperties"].append(row["Path"])
                    else:
                        test_case["steps"][-1]["ignoredProperties"].append(row["Path"])

                # Else, if the value is not nan 
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
    with open(f'./out/test_cases.json', 'w', encoding='utf-8') as file:
        file.write(test_cases_json)
    print('Test cases generated.')
    return test_cases

def normalize_path(text):
    # We normalize the path to remove any accents and replace spaces with underscores
    return ''.join(char for char in unicodedata.normalize('NFD', text) if unicodedata.category(char) != 'Mn').replace(' ', '_')

def get_type(type_in_french):
    if type_in_french == "Envoi":
        return "send"
    elif type_in_french == "Réception":
        return "receive"
