## Script pour le parsing des nomenclatures

### Installation

Les dépendances Python nécessaires peuvent être installés via le requirements.txt
```bash
pip install -r requirements.txt
```

L'installation de la librairie Python `xhtml2pdf` peut nécessiter des dépendances supplémentaires.
Sur MacOS, on devra ainsi installer `pkg-config`.
```bash
brew install pkg-config
```

### Utilisation

```python nomenclature_parser.py --version VERSION --folder FOLDER [--release]``` 
arguments optionnels
- où folder désigne le chemin pour le dossier dans lequel les excels d'entrée sont rangés
- où version désigne la version de nomenclature que l'on s'apprête à publier
- où release doit être présent pour créer un dossier spécifique d'output

### Génération

Un dossier par numéro de version est généré (si le dossier pour une numéro de version existe déjà, il est écrasé).
Les nomenclatures sont générées en .pdf et .csv (délimiteur ; et encodage utf-8) vers le dossier OUTPUT.
Le numéro de version est ajouté au nom des fichiers.
Un sommaire est généré automatiquement à la racine du dossier.

### Release des nomenclatures

Les releases > 1.3.1 sont mises à disposition dans les dossiers correspondant.
```bash
cp -r "/Users/romainfouilland/Library/CloudStorage/OneDrive-SharedLibraries-ANS/Espace Projets - Espace Programme SI-SAMU/01 - Equipe projet/07 - Innovation et prospectif/12 - Hub Santé/17 - MDD/Nomenclatures/01 - Base interne/" in/
# To use today's date as release version (otherwise, add --version flag)
python nomenclature_parser.py # --release # to be added to create release fodler
```