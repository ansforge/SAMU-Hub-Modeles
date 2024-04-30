#!/bin/bash

# Set variables
NOMENCLATURE_IN_FOLDER="/Users/romainfouilland/Library/CloudStorage/OneDrive-SharedLibraries-ANS/Espace Projets - Espace Programme SI-SAMU/01 - Equipe projet/07 - Innovation et prospectif/12 - Hub Santé/17 - MDD/Nomenclatures/01 - Base interne/"
NOMENCLATURE_FOLDER="../nomenclature_parser/in/"
MODELS_IN_FILE="/Users/romainfouilland/Library/CloudStorage/OneDrive-SharedLibraries-ANS/Espace Projets - Espace Programme SI-SAMU/01 - Equipe projet/07 - Innovation et prospectif/12 - Hub Santé/17 - MDD/MDD - Hub Santé.xlsx"
MODELS_FILE="model.xlsx"
TRACKING_BRANCH_NAME="auto/model_tracker"
DATE=$(date +'%y.%m.%d %H:%M')
LOG_FILE="cron.log"

# Enable printing of each command
set -x

# Function to copy nomenclatures excels from OneDrive to local folder
setup() {
  echo "Copying nomenclatures excels from OneDrive to local folder..."
  rm -r "$NOMENCLATURE_FOLDER"
  cp -r "$NOMENCLATURE_IN_FOLDER" "$NOMENCLATURE_FOLDER"
  echo "Copying models excel from OneDrive to local folder..."
  cp "$MODELS_IN_FILE" "$MODELS_FILE"
}

# Function to check for changes in nomenclature folder and run nomenclatures generation
nomenclatures() {
  if git diff-index --quiet HEAD -- "$NOMENCLATURE_FOLDER"; then
    echo "No changes in $NOMENCLATURE_FOLDER, skipping nomenclatures generation..."
  else
    echo "Changes detected in $NOMENCLATURE_FOLDER, running nomenclatures generation..."
    cd ../nomenclature_parser && /Users/romainfouilland/code/envs/all/bin/python nomenclature_parser.py && git add .
  fi
}

# Function to run the script
run() {
  echo "[$DATE] Running script..." | tee -a "$LOG_FILE"
  echo "Checking out tracking branch ($TRACKING_BRANCH_NAME), copying files and committing changes..."
  git checkout "$TRACKING_BRANCH_NAME"
  git pull --rebase
  setup
  git add ..
  nomenclatures
  if git diff-index --quiet HEAD -- ..; then
    echo "No changes found, skipping commit."
  else
    echo "Changes detected, committing updated files..."
    DATE=$(date +'%y.%m.%d %H:%M')
    git commit -m "[$DATE] Model auto-generation"
  fi

  LOCAL_COMMITS_AHEAD=$(git rev-list --count @{u}..HEAD)
  if [ $LOCAL_COMMITS_AHEAD -gt 0 ]; then
    echo "Remote $LOCAL_COMMITS_AHEAD commits behind, pushing..."
    git push --verbose
  else
    echo "Remote up-to-date, skipping push."
  fi

  echo "[$DATE] Run done." | tee -a "$LOG_FILE"
}

# Execute the run function
run
