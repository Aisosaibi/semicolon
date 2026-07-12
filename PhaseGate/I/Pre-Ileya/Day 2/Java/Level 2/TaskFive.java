import java.util.Scanner;

public class TaskFour{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double numberOne = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double numberTwo = scanner.nextDouble();
        System.out.print("Enter third number: ");
        double numberThree = scanner.nextDouble();

        double largestNumber = numberOne;

        if (largestNumber < numberThree) largestNumber = numberTwo;
        else if (largestNumber < numberThree) largestNumber = numberThree;
        
        System.out.print("Largest number is %f%n", largestNumber);
    }
}
