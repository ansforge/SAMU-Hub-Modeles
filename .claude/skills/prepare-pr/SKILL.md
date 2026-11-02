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
3. Attendre l'accord. Commiter uniquement ce qui est validé.
4. Proposer la description de PR en suivant `.github/pull_request_template.md` : détails, documentation, captures, ticket, résumé de la DoD et des preuves de revue. Attendre l'accord avant de la créer.
5. Ne jamais pousser sans accord séparé. Ne jamais forcer un push ni réécrire l'historique partagé.

Les confirmations demandées par `.claude/settings.json` sont un filet de sécurité, pas un accord à elles seules : présenter d'abord, puis agir.
