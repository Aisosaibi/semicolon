function processDuplicates(arr){
    let result = [];
    for (let index = 0; index < arr.length; index++) {
        let output = [];
        let duplicates = [];
        let isDuplicate = false;

        for (let instance = 0; instance < index; instance++) {
            if (arr[index] == arr[instance]){
                if (isDuplicate == true) {
                    duplicates.push(index)
                    break
                }

                isDuplicate = true
                duplicates.push(instance)
                duplicates.push(index)
            }
        }
                
        if (isDuplicate == true) {
            output.push(arr[index])
            output.push(duplicates)
            result.push(output)
        }
    }

    result.reverse()

    return result
}

module.exports = processDuplicates;
