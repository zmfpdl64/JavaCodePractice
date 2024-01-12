package programers.레벨4;
import java.util.*;
import java.util.stream.IntStream;
/*
  돌 사이 거리 10억 이하
  바위 갯수 5만 이하
  제거할 바위 1 <= n <= 바위 갯수
 */

/* idea 1
거리 순으로 정렬 후
차이를 담은 배열 계산
현재 차이 거리 + 다음 거리 를 다음 거리에 적용한다.
최악 50만 * 50만
 */

/*
예외 케이스 돌이 도착지점이랑 같이 있을 떄
돌이 도착지점보다 멀리 있을 떄
돌 == 도착지점
 */


//일단 시간초과는 발생 안함

public class 징검다리 {
    public static void main(String[] args) {
        solution(25, new int[]{2, 14, 11, 21, 17}, 2);
    }
    public static int solution(int distance, int[] rocks, int n) {
        int answer = Integer.MAX_VALUE;
        int[] __rocks = Arrays.stream(rocks).filter(o1 -> distance <= distance).toArray();

        Arrays.sort(__rocks);

        int[] _rocks = IntStream.rangeClosed(0, __rocks.length)
                .map(curIdx -> {
                    if(curIdx == 0) return __rocks[curIdx];
                    if(curIdx == __rocks.length) return distance - __rocks[curIdx-1];
                    return __rocks[curIdx]-__rocks[curIdx-1];
                })
                .toArray();
        // idx 0 부터 _rocks.length-2까지 범위

        //거리 전처리 과정
        // n개 만큼의 돌 제거
        for(int i = 0; i < n; i++) {
            int minIdx = -1;
            int minValue = Integer.MAX_VALUE;
            for(int j = 0; j < _rocks.length-2; j++) {
                if(minValue > _rocks[j] && 0 <= _rocks[j]){
                    int idx = j;
                    while(true){
                        if(_rocks[idx] == -1){
                            idx++;
                        }else{
                            minIdx = idx;
                            minValue = _rocks[idx];
                            break;
                        }
                    }
                }
            }
            if(minIdx != -1){
                _rocks[minIdx+1] += _rocks[minIdx];
                _rocks[minIdx] = -1;
            }
        }

        for(int num : _rocks){
            if(num >= 0 &&  answer > num) {
                answer = num;
            }
        }
        return answer;
    }
}
