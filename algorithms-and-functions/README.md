# Algorithms

Solutions and exercises are grouped by language where practical:

- [`java/`](./java/) — Java kata, course exercises, and projects.
- [`javascript/`](./javascript/) — JavaScript exercises.
- [`python/`](./python/) — Python exercises and small projects.
- [`phase-gate/I/`](./phase-gate/I/) — cohort submissions kept in their
  original project/day/level structure for the Semicolon phase gate exam; submissions
  already group files by language, and moving them could break imports and
  test paths.
- [`unsolved/`](./unsolved/) — language-sorted review register. It links to
  original files instead of duplicating or relocating them.

## Status and problem statements

Names such as `TaskOne` describe the original assignment identifiers, not the
problem. Use source comments, test names, and the collection folder to infer the
prompt. The register in `unsolved/` records items with concrete syntax/build
issues and files for which no corresponding test was found. Other solutions
are not marked verified merely because they parse or compile.

The pyramid task asks for the sum at level `n` in rows of consecutive odd
numbers. The row contains `n` terms centered on `n²`, so its sum is `n³`.
The problem was given at Code Wars, an event hosted at Semicolon. Its original
filename was `PascalTriangle.java`; the Python solution and tests are in
[`python/algorithm/`](./python/algorithm/).

## Naming

New filenames should describe the task in plain English. Preserve familiar
names when tests or project configuration depend on them; when a misleading
name is changed, record the old name in the source header. Language-level
READMEs index the descriptive collection folders.
