function onlyConsonant(String... array){
   let count = 0;

   for (i = 0; i < array.length; i++){
       if (!array[i].contains("a") || !array[i].contains("i") || !array[i].contains("i") || !array[i].contains("o") || !array[i].contains("u")){
            count++;
            break;
        }
    console.log(count);
    }

    let consonantsOnly = [];

    count = 0;

    for (i = 0; i < array.length; i++){
        if (!array[i].contains("a") || !array[i].contains("i") || !array[i].contains("i") || !array[i].contains("o") || !array[i].contains("u")){
            consonantsOnly[count++] = array[i];
            break;
        }
    }
    return consonantsOnly;
}
