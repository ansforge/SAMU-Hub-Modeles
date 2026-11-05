# Converter

Service Python (Flask/gunicorn, MongoDB) qui convertit les messages CISU <-> santé et entre versions santé. Gestionnaire : uv.

## Commandes
- Tests : `uv run pytest`.
- Formatage et lint : `uv run ruff format --check .`, `uv run ruff check .`.
- Types : `uv run --active mypy .`.
- Hooks : `lefthook install` à la racine du repo (ruff format auto-stagé + mypy avant chaque commit).

## Pièges
- La CI ne lance les tests du converter que si ses fichiers changent.
- Release du converter : préfixe `converter-<version>` (la release de la lib n'a pas de préfixe).
