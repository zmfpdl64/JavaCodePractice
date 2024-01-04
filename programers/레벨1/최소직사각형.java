package programers.레벨1;

import java.util.*;
//14시 15분 14시 23분

/* idea 1
반복문을 통해 모든 명함의 가로 세로 최대 최소 값을 나눠서 저장함

길이1 최대(길이1, 최대(명함가로, 명함세로))
길이2 최소(길이2, 최소(명함가로, 명함세로))

가로, 세로 최소 최대 값 구함
 */
public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < sizes.length; i++){
            max = Math.max(max, Math.max(sizes[i][0], sizes[i][1]));
            min = Math.max(min, Math.min(sizes[i][0], sizes[i][1]));
        }
        return max * min;
    }
}
