import argparse
from datetime import date
import warnings
import graphviz  # doctest: +NO_EXE
import json
import os

# UTILS

dot = graphviz.Digraph(comment='UML MDD Hub Sante',strict=True,node_attr={'shape': 'none'})
# direction of graph
dot.attr(rankdir="BT")

# get ref dic objet from raw ref label
def get_ref(str_ref_in, dict_definitions_in) :
    # looking for ref in json
    # get ref from string
    # "#/definitions/etype"
    ref_in = str_ref_in[14:]
    if ref_in in dict_definitions_in :
        return dict_definitions_in[ref_in]
    print("Reference" + str_ref_in + " invalide")
    raise ValueError

#get ref type from raw ref label
def get_id_ref(str_ref_in) :
    ref_in = str_ref_in[14:]
    return ref_in

# define min max value for cardinality
def set_cardinalite(minimal, max) :
    minimal_valid = {"0", "1"}
    if minimal not in minimal_valid:
        raise ValueError
    max_valid = {"1", "n"}
    if max not in max_valid:
        raise ValueError
    return (minimal, max)




## PARSING


def add_node(id_parent, id_in, type_in, buffer_description, cardinalite):
    # draw node
    template_html_node = '''<<TABLE>
                <TR>
                <TD><B>{}</B></TD>
                </TR>
                <TR>
                <TD>{}</TD>
                </TR>
                </TABLE>>'''
    str_node = template_html_node.format(str(id_in), "<I>objet " + type_in + "</I>" + buffer_description)
    dot.node(id_in, str_node)
    # draw edges with parents nodes
    # no edge if pointing itself
    if id_parent and (id_parent != id_in):
        if cardinalite == ("0","1") :
            dot.edge(id_in, id_parent, 
                     constraint='true',
                     headlabel= "1", taillabel="0..1")
        elif cardinalite == ("1","1") :
            dot.edge(id_in, id_parent, 
                     constraint='true',
                     headlabel= "1", taillabel="1")
        elif cardinalite == ("1","n") :
            dot.edge(id_in, id_parent, 
                     constraint='true',
                     headlabel= "1", taillabel="1..*")
        elif cardinalite == ("0","n") :
            dot.edge(id_in, id_parent, 
                     constraint='true',
                     headlabel= "1", taillabel="0..*")
        else :
            print("Cardinalité renseignée incorrecte pour " + str(id_in))
            return ValueError
    return

def parse_object(id_parent, dict_in, dict_definitions, buffer_description_node, id_ignore=[]) :
    # no parsing of id to ignore
    if id_parent in id_ignore :
        if id_parent in buffer_description_node :
            buffer_description_node[id_parent] = "\ncf. objet du même type"
        return
    # buffer_description_node stores descrition of each node to append leaf description
    for id_child, child in dict_in["properties"].items() :
        cardinalite_child = ("0","1")
        # check if child is required
        if "required" in dict_in :
                if id_child in dict_in["required"] :
                    cardinalite_child = set_cardinalite("1", cardinalite_child[1])
        # if is an array
        if "type" in child :
            # check if is an array
            if child["type"] == "array" :
                cardinalite_child = set_cardinalite(cardinalite_child[0],"n")
                # consider now items as the child
                child = child["items"]
        # if is not an array
        # type = id in this case
        if "properties" in child :
            buffer_description_node[id_child] = ""
            parse_object(id_child, child, dict_definitions, buffer_description_node, id_ignore=id_ignore)
            add_node(id_parent, id_child, id_child,
                     buffer_description_node[id_child], cardinalite=cardinalite_child)
        else :
            # if type is indicated consider as a leaf
            if "type" in child :
                # substitute format to type
                if "format" in child :
                    child["type"] = child["format"]
                if id_parent in buffer_description_node :
                    #if child is a leaf, description is appended to buffer_description_node for parent
                    # replacing n by * charachter
                    child_description = "{} <I>{}</I> :  [{}..{}]".format(id_child, child["type"], 
                                                                cardinalite_child[0],
                                                                cardinalite_child[1].replace("n","*"))
                    buffer_description_node[id_parent] = buffer_description_node[id_parent] + "<BR/>" + child_description
            # else look for ref
            elif "$ref" in child :
                # getting type child and child with ref
                type_child = get_id_ref(child["$ref"])
                child = get_ref(child["$ref"], dict_definitions)
                # print(id_parent + " - - >" + id_child)
                buffer_description_node[id_child] = ""
                parse_object(id_child, child, dict_definitions, buffer_description_node, id_ignore=id_ignore)
                add_node(id_parent, id_child, type_child, 
                         buffer_description_node[id_child], cardinalite=cardinalite_child)
            else :
                print("Erreur syntaxe json_schema " + id_parent + "... Generating anyway")
    return

def parse_root_node(id_main_obj, dict_in, dict_definitions, buffer_description_node, id_ignore=[]) :
    # recursive function needs to have main node set in place
    buffer_description_node[id_main_obj] = ""
    parse_object(id_main_obj, dict_in, dict_definitions, buffer_description_node, id_ignore=id_ignore)
    add_node(id_main_obj, id_main_obj, id_main_obj,
             buffer_description_node[id_main_obj], cardinalite=("1","1"))
    return

## RUN
class Color:
    PURPLE = '\033[95m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'
    END = '\033[0m'


def run(model, obj, version=date.today().strftime("%y.%m.%d")):
    print(f'{Color.BOLD}{Color.UNDERLINE}{Color.PURPLE}Building UML from version {version} of {model} ...{Color.END}')

    # warning, if folder out/model empty, causes failure
    print("Loading schema.json from " + os.path.join("out", model) + "...")
    with open(os.path.join("out", model, "schema.json"), 'r') as file:
        json_in = json.load(file)
        print("schema.json loaded.")
        print("Parsing schema.json ...")
        parse_root_node(obj, json_in, json_in["definitions"], {}, id_ignore=["newAlert", "alertLocation"])
        print("Rendering " + os.path.join("out", model, "uml_schema.pdf") + " ...")
        dot.edge_attr.update(arrowhead='odiamond', arrowtail='none')
        dot.render(os.path.join("out", model, "uml_schema"))
        print("Done.")


if __name__ == "__main__":
    parser = argparse.ArgumentParser(
        prog='UML Generator',
        description='Generate uml from json-schema',
    )
    parser.add_argument('-v', '--version', help='the version number to be used in model. Defaults to today.')
    parser.add_argument('-m', '--model', default="RC-EDA.json", help='the concerned model to parse')
    parser.add_argument('-o', '--obj', default="cisu", help='define the head object')
    args = parser.parse_args()

    run(args.model, args.obj, args.version)
