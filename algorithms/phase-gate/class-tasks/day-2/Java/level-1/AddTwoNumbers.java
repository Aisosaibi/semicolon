// Originally: class-tasks/Day 2/Java/Level 1/TaskThree.java (class was TaskThree)
import java.util.Scanner;

public class AddTwoNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double numberOne = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double numberTwo = scanner.nextDouble();
        double sum = numberOne + numberTwo;
        System.out.printf("%n.1f%n", sum);
    }
}
