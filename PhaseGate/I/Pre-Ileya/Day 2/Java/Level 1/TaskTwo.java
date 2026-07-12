import java.util.Scanner;

public class TaskThree{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("How old are you? ");
        int age = scanner.nextInt();
        System.out.printf("In five years, you will be %d%n", (age + 5));
    }
}
