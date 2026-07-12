def split_even_odd(arr):
    odds = []
    evens = []

    for index in range(len(arr)):
        if arr[index] % 2 == 1: 
            odds.append(arr[index])
        else:
            evens.append(arr[index])
        
    
    return [odds, evens]
