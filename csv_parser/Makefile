# Copy nomenclatures excels from OneDrive to local folder
NOMENCLATURE_IN_FOLDER := "/Users/romainfouilland/Library/CloudStorage/OneDrive-SharedLibraries-ANS/Espace Projets - Espace Programme SI-SAMU/01 - Equipe projet/07 - Innovation et prospectif/12 - Hub Santé/17 - MDD/Nomenclatures/01 - Base interne/"
NOMENCLATURE_FOLDER := "../nomenclature_parser/in/"
# Copy the models xlsx from OneDrive to local folder
MODELS_IN_FILE := "/Users/romainfouilland/Library/CloudStorage/OneDrive-SharedLibraries-ANS/Espace Projets - Espace Programme SI-SAMU/01 - Equipe projet/07 - Innovation et prospectif/12 - Hub Santé/17 - MDD/MDD - Hub Santé.xlsx"
MODELS_FILE := "models.xlsx"
# Tracking branch
TRACKING_BRANCH_NAME := auto/model_tracker

CURRENT_DATE := $(shell date +'%y.%m.%d %H:%M')

.PHONY: setup nomenclatures run

setup:
	@echo "Copying nomenclatures excels from OneDrive to local folder..."
	cp -r $(NOMENCLATURE_IN_FOLDER) $(NOMENCLATURE_FOLDER)
	@echo "Copying models excel from OneDrive to local folder..."
	cp $(MODELS_IN_FILE) $(MODELS_FILE)

nomenclatures:
	@if git diff-index --quiet HEAD -- $(NOMENCLATURE_FOLDER); then \
		echo "No changes in $(NOMENCLATURE_FOLDER), skipping nomenclatures generation..."; \
	else \
		echo "Changes detected in $(NOMENCLATURE_FOLDER), running nomenclatures generation..."; \
		cd ../nomenclature_parser && python nomenclature_parser.py; \
	fi

run:
	@echo "Checking out tracking branch ($(TRACKING_BRANCH_NAME)), copying files and committing changes..."
	git checkout $(TRACKING_BRANCH_NAME)
	make setup
	git add ..
	make nomenclatures
	git commit -m "[$(CURRENT_DATE)] Model auto-generation"
	git push origin $(TRACKING_BRANCH_NAME)
