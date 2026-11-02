---
name: design
description: Phase de conception obligatoire avant toute implémentation (feature, bugfix non trivial, refactor, évolution de modèle). Produit le why, la definition of done et la stratégie technique, puis attend la validation humaine.
---

# Conception avant implémentation

Aucun code de production avant la validation explicite de ce document par l'humain.

## 1. Why
- Quel problème, pour qui (acteur métier : SAMU, SMUR, NexSIS, GPS, éditeur), quelle conséquence s'il n'est pas résolu.
- Lien avec le contexte métier du repo (`CLAUDE.md`) et le ticket Asana s'il existe.
- Hors périmètre : ce qu'on ne fait pas.

## 2. Definition of Done
Liste de critères **vérifiables** (un test, une commande ou une observation par critère). Exemples :
- Un message X valide passe la validation, un message Y invalide est rejeté avec l'erreur Z.
- Tests ajoutés et verts, couverture non régressive sur les fichiers modifiés.
- Formatage et lint conformes (voir `CLAUDE.md`).
- Impact sur l'autre repo identifié et traité ou signalé.

## 3. Stratégie technique
- Fichiers et composants touchés, et pourquoi ceux-là.
- Pour Modeles : modifier l'Excel/pipeline, jamais les fichiers générés. Pour Sante : versions de modèle à tester.
- Options écartées et raison.
- Risques : compatibilité entre versions, migrations, contrats avec les clients.

## 4. Plan de tests (TDD)
Tests à écrire d'abord, du plus bas niveau au plus haut, avec leur cas nominal, leurs cas limites et leurs cas d'erreur.

## 5. Découpage
Étapes petites et vérifiables, chacune avec son critère de fin.

## Sortie
Présenter 1 à 5 à l'humain, puis **s'arrêter** et attendre sa validation ou ses corrections. Ne rien commiter, ne rien pousser.
