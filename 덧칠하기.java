import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        ArrayList<Boolean> vi_map = Stream.generate(() -> true).limit(10).collect(Collectors.toCollection(ArrayList::new));
        for(int i = 0; i < section.length; i++) {
            int pos = section[i] + m;
            if (vi_map.get(i) == true){
                answer +=1;
                for(int j = i; j < section.length; j++){
                    if (section[j] < pos){
                        vi_map.set(j, false);
                    }
                }
            }
        }

        return answer;
    }
}
