"""Check whether an array reads the same forwards and backwards. Originally Phase Gate Day 1, Level 1, Task 2."""

def checks_palindrome(array):
    check = False
    range_ = len(array)

    for index in range(range_):
        if array[index] == array[(range_-1) - index]:
            check = True
        else: check = False
    
    return check
