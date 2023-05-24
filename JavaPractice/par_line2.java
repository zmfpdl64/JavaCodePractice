package JavaPractice;

import java.util.HashMap;
import java.util.stream.IntStream;

public class par_line2 {
    public static void main(String[] args) {
        par_line2 s = new par_line2();
        int[][] t = new int[][]{{0,2},{-3,-1},{-2,1}};
        System.out.println(); 
        
    }
    public int solution(int[][] lines) {
        int[] answer = new int[]{0, 0};
        HashMap<Integer, Boolean> dic = new HashMap<>();
        for(int i = 0; i < lines.length-1; i++) {
            int s_x1 = lines[i][0];
            int e_x1 = lines[i][1];
            for(int j = i+1; j < lines.length; j++) {
                int s_x2 = lines[j][0];
                int e_x2 = lines[j][1];
                int s_max = Math.max(s_x1, s_x2);
                int e_min = Math.min(e_x1, e_x2);
                if(s_max >= e_min){
                    continue;
                }
                else{
                    IntStream.range(s_max, e_min).forEach(e -> {
                        dic.putIfAbsent(e, true);
                    });
                }
            }
        }
        int size  = dic.size();
        return size;
    }
}
