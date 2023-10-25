import java.util.*;
import java.io.*;

// 22시 40분 23시 02분
// 실4
// https://www.acmicpc.net/problem/1059
public class 좋은구간 {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).sorted().toArray();
        int goal = Integer.parseInt(reader.readLine());

        if(arr[0] > goal){
            isInRange(goal, 0, arr[0]);
        }
        else{
            for(int i = 0; i < arr.length-1; i++) {
                int preNum = arr[i];
                int postNum = arr[i+1];
                isInRange(goal, preNum, postNum);
            }
        }

        System.out.println(ans);
    }
    public static void isInRange (int goal, int pre, int post) {
        if(pre < goal && goal < post) {
            for(int i = pre+1; i < post; i++) {
                for(int j = i+1; j < post; j++) {
                    if(i <= goal && goal <= j) ans += 1;
                }
            }
        }
    }
}
