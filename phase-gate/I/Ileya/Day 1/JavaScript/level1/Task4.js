function processNonSquare(arr){
    let result = [];

    for (let index = 0; index < arr.length; index++){
        if (Math.sqrt(arr[index]) == Math.round(Math.sqrt(arr[index])))
            result.push(arr[index]);
        else result.push(-1);
    }

    return result;
}


module.exports = processNonSquare;
