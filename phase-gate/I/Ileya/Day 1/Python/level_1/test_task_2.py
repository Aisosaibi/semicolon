import unittest
from task_2 import *

class Test_Task_2(unittest.TestCase):
    def test_that_checks_palindrome_returns_true_if_array_is_palindrome(self):
        array = [45, 0, 8, 0, 45]
        expected = True
        result = checks_palindrome(array)
        self.assertEqual(expected, result) #when I commented this the test still passed. Why?

if __name__ == "__main__":
    unittest.main()
