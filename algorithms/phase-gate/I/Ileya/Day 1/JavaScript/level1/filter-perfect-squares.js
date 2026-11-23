// Originally Phase Gate Day 1, Level 1, Task 3.
function processSquares(arr){
    let onlySquares = [];

    for (let index = 0; index < arr.length; index++){
        if (Math.sqrt(arr[index]) == Math.round(Math.sqrt(arr[index])))
            onlySquares.push(arr[index]);
    }

    return onlySquares;
}

module.exports = processSquares;
