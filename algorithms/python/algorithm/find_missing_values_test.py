from find_missing_values import find_absent_values

def test_find_absent_values_returns_array_of_absent_values():
    arr = [1, 3, 4, 7]
    missing = [2, 5, 6]
    assert find_absent_values(arr) == missing

# import unittest
#
# def test_find_absent_values(unittest.TestCase):
#     array = [1, 3, 4, 7]
#     missing = [2, 5, 6]
#     result = find_absent_values(array)
#     self.assertEqual(missing, result)
#
# if __name__ = "__main__":
#     unittest.main()