package do_it_codetestJava;

import java.util.Scanner;

public class Prefix_sum2 {

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[][] map= new int[N+1][N+1];
        int[][] sums = new int[N+1][N+1];
        for (int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + map[i][j];
            }
        }

        for(int i = 0; i < T; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int sum = 0;

            sum = sums[x2][y2] - sums[x1 - 1][y2] - sums[x2][y1 - 1] + sums[x1 - 1][y1 - 1];
            System.out.println(sum);
        }
    }
}
class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;
    int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return n;
    }
    boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }
    byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }
}