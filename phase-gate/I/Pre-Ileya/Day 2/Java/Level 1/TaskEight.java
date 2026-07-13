import java.util.Scanner;

public class TaskEight{
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
