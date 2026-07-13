import java.util.Scanner;

public class TaskTen{
    public static void main(String[] args){
        average_of_three();
    }

    public static void average_of_three(){
        final int COUNT = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        double numberOne = scanner.nextDouble();
        System.out.print("Enter number: ");
        double numberTwo = scanner.nextDouble();
        System.out.print("Enter number: ");
        double numberThree = scanner.nextDouble();
        double sum = numberOne + numberTwo + numberThree;
        double avg = sum/COUNT;
        System.out.printf("%nAverage: %.1f%n", avg);
                         
    }               
}
