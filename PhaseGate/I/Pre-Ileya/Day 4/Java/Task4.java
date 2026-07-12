import java.util.Arrays;

public class Task4{
    public static String[] onlyConsonant(String... array){
        int count = 0;
//        for (String word: array){
//            if (!word.contains("a") || !word.contains("i") || !word.contains("i") || !word.contains("o") || !word.contains("u")) count++; break;
//        }

        for (int i = 0; i < array.length; i++){
            if (!array[i].contains("a") || !array[i].contains("i") || !array[i].contains("i") || !array[i].contains("o") || !array[i].contains("u")){
                count++;
                break;
            }
        }
        String[] consonantsOnly = new String[count];

        count = 0;

        for (int i = 0; i < array.length; i++){
            if (!array[i].contains("a") || !array[i].contains("i") || !array[i].contains("i") || !array[i].contains("o") || !array[i].contains("u")){
                consonantsOnly[count++] = array[i];
                break;
            }
        }
        return consonantsOnly;
    }

//    public static void main(String[] args){
//        String[] array = {"fly", "aero", "aisos"};
//        System.out.println(Arrays.toString(onlyConsonant(array)));
//    }
}
