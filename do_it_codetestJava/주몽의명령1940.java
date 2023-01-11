package do_it_codetestJava;

import java.util.Arrays;
import java.util.Scanner;

public class 주몽의명령1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] map = new int[size];
        int start = 0;
        int end = size-1;
        int sum = 0;
        int count = 0;
        int M = sc.nextInt();
        for(int i = 0; i < size; i++) {
            map[i] = sc.nextInt();
        }
        Arrays.sort(map);
        while(start < end){
            sum = map[start] + map[end];
            if(sum > M){
                end--;
            }else if(sum == M){
                count += 1;
                start++;
                end--;
            }else{
                start++;
            }
        }
        System.out.println(count);
    }
}
