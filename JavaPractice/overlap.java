package JavaPractice;

import java.util.Arrays;
//연속적으로 연결이 안될 수도 있음

public class overlap {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{0,1},{2,5},{3,9}};
        overlap s = new overlap();
        s.solution(arr1);
    }
    public int solution(int[][] lines) {
        int[] answer = new int[]{0,0};

        for(int i =0; i < lines.length-1; i++) {
            int x1_1 = lines[i][0];
            int x1_2 = lines[i][1];
            for(int j = i+1; j < lines.length; j++) {
                int x2_1 = lines[j][0];
                int x2_2 = lines[j][1];
                int min_x1 = Integer.max(x1_1, x2_1);
                int max_x2 = Integer.min(x1_2, x2_2);
                if(min_x1 >= max_x2){
                    continue;
                }
                else{
                    if(Arrays.stream(answer) != null){
                        answer[0] = Integer.min(answer[0], min_x1); // 3 ~ 9 3 ~ 5 1 ~ 5 1 ~9
                        answer[1] = Integer.max(answer[1], max_x2);
                    }
                    else{
                        answer[0] = min_x1;
                        answer[1] = max_x2;
                    }
                }
                
            }
        }
        if(Arrays.stream(answer) == null)
            return 0;
        return (answer[1] - answer[0]);
    }
}
