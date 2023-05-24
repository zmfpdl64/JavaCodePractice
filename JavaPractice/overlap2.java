package JavaPractice;

import java.util.Arrays;

public class overlap2 {
    public static void main(String[] args) {
    }
    public int[] solution(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] *=2;
        }
        return numbers;
    }
}
