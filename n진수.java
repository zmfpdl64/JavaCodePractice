
public class n진수 {
    public static void main(String[] args) {
        int radix = 5;
        int num =100;
        String num1 = "111";
        // ten to n
        System.out.println(Integer.toString(num, 2));
        // n to ten
        System.out.println(Integer.parseInt(num1, 10));

    }
}
