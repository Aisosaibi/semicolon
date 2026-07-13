#import unittest

from unittest import TestCase
from task_3 import move_zeroes_to_end

#class Test_Task_3(unittest.TestCase)
class Test_Task_3(TestCase):
    def test_that_move_zeroes_to_end_returns_array_of_5_3_2_0_0_0(self):
        array = [5, 0, 3, 0, 2, 0]
        expected = [5, 3, 2, 0, 0, 0]
        result = move_zeroes_to_end(array)
        self.assertEqual(expected, result)

#if __name__ == "__main__":
#    unittest.main()
