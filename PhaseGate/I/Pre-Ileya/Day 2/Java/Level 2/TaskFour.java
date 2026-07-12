import java.util.Scanner;

public class TaskFour{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double numberOne = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double numberTwo = scanner.nextDouble();
        if (numberOne > numberTwo == 0){
            System.out.printf("%d is the largest number%n", numberOne);
        } 
        else if (numberOne < numberTwo == 0){
            System.out.printf("%d is the largest number%n", numberTwo);
        } else{
            System.out.println("Both numbers are equal");
        }
    }
}
