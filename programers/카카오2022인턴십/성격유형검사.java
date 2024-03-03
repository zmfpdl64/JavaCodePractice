package programers.카카오2022인턴십;

/*
성격 유형 16가지 유형 가능

선택지 7가지
매우 동의, 비동의 3점씩
동의, 비동의 2점
약간 동의, 비동의 1점
모르겠음 0점

점수가 같을 때 (사전순)



*/
import java.util.*;

class 성격유형검사 {
    static int[] point = new int[]{
            0, 3, 2, 1, 0, 1, 2, 3
    };
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Boolean> partner = new HashMap<>();
    public String solution(String[] survey, int[] choices) {

        String answer = "";
        init();
        List<Integer> list =new LinkedList<Integer>();
        for(int i = 0; i < choices.length; i++) {
            String start = survey[i].substring(0, 1);
            String end = survey[i].substring(1, 2);
            int choice = choices[i];
            int p = point[choices[i]];
            if(choice <= 3) {
                map.put(start, map.getOrDefault(start, 0) + p);
            }else{
                map.put(end, map.getOrDefault(end, 0) + p);
            }
        }

        List<String> sortedMap = new ArrayList(map.keySet());
        Collections.sort(sortedMap, (o1, o2) -> {
            int i = -map.get(o1).compareTo(map.get(o2));
            if(i != 0) return i;
            return o1.compareTo(o2);
        });
        for(String s : partner.keySet()){
            String s1 = s.substring(0,1);
            String s2 = s.substring(1,2);
            int num = map.get(s1).compareTo(map.get(s2));
            if(num > 0) {
                answer += s1;
            }else if(num == 0) {
                if(s1.compareTo(s2) > 0) {
                    answer += s1;
                }else{
                    answer += s2;
                }
            }else{
                answer += s2;
            }
        }
        return answer;
    }
    public boolean isContains(String s) {
        for(Map.Entry<String, Boolean> set: partner.entrySet()){
            for(char c : set.getKey().toCharArray()){
                if(s.charAt(0) == c && !set.getValue()){
                    partner.put(set.getKey(), true);
                    return false;
                }
            }
        }
        return true;
    }
    public static void init(){
        map.put("R", 0);
        map.put("T", 0);
        partner.put("RT", false);
        map.put("C", 0);
        map.put("F", 0);
        partner.put("CF", false);
        map.put("M", 0);
        map.put("J", 0);
        partner.put("MJ", false);
        map.put("A", 0);
        map.put("N", 0);
        partner.put("NA", false);
    }
}