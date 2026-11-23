import java.util.Scanner;

public class TaskTwo{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        double number = scanner.nextDouble();
        if (number > 0){
            System.out.println("Number is positive");
        }
        else if (number < 0){
            System.out.println("Number is negative");      
        }
        else System.out.println("Number is zero");
    }
}
