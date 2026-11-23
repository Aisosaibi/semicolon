// Originally: class-tasks/Day 2/Java/Level 3/Task3.java (class was Task2)
public class PrintNumbersBelow50{
    public static void main(String[] args){
        System.out.println("Even numbers between 1 and 50 (non-inclusive):")
        for (int num = 1; num < 50; num+=2){
            System.out.printf("%0d%n", num);
        }
        System.out.println();
    }
}
