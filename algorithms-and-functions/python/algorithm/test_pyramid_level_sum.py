import pytest

from pyramid_level_sum import sum_at_level


@pytest.mark.parametrize(
    ("level", "expected"),
    [(1, 1), (2, 8), (3, 27), (10, 1_000)],
)
def test_sum_at_level(level, expected):
    assert sum_at_level(level) == expected


@pytest.mark.parametrize("level", [0, -1])
def test_sum_at_level_rejects_non_positive_levels(level):
    with pytest.raises(ValueError):
        sum_at_level(level)


@pytest.mark.parametrize("level", [True, 1.5, "3"])
def test_sum_at_level_rejects_non_integer_levels(level):
    with pytest.raises(TypeError):
        sum_at_level(level)
