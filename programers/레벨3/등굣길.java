package programers.레벨3;
import java.util.*;
public class 등굣길 {
    private static int[][] moves = {
            {0, 1}, {1, 0}
    };

    public static void main(String[] args) {
//        solution(4, 3 , new int[][]{{2, 2}});
//        solution(4, 1 , new int[][]{{2, 1}});
//        solution(3, 3 , new int[][]{{1, 3}, {3, 1}});
//        solution(100, 100, new int[][]{{}});
        solution(4, 4, new int[][]{
                {1,2}
        });
    }


    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        for(int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
//        goToSchool(dp);
        goToSchoolBrute(dp);
        System.out.println(dp[n][m]);
        return dp[n][m];
    }
    public static void goToSchoolBrute(int[][] map) {
        for(int i = 1; i < map.length; i++) {
            for(int j = 1; j < map[i].length; j++) {
                if(map[i][j] == -1) continue;
                if(map[i][j-1] != -1) map[i][j] += map[i][j-1];
                if(map[i-1][j] != -1) map[i][j] += map[i-1][j];
                map[i][j] %= 1_000_000_007;
            }
        }
    }
    public static void goToSchool(int[][] map) {
        Queue<Integer[]> q = new LinkedList<>();
        Integer[] start = new Integer[]{1, 1};
        q.add(start);
        while(!q.isEmpty()){
            Integer[] nex = q.poll();
            for(int[] move: moves){
                int nexX = nex[0] + move[0];
                int nexY = nex[1] + move[1];
                if((0 <= nexX && nexX < map.length) && (0 <= nexY && nexY < map[nexX].length) && map[nexX][nexY] != -1){
                    map[nexX][nexY] += map[nex[0]][nex[1]] % 1_000_000_007;
                    Integer[] n = {nexX, nexY};
                    q.add(n);
                }
            }
        }
        for(int[] nums: map) {
            for(int num : nums) {
                System.out.printf("%d", num);
            }
            System.out.println();
        }
    }

}
