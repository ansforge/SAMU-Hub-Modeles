import openpyxl
import os
import pandas as pd
import json
import yaml
import argparse
from datetime import date
import datetime
import warnings
import docx
from docx2pdf import convert
import argparse

# custom lib
import hubsante.loader as loader

FOLDER = "in"
RELEASE = "v1.1"

parser = argparse.ArgumentParser(
    prog='Nomenclature Parser',
    description='Parses and converts the Excel Nomenclature to the other needed formats and generates a summary',
)
parser.add_argument('-v', '--version', help='the version number to be used in nomenclature. Defaults to today.')
parser.add_argument('-f', '--folder', default="in", help='the folder to be parsed')
args = parser.parse_args()

if args.version :
    RELEASE = args.version
if args.folder :
    FOLDER = args.folder

def main() :
    loader.parse_folder(FOLDER, release=RELEASE)
    return

if __name__ == '__main__' :
    main()