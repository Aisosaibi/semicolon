import java.util.Scanner;

public class TaskThree{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter score: ");
        double number = scanner.nextDouble();
        if (score >= 50){
            System.out.println("Pass");
        } else System.out.println("Fail");
    }
}
