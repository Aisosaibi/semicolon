// Originally: class-tasks/Day 2/Java/Level 1/TaskSeven.java (class was TaskSeven)
import java.util.Scanner;

public class CircleCircumference{
    public static void main(String[] args){
        circumference();
    }

    public static void circumference(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        double circum = 2 * Math.PI * radius;
        System.out.printf("%nCircumference: %.2f%n", circum);
    }
}
