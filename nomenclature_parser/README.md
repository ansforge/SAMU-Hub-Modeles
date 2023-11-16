## Script pour le parsing des nomenclatures

### Utilisation

```python nomenclature_parser.py --version VERSION --folder FOLDER --output OUTPUT``` 
arguments optionnels
- où folder désigne le chemin pour le dossier dans lequel les excels d'entrée sont rangées
- où output désigne le chemin pour le dossier dans lequel les fichiers générés par le script seront rangés
- où version désigne la version de nomenclature que l'on s'apprête à publier

### Génération

Un dossier par numéro de version est généré (si le dossier pour une numéro de version existe déjà, il est écrasé).
Les nomenclatures sont générées en .pdf et .csv (délimiteur ; et encodage utf-8) vers le dossier OUTPUT.
Le numéro de version est ajouté au nom des fichiers.
Un sommaire est généré automatiquement à la racine du dossier.

### Release des nomenclatures

Les releases > 1.3.1 sont mises à disposition dans les dossiers correspondant.