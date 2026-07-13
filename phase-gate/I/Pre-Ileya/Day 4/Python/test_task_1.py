import unittest
from task_1 import p_sum


class Test_Task_1(unittest.TestCase):
    def test_that_p_sum_function_returns_array_containing_8_and_minus_2(self):
        array = [8, 6, 12, 4, -2]
        number = 6
        expected = [8, -2]
        result = p_sum(array, number)
        self.assertEqual(expected, result)

if __name__ == "__main__":
    unittest.main()

