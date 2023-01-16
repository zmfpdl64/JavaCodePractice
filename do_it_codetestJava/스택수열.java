package do_it_codetestJava;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String answer = "";
        int[] map = new int[N];
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            map[i] = sc.nextInt();
        }
        for( int i = 0; i < map.length; i++) {
            int su = map[i];
            if( su >= num) {
                while(su >= num) {
                    stack.add(num++);
                    answer += "+\n";
                }
                stack.pop();
                answer += "-\n";
            }else {
                int n = stack.pop();
                if (n > su) {
                    answer = "No";
                    break;
                }else {
                    answer += "-\n";
                }
            }
        }
        System.out.println(answer);
    }
}
