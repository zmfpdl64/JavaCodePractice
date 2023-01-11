package do_it_codetestJava;

import java.util.Scanner;

public class RemainderSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start = 0, end = 1;
        int sum = 1;
        int count = 1;
        while(start <= end) {
            if(sum > N){
                sum -= start;
                start += 1;
            }else if(sum == N){
                sum += ++end;
                count++;
            }else{
                sum += ++end;
            }
        }
        System.out.println(count);
    }
}
