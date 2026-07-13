import java.util.Scanner;

public class TaskNine{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        double finalPrice = price * 1.1;
        System.out.printf("%nPrice (+10%% VAT): %.2f%n", finalPrice);
    }
}
