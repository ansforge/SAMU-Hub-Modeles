---
name: design
description: Phase de conception obligatoire avant toute implémentation (feature, bugfix non trivial, refactor, évolution de modèle). Produit le why, les use cases et edge cases, les critères d'acceptance, la definition of done et la stratégie technique (avec ADR), puis attend la validation humaine.
---

# Conception avant implémentation

Aucun code de production avant la validation explicite de ce document par l'humain.

## 1. Why
- Quel problème, pour qui (acteur métier : SAMU, SMUR, NexSIS, GPS, éditeur), quelle conséquence s'il n'est pas résolu.
- Lien avec le contexte métier du repo (`CLAUDE.md`) et le ticket Asana s'il existe.
- Hors périmètre : ce qu'on ne fait pas.

## 2. Use cases et edge cases
Les découvrir avant de rien décider : c'est la partie la plus importante, les critères et les tests en découlent.
- **Use cases** : qui fait quoi, dans quel flux (15-15, 15-SMUR, 15-GPS, 15-NexSIS), avec quel résultat attendu.
- **Edge cases** : entrées invalides ou absentes, valeurs limites, versions de modèle différentes, messages hors ordre ou dupliqués, expiration, erreurs des composants voisins (broker, base, autre Hub).
- Pour chaque cas : comportement attendu, ou **question ouverte** à poser à l'humain. Ne pas deviner le métier.

## 3. Critères d'acceptance
Un critère **vérifiable** par comportement attendu (un test, une commande ou une observation), déduit des use cases et edge cases. Exemple : un message X valide passe la validation, un message Y invalide est rejeté avec l'erreur Z.

## 4. Definition of Done
Exigences de qualité communes à toute tâche, en plus des critères d'acceptance :
- Tests ajoutés et verts, couverture non régressive sur les fichiers modifiés.
- Formatage et lint conformes (voir le `CLAUDE.md` du dossier).
- Impact sur l'autre repo identifié et traité ou signalé.
- Documentation mise à jour si le comportement visible change.

## 5. Stratégie technique et ADR
- Fichiers et composants touchés, et pourquoi ceux-là.
- Pour Modeles : modifier l'Excel/pipeline, jamais les fichiers générés. Pour Sante : versions de modèle à tester.
- Risques : compatibilité entre versions, migrations, contrats avec les clients.
- Chaque décision structurante est consignée sous forme d'**ADR** court :
  - **Contexte** : la contrainte ou la question.
  - **Décision** : ce qu'on retient.
  - **Alternatives écartées** : et pourquoi.
  - **Conséquences** : avantages, coûts, dette éventuelle.
  Un ADR qui doit survivre à la tâche se propose à l'humain comme fichier du repo ; ne rien créer sans accord.

## 6. Plan de tests (TDD)
Un test par critère d'acceptance et par edge case, à écrire d'abord, du plus bas niveau au plus haut : nominal, limites, erreurs.

## 7. Découpage
Étapes petites et vérifiables, chacune avec son critère de fin.

## Sortie
Présenter 1 à 7 à l'humain, avec la liste des questions ouvertes, puis **s'arrêter** et attendre sa validation ou ses corrections. Ne rien commiter, ne rien pousser.
