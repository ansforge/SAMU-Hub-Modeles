# CSV to JsonSchema
## Installation
```bash
pip install -r requirements.txt
```

## Usage
```bash
cp "/Users/romainfouilland/Library/CloudStorage/OneDrive-SharedLibraries-ANS/Espace Projets - Espace Programme SI-SAMU/01 - Equipe projet/07 - Innovation et prospectif/12 - Hub Santé/12 - 15-18/41 - MDD/20230704 - MDD SAMU-NexSIS.xlsx" model.xlsx
python csv_parser.py
# AsyncAPI cleaning and generation
awk '!/example: /' hubsante.asyncapi.yaml > tmpfile && mv tmpfile hubsante.asyncapi.yaml
awk '{sub("#/definitions/","#/components/schemas/")} {print}' hubsante.asyncapi.yaml > tmpfile && mv tmpfile hubsante.asyncapi.yaml
ag hubsante.asyncapi.yaml @asyncapi/html-template -o asyncapi --force-write
```