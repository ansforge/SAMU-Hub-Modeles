# Ajout d'un schema dans le modèle des données

## 1. Fichier excel
1. Créer une nouvelle feuille dans le [fichier .xlsx](https://esantegouv.sharepoint.com/:x:/r/sites/GED-Calypso/espace-projets/_layouts/15/Doc.aspx?sourcedoc=%7B6E6E8D74-7768-41E8-9A03-DAAD2DEDCE19%7D&file=MDD%20-%20Hub%20Sant%25u00e9.xlsx).
2. Construire le tableau représentant le schema en suivant les règles décrites sur la [feuille "Mode d'emploi" du fichier](https://esantegouv.sharepoint.com/:x:/r/sites/GED-Calypso/espace-projets/_layouts/15/Doc.aspx?sourcedoc=%7B6E6E8D74-7768-41E8-9A03-DAAD2DEDCE19%7D&file=MDD%20-%20Hub%20Sant%C3%A9.xlsx&action=default&mobileredirect=true). 

*Le 'titre' du schema (cellule A1) va etre utilisé en tant que nom des classes Java générés, ainsi que pour générer le namespace XML du périmètre. Il doit être écrit en camelCase.*

## 2. Csv parser
1. Remplacer le fichier *./csv_parser/model.xlsx* avec le fichier modifié dans la branche feature concernée.
2. Modifier le fichier ./csv_parser/json_schema2xsd/src/main/java/json_schema2xsd/App.java :
   1. Dans la liste des schemas (ligne 25) ajouter le nom de la feuille.
   2. Dans le switch expression (ligne 91) ajouter un switch case sur le nom de la feuille, positionnant la variable root au 'titre' du schema (qui se trouve a la cellule A1 de la feuille).

## 3. Generator
1. Dans le dossier *./generator/config* , créer un dossier portant le même nom que la feuille.
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
                  "[Titre du schema]": {
                     "$ref": "[Nom de la feuille].schema.json"
                  }
               },
               "required": [
                  "[Titre du schema]"
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
   1. Une propriété **xmlns:[Titre du schema (en flatcase)]="urn:emergency:cisu:2.0:[Titre du schema]"** dans l'élément <schema> 
   2. Un import **<xs:import namespace="urn:emergency:cisu:2.0:[Titre du schema]" schemaLocation="[Nom de la feuille].xsd"/>**
   3. Un element **<xs:element ref="[Titre du schema (en flatcase)]:[Titre du schema]"/>** a l'interieur de l'element <xs:choice> 

## Penser à ajouter des fichiers exemples et des cas passants/non-passants dans src/main/resources/sample, ainsi que mettre en place des tests unitaires vérifiant la validation et la sérialisation/désérialisation des classes 
