// Originally: class-tasks/Day 2/Java/Level 1/TaskEight.java (class was TaskEight)
import java.util.Scanner;

public class SquareANumber{
    public static void main(String[] args){
        square();
    }

    public static void square(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        double number = scanner.nextDouble();
        double numberSquared = number * number;
        System.out.printf("%nNumber squared: %.2f", numberSquared);
    }
}
