function findLargest(x, y, z){
    let largestNumber = x;
    if (largestNumber < y) {
        largestNumber = y;
    } 
    if (largestNumber < z){
        largestNumber = z;
    }
    return largestNumber;
}

console.log(findLargest(2, 3, 4))
console.log(findLargest(1, 2, 2))
console.log(findLargest(1, 1, 1))
