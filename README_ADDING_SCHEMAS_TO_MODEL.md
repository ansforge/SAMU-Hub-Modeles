# Ajout d'un schema dans le modèle des données
## Contexte
La generation automatique des fichiers d'un schema est séparé en plusieurs etapes:
1. csv_parser, script parser_and_mv: le parseur csv utilise les onglets qui ne sont pas préfixés par '#' des fichiers excel contenus dans le repertoire "/models" pour générer les fichiers a parir des données contenus: un schema json, un docx pour visualiser les changements et une diagramme uml ainsi que les schemas asyncApi/openApi.
2. csv_parser, script output_schemas_yaml: de la meme manière, le parseur générer un fichier yaml qui contient des informations nécessaires pour les etapes suivants de la generation automatique.
3. automatic-schema-generator.sh: génére les fichiers suivants en utilisants les templates Go presents dans /templates et le fichier schemas.yaml génére a l'étape précédente:
   1. ContentMessage.java
   2. ContentMessageDeserializer.java
   3. EDXL-DE-full-schema.json
   4. RC-XML-ContentType.xsd
   5. Les fichiers utilisés pour la génération automatique des classes java
5. csv_parser, json_schema2xsd: génére les schemas xsd à partir des schemas json générés.
6. openapi-generator: génére les classes java a partir des fichiers config séparés en deux dossier: generator/config/generated qui contient les fichiers de config générés lors de l'etape 3, et generatr/config/manual qui contient les fichiers gérés manuellement.

## 1. Fichier excel
1. Modifier le [fichier .xlsx](https://esantegouv.sharepoint.com/:x:/r/sites/GED-Calypso/espace-projets/_layouts/15/Doc.aspx?sourcedoc=%7B6E6E8D74-7768-41E8-9A03-DAAD2DEDCE19%7D&file=MDD%20-%20Hub%20Sant%25u00e9.xlsx) existant ou creer un nouveau fichier pour ajouter une nouvelle feuille avec le nom du schema à ajouter.
2. Construire le tableau représentant le schema en suivant les règles décrites sur la [feuille "Mode d'emploi" du fichier](https://esantegouv.sharepoint.com/:x:/r/sites/GED-Calypso/espace-projets/_layouts/15/Doc.aspx?sourcedoc=%7B6E6E8D74-7768-41E8-9A03-DAAD2DEDCE19%7D&file=MDD%20-%20Hub%20Sant%C3%A9.xlsx&action=default&mobileredirect=true).
3. Construire le tableau de 'configuration' de l'onglet au dessus du tableau principal, en suivant la structure suivante (exemple du schema RC-EDA):
   |schema|perimeter|rootElement|package|customExtendPackage|customExtendClass|automaticGeneration|subschema|header|xmlns|
   |RC-EDA|15-18|createCase|cisu|||Y|N|Y|cisu:3.0|
   Les colonnes correspondant aux informations suivantes:
   1. schema: Nom du schema (RC-EDA, RS-EDA, RS-ER, RS-ERROR)
   2. perimetre: L'en-tete de la colonne perimetre correspondante (15-18, 15-15, 15-SMUR, 15-15)
   3. rootElement: Element racine du schema, utilisé additionnellement pour la génération des classes java (createCase, createCaseHealth, resourcesEngagement, error)
   4. package: Package java des classes générées. Préfixé avec "com.hubsante.model." (cisu, health, resources.info, report)
   5. customExtendPackage: Permet de spécifier le package de la classe étendue par la classe du wrapper du schema; "rcde" par default.
   6. customExtendClass: Similairement, permet de spécifier la classe étendue, "DistributionElement" par defaut.
   7. automaticGeneration: Indique si on souhaite générer les fichiers avec automatic-schema-generator pour le schema.
   8. subschema: Indique si le schema est un "sous-schema" d'un schema existant - c'est a dire si elle doit générer ou pas les classes enfants (nécessaire pour ne pas écraser les classes générés pour la classe parent)
   9. header: Indique si une en-tête RC-DE doit etre presente dans les messages correspondants au schema.
   10. xmlns: Indique le namespace xml de l'element racine du schema.
5. **NB.: A enlever dés que le mechanisme de détection des schemas dans le fichier mdd est mis à jour** Dans la cellule A1 de la feuille, lister, utilisant l'espace comme separateur, les schemas à generer à partir de cette feuille en suivant le modèle suivant: [[Nom du schema]:[Périmètre]:[Object racine]]. A noter qui la valeur "Périmètre" doit correspondre au titre d'une des colonnes de perimetre definies dans la feuille.

**Ex.:** La valeur **RC-EDA:15-18:createCase RS-EDA:15-15:createCaseHealth RS-EDA-MAJ:15-MAJ:createCaseHealthUpdate** dans la cellule A1 de la feuille RC-EDA génére 3 schemas distincts.

## 2. Csv parser
1. Mettre le fichier .xlsx, modifié ou créé, dans *./csv_parser/models/*.  
2. Modifier le fichier ./csv_parser/json_schema2xsd/src/main/java/json_schema2xsd/App.java :
   1. Dans la liste des schemas (ligne 25) ajouter le nom du schema (le meme qu'à la cellule A1).
   2. Dans le switch expression (ligne 91) ajouter un switch case sur le nom du schema, positionnant la variable root à la valeur d'objet racine du schema (le meme qu'à la cellule A1).
3. Modifier le fichier ./csv_parser/workflow.py : ajouter le nom de la feuille dans la liste 'sheets' s'il n y est pas présent.

## 3. Generator
Les instructions suivantes concernent seulement les schemas qui sont à maintenir manuellement, c'est à dire les fichiers contenus dans le répertoire generator/config/manual.
1. Dans le dossier *./generator/config* , créer un dossier portant le même nom que la feuille.
   
2. Dans le cas de base, dans le dossier créé, créer trois fichiers de configuration:
   1. [Nom du schema].generator-config.json
   2. [Nom du schema].usecase.generator-config.json
   3. [Nom du schema].wrapper.generator-config.json

3. Dans le cas d'un sous-schema qui contient des objets similaires (avec des proprietes en moins par rapport au schema de base), créer juste deux fichiers de configuration:
   1. [Nom du schema].usecase.generator-config.json
   2. [Nom du schema].wrapper.generator-config.json
      Puis ajouter le [Nom du schema] dans l'expression "if ... fi" de l'etape "Generate Java classes" du fichier *.github/workflows/generate-model.yaml*

4. Le contenu des fichiers doit correspondre au modele suivant:
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

## 4. Dans le cas d'ajout d'un schema en dehors de la pipeline de génération automatique, il est nécessaire de manuellement modifier les templates go, situés dans le répertoire automatic-schema-generator/templates. 
1. Modifier la template *ContentMessage.java.tmpl*, en rajoutant la classe wrapper générée dans la liste des @JsonSubTypes.Type annotations (e.g. **@JsonSubTypes.type([Titre du schema]Wrapper.class)** ) et dans la liste des schemas de la sous-classe **UseCaseHelper**, ainsi qu'ajouter les packages et classes nécessaries dans la liste des **imports**.
2. D'une maniere similaire, modifier la tempalte *ContentMessageDeserializer.java.tmpl*

3. Modifier la template */EDXL-DE-full.schema.json,tmpl* en ajoutant le nouveau schema dans l'element 'oneOf' de l'objet 'EmbeddedJsonContent'm typiquement:
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

3. Modifier le xsd schema *RC-XML-ContentType.xsd.tmpl* en ajoutant les éléments suivants:
   1. Une propriété **xmlns:[Objet racine (en flatcase)]="urn:emergency:cisu:3.0:[Objet racine]"** dans l'élément <schema> 
   2. Un import **<xs:import namespace="urn:emergency:cisu:3.0:[Objet racine]" schemaLocation="[Nom du schema].xsd"/>**
   3. Un element **<xs:element ref="[Objet racine (en flatcase)]:[Objet racine]"/>** a l'interieur de l'element <xs:choice> 

## 5 Lancer la génération des fichiers, en créant une pull request depuis la branche feature en question et poussant les modifications, declenchant l'action github sur le repo distant.**

## Penser à ajouter des fichiers exemples et des cas passants/non-passants dans src/main/resources/sample, ainsi que mettre en place des tests unitaires vérifiant la validation et la sérialisation/désérialisation des classes 

## 5. Front
1. Mettre a jour la map et le switch case dans /composables/messageUtils.js et /mixins/messageUtils.js dans le répo [Santé](https://github.com/ansforge/SAMU-Hub-Sante)
