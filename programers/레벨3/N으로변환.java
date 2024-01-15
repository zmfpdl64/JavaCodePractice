package programers.레벨3;
import java.util.*;

public class N으로변환 {
    public static void main(String[] args) {
        solution(5, 12);
    }
    public static int solution(int N, int number) {
        int[] dp = new int[64002];
        String[] op = {"+", "-", "/", "*"};
        Queue<Integer[]> q = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        q.add(new Integer[] {1, 5});
//        for(int i = 1; i < 5; i++){
//            StringBuilder sb = new StringBuilder();
//            for(int j = 1; j <= i; j++){
//                sb.append(N);
//            }
//            if(sb.length() != 0) q.add(new Integer[] {i, Integer.valueOf(sb.toString())});
//        }

        while(!q.isEmpty()){
            Integer[] nums = q.poll();
            int time = nums[0];
            int num = nums[1];
            for(int i = 0; i < op.length; i++) {
                int total;
                int addNum;
                for(int j = 1; j <= 5; j++){
                    addNum = repeatNum(N, j);
                    total = calNum(op[i], num, addNum);
                    if((0 <= total && total <= 64_000) && (dp[total] == 0 || dp[total] > time)){
                        q.add(new Integer[]{time+j, total});
                        dp[total] = time + j;
                    }
                }
            }
        }
        System.out.println(dp[number]);
        return dp[number];
    }

    public static int calNum(String operation, Integer total, Integer N) {
        if (operation.equals("+")) {
            total += N;
        }else if(operation.equals("-")){
            total -= N;
        }else if(operation.equals("*")){
            total *= N;
        }else{
            total /= N;
        }
        return total;
    }
    public static Integer repeatNum(Integer num, Integer repeat) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeat; i++) {
            sb.append(num);
        }
        return Integer.valueOf(sb.toString());
    }

}
