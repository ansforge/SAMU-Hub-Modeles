import os
import argparse

# custom lib
import hubsante.loader as loader

FOLDER = "in"

parser = argparse.ArgumentParser(
    prog='Nomenclature Parser',
    description='Parses and converts the Excel Nomenclature to the other needed formats and generates a summary',
)
parser.add_argument('-v', '--version', help='the version number to be used in nomenclature. Defaults to today.')
parser.add_argument('-f', '--folder', default="in", help='the folder to be parsed')
args = parser.parse_args()

if args.version :
    RELEASE = "v" + args.version
if args.folder :
    FOLDER = args.folder

def main() :
    # create output folder
    if not os.path.isdir("out") :
        os.mkdir("out")
    if not os.path.isdir(os.path.join("out","release_" + RELEASE)) :
        os.mkdir(os.path.join("out","release_" + RELEASE))
    loader.parse_folder(FOLDER, release=RELEASE)
    return

if __name__ == '__main__' :
    main()