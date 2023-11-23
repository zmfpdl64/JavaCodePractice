package do_it_codetestJava;

// 16시 30분 17시 41분
// 실2
// https://www.acmicpc.net/problem/2304

import java.util.*;
import java.io.*;

public class 창고다각형 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[1001];
        int maxi = -1;
        int maxi_idx = -1;

        for(int i = 0; i < n; i++) {
            String[] ins = br.readLine().split(" ");
            int x = Integer.parseInt(ins[0]);
            int h = Integer.parseInt(ins[1]);
            a[x] = h;
            if(maxi == h && maxi_idx < x) {
                maxi_idx = x;
            }else if(maxi < h){
                maxi = h;
                maxi_idx = x;
            }
        }
        int prev_idx = 0;
        int cur_h = 0;
        int total = 0;
        for(int i = 0; i <= maxi_idx; i++) {
            int h = a[i];
            if(cur_h <= h){
                total += (i-prev_idx) * cur_h + h;
                cur_h = h;
                prev_idx = i+1;
            }
        }
        prev_idx = a.length-1;
        cur_h = 0;

        for(int i = 0; i < a.length - maxi_idx; i++){
            int cur_i = (a.length-1) - i;
            int h = a[cur_i];
            if(cur_h <= h) {
                int bidth = (prev_idx-(cur_i+1)) * cur_h + h;
                total += bidth;
                cur_h = h;
                prev_idx = cur_i;
            }
        }
        total -= cur_h;
        System.out.println(total);
    }
}


