package do_it_codetestJava;

import java.util.Arrays;
import java.util.Scanner;

public class Average {

    public Double solution(int[] nums ) {
        Double length = (double) nums.length;
        Float length1 = (float) nums.length;
        Long length2 = (long) nums.length;
        Integer length3 = (int) 10.7;
        return Arrays.stream(nums).mapToDouble(Double::valueOf).sum() / (double) nums.length;
    }

    public static void main(String[] args) {
        Average s = new Average();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] nums = new int[T];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(s.solution(nums));
    }

}
