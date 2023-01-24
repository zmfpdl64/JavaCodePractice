package do_it_codetestJava;

import java.util.Scanner;

public class 수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start= 0, end = 1;
        int count = 0;
        int sum = 1;
        while(end <= N){
            if(sum < N){
                sum += ++end;
            }else if(sum == N){
                sum += ++end;
                count++;
            }else if(sum > N){
                sum-= start++;
            }
        }
        System.out.println(count);
    }
}
