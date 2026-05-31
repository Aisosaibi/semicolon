def process_duplicates(arr):
    result = []
    range_ = len(arr)
    for index in range(range_):
        output = []
        duplicates = []
        is_duplicate = False
        for instance in range (index):
            if arr[index] == arr[instance]:
                if is_duplicate == True:
                    duplicates.append(index)
                    break
                is_duplicate = True
                duplicates.append(instance)
                duplicates.append(index)
                
        if is_duplicate == True:
            output.append(arr[index])
            output.append(duplicates)
            result.append(output)

    result.reverse()

    return result
