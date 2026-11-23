import java.util.Scanner;

public class Task5{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        int factorial = 0;
        for (int index = number - 1; index > 0; index--){
            factorial += number * index;
        }
        System.out.printf("Factorial of %d = %d%n", number, factorial);
    }
}
