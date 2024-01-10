package programers.레벨3;
import java.util.*;

/*
입국 심사 인원 1 ~ 10억
심사 시간 1 ~ 10억
심사 인원 1 ~ 10만
10억 * 10억 범위까지 가능
10 ^ 18
long 범위 10 ^ 18승
 */
public class 입국심사 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
//        System.out.println(solution(3, new int[]{1, 99, 99}));
    }
    public static long solution(int n, int[] times) {
        double end = Math.pow(10, 18);
        double answer = end;
        double start = 0;
        double mid;

        while(start < end){
            mid = Math.floor((end+start)/2) ;
            long count = count(mid, times);
            if(n > count){
                start = mid + 1;
            }else {
                if(answer == mid) break;
                answer = Math.min(mid, answer);
                end = mid;
            }
        }
        return (long) answer;
    }

    // count 값이 21억을 넘을 수 있다.
    public static long count(double end, int[] times) {
        long count = 0;
        for(int time: times) {
            count += (long) end / time;
        }
        return count;
    }
}
