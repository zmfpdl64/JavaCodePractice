package programers.레벨2;
import java.util.*;
// 원소 100만개
// 스코빌지수 100만이하
public class 더맵게 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[] { 12, 10, 3, 5, 8, 2, 1}, 7));
//        System.out.println(solution(new int[] {0, 0, 0, 1, 1}, 3));
//        System.out.println(solution(new int[] {0, 0, 0, 0}, 3));
        int[] arr = new int[1_000_000];
        Arrays.fill(arr, 1_000_000);
        System.out.println(solution(arr, 1_000_000_000));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Long> q = new PriorityQueue<>();
        for(int score: scoville){
            q.add((long) score);
        }
        if(q.peek() >= K) return answer;

        while(q.size() != 1){
            long first_min = q.remove();
            long second_min = q.remove();
            long sum = first_min + second_min * 2;
            if(first_min >= K) System.out.println(sum);
            if(first_min >= K){
                return answer;
            }
            q.add(sum);
            answer += 1;
        }
        if(q.peek() >= K) return answer;

        return -1;
    }
}
