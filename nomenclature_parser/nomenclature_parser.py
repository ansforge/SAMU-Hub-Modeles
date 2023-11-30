import os
import argparse
from datetime import date
from distutils.dir_util import copy_tree
import shutil

# custom lib
import hubsante.loader as loader

parser = argparse.ArgumentParser(
    prog='Nomenclature Parser',
    description='Parses and converts the Excel Nomenclature to the other needed formats and generates a summary',
)
parser.add_argument('-v', '--version', help='the version number to be used in nomenclature. Defaults to today.')
parser.add_argument('-f', '--folder', default="in", help='the folder to be parsed')
parser.add_argument('-r', '--release', action=argparse.BooleanOptionalAction)
args = parser.parse_args()

VERSION = "v" + (args.version or date.today().strftime("%y.%m.%d"))
FOLDER = args.folder
OUTPUT_LATEST = "out/latest/"


def main():
    # Clean current latest output
    shutil.rmtree(OUTPUT_LATEST)
    os.mkdir(OUTPUT_LATEST)
    # Parse nomenclatures
    loader.parse_folder(FOLDER, VERSION, OUTPUT_LATEST)
    # If release, copy it to specific folder
    if args.release:
        copy_tree(OUTPUT_LATEST, f"out/{VERSION}")


if __name__ == '__main__':
    main()
