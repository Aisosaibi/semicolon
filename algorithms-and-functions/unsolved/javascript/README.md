# JavaScript review queue

## Does not parse

These Phase Gate exam submissions fail `node --check`:

- [`Pre-Ileya/Day 2/JavaScript/Level 3/Task7.js`](../../phase-gate/I/Pre-Ileya/Day%202/JavaScript/Level%203/Task7.js) — invalid `console.log` argument syntax.
- [`Pre-Ileya/Day 2/JavaScript/Level 4/Task5.js`](../../phase-gate/I/Pre-Ileya/Day%202/JavaScript/Level%204/Task5.js) — invalid `if` syntax; the rest of the function also needs review.
- [`Pre-Ileya/Day 4/JavaScript/remove-duplicate-values.js`](../../phase-gate/I/Pre-Ileya/Day%204/JavaScript/remove-duplicate-values.js) — Java-style `boolean` declaration and additional non-JavaScript syntax.
- [`Pre-Ileya/Day 4/JavaScript/list-integers-from-minimum-to-maximum-exclusive.js`](../../phase-gate/I/Pre-Ileya/Day%204/JavaScript/list-integers-from-minimum-to-maximum-exclusive.js) — unmatched closing brace and Java-only constructs.
- [`Pre-Ileya/Day 4/JavaScript/filter-words-without-vowels.js`](../../phase-gate/I/Pre-Ileya/Day%204/JavaScript/filter-words-without-vowels.js) — invalid parameter declaration and Java-style string operations.

Syntax validity does not establish correct behavior. No matching tests were
found in the standalone [`javascript/`](../../javascript/) exercises; tests
exist for some Phase Gate assignments beside their source files.
