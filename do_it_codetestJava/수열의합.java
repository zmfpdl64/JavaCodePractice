package do_it_codetestJava;

// 16시 33분 15시 17분
// 실2
// https://www.acmicpc.net/problem/1024

// 연속된 합
// 연속된 수의 갯수가 100미만이여야 한다.
// 갯수가 100이상이면 -1을 반환한다.
import java.util.*;
import java.io.*;

public class 수열의합 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        String[] ins = reader.readLine().split(" ");
        List<Long[]> answers = new ArrayList<>();

        long sum_g = Long.parseLong(ins[0]);
        long size = Long.parseLong(ins[1]);

        long start = 0L;
        long end = 1L;
        long sum = 1L;
        while(start <= end) {
            if(sum > sum_g) {
                sum -= start;
                start += 1;
            }else if(sum == sum_g) {
                if((end-start) < 100 && (end-start) >= size-1){
                    answers.add(new Long[]{start, end});
                }
                sum -= start;
                start += 1;
            }else{
                end += 1;
                sum += end;
            }
        }
        long min = Long.MAX_VALUE;
        int ans = -1;
        for(int i = 0; i < answers.size(); i++) {
            long dif_v = answers.get(i)[1] - answers.get(i)[0];
            if(min > dif_v){
                min = dif_v;
                ans = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(ans == -1){
            System.out.println(-1);
        }else{
            long start_v = answers.get(ans)[0];
            long end_v = answers.get(ans)[1];
            for(long i = start_v; i <= end_v; i++) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }

        reader.close();
        writer.close();
    }
}
