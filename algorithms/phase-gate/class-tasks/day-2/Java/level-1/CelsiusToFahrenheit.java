// Originally: class-tasks/Day 2/Java/Level 1/TaskFive.java (class was TaskFive)
import java.util.Scanner;

public class CelsiusToFahrenheit{
    public static void main(String[] args){
        convertTemp();
    }

    public static void convertTemp(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Temperature in celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = 32 + 1.8 * celsius;
        System.out.printf("%nTemperature in Fahrenheit: %f degrees", fahrenheit);
    }
}
