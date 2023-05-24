package JavaPractice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class mode {
    public static void main(String[] args) {
        
    }
    public int solution(int[] array) {
        HashMap<Integer, Integer> dic = new HashMap<>();
        int answer = 0;
        for(int i : array){
            if(dic.containsKey(i)){
                dic.put(i, dic.get(i)+1);
            }
            else{
                dic.put(i, 1);
            }
        }
        int max = Collections.max(dic.values());
        Optional<Integer> key = dic.entrySet().stream().filter(i -> i.getValue() == max).map(Map.Entry::getKey).findFirst();
        int count = (int)dic.entrySet().stream().filter(i -> i.getValue() == max).count();
        if(count > 1){
            return -1;
        }        
        else
            return key.get();
    
    }
}
