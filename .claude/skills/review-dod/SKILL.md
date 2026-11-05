---
name: review-dod
description: Revue indépendante d'une implémentation et validation de la definition of done. À lancer par un autre agent ou membre de l'équipe que celui qui a implémenté.
---

# Revue et validation de la DoD

Le relecteur n'est pas l'auteur du code. Il part du document de conception validé et du diff, pas des explications de l'auteur.

## Étapes
1. Lire la conception (why, use cases et edge cases, critères d'acceptance, DoD, ADR, plan de tests) et le diff complet.
2. **Critères d'acceptance et DoD** : pour chaque critère, le vérifier soi-même (lancer le test ou la commande) et noter Validé / Non validé avec la preuve. Vérifier aussi que chaque edge case identifié a son test.
3. **Qualité** :
   - Les tests décrivent-ils le comportement attendu, ou seulement le code actuel ?
   - Cas limites et erreurs couverts ?
   - Le diff reste-t-il dans le périmètre ?
   - Fichiers générés édités à la main (Modeles) ?
   - Impact sur l'autre repo, compatibilité entre versions de modèle ?
   - Secrets, certificats, artefacts locaux dans le diff ?
4. Lancer la suite complète, le formatage et le lint.

## Sortie
- Verdict : **validé** ou **à corriger**.
- Tableau critère par critère (acceptance, puis DoD) avec preuve.
- Liste des problèmes classés par gravité, avec fichier:ligne.

N'appliquer aucune correction sans demande. Ne rien commiter ni pousser.
