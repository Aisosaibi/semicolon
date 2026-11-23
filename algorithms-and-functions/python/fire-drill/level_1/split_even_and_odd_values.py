"""Split values into odd and even groups. Originally Phase Gate Day 1, Level 1, Task 1."""

def split_even_odd(arr):
    odds = []
    evens = []

    for index in range(len(arr)):
        if arr[index] % 2 == 1: 
            odds.append(arr[index])
        else:
            evens.append(arr[index])
        
    
    return [odds, evens]
