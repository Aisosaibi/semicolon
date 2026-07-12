import java.util.Scanner;

public class ParkingLot{
    public static String parkingLot(){
        Scanner scanner = new Scanner(System.in);
        int size = 20;
        int[] pLot = new int[size];
        int parkingSpot;
        String message = "There are free slots!";
        String status = String.format("%d slots still available", (size));

        int spots = 0;
        for (int i = 0; i < size; i++)
            if (pLot[i] == 0){
                System.out.print("Welcome to our parking lot. Do you wish to park with us? ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("Yes")){
                System.out.print("Choose your parking spot (1-20): ");
                parkingSpot = scanner.nextInt() - 1;
                    if (pLot[parkingSpot] == 0){
                        size--;
                        pLot[parkingSpot] = 1;
                        message = String.format("Your car is safely parked at spot %d", (parkingSpot + 1));
                        System.out.println(message);
                    }
                }else{
                    status = "That spot is currently occupied. Choose another parking spot.";
                    return status;    
                }
            }
        return message;
    }

//    public static String parkingLot(int... array){
//        if (array.length > 20){
//            String message = "Enter an array with 20 elements";
//            return message;
//        }
//    }

    public static void main(String[] args){
        System.out.println(parkingLot());
    }
}
