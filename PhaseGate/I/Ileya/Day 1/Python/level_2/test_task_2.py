#import unittest

from unittest import TestCase
from task_2 import process_duplicates

#class Test_Task_2(unittest.TestCase)
class Test_Task_2(TestCase):
    def test_that_process_duplicates_returns_expected_array_of_arrays(self):
        array = [-11, -9, 3, -9, 2, -11]
        expected = [[-11, [0, 5]], [-9, [1, 3]]]
        result = process_duplicates(array)
        self.assertEqual(expected, result)

#if __name__ == "__main__":
#    unittest.main()
