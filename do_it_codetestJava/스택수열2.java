package do_it_codetestJava;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] map = new int[N];
        int num = 1;
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            map[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            int su = map[i];
            if(su >= num) { //su까지의 값들을 모두 stack에 추가한다.
                while(su >= num) {
                    stack.add(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else{
                int n = stack.pop();
                if(n != su){
                    sb = new StringBuffer("NO");
                    break;
                }else{
                    sb.append("-\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}