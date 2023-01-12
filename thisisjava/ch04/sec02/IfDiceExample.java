package thisisjava.ch04.sec02;

public class IfDiceExample {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {

        int num = (int) (Math.random() * 6) + 1;

        if(num == 1) {
            System.out.println(1);
        } else if (num == 2) {
            System.out.println(2);
        } else if (num == 3) {
            System.out.println(3);
        } else if (num == 4) {
            System.out.println(4);
        } else if (num == 5) {
            System.out.println(5);
        } else if (num == 6) {
            System.out.println(6);
        }
    }

    }
}
