package do_it_codetestJava;

import java.util.Arrays;
import java.util.Scanner;

public class Prefix_sum {
    public long solution(int[] nums, int start, int end) {
        long S[] = new long[nums.length];
        S[0] = nums[0];
        for(int i = 0; i < nums.length-1; i++){
            S[i+1] = S[i] + nums[i+1];
        }
        return S[end] - S[start];
    }

    public static void main(String[] args) {
        Prefix_sum s = new Prefix_sum();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int[] nums = new int[T];
        for(int i = 0; i < T; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(s.solution(nums, start, end));
    }
}
