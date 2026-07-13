public class Task2{
    public static void main(String[] args){
        System.out.println(IsEven(2));
        System.out.println(IsEven(3));

    }

    public static String IsEven(int x){
        String message = "init";
        if (x % 2 == 0) {message = "Number is even";}
        else {message = "Number is odd";}
     
        return message;
    }
}
