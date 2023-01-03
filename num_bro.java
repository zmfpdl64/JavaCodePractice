import java.util.HashMap;

public class num_bro {
    
    public static void main(String[] args) {
        
    }
    
    public String Solution(String X, String Y) {
        HashMap<Integer, Integer> dic1 = new HashMap<>();
        HashMap<Integer, Integer> dic2 = new HashMap<>();
        for(int i=0; i < 10; i++) {
            dic1.put(i,0);
            dic2.put(i, 0);
        }
        for(int i=0; i < X.length(); i++) {
            dic1.put(i, dic1.get(i)+1);
        }
        for(int i=0; i < Y.length(); i++) {
            dic2.put(i, dic2.get(i)+1);
        }

        String answer = "";

        return answer;

    }
}
