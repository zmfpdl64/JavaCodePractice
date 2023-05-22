package do_it_codetestJava;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        int[] map = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringBuffer ans = new StringBuffer();
        int[] answer = new int[N];
        map = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        stack.push(0);
        for(int i = 0 ; i < map.length; i++) {
            while(!stack.isEmpty() && map[stack.peek()] < map[i]) {
                answer[stack.pop()] = map[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        for(int i = 0; i < N; i++) {
            ans.append(answer[i]+" ");
        }
        ans.append("\n");
        System.out.println(ans);
    }
}
