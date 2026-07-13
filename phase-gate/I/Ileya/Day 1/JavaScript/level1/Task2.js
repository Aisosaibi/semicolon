function checksPalindrome(arr){
    let check = false;
    for (let index = 0; index < arr.length; index++){
        if (arr[index] == arr[(arr.length - 1) - index]){
            check = true;
        } else check = false;
    }
    return check;
}

module.exports = checksPalindrome;
