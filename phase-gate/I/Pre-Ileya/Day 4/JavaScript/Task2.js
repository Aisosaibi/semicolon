function unique(array){
    let count = 0;

    for (i = 0; i < array.length; i++){
        boolean seenBefore = false;            
        for (j = 0; j < i; j++){
            if (array[i] == array[j]){
                seenBefore = true;
                break;
            }           
        }
        if (!seenBefore) count++; 
    }

    let uniqueSubset = [];

    for (i = 0; i < array.length; i++){
        boolean seenBefore = false;
        for (j = 0; j < i; j++){
            if (array[i] == array[j]){
                seenBefore = true;
                break;
            }
        }

        if (!seenBefore){
            uniqueSubset.append(array[i]) = array[i];
        }
    }  
        
    return uniqueSubset;    
}
}
