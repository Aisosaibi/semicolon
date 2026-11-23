# Python review queue

## Does not parse

These are not ready to run until their syntax errors are fixed:

- [`Pre-Ileya/Day 2/Python/Level 1/TaskEight.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%201/TaskEight.py)
- [`Pre-Ileya/Day 2/Python/Level 1/TaskTen.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%201/TaskTen.py)
- [`Pre-Ileya/Day 2/Python/Level 2/TaskFive.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%202/TaskFive.py)
- [`Pre-Ileya/Day 2/Python/Level 2/TaskFour.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%202/TaskFour.py)
- [`Pre-Ileya/Day 2/Python/Level 2/TaskOne.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%202/TaskOne.py)
- [`Pre-Ileya/Day 2/Python/Level 2/TaskThree.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%202/TaskThree.py)
- [`Pre-Ileya/Day 2/Python/Level 2/TaskTwo.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%202/TaskTwo.py)
- [`Pre-Ileya/Day 2/Python/Level 3/task4.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%203/task4.py)
- [`Pre-Ileya/Day 2/Python/Level 3/task5.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%203/task5.py)
- [`Pre-Ileya/Day 2/Python/Level 3/task6.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%203/task6.py)
- [`Pre-Ileya/Day 2/Python/Level 3/task8.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%203/task8.py)
- [`Pre-Ileya/Day 2/Python/Level 4/task6.py`](../../phase-gate/I/Pre-Ileya/Day%202/Python/Level%204/task6.py)
- [`Pre-Ileya/Day 3/Python/afternoon_session/test_parking_lot.py`](../../phase-gate/I/Pre-Ileya/Day%203/Python/afternoon_session/test_parking_lot.py)
- [`Pre-Ileya/Day 3/Python/morning_session/test_fire_drill1.py`](../../phase-gate/I/Pre-Ileya/Day%203/Python/morning_session/test_fire_drill1.py)
- [`Pre-Ileya/Day 4/Python/remove_duplicate_values.py`](../../phase-gate/I/Pre-Ileya/Day%204/Python/remove_duplicate_values.py)
- [`introductory-exercises/validatedate.py`](../../python/introductory-exercises/validatedate.py)
- [`chapter-exercises/chapter02/exercise2_14.py`](../../python/chapter-exercises/chapter02/exercise2_14.py)
- [`chapter-exercises/chapter02/exercise2_5.py`](../../python/chapter-exercises/chapter02/exercise2_5.py)
- [`chapter-exercises/chapter02/exercise2_8.py`](../../python/chapter-exercises/chapter02/exercise2_8.py)

The task identifiers do not reveal a reliable prompt on their own; use
neighboring exercise files or their tests when repairing these.

## Tests missing or needing review

No obvious matching test file was found in these standalone collections:

- [`python/introductory-exercises/`](../../python/introductory-exercises/)
- [`python/chapter-exercises/`](../../python/chapter-exercises/)
- [`python/basic-arithmetic-exercises/`](../../python/basic-arithmetic-exercises/)
- [`python/class-work/`](../../python/class-work/)
- [`phase-gate/I/Pre-Ileya/Day 2/Python/`](../../phase-gate/I/Pre-Ileya/Day%202/Python/)

These are collection-level flags, not proof that every source lacks a test.
Check for tests elsewhere before treating an individual program as untested.

## Failing test / incomplete solution

- [`algorithm/find_missing_values.py`](../../python/algorithm/find_missing_values.py) — the
  associated test expects `[2, 5, 6]` missing from `[1, 3, 4, 7]`, but
  `find_absent_values` currently returns `None`; it stops after building a
  candidate range.
