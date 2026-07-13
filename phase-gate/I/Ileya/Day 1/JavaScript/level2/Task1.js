function processDuplicates(arr){
    let output = []
    for (let index = 0; index < arr.length; index++){
        let duplicate = false;
        for (let instance = 0; instance < index; instance++){
            if (arr[index] == arr[instance]){
                if (duplicate == true) {
                    duplicate = false
                    break
                }

                duplicate = true
            }
        }
                
        if (duplicate == true) {
            output.push(arr[index]);
        }
    }

    return output
}

module.exports = processDuplicates;
