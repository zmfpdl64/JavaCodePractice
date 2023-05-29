// 18시 55분
// 20시 20분
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 미로탈출 {
    public static Integer[][] move = new Integer[][]{
            new Integer[]{0, 1},
            new Integer[]{0, -1},
            new Integer[]{1, 0},
            new Integer[]{-1, 0}
    } ;

    public static void main(String[] args) {
        String[] input = new String[] {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] input2 = new String[] {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        System.out.println(solution(input));
        System.out.println(solution(input2));

    }
    public static int solution(String[] maps) {
        int[][] vi_map = new int[maps.length][maps[0].length()];

        Integer s_x = 0, s_y = 0;
        Integer l_x = 0, l_y = 0;
        Integer e_x = 0, e_y = 0;
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'S'){
                    s_x = i;
                    s_y = j;
                    System.out.println(i + " " + j);
                }else if(maps[i].charAt(j) == 'L'){
                    l_x = i;
                    l_y = j;
                    System.out.println(i + " " + j);
                }else if(maps[i].charAt(j) == 'E'){
                    e_x = i;
                    e_y = j;
                    System.out.println(i + " " + j);
                }
                vi_map[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] clone = Arrays.stream(vi_map).map(int[]::clone).toArray(int[][]::new);
        bfs(s_x, s_y, clone, maps);
        bfs(l_x, l_y, vi_map, maps);
        if (clone[s_x][s_y] == Integer.MAX_VALUE || vi_map[e_x][e_y] == Integer.MAX_VALUE){
            return -1;
        }
        return clone[l_x][l_y] + vi_map[e_x][e_y];
    }
    public static void  bfs(int x, int y, int[][] vi_map, String[] maps){
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new Integer[]{0, x, y});
        vi_map[x][y] = 0;
        while(!pq.isEmpty()){
            Integer[] cur = pq.poll();
            int time = cur[0];
            int curx = cur[1];
            int cury = cur[2];
            for(int i = 0; i < move.length; i++) {
                Integer[] next = move[i];
                int nx = curx + next[0];
                int ny = cury + next[1];
                if( 0 <= nx && nx < maps.length && 0 <= ny && ny < maps[0].length() && vi_map[nx][ny] > time+1 && maps[nx].charAt(ny) != 'X'){
                    vi_map[nx][ny] = time+1;
                    pq.add(new Integer[]{time+1, nx, ny});
                }
            }
        }
    }
}
