import java.util.ArrayList;

public class Base {
    public static int convert(int number, int currentBase, int targetBase) {
        if (currentBase > 10 || targetBase > 10) { throw new IllegalArgumentException("This implementation requires a maximum target base of 10."); }
        if (currentBase == 10) return convertFromBaseTen(number, targetBase);
        else {
            int baseTenEquiv = convertToBaseTen(number, currentBase);
            return convertFromBaseTen(baseTenEquiv, targetBase);
        }
    }

    public static int convert(int number, int targetBase) {
            return convertFromBaseTen(number, targetBase);
    }

    public static int convertToBaseTen(int number, int currentBase) {
        int numberOfDigits = Integer.toString(number).length();
        int count = 0; int result = 0;
        while (count < numberOfDigits) {
            result += (int) ((number % 10) * Math.pow(currentBase, count));
            number =  number / 10;
            count++;
        }
        return result;
    }

    private static int convertFromBaseTen(int number, int targetBase) {
        int result = 0;
        ArrayList<Integer> remainders = new ArrayList<>();
        while (number > 0) {
            remainders.add(number % targetBase);
            number /= targetBase;
        }
        for (int i = remainders.size() - 1; i >= 0; i--) {
            result += (int) (Math.pow(10, i) * remainders.get(i));
        }
        return result;
    }
}
