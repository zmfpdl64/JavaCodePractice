package do_it_codetestJava;

// 22시 51분 23시 20분 29분
// 실1
// https://www.acmicpc.net/problem/1303

import java.util.*;
import java.io.*;

public class 전쟁전투 {

    //내팀 흰색
    // 적군 파란색

    //같은 팀이 모여있을 수록 쌔짐
    //n명이 모여있으면 n^2 쌔진다. 대각선은 뭉쳐있다고 얘기하지 않음

    // 아군 위력 출력 후 적군 위력 출력
    static final int[][] move = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
    static final String blue = "B";
    static final String white = "W";
    static String[][] maps;
    static Boolean[][] vi_map;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        
        //가로 크기
        Integer n = Integer.parseInt(st.nextToken());
        //세로 크기
        Integer m = Integer.parseInt(st.nextToken());
        
        //블루 결과
        int b_total = 0;
        int w_total = 0;
        //화이트 결과

        maps = new String[m][n];
        vi_map = new Boolean[m][n];

        for(int i = 0; i < m; i++) {
            maps[i] = reader.readLine().split("");
            Arrays.fill(vi_map[i], false);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(vi_map[i][j] == false ){
                    if(blue.equals(maps[i][j]) && vi_map[i][j] == false) b_total += Math.pow(dfs(i, j, 1, blue),2);
                    else if(white.equals(maps[i][j]) && vi_map[i][j] == false) w_total += Math.pow(dfs(i, j, 1, white),2);
                }
            }
        }
        System.out.println(w_total + " " + b_total);
    }

    public static Integer dfs(int x, int y, int count, String team) {
        vi_map[x][y] = true;
        for(int[] m : move) {
            int nx = m[0] + x;
            int ny = m[1] + y;
            try{
                if(vi_map[nx][ny]==false && maps[nx][ny].equals(team)){
                    count = Math.max(dfs(nx, ny, count + 1, team),count);
                }
            }catch(RuntimeException e){
                continue;
            }
        }
        return count;
    }

}
