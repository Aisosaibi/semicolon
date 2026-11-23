// Originally: class-tasks/Day 2/Java/Level 3/Task9.java (class was Task9)
import java.util.Scanner;

public class StarTriangle{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size: ");
        int number = scanner.nextInt();
        System.out.println();

        for (int index = 0; index < number; index++){
            for (int jndex = 0; jndex < index; jndex++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
