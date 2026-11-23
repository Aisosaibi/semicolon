import unittest
from replace_non_squares_with_minus_one import process_non_squares

class Test_Task_4(unittest.TestCase):
    def test_that_process_non_squares_returns_desired_output(self):
        array = [4, 7, 9, 10, 49, 6]
        expected = [4, -1, 9, -1, 49 , -1]
        result = process_non_squares(array)
        self.assertEqual(expected, result)

if __name__ == "__main__":
    unittest.main()
