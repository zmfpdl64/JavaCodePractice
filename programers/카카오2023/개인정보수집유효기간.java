package programers.카카오2023;
import programers.테스트용.IsGoodAnswer;

import java.util.*;
public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        String today = "2022.06.19";
        String[] terms = {
                "A 6", "B 12", "C 3"
        };
        String[] ins = {
                "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"
        };
        System.out.println(solution(today, terms, ins));
//        IsGoodAnswer.isPass(0, solution(today, terms, ins), new int[] {1, 3});
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new LinkedList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int cur = getDays(today);

        for(String term: terms) {
            String[] _term = term.split(" ");
            termMap.put(_term[0], Integer.valueOf(_term[1]) * 28);
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] _privacies = privacies[i].split(" ");
            int _privacyDays = getDays(_privacies[0]) + termMap.get(_privacies[1]);
            if(_privacyDays < cur) answer.add(i+1);
        }

         return answer.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static int getDays(String day){
        int[] _day = Arrays.stream(day.split("\\.")).mapToInt(Integer::valueOf).toArray();
        return _day[0] * 28 * 12 + _day[1] * 28 + _day[2];
    }

}
