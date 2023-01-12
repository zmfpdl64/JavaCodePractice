package thisisjava.ch05.sec05;

public class EqualsExample {
    public static void main(String[] args) {
        String strVal1 = "홍길동";
        String strVal2 = "홍길동";

        System.out.println(strVal1 == strVal2);
        System.out.println(strVal1.equals(strVal2));
    }
}
