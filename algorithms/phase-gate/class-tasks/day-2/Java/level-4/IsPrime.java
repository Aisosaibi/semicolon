// Originally: class-tasks/Day 2/Java/Level 4/Task5.java (class was Task5)
public class IsPrime{
    public static void main(String[] args){
        System.out.println(isPrime());
    }

    public static String isPrime(int number){

        String status = "init";
        if number < 0 {
            status = "Input positive numbers";
            return status;
        }

        else if (number == 1) {
            status = "1 is not considered a prime number"; 
            return status;
        }

        else if (number == 2 || number == 3) {
            status = "Prime number";
            return status;
        } else {
            for (int index = 2; index < number; i++){
                if (number % index == 0){
                    status == "Not a prime number"
                    return status;
                }

            status == "Prime number";
            return status;
            }
        }
    }
}
