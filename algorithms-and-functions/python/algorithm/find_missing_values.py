"""Find integers missing from the range covered by the input values.

The test case for this exercise expects ``[2, 5, 6]`` to be missing from
``[1, 3, 4, 7]``. The original source file was named ``finding_nemo.py``.
"""


def is_consecutive(number_one, number_two):
    if number_one == number_two + 1 or number_two - 1:
        return True
    return False

def find_absent_values(arr):
    absent_values = []
    min_value = sorted(arr)[0]
    max_value = sorted(arr)[len(arr) - 1]

    complete_set = [i for i in range(min_value, max_value + 2)]