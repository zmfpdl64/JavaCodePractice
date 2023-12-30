package programers.레벨3;
import java.util.*;
// 15시 05분

public class 디스크컨트롤러 {
    public static void main(String[] args) {
//        int[][] arr = {{0,3},{1,9}, {2,6}};
        int[][] arr = {{7, 8},{9, 6}, {3,5}};
//        int[][] arr = {{0,3},{4,9}, {4,6}};
        System.out.println(solution(arr));
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        int curTime = 0;
        Arrays.sort(jobs, (job1, job2) -> {
            Integer j1_start = job1[0];
            Integer j1_end = job1[1];
            Integer j2_start = job2[0];
            Integer j2_end = job2[1];
            if(j1_start < j2_start && j2_start < j1_start + j1_end){
                if(j1_end < j2_end) return -1;
                return 1;
            }
            return -1;
        });
        for(int[] job: jobs) {
            System.out.println(job[0] + " : " + job[1]);
        }
        for(int[] job: jobs){
            int dif_time = job[1];
            if(curTime <= job[0]) {
                curTime += job[0] - curTime;
                answer += job[0] - curTime;
            }
            curTime += dif_time;
            answer += curTime - job[0];
        }
        return answer / jobs.length;
    }
}
