---
name: prepare-pr
description: Préparer commits et PR une fois la DoD validée en revue. Présente tout à l'humain et n'exécute aucune action de versioning sans son accord explicite.
---

# Préparer commits et PR

Prérequis : DoD validée par la revue (skill `review-dod`).

## Règle absolue
Aucun `git commit`, `git push`, `gh pr create` ni autre action de versioning sans accord explicite de l'humain, **action par action**. Un accord pour commiter n'est pas un accord pour pousser.

## Étapes
1. `git status` et `git diff` : vérifier qu'aucun fichier hors périmètre (artefacts locaux, `.env`, certificats, modifs de l'humain) n'est inclus.
2. Proposer le découpage en commits et les messages (Conventional Commits, scope si le repo en utilise). Présenter les fichiers de chaque commit.
3. Commiter **un commit à la fois** : présenter ses fichiers et son message, attendre l'accord explicite de l'humain pour ce commit, le créer, puis passer au suivant. L'accord sur le découpage de l'étape 2 ne vaut pas accord de commit. Ne commiter que ce qui a été validé.
4. Proposer la description de PR en suivant `.github/pull_request_template.md` : détails, documentation, captures, ticket, résumé des critères d'acceptance et de la DoD avec le verdict de revue. Attendre l'accord avant de la créer.
   - Y inclure un **mode opératoire de validation**, à générer à partir des critères d'acceptance : pour chacun, les étapes à suivre (commandes, messages d'exemple, environnement) et le résultat attendu, pour que le relecteur humain puisse le rejouer sans lire le code.
   - Partir de ce qui a réellement été exécuté. Ne pas inventer de commande non vérifiée : signaler ce qui n'a pas pu être testé.
5. Ne jamais pousser sans accord séparé. Ne jamais forcer un push ni réécrire l'historique partagé.

Les confirmations demandées par `.claude/settings.json` sont un filet de sécurité, pas un accord à elles seules : présenter d'abord, puis agir.
