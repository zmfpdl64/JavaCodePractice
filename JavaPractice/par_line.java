package JavaPractice;

import java.util.HashMap;

public class par_line {
    public static void main(String[] args) {
        par_line s = new par_line();
        int[][] dots = new int[][]{{1,4},{9,2},{3,8},{10,4}};
        int[][] dots2 = new int[][]{{1,1},{1,10},{3,11}};
        int[][] dots3 = new int[][]{{3,5},{4,1},{2,4}, {5,10}};
        System.out.println(s.solution(dots));
        System.out.println(s.solution(dots2)); 
        System.out.println(s.solution(dots3));
        
    }
    
    public int solution(int[][] dots) {
        HashMap<Double, Boolean> dic = new HashMap<>();

        for(int i = 0; i < dots.length-1; i++) {
            int x_1 = dots[i][0];
            int y_1 = dots[i][1];
            for(int j = i+1; j < dots.length; j++) {
                int x_2 = dots[j][0];
                int y_2 = dots[j][1];
                int dif_x = x_1-x_2;
                int dif_y = y_1-y_2;

                double inc = (double)dif_y / (double)dif_x;
                if(inc == 0) inc = 0;
                if(Double.isInfinite(inc)) inc = Double.POSITIVE_INFINITY;

                if(dic.containsKey(inc)){
                    System.out.println("get: "+inc);
                    return 1;
                }
                else {
                    System.out.println("put: "+inc);
                    dic.put(inc, true);
                }
            } 
        }
        return 0;
    }
}
