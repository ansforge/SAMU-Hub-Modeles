import pandas as pd
import warnings
from json import dumps

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
        test_cases_df = pd.read_excel(f'./{perimeter["file"]}.xlsx', header=None, sheet_name=None)

        # Create an object with the perimeter name in the json
        perimeter_object = {
            "categoryLabel": perimeter["name"],
            "testCases": []
        }

        # Each test case is stored in a separate sheet in the excel file, so we iterate over each sheet
        for sheet, test_case_df in test_cases_df.items():
            # Create test case object
            test_case = {}
            # Read only the useful rows from the excel. Test case starts at row 9 (headers) and ends at the last row
            test_case_inner_df = pd.read_excel(f'./{perimeter["file"]}.xlsx', sheet_name=sheet, skiprows=8)
            # Test case name is located in the cell C3
            test_case["label"] = test_case_df.iloc[2, 2]
            # Test case description is located in the cell C4
            test_case["description"] = test_case_df.iloc[3, 2]
            # Create steps array in test_case object
            test_case["steps"] = []
            # The beginning of each test case step is marked by the type of the step in the column A, and the
            # end either by the beginning of another step or by the last row in the sheet, containing value 'End'
            for index, row in test_case_inner_df.iterrows():
                # 'End' marks the end of the test case
                if row["Pas de test"] == "End":
                    break
                # Else if the value is nan, we check if the row represents a 'required' value by checking the V column
                elif pd.isna(row["Pas de test"]):
                    # If the value is 'X', we add the required value to the latest step in the test case
                    if row["V"] == "X":
                        values = []
                        for i in range(5):
                            if pd.notna(row[f"JDD {i+1}"]):
                                values.append(row[f"JDD {i+1}"])
                        required_value = {
                            "path": row["path JSON"],
                            "value": values
                        }
                        test_case["steps"][-1]["message"]["requiredValues"].append(required_value)

                # Else, if the value is not nan, we add a new step to the test case. If the type of the step is
                # "receive", we also add the property "file" containing a string with the name of the template
                # file lrm is going to use to generate the message
                else:
                    test_case["steps"].append({
                        "type": get_type(row["Pas de test"]),
                        "label": row["Pas de test"] + " " + row["Modèle"],
                        "description": row["Description"],
                        "message": {
                            "requiredValues": [],
                        }
                    })
                    if get_type(row["Pas de test"]) == "receive":
                        test_case["steps"][-1]["message"]["file"] = row["Donnée"]
            # Add the test case object to the perimeter object
            perimeter_object["testCases"].append(test_case)
        # Add the perimeter object to the test cases array
        test_cases.append(perimeter_object)
    # Convert object to json
    # We use pandas to convert the array to json, as it handles the conversion of NaN values to null
    test_cases_json = pd.DataFrame(test_cases).to_json(orient='records', indent=4, force_ascii=False)
    # Save the test cases array to a json file, overwriting the previous file
    with open(f'./out/test_cases.json', 'w', encoding='utf-8') as file:
        file.write(test_cases_json)
    print('Test cases generated.')
    return test_cases


def get_type(type_in_french):
    if type_in_french == "Envoi":
        return "send"
    elif type_in_french == "Réception":
        return "receive"
