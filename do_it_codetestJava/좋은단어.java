package do_it_codetestJava;

// 15시 49분 16시 25분
// 실4
// https://www.acmicpc.net/problem/3986

import java.util.*;
import java.io.*;
public class 좋은단어 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String[] ins = br.readLine().split("");
            List<String> list = new ArrayList<>();
            list.add(ins[0]);
            for (int j = 1; j < ins.length; j++) {
                String s = ins[j];
                boolean flag = true;
                while (list.size() >= 2 && list.get(list.size()-1).equals(s)) {
                    list.remove(list.size() - 1);
                    flag = false;
                }
                if(flag) list.add(s);
            }
            if(list.size() == 0) answer +=1;
        }
        System.out.println(answer);
    }
}