<h1 align="center">Hub Santé - librairie Modèles</h1>
<p align="center">
  <img alt="Version" src="https://img.shields.io/badge/version-1.0-blue.svg?cacheSeconds=2592000" />
  <a href="#" target="_blank">
    <img alt="License: Apache-2.0" src="https://img.shields.io/badge/License-Apache_2.0-yellow.svg" />
  </a>
</p>

> Librairie du modèle de données utilisé par le projet SAMU-Hub-Santé (Plateforme d'échanges de messages asynchrones entre les acteurs de l'urgence)

🏠 [Page d'accueil](https://github.com/ansforge/SAMU-Hub-Modeles)

## Usage

Cette librairie est utilisée par le projet [SAMU-Hub-Santé](https://github.com/ansforge/SAMU-Hub-Sante).

Elle contient les classes Java permettant de manipuler les messages échangés entre les acteurs de l'urgence, ainsi que quelques utilitaires (pour les opérations de sérialisation/désérialisation ou de validation notamment).

Les json-schemas sont disponibles dans le répertoire [src/main/resources/json-schema](src/main/resources/json-schema).
Des exemples de messages sont disponibles dans le répertoire [src/main/resources/sample/valid](src/main/resources/sample/valid).

Les spécifications du modèle de données sont disponibles sur le [site du projet SAMU-Hub-Santé](https://hub.esante.gouv.fr/).

## Correspondance DSF - librairie

|Release / <br>Format d'échanges|Principes transverses|Périmètre 15-15|Périmètre 15-SMUR|Périmètre 15-GPS|Périmètre 15-NexSIS|
|-|-|-|-|-|-|
|[0.5](https://github.com/ansforge/SAMU-Hub-Modeles/tree/0.5.1)|1.1|1.2|1.1|1.0-1.1|1.6|
|[0.6](https://github.com/ansforge/SAMU-Hub-Modeles/tree/0.6.0)|1.2|1.3|1.2|1.0-1.1|1.6|
|[0.7](https://github.com/ansforge/SAMU-Hub-Modeles/tree/0.7.0)|1.3|1.4|1.3|1.0-1.1|1.7|
|[1.0](https://github.com/ansforge/SAMU-Hub-Modeles/tree/1.0)|1.4|1.5 (**LTS**)|1.4-1.5|1.0-1.1|1.8|
|[2.0](https://github.com/ansforge/SAMU-Hub-Modeles/tree/2.0)|1.4|2.0|1.6|1.2|1.9|
|[3.0](https://github.com/ansforge/SAMU-Hub-Modeles/tree/3.0.0)|1.5|2.1|1.7|1.3|1.9.1               |

Pour télécharger la dernière version du package Maven com.hubsante.models, il est recommandé de se baser sur le label de la "latest release" des Github Releases.

## Modèles

|            | [Schéma](src/main/resources/json-schema/)                                       | Détails                                                                    | UML                                                                                | [Exemples](src/main/resources/sample/examples/)                       |
|------------|---------------------------------------------------------------------------------|----------------------------------------------------------------------------|------------------------------------------------------------------------------------|-----------------------------------------------------------------------|
| RC-DE      | [RC-DE.schema.json](src/main/resources/json-schema/RC-DE.schema.json)           | [RC-DE.schema.docx](csv_parser/out/RC-DE/RC-DE.schema.docx)                | [RC-DE.uml_diagram.pdf](csv_parser/out/RC-DE/RC-DE.uml_diagram.pdf)                | -                                                                     |
| RC-EDA     | [RC-EDA.schema.json](src/main/resources/json-schema/RC-EDA.schema.json)         | [RC-EDA.schema.docx](csv_parser/out/RC-EDA/RC-EDA.schema.docx)             | [RC-EDA.uml_diagram.pdf](csv_parser/out/RC-EDA/RC-EDA.uml_diagram.pdf)             | [Exemples RC-EDA](src/main/resources/sample/examples/RC-EDA/)         |
| RS-EDA     | [RS-EDA.schema.json](src/main/resources/json-schema/RS-EDA.schema.json)         | [RS-EDA.schema.docx](csv_parser/out/RS-EDA/RS-EDA.schema.docx)             | [RS-EDA.uml_diagram.pdf](csv_parser/out/RS-EDA/RS-EDA.uml_diagram.pdf)             | [Exemples RS-EDA](src/main/resources/sample/examples/RS-EDA/)         |
| RS-EDA-MAJ | [RS-EDA-MAJ.schema.json](src/main/resources/json-schema/RS-EDA-MAJ.schema.json) | [RS-EDA-MAJ.schema.docx](csv_parser/out/RS-EDA-MAJ/RS-EDA-MAJ.schema.docx) | [RS-EDA-MAJ.uml_diagram.pdf](csv_parser/out/RS-EDA-MAJ/RS-EDA-MAJ.uml_diagram.pdf) | [Exemples RS-EDA-MAJ](src/main/resources/sample/examples/RS-EDA-MAJ/) |
| RS-RPIS    | [RS-RPIS.schema.json](src/main/resources/json-schema/RS-RPIS.schema.json)       | [RS-RPIS.schema.docx](csv_parser/out/RS-RPIS/RS-RPIS.schema.docx)          | [RS-RPIS.uml_diagram.pdf](csv_parser/out/RS-RPIS/RS-RPIS.uml_diagram.pdf)          | [Exemples RS-RPIS](src/main/resources/sample/examples/RS-RPIS/)       |
| EMSI       | [EMSI.schema.json](src/main/resources/json-schema/EMSI.schema.json)             | [EMSI.schema.docx](csv_parser/out/EMSI/EMSI.schema.docx)                   | [EMSI.uml_diagram.pdf](csv_parser/out/EMSI/EMSI.uml_diagram.pdf)                   | [Exemples EMSI](src/main/resources/sample/examples/EMSI/)             |
| RS-RI      | [RS-RI.schema.json](src/main/resources/json-schema/RS-RI.schema.json)           | [RS-RI.schema.docx](csv_parser/out/RS-RI/RS-RI.schema.docx)                | [RS-RI.uml_diagram.pdf](csv_parser/out/RS-RI/RS-RI.uml_diagram.pdf)                | [Exemples RS-RI](src/main/resources/sample/examples/RS-RI/)           |
| RS-DR      | [RS-DR.schema.json](src/main/resources/json-schema/RS-DR.schema.json)           | [RS-DR.schema.docx](csv_parser/out/RS-DR/RS-DR.schema.docx)                | [RS-DR.uml_diagram.pdf](csv_parser/out/RS-DR/RS-DR.uml_diagram.pdf)                | [Exemples RS-DR](src/main/resources/sample/examples/RS-DR/)           |
| RS-RR      | [RS-RR.schema.json](src/main/resources/json-schema/RS-RR.schema.json)           | [RS-RR.schema.docx](csv_parser/out/RS-RR/RS-RR.schema.docx)                | [RS-RR.uml_diagram.pdf](csv_parser/out/RS-RR/RS-RR.uml_diagram.pdf)                | [Exemples RS-RR](src/main/resources/sample/examples/RS-RR/)           |
| RS-SR      | [RS-SR.schema.json](src/main/resources/json-schema/RS-SR.schema.json)           | [RS-SR.schema.docx](csv_parser/out/RS-SR/RS-SR.schema.docx)                | [RS-SR.uml_diagram.pdf](csv_parser/out/RS-SR/RS-SR.uml_diagram.pdf)                | [Exemples RS-SR](src/main/resources/sample/examples/RS-SR/)           |
| GEO-POS    | [GEO-POS.schema.json](src/main/resources/json-schema/GEO-POS.schema.json)       | [GEO-POS.schema.docx](csv_parser/out/GEO-POS/GEO-POS.schema.docx)          | [GEO-POS.uml_diagram.pdf](csv_parser/out/GEO-POS/GEO-POS.uml_diagram.pdf)          | [Exemples GEO-POS](src/main/resources/sample/examples/GEO-POS/)       |
| GEO-REQ    | [GEO-REQ.schema.json](src/main/resources/json-schema/GEO-REQ.schema.json)       | [GEO-REQ.schema.docx](csv_parser/out/GEO-REQ/GEO-REQ.schema.docx)          | [GEO-REQ.uml_diagram.pdf](csv_parser/out/GEO-REQ/GEO-REQ.uml_diagram.pdf)          | [Exemples GEO-REQ](src/main/resources/sample/examples/GEO-REQ/)       |
| GEO-RES    | [GEO-RES.schema.json](src/main/resources/json-schema/GEO-RES.schema.json)       | [GEO-RES.schema.docx](csv_parser/out/GEO-RES/GEO-RES.schema.docx)          | [GEO-RES.uml_diagram.pdf](csv_parser/out/GEO-RES/GEO-RES.uml_diagram.pdf)          | [Exemples GEO-RES](src/main/resources/sample/examples/GEO-RES/)       |

N. B. : Pour accéder aux versions les plus recentes des fichiers, veuillez utiliser les liens du README de la branche **auto/model_tracker** en cliquant [ici](https://github.com/ansforge/SAMU-Hub-Modeles/tree/auto/model_tracker?tab=readme-ov-file#modèles).

## Auteur

👤 **ANS > Equipe Hub Santé**

* Site web de l'équipe : https://hub.esante.gouv.fr/
* Site web du programme : https://esante.gouv.fr/si-samu

## 🤝 Contribuer

Les contributions, *issues* & *pull requests* sont les bienvenues !
<br />N'hésitez pas à utiliser notre [page d'*issues*](https://github.com/ansforge/SAMU-Hub-Modeles/issues).

### Pre-commit

Des hooks Git sont définis pour simplifier le travail des développeurs.

Pour les installer :

- Installer [lefthook](https://lefthook.dev/installation/index.html)
- Lancer à la racine du dépôt `lefthook install`

Avant chaque commit, les hooks seront exécutés automatiquement et le commit sera annulé si des erreurs sont détectées.

## Montrez votre support

Mettez une ⭐️ si ce projet vous a aidé !

***
_Ce README est inspiré de [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
