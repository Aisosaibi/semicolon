#import unittest

from unittest import TestCase
from task_1 import process_duplicates

#class Test_Task_1(unittest.TestCase)
class Test_Task_1(TestCase):
    def test_that_process_duplicates_returns_2_and_3(self):
        array = [1, 2, 3, 2, 4, 3]
        expected = [2, 3]
        result = process_duplicates(array)
        self.assertEqual(expected, result)

#if __name__ == "__main__":
#    unittest.main()
