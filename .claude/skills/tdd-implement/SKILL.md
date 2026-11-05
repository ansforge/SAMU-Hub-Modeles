---
name: tdd-implement
description: Implémentation en TDD d'une conception validée, avec couverture maximale. À utiliser seulement une fois le document de conception (why, DoD, stratégie) validé par l'humain.
---

# Implémentation en TDD

Prérequis : conception validée par l'humain (skill `design`). Sinon, s'arrêter et la demander.

## Boucle, pour chaque étape du découpage
1. **Rouge** : écrire le test qui échoue pour la bonne raison. Le lancer et constater l'échec.
2. **Vert** : écrire le minimum de code pour le faire passer.
3. **Refactor** : nettoyer en gardant les tests verts.

## Règles
- Tester le comportement, pas l'implémentation.
- Couvrir nominal, limites et erreurs. Viser une couverture maximale, au minimum celle exigée par la CI du repo.
- Un bug se corrige en écrivant d'abord le test qui le reproduit.
- Ne pas modifier un test pour le faire passer sans en expliquer la raison à l'humain.
- Respecter les conventions et commandes du `CLAUDE.md` (formatage, lint, versions de modèle à tester).
- Ne jamais éditer à la main un fichier généré.
- Rester dans le périmètre de la conception. Un écart se signale, il ne se glisse pas dans le diff.

## Fin
Lancer toute la suite de tests, le formatage et le lint. Rapporter les résultats réels, y compris les échecs.
Ne rien commiter ni pousser : la suite est la revue (agent `reviewer` ou autre membre de l'équipe).
