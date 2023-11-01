package do_it_codetestJava;
// 23시 29분
// 실3
// https://www.acmicpc.net/problem/1063

import java.util.*;
import java.io.*;

// 행 :숫자(1,8)     열 : 알파뱃(a~h)
public class 킹 {
    static Map<String, Integer[]> maps = new TreeMap<>();
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] move_s = {
                "R", "L", "B", "T", "RT", "LT", "RB", "LB"
        };
        Integer[][] move_i = {
                {0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        String[] ans = new String[2];
        for(int i = 0; i < move_s.length; i++) {
            maps.put(move_s[i], move_i[i]);
        }

        String[] pos = reader.readLine().split(" ");
        int n = Integer.parseInt(pos[2]);
        String[] move = new String[n];
        for(int i = 0; i < n; i++) {
            move[i] = reader.readLine();
        }
        int[] king = {transAlphaToIndex(pos[0]), Character.getNumericValue(pos[0].charAt(1))} ;
        int[] dol = {transAlphaToIndex(pos[1]), Character.getNumericValue(pos[1].charAt(1))} ;
        int[][] points = {king, dol};

        for(int i = 0; i < move.length; i++) {
            String m = move[i];
            isOk(points, m);
        }
        String s1 = ransIndexToAlpha(points[0][0]);
        System.out.println(s1 + points[0][1]);
        String s2 = ransIndexToAlpha(points[1][0]);
        System.out.println(s2 + points[1][1]);

    }

    public static void isOk(int[][] points, String m ) {
        Integer[] nm = maps.get(m);
        if(isGood(points[0], nm) && isGood(points[1], nm)){
            setValue(points[0], nm);
            setValue(points[1], nm);
        }
    }
    public static boolean isGood(int points[], Integer[] nm){
        int nx = points[0] + nm[0];
        int ny = points[1] + nm[1];
        if(0 < nx && nx <= 8 && 0 < ny && ny <= 8) return true;
        return false;
    }
    public static void setValue(int points[], Integer[] nm) {
        int nx = points[0] + nm[0];
        int ny = points[1] + nm[1];
        points[0] = nx;
        points[1] = ny;
    }

    public static int transAlphaToIndex(String row) {
        int pos = row.charAt(0);
        return pos - 64;
    }
    public static String ransIndexToAlpha(int idx) {
        String s = String.valueOf((char) (idx + 64));
        return s;
    }

}
