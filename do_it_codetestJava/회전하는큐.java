package do_it_codetestJava;
import java.util.*;
import java.io.*;

// 23시 24분
// 실3
// https://www.acmicpc.net/problem/1021

public class 회전하는큐 {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> dq = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] pops = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;

        for(int i = 1; i <= nm[0]; i++) {
            dq.add(i);
        }
        for(int idx : pops) {
            int target_idx = dq.indexOf(idx);
            int half_idx = dq.size() / 2;
            if(target_idx <= half_idx) {
                for(int j = 0; j < target_idx; j++) {
                    int temp = dq.pollFirst();
                    dq.offerLast(temp);
                    count++;
                }
            }else{
                for(int j = 0; j < dq.size() - target_idx; j++) {
                    int temp = dq.pollLast();
                    dq.offerFirst(temp);
                    count++;
                }
            }
            dq.pollFirst();
        }

        System.out.println(count);
    }
}
