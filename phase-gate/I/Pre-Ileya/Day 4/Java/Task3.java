import java.util.Arrays;

public class Task3{
    public static int[] minMaxRange(int[] array){
        int leastNumber = array[0];
        int largestNumber = array[0];

        for (int i = 0; i < array.length; i++){
            if (largestNumber < array[i]) {
                largestNumber = array[i];  
            }

            if (leastNumber > array[i]) {
                leastNumber = array[i];
            }
        }

        int count = largestNumber - leastNumber;

        if (largestNumber == leastNumber){
            throw new IllegalArgumentException("No range between min and max values!");
        }

        int[] mintoMax = new int[count]; 

        for (int i = 0; i < count; i++){
            mintoMax[i] = leastNumber + i;
        }
        
        return mintoMax;    
    }

//    public static void main(String[] args){
//        int[] array = {1, 11};
//        System.out.println(Arrays.toString(minMaxRange(array)));
//    }
}
