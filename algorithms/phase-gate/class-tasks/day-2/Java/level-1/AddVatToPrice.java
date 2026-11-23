// Originally: class-tasks/Day 2/Java/Level 1/TaskNine.java (class was TaskNine)
import java.util.Scanner;

public class AddVatToPrice{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        double finalPrice = price * 1.1;
        System.out.printf("%nPrice (+10%% VAT): %.2f%n", finalPrice);
    }
}
