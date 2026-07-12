def process_duplicates(arr):
    output = []
    range_ = len(arr)
    for index in range(range_):
        duplicate = False
        for instance in range (index):
            if arr[index] == arr[instance]:
                if duplicate == True:
                    duplicate = False
                    break
                duplicate = True
                
        if duplicate == True:
            output.append(arr[index])

    return output
