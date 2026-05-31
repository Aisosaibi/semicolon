import math

def process_non_squares(arr):
    result = []

    for index in range(len(arr)):
        if math.sqrt(arr[index]) == math.floor(math.sqrt(arr[index])):
            result.append(arr[index])
        else: result.append(-1)

    return result
