package do_it_codetestJava;
// 17시 22분 17시 53분
// 실4
// https://www.acmicpc.net/problem/1049

// 끊어진 기타줄 N, 기타줄 가격들 M
// 6줄 가격, 1줄 가격

import java.util.*;
import java.io.*;

public class 기타줄 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min_1 = Integer.MAX_VALUE;
        int min_2 = Integer.MAX_VALUE;

        // 6개 묶음중 최소값을 저장
        // 1개 가격중 최솟값 저장

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int lines_p = Integer.parseInt(st.nextToken());
            int line_p = Integer.parseInt(st.nextToken());
            if(min_1 > lines_p) min_1 = lines_p;
            if(min_2 > line_p) min_2 = line_p;
        }
        int prices = 0;
        // 우선 6개 단위의 묶음으로 더 적은 값 계산
        if(min_1 / 6 < min_2) {
            prices = n / 6 * min_1;
        }else{
            prices = n / 6 * 6 * min_2;
        }
        // 낱개 계산과 묶음 1개 가격 비교 후 더하기
        prices += Math.min(min_2 * (n % 6), min_1);
        System.out.println(prices);
    }
}
