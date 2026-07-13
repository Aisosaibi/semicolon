import java.util.Scanner;

public class Task9{
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
