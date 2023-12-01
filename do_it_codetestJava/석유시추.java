package do_it_codetestJava;
import java.util.*;
// 9시 1분
//
public class 석유시추 {
    public static int[][] move = {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
    };
    static int maxY;
    static int minY;
    static int maxi;

    public static void main(String[] args) {
        solution(new int[][]
                {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}
        );
//        solution(new int[][]{{1,1},{1,1}});



    }
    public static int solution(int[][] land) {
        boolean[][] viMap = new boolean[land.length][land[0].length];
        int[] oils = new int[land[0].length];
        int answer = 0;
        Arrays.fill(oils, 0);
        for(int i = 0; i < viMap.length; i++){
            Arrays.fill(viMap[i], false);
        }
        for(int i = 0; i < viMap.length; i++) {
            for(int j = 0; j < viMap[i].length; j++){
                if(!viMap[i][j] && land[i][j] == 1){
                    maxY = j;
                    minY = j;
                    viMap[i][j] = true;
                    int size = bfs(land, viMap, i, j);
                    for(int curY = minY; curY <= maxY; curY++){
                        oils[curY] += size;
                    }
                }
            }
        }
        return Arrays.stream(oils).max().getAsInt();
    }

    public static boolean isOkRange(int[][] land, int nx, int ny) {
        int xSize = land.length;
        int ySize = land[0].length;
        if(0 <= nx && nx < xSize && 0 <= ny && ny < ySize) return true;
        return false;
    }
    public static int bfs(int[][] land, boolean[][] viMap, Integer x, Integer y) {
        List<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{x, y});
        int size = 0;
        while(q.size() != 0) {
            size++;
            Integer[] point = q.remove(0);
            for(int[] m : move){
                int nx = m[0] + point[0];
                int ny = m[1] + point[1];
                if(isOkRange(land, nx, ny) && !viMap[nx][ny] && land[nx][ny] == 1){
                    viMap[nx][ny] = true;
                    minY = Math.min(ny, minY);
                    maxY = Math.max(ny, maxY);
                    q.add(new Integer[]{nx, ny});
                }
            }
        }
        return size;
    }

    public static int dfs(int[][] land, boolean[][] viMap, int x, int y, int curCount) {
        for(int[] m : move) {
            int nx = m[0] + x;
            int ny = m[1] + y;
            int xSize = land.length;
            int ySize = land[0].length;
            if(0 <= nx && nx < xSize && 0 <= ny && ny < ySize && !viMap[nx][ny] && land[nx][ny] == 1) {
                minY = Math.min(ny, minY);
                maxY = Math.max(ny, maxY);
                viMap[nx][ny] = true;
                curCount = Math.max(dfs(land, viMap, nx, ny, curCount +1), curCount);
                land[nx][ny] = curCount;
            }
        }
        return curCount;
    }
}
