public class Task1{
    public static int[] getIndicesToSum(int[] array, int value){
        int[] result = {-1, -1}; //Nothing found

        for (int index = 0; index < array.length; index++){
            for (int instance = index + 1; instance < array.length; instance++){
                if (array[index] + array[instance] == value){
                    result[0] = index;
                    result[1] = instance;
                    return result;
                }
            }
        }

        return result;
    }
}
