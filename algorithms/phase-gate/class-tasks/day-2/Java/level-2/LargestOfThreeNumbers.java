// Originally: class-tasks/Day 2/Java/Level 2/TaskFive.java (class was TaskFour)
import java.util.Scanner;

public class LargestOfThreeNumbers{
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
