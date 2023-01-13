package thisisjava.ch06.sec08.exam02;

public class Computer {

    int sum(int ... values) {
        int sum = 0;

        for(int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Computer c = new Computer();
        System.out.println(c.sum(1,2,3,4,5));
    }

}
