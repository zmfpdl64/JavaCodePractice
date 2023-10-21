package do_it_codetestJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;

// 22시 02분 22시 29분
// 실3
// https://www.acmicpc.net/problem/1004
public class 어린왕자 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Integer answer = 0;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            solution();
            System.out.println(answer);
            answer = 0;
        }
    }
    public static void solution() throws IOException {
        int[] pos = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer sx = pos[0];
        Integer sy = pos[1];
        Integer ex = pos[2];
        Integer ey = pos[3];

        int n = Integer.parseInt(reader.readLine());
        int[][] circles = new int[n][3];
        for(int i = 0; i< n; i++) {
            circles[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(isEnter(sx, sy, ex, ey, circles[i])) answer += 1;
        }
    }

    public static boolean isEnter(int x1, int y1, int x2, int y2, int[] circle) {
        double len1 = Math.sqrt(Math.pow(Math.abs(x1 - circle[0]), 2) + Math.pow(Math.abs(y1 - circle[1]), 2));
        double len2 = Math.sqrt(Math.pow(Math.abs(x2 - circle[0]), 2) + Math.pow(Math.abs(y2 - circle[1]), 2));

        if(len1 > circle[2] && len2 > circle[2]) {
            return false;
        }else if(len1 > circle[2] && len2 < circle[2]){
            return true;
        }else return len1 < circle[2] && len2 > circle[2];
    }


}
