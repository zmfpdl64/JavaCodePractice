package do_it_codetestJava;


// 22시 58분 23시 48분
// 실4
// https://www.acmicpc.net/problem/1057

// n명 참가 토너먼트 1 ~ n
// 홀수명이면 마지막 참가자 다음라운드 자동 진출
// 브루트 포스

import java.util.*;
import java.io.*;

public class 토너먼트 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (true) {
            answer++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            if (a == b) break;
        }
        System.out.println(answer);
    }
}
