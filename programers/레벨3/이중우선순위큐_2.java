package programers.레벨3;

// 16시 36분
/*
I 숫자 삽입
D 1 최댓값 제거
D -1 최솟값 삭제
 */
/*
조건
삽입, 삭제 100만개
1. 삭제 같은 값 2개 있을 시 하나만 삭제
2. 비어있을 때 삭제시 무시
 */

/* idea 1
최댓값 최솟값을 삭제 해야 하므로 우선순위 큐를 사용한다.
 */
import java.util.*;

public class 이중우선순위큐_2 {
    public static void main(String[] args) {
        int[] nums = solution(new String[] {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"});
        System.out.println(nums[0] + " : " + nums[1]);
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};
        Queue<Integer> minQ = new PriorityQueue<>((o1, o2) -> o1 - o2);
        Queue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int count = 0;

        for(String operate: operations) {
            String[] nums = operate.split(" ");
            String op = nums[0];
            Integer num = Integer.parseInt(nums[1]);

            if(op.equals("I")){ // 값 추가
                minQ.add(num);
                maxQ.add(num);
                count++;
            }else{
                if(num < 0) { // 최솟값 추출
                    if(!minQ.isEmpty() || !maxQ.isEmpty()) {
                        int _min = minQ.poll();
                        maxQ.remove(_min);
                        count--;
                    }
                }else { //최댓값 추출
                    if(!maxQ.isEmpty() || !minQ.isEmpty()) {
                        int _max = maxQ.poll();
                        minQ.remove(_max);
                        count--;
                    }
                }
            }
        }

        if(minQ.isEmpty() || maxQ.isEmpty()) return answer;
        answer = new int[] {maxQ.poll(), minQ.poll()};
        return answer;
    }
}
// minQ 123
// maxQ 123
