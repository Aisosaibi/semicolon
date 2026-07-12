#convert to python

#def minMaxRange(array){
#    let leastNumber = array[0];
#    let largestNumber = array[0];

#    for (i = 0; i < array.length; i++){
#        if (largestNumber < array[i]) {
#            largestNumber = array[i];  
#        }
#
#        if (leastNumber > array[i]) {
#            leastNumber = array[i];
#        }
#    }

#    const count = largestNumber - leastNumber;
#
#    if (largestNumber == leastNumber){
#        throw new IllegalArgumentException("No range between min and max values!");
#    }

#    let mintoMax = []; 
#
#    for (i = 0; i < count; i++){
#        mintoMax[i] = leastNumber + i;
#    }
       
#    return mintoMax; 
#}
