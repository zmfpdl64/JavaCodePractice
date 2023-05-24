package JavaPractice;

import java.util.stream.IntStream;

public class num_bro3 {
    
    public static void main(String[] args) {
        num_bro3 s = new num_bro3();
        System.out.println(s.Solution(12)); 
    }

    public int Solution(int n) {
        return IntStream.rangeClosed(0, n)
        .filter(e -> e % 2 == 0)
        .sum();
    }
}
