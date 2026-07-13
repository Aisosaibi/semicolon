//const splitEvenOdd = function (arr){
function splitEvenOdd(arr){
    let odds = [];
    let evens = [];

    for (let index = 0; index < arr.length; index++) {
        if (arr[index] % 2 == 1) {
            odds.push(arr[index]);
        } else {
            evens.push(arr[index]);
        }
    }
    return [odds, evens];
}

module.exports = splitEvenOdd;
