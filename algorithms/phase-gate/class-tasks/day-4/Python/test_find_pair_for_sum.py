import unittest
from find_pair_for_sum import find_pair_for_sum


class Test_Task_1(unittest.TestCase):
    def test_that_p_sum_function_returns_array_containing_8_and_minus_2(self):
        array = [8, 6, 12, 4, -2]
        number = 6
        expected = [8, -2]
        result = find_pair_for_sum(array, number)
        self.assertEqual(expected, result)

if __name__ == "__main__":
    unittest.main()

