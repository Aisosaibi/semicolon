// Originally: class-tasks/Day 2/Java/Level 2/TaskThree.java (class was TaskThree)
import java.util.Scanner;

public class PassOrFail{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter score: ");
        double number = scanner.nextDouble();
        if (score >= 50){
            System.out.println("Pass");
        } else System.out.println("Fail");
    }
}
