import unittest
from task_1 import split_even_odd
#import task_1

class Test_Task_1(unittest.TestCase):
    def test_that_split_even_odd_returns_an_array_of_arrays_odds_and_evens(self):
        array = [45, 60, 3, 10, 9, 22]
        expected = [[45, 3, 9], [60, 10, 22]]
        result = split_even_odd(array)
        self.assertEqual(expected, result)

if __name__ == "__main__":
    unittest.main()
