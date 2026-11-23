// Originally: class-tasks/Day 2/Java/Level 3/Task8.java (class was Task8)
//Ask the user to enter numbers until they enter 0 and then print the total

public class SumUntilZero{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter number: ")
        int entry = scanner.nextInt();

        while (entry != 0){
            System.out.print("Enter another number (0 to stop): ");
            sum += entry;
            entry = scanner.nextInt();
        }

        System.out.println("Sum total = %d", sum);
    }
}
