# Ajout d'un schema dans le modèle des données

## 1. Fichier excel
1. Modifier le [fichier .xlsx](https://esantegouv.sharepoint.com/:x:/r/sites/GED-Calypso/espace-projets/_layouts/15/Doc.aspx?sourcedoc=%7B6E6E8D74-7768-41E8-9A03-DAAD2DEDCE19%7D&file=MDD%20-%20Hub%20Sant%25u00e9.xlsx) existant ou creer un nouveau fichier pour ajouter une nouvelle feuille avec le nom du schema à ajouter.
2. Construire le tableau représentant le schema en suivant les règles décrites sur la [feuille "Mode d'emploi" du fichier](https://esantegouv.sharepoint.com/:x:/r/sites/GED-Calypso/espace-projets/_layouts/15/Doc.aspx?sourcedoc=%7B6E6E8D74-7768-41E8-9A03-DAAD2DEDCE19%7D&file=MDD%20-%20Hub%20Sant%C3%A9.xlsx&action=default&mobileredirect=true). 
3. Dans la cellule A1 de la feuille, lister, utilisant l'espace comme separateur, les schemas à generer à partir de cette feuille en suivant le modèle suivant: [[Nom du schema]:[Périmètre]:[Object racine]]. A noter qui la valeur "Périmètre" doit correspondre au titre d'une des colonnes de perimetre definies dans la feuille.

**Ex.:** La valeur **RC-EDA:15-18:createCase RS-EDA:15-15:createCaseHealth RS-EDA-MAJ:15-MAJ:createCaseHealthUpdate** dans la cellule A1 de la feuille RC-EDA génére 3 schemas distincts.

## 2. Csv parser
1. Mettre le fichier .xlsx, modifié ou créé, dans *./csv_parser/models/*.  
2. Modifier le fichier ./csv_parser/json_schema2xsd/src/main/java/json_schema2xsd/App.java :
   1. Dans la liste des schemas (ligne 25) ajouter le nom du schema (le meme qu'à la cellule A1).
   2. Dans le switch expression (ligne 91) ajouter un switch case sur le nom du schema, positionnant la variable root à la valeur d'objet racine du schema (le meme qu'à la cellule A1).

## 3. Generator
1. Dans le dossier *./generator/config* , créer un dossier portant le même nom que la feuille.
2. Dans le dossier créé, créer trois fichiers de configuration:
   1. [Nom du schema].generator-config.json
   2. [Nom du schema].usecase.generator-config.json
   3. [Nom du schema].wrapper.generator-config.json
3. Le contenu des fichiers doit correspondre au modele suivant:
```
{
  "inputSpec": "./input/[Nom du schema].openapi.yaml",
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
    "modelPackage": "com.hubsante.model.[Package désiré]",
    "serializationLibrary": "jackson",
    "openApiNullable": true,
    "supportUrlQuery": false,
    "enablePostProcessFile": true
  }
}
```
Les propriétés "templateDir" et "models" vont varier selon le fichier:
1. [Nom du schema].generator-config.json:
```
   "templateDir": "templates/child-classes/",
   "models": "",
```
2. [Nom du schema].usecase.generator-config.json:
```
   "templateDir": "templates/useCase/",
   "models": "[Object racine]",
```
3. [Nom du schema].wrapper.generator.config.json:
```
   "templateDir": "templates/useCase/",
   "models": "[Object racine]Wrapper",
```

**4. Lancer la génération des fichiers, soit en exécutant la github action generate-model en local grace a github act ou en créant une pull request depuis la branche feature en question et poussant les modifications, declenchant l'action github sur le repo distant et ensuite recuperant les fichiers générés.**
   
## 4. Java
1. Modifier la classe com/hubsante/model/edxl/ContentMessage.java, en ajoutant la classe wrapper générée dans la liste des @JsonSubTypes.Type annotations (e.g. **@JsonSubTypes.type([Titre du schema]Wrapper.class)** )

2. Modifier le json schema *src/main/resources/json-schema/EDXL-DE-full.schema.json* en ajoutant le nouveau schema dans l'element 'oneOf' de l'objet 'EmbeddedJsonContent'm typiquement:
```
"oneOf": [
   ...
      {
         "allOf": [
         {
            "properties": {
               "message": {
               "$ref": "RC-DE.schema.json"
               }
            }
         },
         {
            "properties": {
               "message": {
               "properties": {
                  "[Objet racine]": {
                     "$ref": "[Nom du schema].schema.json"
                  }
               },
               "required": [
                  "[Objet racine]"
               ]
               }
            }
         }
         ]
      }
   ...
]
```
Si la présence de l'en-tete RC-DE n'est pas désirée, il est seulement nécessaire d'ajouter la partie "properties" contenant le nouveau schema.

3. Modifier le xsd schema *src/main/resources/xsd/RC-XML-ContentType.xsd* en ajoutant les éléments suivants:
   1. Une propriété **xmlns:[Objet racine (en flatcase)]="urn:emergency:cisu:2.0:[Objet racine]"** dans l'élément <schema> 
   2. Un import **<xs:import namespace="urn:emergency:cisu:2.0:[Objet racine]" schemaLocation="[Nom du schema].xsd"/>**
   3. Un element **<xs:element ref="[Objet racine (en flatcase)]:[Objet racine]"/>** a l'interieur de l'element <xs:choice> 

## Penser à ajouter des fichiers exemples et des cas passants/non-passants dans src/main/resources/sample, ainsi que mettre en place des tests unitaires vérifiant la validation et la sérialisation/désérialisation des classes 
