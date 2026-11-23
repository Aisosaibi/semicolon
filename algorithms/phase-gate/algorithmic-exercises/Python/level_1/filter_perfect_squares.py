"""Keep perfect-square values from an array. Originally Phase Gate Day 1, Level 1, Task 3."""

import math

def process_squares(array):
    only_squares = []

    for index in range(len(array)):
        if (math.sqrt(array[index]) == math.floor(math.sqrt(array[index]))):
            only_squares.append(array[index])

    return only_squares
