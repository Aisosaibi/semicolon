"""Find a pair of values whose sum matches the target. Originally Phase Gate Day 4, Task 1."""

def find_pair_for_sum(array, number):
    index = 0;
    length = len(array)
    p_sum_array = []
    for i in range(length):
        for j in range(length):
            if i == j: continue;
            sum = array[i] + array[j]
            if sum == number:
                p_sum_array.append(array[i])
                p_sum_array.append(array[j])
                break;
        return p_sum_array


array = [2, 3, 4, 5, 6]
print(find_pair_for_sum(array, 6))
