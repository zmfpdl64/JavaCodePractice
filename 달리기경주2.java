import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 달리기경주2 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        final Map<Integer, String> int_to_str_ranking = new HashMap<>();
        final Map<String, Integer> str_to_int_ranking = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            int_to_str_ranking.put(i, players[i]);
            str_to_int_ranking.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++) {
            String name = callings[i];
            Integer rank = str_to_int_ranking.get(name);
            String first = int_to_str_ranking.get(rank-1);
            str_to_int_ranking.put(name, rank-1);
            str_to_int_ranking.put(first, rank);
            int_to_str_ranking.put(rank, first);
            int_to_str_ranking.put(rank-1, name);
        }

        return int_to_str_ranking.values().stream().toArray(String[]::new);
    }
}
