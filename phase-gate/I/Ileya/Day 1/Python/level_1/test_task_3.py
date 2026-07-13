import unittest
from task_3 import process_squares

class Test_Task_3(unittest.TestCase):
    def test_that_process_squares_returns_4_9_16(self):
        array = [4, 7, 9, 10, 16, 18]
        expected = [4, 9, 16]
        result = process_squares(array)
        self.assertEqual(expected, result)

if __name__ == "__main__":
    unittest.main()
