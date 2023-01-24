package do_it_codetestJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 좋다1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(map);

        for(int i = 0; i < N; i++) {
            int goal = map[i];
            int start = 0, end = N-1;
            while(start < end){
                int sum = map[start] + map[end];
                if(goal == sum) {
                    if(start != i && end != i){
                        count ++;
                        break;
                    }else if(start == i){
                        start++;
                    }else{
                        end--;
                    }
                }else if(sum > goal){
                    end--;
                }else{
                    start++;
                }
            }
        }
        System.out.println(count);
    }
}
