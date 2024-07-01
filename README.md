<h1 align="center">Hub Santé - librairie Modèles</h1>
<p align="center">
  <img alt="Version" src="https://img.shields.io/badge/version-0.3-blue.svg?cacheSeconds=2592000" />
  <a href="#" target="_blank">
    <img alt="License: Apache-2.0" src="https://img.shields.io/badge/License-Apache_2.0-yellow.svg" />
  </a>
</p>

> Librairie du modèle de données utilisé par le projet SAMU-Hub-Santé (Plateforme d'échanges de messages asynchrones entre les acteurs de l'urgence)

🏠 [Page d'accueil](https://github.com/ansforge/SAMU-Hub-Modeles)

## Usage

Cette librairie est utilisée par le projet [SAMU-Hub-Santé](https://github/.com/ansforge/SAMU-Hub-Sante).

Elle contient les classes Java permettant de manipuler les messages échangés entre les acteurs de l'urgence, ainsi que quelques utilitaires (pour les opérations de sérialisation/désérialisation ou de validation notamment).

Les json-schemas sont disponibles dans le répertoire [src/main/resources/json-schema](src/main/resources/json-schema).
Des exemples de messages sont disponibles dans le répertoire [src/main/resources/sample/valid](src/main/resources/sample/valid).

Les spécifications du modèle de données sont disponibles sur le [site du projet SAMU-Hub-Santé](https://hub.esante.gouv.fr/).

## Correspondance DSF - librairie

||Release|Périmètre 15-15|Périmètre 15-NexSIS|Périmètre 15-SMUR|
|-|-|-|-|-|
|[0.5](https://github.com/ansforge/SAMU-Hub-Modeles/tree/0.5.1)|1.2|1.6|1.1|
|[0.6](https://github.com/ansforge/SAMU-Hub-Modeles/tree/0.6.0)|1.3|1.6|1.2|

## Modèles

||[Schéma](src/main/resources/json-schema/)|Détails|UML|
|-|-|-|-|
|EMSI|[EMSI.schema.json](src/main/resources/json-schema/EMSI.schema.json)|[EMSI.schema.docx](csv_parser/out/EMSI/EMSI.schema.docx)|[EMSI.uml_diagram.pdf](csv_parser/out/EMSI/EMSI.uml_diagram.pdf)|
|RC-DE|[RC-DE.schema.json](src/main/resources/json-schema/RC-DE.schema.json)|[RC-DE.schema.docx](csv_parser/out/RC-DE/RC-DE.schema.docx)|[RC-DE.uml_diagram.pdf](csv_parser/out/RC-DE/RC-DE.uml_diagram.pdf)|
|RC-EDA|[RC-EDA.schema.json](src/main/resources/json-schema/RC-EDA.schema.json)|[RC-EDA.schema.docx](csv_parser/out/RC-EDA/RC-EDA.schema.docx)|[RC-EDA.uml_diagram.pdf](csv_parser/out/RC-EDA/RC-EDA.uml_diagram.pdf)|
|RS-EDA|[RS-EDA.schema.json](src/main/resources/json-schema/RS-EDA.schema.json)|[RS-EDA.schema.docx](csv_parser/out/RS-EDA/RS-EDA.schema.docx)|[RS-EDA.uml_diagram.pdf](csv_parser/out/RS-EDA/RS-EDA.uml_diagram.pdf)|

[Exemples des messages](src/main/resources/sample/examples/)

N. B. : Pour accéder aux versions les plus recentes des fichiers, veuillez utiliser les liens du README de la branche **auto/model_tracker** en cliquant [ici](https://github.com/ansforge/SAMU-Hub-Modeles/tree/auto/model_tracker?tab=readme-ov-file#modèles).

## Auteur

👤 **ANS > Equipe Hub Santé**

* Site web de l'équipe : https://hub.esante.gouv.fr/
* Site web du programme : https://esante.gouv.fr/si-samu

## 🤝 Contribuer

Les contributions, *issues* & *pull requests* sont les bienvenues !
<br />N'hésitez pas à utiliser notre [page d'*issues*](https://github.com/ansforge/SAMU-Hub-Modeles/issues).

## Montrez votre support

Mettez une ⭐️ si ce projet vous a aidé !

***
_Ce README est inspiré de [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
