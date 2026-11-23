// Originally: class-tasks/Day 2/Java/Level 2/TaskOne.java (class was TaskOne)
import java.util.Scanner;

public class EvenOrOdd{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        double number = scanner.nextDouble();
        if (number % 2 == 0){
            System.out.println("Number is even");
        } else{
            System.out.println("Number is odd");
        }
    }
}
