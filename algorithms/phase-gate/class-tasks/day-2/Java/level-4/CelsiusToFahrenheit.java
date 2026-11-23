// Originally: class-tasks/Day 2/Java/Level 4/Task4.java (class was Task4)
public class CelsiusToFahrenheit{
    public static void main(String[] args){
        System.out.println(celsiusToFahrenheit(100));
        System.out.println(celsiusToFahrenheit(25));
    }

    public static int celsiusToFahrenheit(int celsius){

        int fahrenheit = 32 + 1.8 * celsius;
        return fahrenheit;
    }
}
