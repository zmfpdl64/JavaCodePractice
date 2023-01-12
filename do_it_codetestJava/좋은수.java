package do_it_codetestJava;

import java.util.Arrays;
import java.util.Scanner;

public class 좋은수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int goal_idx = 0; goal_idx < N; goal_idx++){
            int start_idx = 0;
            int end_idx = N-1;
            long goal = arr[goal_idx];
                while(start_idx < end_idx){
                    long sum = arr[start_idx] + arr[end_idx];

                    if(sum == goal) {
                        if(goal_idx != start_idx && goal_idx != end_idx){
                            count++;
                            break;
                        } else if(goal_idx == start_idx){
                            start_idx++;
                        } else {
                            end_idx--;
                        }
                    }else if(sum > goal){
                        end_idx--;
                    }else{
                        start_idx++;
                    }
                }
        }
        System.out.println(count);
    }
}
