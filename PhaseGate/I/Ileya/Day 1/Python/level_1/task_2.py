def checks_palindrome(array):
    check = False
    range_ = len(array)

    for index in range(range_):
        if array[index] == array[(range_-1) - index]:
            check = True
        else: check = False
    
    return check
