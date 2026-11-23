// Originally: class-tasks/Day 2/Java/Level 5/Task2.java (class was Task1)
import java.util.Arrays;

public class RemoveNegativeNumbers{
    public static void main(String[] args){
        int[] input = {5, -9, 3, -6, 2, -1};
        System.out.println(Arrays.toString(eraseNegativeElements(input)));
    }

    public static int[] eraseNegativeElements(int... array){
        for (int index = 0; index < array.length - 1; index++){
            if (array[index] < 0){
                array[index] = 0;
            }      
        }

        return array;
    }
}
