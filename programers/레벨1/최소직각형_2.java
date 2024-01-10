package programers.레벨1;
import java.util.*;
/*
가로 세로는 중요하지 않음
2개의 길이가 중요함
1. 명함의 긴 길이와 짧은 길이를 나눔
2. 긴명함의 최댓값 짧은 길이의 최댓값
 길이1 최대 최대
 길이2 최소 최대
 위의 규칙을 지켜야지 모든 명함을 담을 수 있다.
 */
public class 최소직각형_2 {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        for(int[] sqr: sizes) {
            int _max = Math.max(sqr[0], sqr[1]);
            int _min = Math.min(sqr[0], sqr[1]);
            max = Math.max(_max, max);
            min = Math.max(_min, min);
        }
        return max * min;
    }
}
