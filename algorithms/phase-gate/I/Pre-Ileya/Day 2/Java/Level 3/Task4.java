import java.util.Scanner;

public class Task4{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        for (int index = 1; index < 12; index++){
            int product = number * index;
            System.out.printf("%d * %2d = %2d%n", number, index, product);
        }
        System.out.println();
    }
}
