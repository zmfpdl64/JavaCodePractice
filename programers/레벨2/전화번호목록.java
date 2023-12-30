package programers.레벨2;

import java.util.*;
public class 전화번호목록 {
    public static void main(String[] args) {
        String[] arg = new String[] {
                "119", "97674223", "1195524421"
        };
        solution(arg);
    }

    public static boolean solution(String[] phone_book) {
        Map<String, List<String>> maps = new HashMap<>();
        for(String num: phone_book){
            String s = num.substring(0, 1);
            if(maps.containsKey(s)){
                List<String> strings = maps.get(s);
                strings.add(num);
                maps.put(s, strings);
            }else{
                maps.put(s, new ArrayList<>(List.of(num)));
            }
        }
        for(List<String> lists : maps.values()){
            lists.sort(Comparator.comparingInt(String::length));
            for(int i = 0; i < lists.size(); i++){
                String num = lists.get(i);
                for(int j = i+1; j < lists.size(); j++){
                    String num2 = lists.get(j);
                    if(num2.startsWith(num)) return false;
                }
            }
        }
        return true;
    }

}

