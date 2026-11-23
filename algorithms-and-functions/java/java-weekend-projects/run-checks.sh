#!/bin/sh
set -eu

ROOT=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
BUILD_DIR=$(mktemp -d)
trap 'rm -rf "$BUILD_DIR"' EXIT HUP INT TERM

javac --release 17 -d "$BUILD_DIR" \
  "$ROOT/01-safebank/src/safebank/App.java" \
  "$ROOT/01-safebank/test/safebank/SafeBankChecks.java"
java -ea -cp "$BUILD_DIR" safebank.SafeBankChecks

javac --release 17 -d "$BUILD_DIR" \
  "$ROOT/02-textlab/src/textlab/App.java" \
  "$ROOT/02-textlab/test/textlab/TextLabChecks.java"
java -ea -cp "$BUILD_DIR" textlab.TextLabChecks

javac --release 17 -d "$BUILD_DIR" \
  "$ROOT/03-studyvault/src/studyvault/App.java" \
  "$ROOT/03-studyvault/test/studyvault/StudyVaultChecks.java"
java -ea -cp "$BUILD_DIR" studyvault.StudyVaultChecks

javac --release 17 -d "$BUILD_DIR" \
  "$ROOT/04-cohorthub/src/cohorthub/App.java" \
  "$ROOT/04-cohorthub/test/cohorthub/CohortHubChecks.java"
java -ea -cp "$BUILD_DIR" cohorthub.CohortHubChecks
