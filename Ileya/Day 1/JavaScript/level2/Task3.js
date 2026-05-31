function moveZeroesToEnd(arr) {
    let result = [];
    let index = 0;

    for (let instance = 0; instance < arr.length; instance++){
        result.push(0);
    }

    for (let instance = 0; instance < arr.length; instance++){
        if (arr[instance] != 0) {
            result[index] = arr[instance];
            index ++;
        }
    }

    return result
}

module.exports = moveZeroesToEnd;
