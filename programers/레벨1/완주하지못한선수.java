package programers.레벨1;

import java.util.*;
// 17시 22분 17시 27분
public class 완주하지못한선수 {
    public static void main(String[] args) {

    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> maps = new HashMap<>();
        for(String partition : participant){
            if(maps.containsKey(partition)) {
                Integer value = maps.get(partition);
                value+=1;
                maps.put(partition, value);
            }else{
                maps.put(partition, 1);
            }
        }
        for(String com: completion){
            Integer value = maps.get(com);
             value -= 1;
             maps.put(com, value);
        }
        String key = maps.entrySet().stream().filter(set -> {
            if (set.getValue() >= 1) {
                return true;
            }
            return false;
        }).findFirst().get().getKey();
        return key;
    }
}
