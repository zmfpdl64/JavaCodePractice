package programers.레벨2;


import java.util.*;
// 예외 케이스
// 0 0 0 0
public class K번째가장큰수_2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {0, 0, 0, 0}));
    }

    public static String solution(int[] numbers) {
        String answer;
        String[] sNums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(sNums, (o1, o2) -> {
            String num1 = o1 + o1 + o1;
            String num2 = o2 + o2 + o2;
            return -num1.compareTo(num2);
        });
        StringBuffer sb = new StringBuffer();
        for(String num: sNums){
            sb.append(num);
        }
        answer = sb.toString();
        if(answer.charAt(0)=='0') return "0";
        return answer;
    }
}
