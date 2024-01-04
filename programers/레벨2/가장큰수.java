package programers.레벨2;

import java.util.*;

// 12시 31분

// 문자의 길이 10만
// 원소 갯수 1000

// 주의사항
// 1. 숫자로 계산하면 오버플로우 발생
// 2. 모든 경우의 수 1000P500 -> 시간 초과(순열)


/* idea 1
모든 경우의 수를 만들어 숫자를 만들기
 */
/* idea 2
그리디로 숫자 생성
 */
public class 가장큰수 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[] {11, 11109423}));
        System.out.println(solution(new int[] {6, 10, 2}));
    }
    public static String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(nums, (num1, num2) -> {
            String _num1 = num1+num1+num1;
            String _num2 = num2+num2+num2;
            return -_num1.compareTo(_num2);
        });
        String answer = String.join("", nums);
        int idx = 0;
        for(int i = 0; i < answer.length(); i++){
            if(answer.charAt(i) == '0') idx ++;
            else break;
        }
        answer = answer.substring(idx);
        return answer.substring(idx).equals("") ? "0" : answer.substring(idx);
    }
}
