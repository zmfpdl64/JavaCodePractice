// 20시 17분
// 20시 30분 13분
import java.util.*;
public class 대충만든자판 {
        public int[] solution(String[] keymap, String[] targets) {
            ArrayList<Integer> answer = new ArrayList<>();
            Map<Character, Integer> maps = new LinkedHashMap<>();
            for(String key : keymap){
                for(int i = 0; i < key.length(); i++){
                    Character c = key.charAt(i);
                    if(maps.containsKey(c)){
                        maps.put(c, Math.min(maps.get(c), i+1));
                    }else{
                        maps.put(c, i+1);
                    }
                }
            }
            for(String target: targets){
                int count = 0;
                for(int i = 0; i < target.length(); i++){
                    Character c = target.charAt(i);
                    if(maps.containsKey(c)){
                        count += maps.get(c);
                    }else{
                        count = -1;
                        break;
                    }
                }
                answer.add(count);
            }

            return answer.stream().mapToInt(i-> i).toArray();
        }
}
