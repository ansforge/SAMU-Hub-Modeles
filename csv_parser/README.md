# Installation
```bash
pip install -r requirements.txt
```

# Setup
## Run
```bash
# Run everything
./auto.sh
```

## Cron
### Setup
Weird bug left `git push` hanging and not doing anything. Updating remote from https to git fixed it.
```bash
git remote set-url origin git@github.com:ansforge/SAMU-Hub-Modeles.git
```

### Crontab
Update local crons (`crontab -e`). To see current crons, use `crontab -l`.
```bash
# - For frequent runs 
30 9-17/2 * * 1-5 cd ~/code/ans/AUTO_SAMU-Hub-Modeles/csv_parser/ && (./auto.sh >>cron.log 2>&1)
# - For weekly log deletion
30 17 1-7 * 5 rm ~/code/ans/AUTO_SAMU-Hub-Modeles/csv_parser/cron.log
# - For debug (run every minute)
# * * * * * cd ~/code/ans/AUTO_SAMU-Hub-Modeles/csv_parser/ && (./auto.sh >>cron.log 2>&1)
```

## Merge and branch creation process
```bash
# Review PR and merge it in GitHub
# Go to local tracker repo 
cd ~/code/ans/AUTO_SAMU-Hub-Modeles/
# Delete remote branch (also doable on GitHub PR)
git push origin --delete auto/model_tracker
# Delete local branch
git checkout main
git branch -D auto/model_tracker
# Pull latest main state
git pull
# Recreate branch from latest main
git checkout -b auto/model_tracker
# Link it with remote branch
git push -u origin auto/model_tracker
```

# CSV to JsonSchema
## Usage
```bash
# Params to specify the sheet and version
# by default, integrate uml generation process
python csv_parser.py -s RC-DE -v 0.5  
python csv_parser.py --sheet RC-DE --version 0.5
# Defaults to RC-EDA and today (YY.MM.DD)
python csv_parser.py
```

## 
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

# JsonSchema to UML
## Installation
In addition to the `requirementx.txt`, you need to install graphviz on your execution environment https://graphviz.org/

## Usage
UML generator is called by default in the `csv_parser.py` but you may want to run it directly.
```bash
# Params to specify model and version
python uml_generator.py -m RC-EDA -o cisu -v 1.12
python uml_generator.py --model RC-EDA --obj cisu --version 1.12
```
