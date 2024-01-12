package programers.레벨3;
import java.util.*;
// dfs 로 모든 네트워크를 순회한다.
// 방문 맵을 만들어 dfs를 시작할 때만 네트워크 카운팅


public class 네트워크 {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, { 1, 1, 0}, {0, 0, 1}};
        solution(3, arr);
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i < computers.length; i++) {
            boolean flag = false;
            for(int j = 0; j < computers.length; j++) {
                if(computers[i][j] == 1){
                    dfs(computers, j);
                    flag = true;
                }
            }
            if(flag) answer ++;
        }
        return answer;
    }
    public static void dfs(int[][] computers, int cur){
        for(int i = 0; i < computers[cur].length; i++) {
            if(computers[cur][i] == 1) {
                computers[cur][i] = 0;
                dfs(computers, i);
            }
        }
    }
}
