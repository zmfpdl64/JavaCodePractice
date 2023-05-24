import java.lang.reflect.Array;
import java.util.*;

public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> maps = new HashMap<>();
        Map<Integer, String> maps2 = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            maps.put(players[i], i);
            maps2.put(i, players[i]);
        }
        for(int i = 0; i < callings.length; i++){
            Integer rank = maps.get(callings[i]);
            String f_name = maps2.get(rank-1);
            maps.put(callings[i],rank-1);
            maps.put(f_name, rank);
            maps2.put(rank, f_name);
            maps2.put(rank-1, callings[i]);
        }
        String[] array = maps.values().toArray(new String[0]);
        TreeMap<Integer, String> sortedMap = new TreeMap<>(maps2);
        return sortedMap.values().toArray(new String[0]);

    }
}
