import java.util.Arrays;

public class Task2{
    public static int[] unique(int[] array){
        int count = 0;

        for (int i = 0; i < array.length; i++){
            boolean seenBefore = false;            
            for (int j = 0; j < i; j++){
                if (array[i] == array[j]){
                    seenBefore = true;
                    break;
                }           
            }
            if (!seenBefore) count++; 
        }

        int[] uniqueSubset = new int[count];
        int uI = 0;

        for (int i = 0; i < array.length; i++){
            boolean seenBefore = false;
            for (int j = 0; j < i; j++){
                if (array[i] == array[j]){
                    seenBefore = true;
                    break;
                }
            }

            if (!seenBefore){
                uniqueSubset[uI] = array[i];
                uI++;
            }
        }  
        
        return uniqueSubset;    
    }

//    public static void main(String[] args){
//        int[] array = {1, 2, 3, 1, 2, 3, 4};
//        System.out.println(Arrays.toString(unique(array)));
//    }
}
