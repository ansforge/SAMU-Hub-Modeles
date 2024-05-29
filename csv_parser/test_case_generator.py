import os
import pandas as pd
import warnings
import math
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
            # Create empty JSON object that we'll use to generate potential JSON files for the 'receive' steps
            receive_json = {}
            # Holds current step data
            current_step = {}
            # The beginning of each test case step is marked by the type of the step in the column A, and the
            # end either by the beginning of another step or by the last row in the sheet, containing value 'End'
            for index, row in test_case_inner_df.iterrows():
                # 'End' marks the end of the test case
                if row["Pas de test"] == "End":
                    # If the last step is of 'receive' type, we generate the JSON file for it
                    if get_type(current_step["Pas de test"]) == "receive":
                        generate_step_json(perimeter, test_case, current_step, receive_json)
                    break
                # Else if the value is nan, we check if the row represents a 'required' value by checking the V column
                elif pd.isna(row["Pas de test"]):
                    # As we iterate over the step, we generate a json object using the ["path JSON"] field, which
                    # contains a JSONPath string (such as $.createCaseHealth.caseId) and the value of ["JDD 1"] column
                    if pd.notna(row["JDD 1"]):
                        # We split the JSONPath string by '.' and iterate over the keys to create the JSON object,
                        # dropping the initial '$.' element and creating arrays when the key has a bracketed number
                        # (such as $.createCaseHealth.patient[0].id)
                        path = row["path JSON"].split('.')
                        current = receive_json
                        # We iterate over the split path (dropping the $)
                        for i in range(1, len(path) - 1):
                            # Presence of '[' indicates an array
                            if path[i].find('[') != -1:
                                # We split on '[' and ']' to get the key and the index
                                key = path[i].split('[')[0]
                                index = int(path[i].split('[')[1].split(']')[0])
                                # If the key is not in the current object, we add it as an empty array
                                if key not in current:
                                    current[key] = []
                                # If the index is greater than the length of the array, we add empty objects to the
                                # array until the index is reached
                                if len(current[key]) <= index:
                                    current[key].append({})
                                # We grab the object at the index and set it as the current object
                                current = current[key][index]
                            else:
                                # For properties that are not arrays, we simply add the key to the current object if it
                                # is not already present
                                if path[i] not in current:
                                    current[path[i]] = {}
                                # We set the current object to the object at the path
                                current = current[path[i]]
                            # We add the value to the last key in the path
                            current[path[-1]] = row["JDD 1"]

                    # If the value is not empty, we add it to the required values array of the last step, specifying
                    # the number in the "verificationLevel" property
                    if pd.notna(row["V"]):
                        try:
                            values = []
                            for i in range(5):
                                if pd.notna(row[f"JDD {i+1}"]):
                                    values.append(row[f"JDD {i+1}"])

                            required_value = {
                                "path": row["path JSON"],
                                "value": values,
                                "verificationLevel": int(row["V"]),
                            }
                            test_case["steps"][-1]["message"]["requiredValues"].append(required_value)
                        except ValueError:
                            print(f"Error: Invalid verification level in test case {test_case['label']}, row {index + 1}")

                # Else, if the value is not nan, we add a new step to the test case. If the type of the step is
                # "receive", we also add the property "file" containing a string with the name of the template
                # file lrm is going to use to generate the message
                else:
                    if len(current_step.keys())>0 and get_type(current_step["Pas de test"]) == "receive":
                        generate_step_json(perimeter, test_case, current_step, receive_json)
                    test_case["steps"].append({
                        "type": get_type(row["Pas de test"]),
                        "label": row["Pas de test"] + " " + row["Modèle"],
                        "description": row["Description"],
                        "message": {
                            "requiredValues": [],
                        }
                    })
                    # We update current set and empty the receive_json object
                    current_step = row
                    receive_json = {}
                    # For 'receive' steps, we generate a json file using all the values of the step (even unmarked
                    # ones, through the usage of receive_json object) and save it to the path
                    # ./out/test-cases/[perimeter_name]/[test_case_name]/[step_name].json
                    # We only use JDD1 values, as the other two JDDs will be overriden later on in the lrm itself
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


def generate_step_json(perimeter, test_case, row, receive_json):
    # Create the JSON file for the step
    if not os.path.exists(f'./out/test-cases/{perimeter["name"]}/{test_case["label"]}'):
        os.makedirs(f'./out/test-cases/{perimeter["name"]}/{test_case["label"]}')
    with open(
            f'./out/test-cases/{perimeter["name"]}/{test_case["label"]}/{len(test_case["steps"])}-{row["Pas de test"]} {row["Modèle"]}.json',
            'w', encoding='utf-8') as file:
        file.write(dumps(receive_json, indent=4, ensure_ascii=False))


def get_type(type_in_french):
    if type_in_french == "Envoi":
        return "send"
    elif type_in_french == "Réception":
        return "receive"
