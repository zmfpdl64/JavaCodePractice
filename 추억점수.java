import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> maps = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            maps.put(name[i], yearning[i]);
        }
        for(String[] p : photo){
            Integer a = 0;
            for(String peo : p){
                a += maps.getOrDefault(peo, 0);
            }
            answer.add(a);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
