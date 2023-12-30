package programers.레벨1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(!list.get(list.size()-1).equals(arr[i])){
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
