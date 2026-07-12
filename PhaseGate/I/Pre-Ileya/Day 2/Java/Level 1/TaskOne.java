import java.util.Scanner;

public class TaskOne{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What's your name? ");
        String name = scanner.nextLine();
        System.out.printf("Hello, %s%n", name);
    }
}
