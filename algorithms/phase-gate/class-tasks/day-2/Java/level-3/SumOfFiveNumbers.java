// Originally: class-tasks/Day 2/Java/Level 3/Task7.java (class was Task7)
import java.util.Scanner;

public class SumOfFiveNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        final int ROUNDS = 5;
        int[] numbers = new int[ROUNDS];

        for (int index = 0; index < ROUNDS; index++){
            System.out.print("Enter number: ");
            numbers[index] = scanner.nextInt();
        }

        int sumN = 0;
        for (int number: numbers){
            sumN += number;
        }

        System.out.printf("Sum: %d%n", sumN);
    }
}
