#!/usr/bin/env python3
"""Generate CISU<->RS nomenclature maps from the mapping CSV export.

Produces n = x*y Python modules under converter/nomenclatures/, one per
combination of direction (x) and balise (y). Each module exposes a MAP dict
keyed by the received code, valued by the {code, label} to transmit.
"""

from __future__ import annotations

import csv
import re
import subprocess
import sys
from pathlib import Path

# Protocol version codes as they appear in the "Version code reçu" / "Version
# code transmis" columns. Update here if a protocol's version changes.
PROTOCOL_VERSIONS = {
    "cisu": "1.9",
    "rs": "2.3",
}

DIRECTIONS = {
    (PROTOCOL_VERSIONS["cisu"], PROTOCOL_VERSIONS["rs"]): "from_cisu_to_rs",
    (PROTOCOL_VERSIONS["rs"], PROTOCOL_VERSIONS["cisu"]): "from_rs_to_cisu",
}

DEFAULT_INPUT = (
    Path(__file__).resolve().parent.parent
    / "resources"
    / "export_mapping_nomenclatures.csv"
)
DEFAULT_OUTPUT_DIR = (
    Path(__file__).resolve().parent.parent / "converter" / "nomenclatures"
)

MapKey = tuple[str, str]  # (direction, balise)
Entry = dict[str, str]  # {"code": ..., "label": ...}


def _read_rows(input_path: Path) -> list[dict[str, str | None]]:
    # utf-8-sig strips the leading BOM some spreadsheet tools add on CSV export.
    with input_path.open(encoding="utf-8-sig", newline="") as f:
        reader = csv.DictReader(f, delimiter=";")
        # Empty CSV fields decode as "" (unlike empty xlsx cells, which are
        # None) — normalize them so a blank "Code à transmettre" still means
        # "no entry" rather than an empty-string code.
        return [
            {key: (value if value else None) for key, value in row.items()}
            for row in reader
            if any(value for key, value in row.items() if key)
        ]


def _slug(balise: str) -> str:
    name = balise.rsplit(".", 1)[-1]
    return re.sub(r"(?<!^)(?=[A-Z])", "_", name).lower()


def _required(row: dict[str, str | None], column: str) -> str:
    value = row[column]
    if value is None:
        raise ValueError(f"Colonne obligatoire vide : {column!r} (ligne {row})")
    return value


def build_maps(
    rows: list[dict[str, str | None]],
) -> dict[MapKey, dict[str, Entry | None]]:
    balises = {_required(row, "Balise") for row in rows}
    maps: dict[MapKey, dict[str, Entry | None]] = {
        (direction, balise): {}
        for direction in DIRECTIONS.values()
        for balise in balises
    }

    skipped = 0
    for row in rows:
        received_version = _required(row, "Version code reçu")
        sent_version = _required(row, "Version code transmis")
        direction = DIRECTIONS.get((received_version, sent_version))
        if direction is None:
            skipped += 1
            print(
                f"Ligne ignorée (versions inattendues {received_version!r} -> "
                f"{sent_version!r}) : {row['Balise']} / {row['Code reçu']}",
                file=sys.stderr,
            )
            continue

        balise = _required(row, "Balise")
        received_code = _required(row, "Code reçu")
        code = row["Code à transmettre"]
        label = row["Libellé à transmettre"]
        entry = (
            None if code is None or label is None else {"code": code, "label": label}
        )
        maps[(direction, balise)][received_code] = entry

    if skipped:
        print(f"{skipped} ligne(s) ignorée(s) au total.", file=sys.stderr)
    return maps


def _module_source(entries: dict[str, Entry | None]) -> str:
    sorted_entries = dict(sorted(entries.items()))
    return (
        '"""Auto-generated nomenclature mapping. '
        'Do not edit by hand — regenerate via scripts/generate_nomenclatures_maps.py."""\n\n'
        f"MAP: dict[str, dict[str, str] | None] = {sorted_entries!r}\n"
    )


def write_maps(
    maps: dict[MapKey, dict[str, Entry | None]], output_dir: Path
) -> list[Path]:
    written = []
    for (direction, balise), entries in maps.items():
        module_dir = output_dir / direction
        module_dir.mkdir(parents=True, exist_ok=True)
        module_path = module_dir / f"{_slug(balise)}.py"
        module_path.write_text(_module_source(entries), encoding="utf-8")
        written.append(module_path)
    return written


def main() -> None:
    input_path = Path(sys.argv[1]) if len(sys.argv) > 1 else DEFAULT_INPUT
    if not input_path.is_file():
        print(f"Fichier introuvable : {input_path}", file=sys.stderr)
        sys.exit(1)

    rows = _read_rows(input_path)
    maps = build_maps(rows)
    written = write_maps(maps, DEFAULT_OUTPUT_DIR)

    subprocess.run(["ruff", "format", *[str(p) for p in written]], check=True)

    total_entries = sum(len(entries) for entries in maps.values())
    print(
        f"{len(written)} maps générées ({total_entries} entrées) dans {DEFAULT_OUTPUT_DIR}"
    )


if __name__ == "__main__":
    main()
