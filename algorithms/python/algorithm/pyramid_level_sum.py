"""Sum the odd numbers in a pyramid level.

Problem from Code Wars, an event hosted at Semicolon: rows contain consecutive
odd numbers, as in ``1; 3, 5; 7, 9, 11; ...``. Return the sum at level n.
The original solution file was named ``PascalTriangle.java``.
"""


def sum_at_level(level: int) -> int:
    """Return the sum at a 1-indexed pyramid level; the sum is level cubed."""
    if isinstance(level, bool) or not isinstance(level, int):
        raise TypeError("level must be an integer")
    if level < 1:
        raise ValueError("level must be positive")
    return level**3
