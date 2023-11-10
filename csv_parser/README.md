# CSV to JsonSchema
## Installation
```bash
pip install -r requirements.txt
```

## Usage
```bash
# Params to specify the sheet and version
python csv_parser.py -s RC-DE -v 0.5  
python csv_parser.py --sheet RC-DE --version 0.5
# Defaults to RC-EDA and today (YY.MM.DD)
python csv_parser.py
```

```bash
cp "/Users/romainfouilland/Library/CloudStorage/OneDrive-SharedLibraries-ANS/Espace Projets - Espace Programme SI-SAMU/01 - Equipe projet/07 - Innovation et prospectif/12 - Hub Santé/17 - MDD/MDD - Hub Santé.xlsx" model.xlsx
python csv_parser.py
# AsyncAPI cleaning and generation
awk '!/example: /' out/RC-EDA/hubsante.asyncapi.yaml > tmpfile && mv tmpfile out/RC-EDA/hubsante.asyncapi.yaml
awk '!/example: /' out/RC-DE/hubsante.asyncapi.yaml > tmpfile && mv tmpfile out/RC-DE/hubsante.asyncapi.yaml
awk '{sub("#/definitions/","#/components/schemas/")} {print}' out/RC-EDA/hubsante.asyncapi.yaml > tmpfile && mv tmpfile out/RC-EDA/hubsante.asyncapi.yaml
awk '{sub("#/definitions/","#/components/schemas/")} {print}' out/RC-DE/hubsante.asyncapi.yaml > tmpfile && mv tmpfile out/RC-DE/hubsante.asyncapi.yaml
asyncapi generate fromTemplate ../hubsante.asyncapi.yaml  @asyncapi/html-template@0.28.0 -o ../../web/specs --force-write
```

# JsonSchema to uml
## Installation

Install graphviz on your execution environnement
https://graphviz.org/
```bash
pip install -r requirements.txt
```

## Usage
```bash
# Params to specify model and version
python uml_generator.py -m RC-EDA -o cisu -v 1.12
python uml_generator.py --model RC-EDA --obj cisu --version 1.12
```


