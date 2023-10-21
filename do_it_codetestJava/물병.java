package do_it_codetestJava;

// 18시 21분
// 실1
// https://www.acmicpc.net/problem/1052

import java.util.*;
import java.io.*;
public class 물병 {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int n1 = n;
        int k1 = k;

        List<Integer> lists1 = new ArrayList<>();
        while(n > 0 && k > 0){
            int i = 1;
            while(n > i){
                i *= 2;
            }
            lists1.add(i);
            n -= i;
            k -= 1;
        }

        List<Integer> lists = new ArrayList<>();
        while(n1 >= 0 && k1 > 0) {
            int i = 1;
            while(n1 > i){
                i *= 2;
            }
            i /= 2;
            lists.add(i);
            n1 -= i;
            k1 -= 1;
        }
        System.out.println(Math.min(Math.abs(n), n1));
        System.out.println(lists.toString());
        System.out.println(lists1.toString());
    }
}
