import java.util.Scanner;

public class Task6{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        int sumN = 0;
        for (int index = number; index > 0; index--){
            sumN += index;
        }
        System.out.printf("Sum of all numbers from 1 to %d = %d%n", number, sumN);
    }
}
