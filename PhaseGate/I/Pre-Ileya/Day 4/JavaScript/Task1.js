function pSum(array, number){
    const pSumArray = []; 
    for (let i = 0; i < array.length/2; i++){
        for (let j = 0; j < array.length; j++){
	    if (i == j) continue;
	    sum = array[i] + array[j];
	    if (sum == number){
	        pSumArray.push(array[i]);
	        pSumArray.push(array[j]);
	        break;
	    }
        }
	return pSumArray;
    }
}

module.exports = pSum;
