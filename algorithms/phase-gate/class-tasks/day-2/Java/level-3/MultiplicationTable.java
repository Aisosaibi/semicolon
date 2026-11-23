// Originally: class-tasks/Day 2/Java/Level 3/Task4.java (class was Task4)
import java.util.Scanner;

public class MultiplicationTable{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        for (int index = 1; index < 12; index++){
            int product = number * index;
            System.out.printf("%d * %2d = %2d%n", number, index, product);
        }
        System.out.println();
    }
}
