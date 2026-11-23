import java.util.Arrays;

public class Task1{
    public static void main(String[] args){
        int[] input = {5, 9, 3, 6, 2};
        System.out.println(Arrays.toString(sortArray(input)));
    }

    public static int[] sortArray(int... array){
        for (int index = 0; index < array.length; index++){
            for (int innerIndex = index + 1; innerIndex < array.length; innerIndex++)
                int temp = array[index];
                if (array[index] < array[innerIndex]){
                    array[index] = array[innerIndex];
                    array[innerIndex] = temp;            
                }      
        }

        return array;
    }
}
