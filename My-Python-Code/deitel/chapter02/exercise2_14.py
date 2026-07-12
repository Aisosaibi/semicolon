#public class HeartRateCalculator {
#    public static void main(String[] args) {
#        Scanner input = new Scanner(System.in);
#        System.out.print("What's your age? ");
#        int age = input.nextInt();
#
#        maximumHeartRate = 220 - age;
#        targetLowerRange = 0.5 * maximumHeartRate;
#        targetHigherRange = 0.85 * maximumHeartRate;
#
#        System.out.printf("Your maximum heart Rate is %d bpm. Your normal heart range should fall between %d - %d.%n bpm", maximumHeartRate, targetLowerRange, targetHigherRange)
#    }
#}

maximum_heart_rate = 220 - int(input("Enter Age: "))
target_lower_range = 0.5 * maximum_heart_rate
target_higher_range = 0.85 * maximum_heart_rate

print("Your maximum heart rate is " + maximumHeartRate + " bpm. Your normal heart rate should fall between " + target_lower_range " - " + target_higher_range " bpm.")
