# SAMU-Hub-Modeles — contexte métier

## C'est quoi
Librairie du **modèle de données** du Hub Santé (ANS, équipe Hub Santé) : plateforme d'échanges de messages asynchrones entre les acteurs de l'urgence (SAMU/15, SMUR, SDIS/NexSIS 18, GPS, éditeurs de logiciels).
Consommée par le repo frère **SAMU-Hub-Sante** (Dispatcher) via le package Maven `com.hubsante.models`.
Spécifications fonctionnelles (DSF) : https://hub.esante.gouv.fr/ — la doc du repo est en français.

## Vocabulaire
- **EDXL-DE (RC-DE)** : enveloppe de distribution qui encapsule tous les messages.
- **Messages métier** (le contenu) : RC-EDA, RS-EDA, RS-EDA-MAJ, RS-RPIS, RS-RI, RS-DR, RS-RR, RS-SR (échanges d'affaires/ressources entre acteurs), GEO-POS / GEO-REQ / GEO-RES (géolocalisation).
- **CISU** : format d'échange historique (norme inter-SI de l'urgence) ; le `converter/` convertit CISU <-> santé et entre versions santé.
- **Périmètres** : 15-15, 15-SMUR, 15-GPS, 15-NexSIS (15-18). Chacun a sa version de DSF.
- **Version de la lib <-> version de DSF** : voir le tableau du `README.md`. Une release de la lib fige une version par périmètre.

## Source de vérité
`csv_parser/models/model.xlsx` et `model-technical.xlsx` (onglets préfixés `#` ignorés).
Tout le reste est **généré** : classes Java, JSON schema, XSD, openapi/asyncapi, docx, UML, `csv_parser/out/`.
**Ne jamais éditer à la main un fichier généré** : modifier l'Excel (ou le pipeline), la CI régénère (`.github/workflows/generate-model.yaml`).
Pipeline et ajout d'un schéma : `README_ADDING_SCHEMAS_TO_MODEL.md`.

## Structure
- `csv_parser/` : xlsx -> schémas/docs. `workflow.py` orchestre.
- `automatic-schema-generator/` : templates Go + `schemas.yaml`.
- `generator/`, `generator_python|ruby|csharp/` : génération des libs par langage.
- `src/main/java/com/hubsante/model` : classes générées + code manuel (`Validator`, `EdxlHandler`, `Sanitizer`, `builders`, `custom`, `config`, `exception`, `edxl`, `utils`).
- `src/main/resources/{json-schema,xsd,sample}` : schémas et exemples (`sample/valid`, `sample/examples`).
- `converter/` : service Python (conversions CISU/santé et inter-versions).

## Commandes
- Java 21 / Gradle : `./gradlew test` (`-Pfunctional` exclut les tests `*Technical*`, `-Ptechnical` ne lance qu'eux).
- Converter (Python, uv) : `uv run pytest`, `uv run ruff format --check .`, `uv run ruff check .`, `uv run --active mypy .`.
- Hooks : `lefthook install` (ruff + mypy sur `converter/`).

## Pièges
- Les sous-schémas doivent avoir `subschema=Y` sinon ils écrasent les classes de leur parent.
- Les fichiers Java exigent le header de licence (`LICENSE_HEADER.txt`, hors tests).
- Nom de release : `^[0-9]+\.[0-9]+(\.[0-9]+)?(-suffix)*$` ; préfixe `converter-<version>` = release du converter.
- Un changement de modèle impacte Hub-Sante (validation, conversion, routage) : le signaler dans la PR.
- Ne pas commiter d'artefacts locaux (`.venv`, `cron.log`, caches, `__pycache__`).

## Workflow obligatoire
Pour toute tâche non triviale (feature, bugfix non trivial, refactor, évolution de modèle) :

0. **Confirmer le flow** : en début de tâche, demander à l'humain s'il veut bien suivre ce flow (ou une variante). Ne pas supposer.
1. **Conception** (skill `design`) : why, definition of done vérifiable, stratégie technique, plan de tests. Attendre la validation de l'humain. Aucun code avant.
2. **Implémentation + tests en TDD** (skill `tdd-implement`, agent `implementer`). Tests d'abord, couverture maximale.
3. **Revue + validation de la DoD** (skill `review-dod`, agent `reviewer`), par un autre agent ou membre de l'équipe que l'implémenteur.
4. **PR** (skill `prepare-pr`) : présenter commits et PR à l'humain avant d'agir.

Tâche triviale (typo, doc mineure) : dire qu'on saute le flow et pourquoi.

## Versioning
Jamais de commit, push, tag, merge ou PR sans accord explicite de l'humain, action par action. Un accord pour commiter n'est pas un accord pour pousser. Un garde-fou est aussi défini dans `.claude/settings.json`.
