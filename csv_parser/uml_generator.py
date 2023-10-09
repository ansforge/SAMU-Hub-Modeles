import argparse
from datetime import date
import warnings
import graphviz  # doctest: +NO_EXE
import json
import os

parser = argparse.ArgumentParser(
    prog='UML Generator',
    description='Generate uml from json-schema',
)

parser.add_argument('-v', '--version', help='the version number to be used in model. Defaults to today.')
parser.add_argument('-m', '--model', default="RC-EDA.json", help='the concerned model to parse')
parser.add_argument('-o','--obj', default="cisu", help='define the head object')
args = parser.parse_args()


class Color:
    PURPLE = '\033[95m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'
    END = '\033[0m'


args.version = args.version or date.today().strftime("%y.%m.%d")
print(f'{Color.BOLD}{Color.UNDERLINE}{Color.PURPLE}Building UML from version {args.version} of {args.model} ...{Color.END}')

# UTILS

dot = graphviz.Digraph(comment='UML MDD Hub Sante',strict=True,node_attr={'shape': 'box'})
dot.attr(rankdir="BT")


def read_json(path_in) :
    json_file = path_in
    # Opening JSON file
    f = open(path_in)
    # returns JSON object as
    # a dictionary
    json_out = json.load(f)
    # Closing file
    f.close()
    return json_out

# get ref dic objet from raw ref label
def get_ref(str_ref_in, dict_definitions_in) :
    # looking for ref in json
    # get ref from string
    # "#/definitions/etype"
    ref_in = str_ref_in[14:]
    if ref_in in dict_definitions_in :
        print("Reference" + str_ref_in + " valide")
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

def add_node(id_parent, id_in, type_in, buffer_description, cardinalite=("0","1"), dot_in=dot) :
    # in practice definition uses "title"
    dot.node(id_in, 
            str(id_in) + "\n" + "objet " + type_in + buffer_description)
    if id_parent :
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
            buffer_description_node["id_parent"] = "cf. objet du même type"
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
            print(id_child + " Object")
            print(id_parent + " - - >" + id_child)
            buffer_description_node[id_child] = ""
            parse_object(id_child, child, dict_definitions, buffer_description_node, id_ignore=id_ignore)
            add_node(id_parent, id_child, id_child,
                     buffer_description_node["id_child"], cardinalite=cardinalite_child)
        else :
            # if type is indicated consider as a leaf
            if "type" in child :
                print(id_child + " Feuille")
                print(id_parent + " - - >" + id_child)
                if id_parent in buffer_description_node :
                    #if child is a leaf, description is appended to buffer_description_node for parent
                    child_description = "{} {}: [{}:{}]".format(id_child, child["type"], 
                                                                cardinalite_child[0],
                                                                cardinalite_child[1])
                    buffer_description_node[id_parent] = buffer_description_node[id_parent] + "\n" + child_description
            # else look for ref
            elif "$ref" in child :
                print(id_child + " Object Ref")
                # getting type child and child with ref
                type_child = get_id_ref(child["$ref"])
                child = get_ref(child["$ref"], dict_definitions)
                print(id_parent + " - - >" + id_child)
                buffer_description_node[id_child] = ""
                parse_object(id_child, child, dict_definitions, buffer_description_node, id_ignore=id_ignore)
                add_node(id_parent, id_child, type_child, 
                         buffer_description_node[id_child], cardinalite=cardinalite_child)
            else :
                print("Erreur syntaxe json_schema " + id_parent + "... Generating anyway")
    return

## RUN

# warning, if folder out/args.model empty, causes failure
json_in = read_json(os.path.join("out", args.model, "schema.json"))
parse_object(args.obj, json_in, json_in["definitions"], {}, id_ignore=["newAlert"])
dot.edge_attr.update(arrowhead='odiamond',arrowtail='none')
dot.render(os.path.join("out",args.model,"uml_schema.pdf"))
