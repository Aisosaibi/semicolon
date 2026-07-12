def unique(array):
    count = 0;

    for i in range(len(array)):
        seenBefore = false   
        for j in range(i):
            if (array[i] == array[j]):
                seenBefore = true
                break
         
        if !seenBefore:
            count += 1

    uniqueSubset = []

    for i in range(len(array)):
        seenBefore = false   
        for j in range(i):
            if (array[i] == array[j]):
                seenBefore = true
                break

        if !seenBefore:
            uniqueSubset.append(array[i]) = array[i]
 
    return uniqueSubset
