import java.util.Arrays;

public class Task1{
    public static void main(String[] args){
        int[] input = {5, 9, 3, 6, 2};
        System.out.println(Arrays.toString(moveZerosInArray(input)));
    }

    public static int[] moveZeroesInArray(int... array){
        for (int index = 0; index < array.length; index++){
            if (array[index] == 0){
                for (int innerIndex = index + 1; innerIndex < array.length; innerIndex++){
                if (array[innerIndex] == 0) continue;
                else {
                    int temp = array[index];
                    array[index] = array[innerIndex];
                    array[innerIndex] = temp;            
                }  
            }    
        }

        return array;
    }
}
