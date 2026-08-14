# Installation
```bash
pip install -r requirements.txt
```
For the UML generator (run automatically within the CSV parser), in addition to the `requirements.txt`, you need to install graphviz on your execution environment https://graphviz.org/

# Usage
## CSV Parser
```bash
# -s/--sheet, -n/--name, -m/--model-type, -p/--filepath are required
# -v/--version defaults to today (YY.MM.DD), -f/--filter defaults to False
# by default, integrate uml generation process
python csv_parser.py -s RC-DE -n toto -v 0.5 -m distributionElement -p models/model.xlsx
python csv_parser.py --sheet RC-DE --name toto --version 0.5 --model-type distributionElement --filepath models/model.xlsx
```
`--model-type` (rootElement) and `--filepath` (source xlsx) are looked up per sheet in `out/schemas.yaml`.

## Full pipeline
The full pipeline is defined in the GitHub action. 
To run it locally, you can rely on [act](https://github.com/nektos/act) and its [medium image runner](https://github.com/nektos/act?tab=readme-ov-file#runners).
Check the [documentation](https://github.com/nektos/act?tab=readme-ov-file#github_token) to provide your `GITHUB_TOKEN`.
```bash
# Using GitHub CLI to get GitHub token
act -s GITHUB_TOKEN="$(gh auth token)"
```

## JsonSchema to UML
UML generator is called by default in the `csv_parser.py` but you may want to run it directly.
```bash
# Params to specify model and version
python uml_generator.py -m RC-EDA -o cisu -v 1.12
python uml_generator.py --model RC-EDA --obj cisu --version 1.12
```

# Automatic nomenclature & model push
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
