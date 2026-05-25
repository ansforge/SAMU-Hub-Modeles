#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR=$(cd "$(dirname "$0")" && pwd)
ENVELOPE_DEFAULT="$SCRIPT_DIR/../tests/fixtures/EDXL/edxl_envelope_health_to_health.json"
CONVERTER_URL_DEFAULT="http://localhost:8083"

usage() {
  cat >&2 <<EOF
Usage: $(basename "$0") <sourceVersion> <targetVersion> <type> <useCase> [options]

Positional arguments:
  sourceVersion    e.g. v1, v2, v3, vactive (passed as-is)
  targetVersion    e.g. v1, v2, v3, vactive (passed as-is)
  type             HealthVersionConversion | CISUTranscoding | CISUVersionConversion
  useCase          path to a JSON file OR http(s) URL of the message payload

Options:
  --envelope <path|url>     EDXL envelope file or URL
                            (default: tests/fixtures/EDXL/edxl_envelope_health_to_health.json)
  --converter_url <url>     Converter base URL (default: http://localhost:8083)
  -h, --help                Show this message

Example:
  $(basename "$0") v3 v2 HealthVersionConversion tests/fixtures/RS-RI/RS-RI_V3.0_exhaustive_fill.json
EOF
}

ENVELOPE="$ENVELOPE_DEFAULT"
CONVERTER_URL="$CONVERTER_URL_DEFAULT"
POSITIONAL=()

while [[ $# -gt 0 ]]; do
  case "$1" in
    --envelope)
      [[ $# -ge 2 ]] || { echo "Error: --envelope requires a value" >&2; usage; exit 1; }
      ENVELOPE="$2"; shift 2;;
    --converter_url)
      [[ $# -ge 2 ]] || { echo "Error: --converter_url requires a value" >&2; usage; exit 1; }
      CONVERTER_URL="$2"; shift 2;;
    -h|--help)
      usage; exit 0;;
    --*)
      echo "Error: unknown flag: $1" >&2; usage; exit 1;;
    *)
      POSITIONAL+=("$1"); shift;;
  esac
done

if [[ ${#POSITIONAL[@]} -ne 4 ]]; then
  echo "Error: expected 4 positional arguments, got ${#POSITIONAL[@]}" >&2
  usage
  exit 1
fi

SOURCE_VERSION="${POSITIONAL[0]}"
TARGET_VERSION="${POSITIONAL[1]}"
TYPE="${POSITIONAL[2]}"
USECASE="${POSITIONAL[3]}"

for dep in jq curl; do
  if ! command -v "$dep" >/dev/null 2>&1; then
    echo "Error: missing required dependency: $dep" >&2
    exit 1
  fi
done

read_source() {
  local src="$1"
  local label="$2"
  if [[ "$src" =~ ^https?:// ]]; then
    if ! curl -fsSL "$src"; then
      echo "Error: failed to download $label from $src" >&2
      return 1
    fi
  else
    if [[ ! -f "$src" ]]; then
      echo "Error: $label file not found: $src" >&2
      return 1
    fi
    cat "$src"
  fi
}

ENVELOPE_JSON=$(read_source "$ENVELOPE" "envelope") || exit 1
USECASE_JSON=$(read_source "$USECASE" "useCase") || exit 1

PAYLOAD=$(jq -n \
  --argjson envelope "$ENVELOPE_JSON" \
  --argjson usecase "$USECASE_JSON" \
  --arg sourceVersion "$SOURCE_VERSION" \
  --arg targetVersion "$TARGET_VERSION" \
  --arg type "$TYPE" \
  '{
    sourceVersion: $sourceVersion,
    targetVersion: $targetVersion,
    type: $type,
    edxl: ($envelope.edxl | .content[0].jsonContent.embeddedJsonContent.message |= (. + $usecase))
  }')

RESPONSE=$(curl -sS -X POST "$CONVERTER_URL/convert" \
  -H "Content-Type: application/json" \
  -d "$PAYLOAD")

if printf '%s' "$RESPONSE" | jq . >/dev/null 2>&1; then
  printf '%s' "$RESPONSE" | jq .
else
  printf '%s\n' "$RESPONSE"
fi
