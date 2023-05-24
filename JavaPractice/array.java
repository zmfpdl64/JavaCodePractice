package JavaPractice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class array{
    public static void main(String[] args) {
        array s = new array();
        System.out.println(s.solution(new int[]{1,2,3,4,5})); 
    }
    public int[] solution(int[] arr1) {

        return IntStream.of((int) Arrays.stream(arr1).filter(i -> i % 2 == 0).count(), (int) Arrays.stream(arr1).filter(i -> i % 2 != 0).count()).toArray();
    }
}