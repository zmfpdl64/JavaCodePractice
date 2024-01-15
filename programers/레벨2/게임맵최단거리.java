package programers.레벨2;
import java.util.*;
/*
최단 거리 -> bfs로 해결 가능

 */
public class 게임맵최단거리 {
    public static void main(String[] args) {

    }
    public static int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        return answer;
    }
    public static int bfs(int[][] maps){
        int startX = 0;
        int startY = 0;
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        maps[startX][startY] = 1;

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        q.add(new int[]{1, startX, startY});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int t = cur[0];
            int x = cur[1];
            int y = cur[2];
            if(x == maps.length-1 && y == maps.length-1){

                break;
            }
            for(int[] nex: move){
                int nx = x + nex[0];
                int ny = y + nex[1];
                if(0 <= nx && nx < maps.length && 0 <= ny && ny < maps[nx].length && (maps[nx][ny] > t+1 || maps[nx][ny] == 1)){
                    maps[nx][ny] = t+1;
                    q.add(new int[] {t+1, nx, ny});
                }
            }
        }


        int answer = maps[maps.length-1][maps[0].length-1];
        if(maps.length == 1 && maps[0].length == 1){
            return 1;
        }
        if(answer == 1) return -1;
        return answer;
    }
}
