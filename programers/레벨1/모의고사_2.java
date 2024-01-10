package programers.레벨1;

import java.util.Arrays;
import java.util.stream.*;
public class 모의고사_2 {
    public int[] solution(int[] answers) {
        // 반복되는 패턴으로 배열을 만들기
        int[] math1 = new int[] {1,2,3,4,5};
        int[] math2 = new int[] {2,1,2,3,2,4,2,5};
        int[] math3 = new int[] {3,3,1,1,2,2,4,4,5,5};
        int[][] maths = new int[][]{math1, math2, math3};
        int[] answer = new int[]{0, 0, 0};
        // 일치하는지 확인
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < maths.length; j++) {
                // maths의 각 배열은 각 math1, math2, math3 패턴을 의미하고
                // 2번째 배열은 각 패턴의 정답이 들어 있다.
                if(maths[j][i%maths[j].length] == answers[i]){
                    answer[j]++;
                }
            }
        }
        int max = Arrays.stream(answer).max().getAsInt();
        return IntStream.rangeClosed(1, answer.length).filter(num -> answer[num-1]==max).toArray();
    }
}
