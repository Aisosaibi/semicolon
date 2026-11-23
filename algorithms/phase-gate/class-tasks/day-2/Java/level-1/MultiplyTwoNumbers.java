// Originally: class-tasks/Day 2/Java/Level 1/TaskFour.java (class was TaskFour)
import java.util.Scanner;

public class MultiplyTwoNumbers{
    public static void main(String[] args){
        nxn();
    }

    public static void nxn(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double numberOne = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double numberTwo = scanner.nextDouble();
        double product = numberOne * numberTwo;
        System.out.printf("%nProduct: %.1f", numberOne, numberTwo, product);
    }
}
