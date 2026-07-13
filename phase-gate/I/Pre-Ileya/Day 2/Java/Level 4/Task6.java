public class Task6{
    public static void main(String[] args){
        findLargest(1, 2, 2));
        findLargest(4, 25, 30));
    }

    public static void findLargest(double x, double y, double z){
        double largestNumber = x;
        if (largestNumber < y) {
            largestNumber = y;
        } 

        if (largestNumber < z){
            largestNumber = z;
        }

        System.out.printf("%.2f", largestNumber);
    }
}
