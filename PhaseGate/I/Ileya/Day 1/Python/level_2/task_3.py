#def move_zeroes_to_end(array):
#    range_ = len(array)
#    for index in range(range_):
#        temp = 'init'
#        shift = 0
#        if array[index] == 0:
#            temp = array[index]
#            while array[-1 + shift] == 0:
#                shift += 1
#            
#            array[index] = array[-1 + shift]
#            array[-1 + shift] = temp
#            shift += 1
#
#    return array

#def move_zeroes_to_end(array):
#    range_ = len(array)
#    count = 0
#    index = 0
#
#    for instance in range(range_):
#        if array[index] == 0:
#            array.pop(index)
#            count += 1
#            index += 1
#
#    for instance in range(count):
#        array.append(0)            
#
#    return array

def move_zeroes_to_end(array):
    result = []
    range_ = len(array)
    index = 0

    for instance in range(range_):
        result.append(0)

    for instance in range(range_):
        if array[instance] != 0:
            result[index] = array[instance]
            index += 1

    return result
