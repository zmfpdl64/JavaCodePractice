package do_it_codetestJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 22시 29분 22시 10분
// 실4
// https://www.acmicpc.net/problem/1015


public class 수열정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<Integer, List<Integer>> nums = new HashMap<>();
        int[] ins = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] answer = new String[n];
        int count = 0;

        for(int i = 0; i < ins.length; i++) {
            int num = ins[i];
            if(nums.containsKey(num)) {
                nums.get(num).add(i);
            }else{
                nums.put(num, new LinkedList<Integer>(Collections.singletonList(i)));
            }
        }


        for(Integer num : nums.keySet().stream().sorted().mapToInt(Integer::intValue).toArray()){
            for(int i = 0; i < nums.get(num).size(); i++) {
                answer[nums.get(num).get(i)] = String.valueOf(count++);
            }
        }

        System.out.println(String.join(" ", answer));

    }
}
