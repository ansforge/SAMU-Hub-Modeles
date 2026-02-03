import argparse
from datetime import date
import graphviz  # doctest: +NO_EXE
import json
import os


# UTILS
# get ref dic objet from raw ref label
def get_ref(str_ref_in, dict_definitions_in):
    # looking for ref in json
    # get ref from string
    # "#/definitions/etype"
    ref_in = str_ref_in[14:]
    if ref_in in dict_definitions_in:
        return dict_definitions_in[ref_in]
    print("Reference" + str_ref_in + " invalide")
    raise ValueError


# get ref type from raw ref label
def get_id_ref(str_ref_in):
    ref_in = str_ref_in[14:]
    return ref_in


# define min max value for cardinality
def set_cardinalite(minimal, max):
    minimal_valid = {"0", "1"}
    if minimal not in minimal_valid:
        raise ValueError
    return (minimal, max)


## PARSING


def add_node(dot, id_parent, id_in, type_in, buffer_description, cardinalite, health_only=False):
    if health_only:
        background_color = "BGCOLOR=\"#dceaf7\""
    else:
        background_color = ""
    # draw node
    template_html_node = '''<<TABLE>
                <TR>
                <TD {}><B>{}</B></TD>
                </TR>
                {}
                </TABLE>>'''
    str_node = template_html_node.format(background_color, str(id_in),
                                         "<TR><TD " + background_color + " BORDER=\"0\"><I>objet " + type_in + "</I></TD></TR>" + buffer_description)
    dot.node(id_in, str_node)
    # draw edges with parents nodes
    # no edge if pointing itself
    if id_parent and (id_parent != id_in):
        cardinalite = (cardinalite[0], cardinalite[1].replace("n", "*"))
        dot.edge(id_in, id_parent, headlabel="1", taillabel="1" if cardinalite == ("1", "1") else cardinalite[0]+".."+cardinalite[1])
    return


def parse_object(dot, id_parent, dict_in, dict_definitions, buffer_description_node, id_ignore=[]):
    # no parsing of id to ignore
    if id_parent in id_ignore:
        if id_parent in buffer_description_node:
            buffer_description_node[id_parent] = "cf. objet du même type"
        return
    # buffer_description_node stores descrition of each node to append leaf description
    for id_child, child in dict_in["properties"].items():
        cardinalite_child = ("0", "1")
        # check if child is required
        if "required" in dict_in:
            if id_child in dict_in["required"]:
                cardinalite_child = set_cardinalite("1", cardinalite_child[1])
        # if is an array
        if "type" in child:
            # check if is an array
            if child["type"] == "array":
                cardinalite_child = set_cardinalite(cardinalite_child[0], str(child["maxItems"]) if child.get("maxItems") else "n")
                # consider now items as the child
                child = child["items"]
        # if is not an array
        # type = id in this case
        if "properties" in child:
            buffer_description_node[id_child] = ""
            parse_object(dot, id_child, child, dict_definitions, buffer_description_node, id_ignore=id_ignore)
            add_node(dot, id_parent, id_child, id_child,
                     buffer_description_node[id_child], cardinalite=cardinalite_child,
                     health_only=child["x-health-only"] if "x-health-only" in child else False)
        else:
            # if type is indicated consider as a leaf
            if "type" in child:
                # substitute format to type
                if "format" in child:
                    child["type"] = child["format"]
                if id_parent in buffer_description_node:
                    # if child is a leaf, description is appended to buffer_description_node for parent
                    # replacing n by * charachter
                    health_only = ""
                    # if child contains x-health-only: True, add 15-15 to the child description
                    if "x-health-only" in child and child["x-health-only"] == True:
                        health_only = " <B>15-15</B>"
                    child_description = "<TR><TD BORDER=\"0\" {}>{} <I>{}</I> : [{}..{}] {}</TD></TR>".format(
                        "BGCOLOR=\"#dceaf7\"" if "x-health-only" in child and child["x-health-only"] == True else "",
                        id_child,
                        child["type"],
                        cardinalite_child[0],
                        cardinalite_child[1].replace("n", "*"),
                        health_only)
                    buffer_description_node[id_parent] = buffer_description_node[id_parent] + child_description
            # else look for ref
            elif "$ref" in child:
                # getting type child and child with ref
                type_child = get_id_ref(child["$ref"])
                # print(id_parent + " - - >" + id_child)
                buffer_description_node[id_child] = ""
                # if child contains x-health-only: True or is a health-only array add 15-15 to the buffer
                if "x-health-only" in child and child["x-health-only"] == True:
                    buffer_description_node[id_child] = buffer_description_node[id_child]
                child = get_ref(child["$ref"], dict_definitions)
                parse_object(dot, id_child, child, dict_definitions, buffer_description_node, id_ignore=id_ignore)
                add_node(dot, id_parent, id_child, type_child,
                         buffer_description_node[id_child], cardinalite=cardinalite_child,
                         health_only=child["x-health-only"] if "x-health-only" in child else False)
            else:
                print("Erreur syntaxe json_schema " + id_parent + "... Generating anyway")
    return


def parse_root_node(dot, id_main_obj, dict_in, dict_definitions, buffer_description_node, id_ignore=[]):
    # recursive function needs to have main node set in place
    buffer_description_node[id_main_obj] = ""
    parse_object(dot, id_main_obj, dict_in, dict_definitions, buffer_description_node, id_ignore=id_ignore)
    add_node(dot, id_main_obj, id_main_obj, id_main_obj,
             buffer_description_node[id_main_obj], cardinalite=("1", "1"))
    return


## RUN
class Color:
    PURPLE = '\033[95m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'
    END = '\033[0m'
    WARNING = '\033[93m'


def run(model, root_name, version=date.today().strftime("%y.%m.%d")):
    print(f'{Color.BOLD}{Color.UNDERLINE}{Color.PURPLE}Building UML from version {version} of {model} ...{Color.END}')

    # Create new vis to start from empty canvas
    dot = graphviz.Digraph(comment='UML MDD Hub Sante', strict=True, node_attr={'shape': 'none'})
    # direction of graph
    dot.attr(rankdir="BT")

    # warning, if folder out/model empty, causes failure
    print("Loading schema.json from " + os.path.join("out", model) + "...")
    path = os.path.join("out", model, f"{model}.schema.json")
    with open(os.path.join(path), 'r') as file:
        json_in = json.load(file)
        print("schema.json loaded.")
        print("Parsing schema.json ...")
        parse_root_node(dot, root_name, json_in, json_in["definitions"], {}, id_ignore=["newAlert", "alertLocation"])
        print("Rendering " + os.path.join("out", model, model + ".uml_diagram.pdf") + " ...")
        dot.edge_attr.update(arrowhead='odiamond', arrowtail='none')
        dot.render(os.path.join("out", model, model + ".uml_diagram"))
        print("Done.")
    return


if __name__ == "__main__":
    parser = argparse.ArgumentParser(
        prog='UML Generator',
        description='Generate uml from json-schema',
    )
    parser.add_argument('-v', '--version', help='the version number to be used in model. Defaults to today.')
    parser.add_argument('-m', '--model', default="RC-EDA", help='the concerned model to parse')
    parser.add_argument('-o', '--obj', default="cisu", help='define the head object')
    args = parser.parse_args()

    run(args.model, args.obj, args.version)
