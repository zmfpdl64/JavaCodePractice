package do_it_codetestJava;


// 22시 58분 23시 48분
// 실4
// https://www.acmicpc.net/problem/1057

// n명 참가 토너먼트 1 ~ n
// 홀수명이면 마지막 참가자 다음라운드 자동 진출

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
        Integer[] joins = new Integer[]{a,b};

        List<Integer> maps = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            maps.add(i);

        }
        int flag = 0;
        while(maps.size() != 1) {
            answer += 1;
            List<Integer> newMap = new ArrayList<>();
            for(int i = 0; i < maps.size(); i+=2) {
                int num1 = maps.get(i);
                if(i+1 == maps.size()){
                    newMap.add(num1);
                    break;
                }
                int num2 = maps.get(i+1);
                if(isContains(num1, joins)){
                    if(isContains(num2, joins)){
                        flag = 1;
                        break;
                    }else{
                        newMap.add(num1);
                    }
                }else{
                    newMap.add(num2);
                }
            }
            if(flag == 1){
                break;
            }
            maps = newMap;
        }
        if(flag == 1) {
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
    }
    public static boolean isContains(int num1, Integer[] nums){
        for (Integer num : nums) {
            if (num == num1) {
                return true;
            }
        }
        return false;
    }
}
