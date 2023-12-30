package programers.레벨3;

import java.util.*;

public class 디스크컨트롤러2 {
    public static void main(String[] args) {
        int[][] arr = {{0,3},{1,9}, {2,6}};
//        int[][] arr = {{7, 8},{9, 6}, {3,5}};
//        int[][] arr = {{0,3},{4,9}, {4,6}};

    }
    public static int solution(int[][] jobs) {
        int count = 0;
        int curIdx = 0;
        int end = 0;
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        while(count < jobs.length){
            while (curIdx < jobs.length && jobs[curIdx][0] <= end) {
                q.add(jobs[curIdx++]);
            }
            if(q.isEmpty()) end = jobs[curIdx][0];
            else{
                int[] temp = q.poll();
                end += temp[1];
                answer += end - temp[0];
                count++;
            }
        }
        return answer / jobs.length;
    }
}
