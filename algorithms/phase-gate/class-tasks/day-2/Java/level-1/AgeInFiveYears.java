// Originally: class-tasks/Day 2/Java/Level 1/TaskTwo.java (class was TaskThree)
import java.util.Scanner;

public class AgeInFiveYears{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("How old are you? ");
        int age = scanner.nextInt();
        System.out.printf("In five years, you will be %d%n", (age + 5));
    }
}
