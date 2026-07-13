import java.util.Arrays;

public class Task1{
    public static void main(String[] args){
	int[] array = {1, 2, 5, 7, 6, 8, 9};
	System.out.println(Arrays.toString(pSum(array, 12)));
	
    }

    public static int[] pSum(int[] array, int number){
	int sum = 0;
	int[] pSumArray = new int[2];

	for (int i = 0; i < array.length/2; i++){
	    int j = 0;

	    for (j = 0; j < array.length; j++){
		if (i == j) continue;
	        sum = array[i] + array[j];
		if (sum == number){
		    pSumArray[0] = array[i];
		    pSumArray[1] = array[j];
		    break;
		}
	    }
	}

	return pSumArray;
    }
}
