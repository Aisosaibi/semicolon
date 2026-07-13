import java.util.Scanner;

public class TaskSix{
    public static void main(String[] args){
        area_of_rectangle();
    }

    public static void area_of_rectangle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        double area = length * width;
        System.out.printf("%nArea: %.1f units squared%n", area);
    }
}
