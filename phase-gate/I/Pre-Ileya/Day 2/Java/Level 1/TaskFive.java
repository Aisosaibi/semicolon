import java.util.Scanner;

public class TaskFive{
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
