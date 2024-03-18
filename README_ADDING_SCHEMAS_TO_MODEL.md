# Ajout d'un schema dans le modèle des données

# 1. Fichier excel
1. Créer une nouvelle feuille dans le [fichier .xlsx](https://esantegouv.sharepoint.com/:x:/r/sites/GED-Calypso/espace-projets/_layouts/15/Doc.aspx?sourcedoc=%7B6E6E8D74-7768-41E8-9A03-DAAD2DEDCE19%7D&file=MDD%20-%20Hub%20Sant%25u00e9.xlsx).
2. Construire le tableau representant le schema en suivant les regles decrites sur la [feuille "Mode d'emploi" du fichier](https://esantegouv.sharepoint.com/:x:/r/sites/GED-Calypso/espace-projets/_layouts/15/Doc.aspx?sourcedoc=%7B6E6E8D74-7768-41E8-9A03-DAAD2DEDCE19%7D&file=MDD%20-%20Hub%20Sant%C3%A9.xlsx&action=default&mobileredirect=true). 

*A noter que 'titre' du schema (cellule A1) va etre utilisé en tant que nom des classes Java générés.*

# 2. Csv parser
1. Remplacer le fichier ./csv_parser/model.xlsx avec le fichier modifié dans la branche feature concerné.
2. Ajouter le nom de la feuille crée dans la liste des schemas dans le fichier ./csv_parser/json_schema2xsd/src/main/java/json_schema2xsd/App.java :
   1. Dans la liste des schemas (ligne 25) ajouter le nom de la feuille.
   2. Dans le switch expression (ligne 91) ajouter un switch case sur le nom de la feuille, positionnant la variable root au 'titre' du schema (qui se trouve a la cellule A1 de la feuille).

# 3. Generator
1. Dans le dossier ./generator/config , créer un dossier portant le meme nom que la feuille.
2. Dans le dossier créé, créer trois fichiers de configuration:
   1. [Nom de la feuille].generator-config.json
   2. [Nom de la feuille].usecase.generator-config.json
   3. [Nom de la feuille].wrapper.generator-config.json
3. Le contenu des fichiers doit correspondre au modele suivant:
```
{
  "inputSpec": "./input/[Nom de la feuille].openapi.yaml",
  "outputDir": "classes/",
  "generatorName": "java",
  "templateDir": [Varie en fonction du fichier config]
  "globalProperties": {
    "models": [Varie en fonction du fichier config]
    "apis": false,
    "apiTests": false,
    "apiDocs": false,
    "modelDocs": false,
    "modelTests": false
  },
  "additionalProperties": {
    "library": "native",
    "modelPackage": "com.hubsante.model.[Titre du schema (en flatcase)]",
    "serializationLibrary": "jackson",
    "openApiNullable": true,
    "supportUrlQuery": false,
    "enablePostProcessFile": true
  }
}
```
Les propriétés "templateDir" et "models" vont varier selon le fichier:
1. [Nom de la feuille].generator-config.json:
```
   "templateDir": "templates/child-classes/",
   "models": "",
```
2. [Nom de la feuille].usecase.generator-config.json:
```
   "templateDir": "templates/useCase/",
   "models": "[Titre du schema]",
```
3. [Nom de la feuille].wrapper.generator.config.json:
```
   "templateDir": "templates/useCase/",
   "models": "[Titre du schema]Wrapper",
```
   
