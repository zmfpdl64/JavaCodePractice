package do_it_codetestJava;

//17시 58분 18시 18분
// 실3
// https://www.acmicpc.net/problem/1051

import java.util.*;
import java.io.*;

public class 숫자정사각형 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int m_size = Math.min(n, m);

        int[][] maps = new int[n][m];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            String ins =  reader.readLine();
            maps[i] = Arrays.stream(ins.split("")).mapToInt(Integer::parseInt).toArray();
        }
        for(int s = 0; s <= m_size; s++) {
            for(int i = 0; i < n-s; i++) {
                for(int j = 0; j < m-s; j++) {
                    int[][] sq = {
                            {i, j}, {i+s, j}, {i, j+s}, {i+s, j+s}
                    };
                    int flag = 1;
                    for(int l = 0; l < 3; l++) {
                        if(maps[sq[l][0]][sq[l][1]] == maps[sq[l+1][0]][sq[l+1][1]]){
                            continue;
                        }else{
                            flag = 0;
                        }
                    }
                    if(flag == 1){
                        ans = (s+1)*(s+1);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
