# Notes sur la configuration d'un générateur de lib Ruby pour porter le modèle du Hub Santé

### Principes de base :
- La CI du repo SAMU-Hub-Modeles suit en quasi continu les travaux éditeurs / métiers. Les modifications issues des échanges sont portées par le classeur [model.xslx](../../../csv_parser/models/model.xlsx).
- Ce fichier permet de générer en cascade les JSON-schemas et les XSDs des différents périmètres, des supports de documentation (contrat d'interface, diagrammes UML), et des descripteurs OpenAPI (uniquement sur le modèle de données)
- Un paquet npm permet d'appeler un des générateurs développés par la communauté OpenAPI, à partir des descripteurs OpenAPI. On trouve trace des appels dans cette [github action](../../../.github/workflows/generate-model.yaml) : 
- Ces différents générateurs peuvent être implémentés différemment ; mais dans l'ensemble le principe est le suivant : chaque objet défini dans le descripteur est injecté dans des templates prédéfinis, en fonction de paramètres configurables.

```bash
npx @openapitools/openapi-generator-cli generate -c ./config/$SCHEMA/$SCHEMA.generator-config.json --skip-validate-spec
```

### Arborescence du répertoire _generator_
Le répertoire _generator_ se décompose ainsi :
##### Configuration pour le générateur Java :
- [x] config : les fichiers de configuration du générateur Java, périmètre par périmètre
- [x] input : les descripteurs OpenAPI générés préalablement
- [x] classes : les classes Java générés (ce répertoire n'est pas forcément visible, car déplacé dans le code source à la fin de la github action)
- [x] templates : des templates mustache additionnels pour les classes Java. Par défaut, le générateur utilise ses propres templates, accessibles sur Github; il est possible de les surcharger via des templates locaux, comme ici.

##### Ajouts pour d'autres langages :
- [x] docs : des README pour chaque langage essayé
- [x] ruby : le répertoire de sortie des fichiers générés