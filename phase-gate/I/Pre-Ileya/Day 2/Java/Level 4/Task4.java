public class Task4{
    public static void main(String[] args){
        System.out.println(celsiusToFahrenheit(100));
        System.out.println(celsiusToFahrenheit(25));
    }

    public static int celsiusToFahrenheit(int celsius){

        int fahrenheit = 32 + 1.8 * celsius;
        return fahrenheit;
    }
}
