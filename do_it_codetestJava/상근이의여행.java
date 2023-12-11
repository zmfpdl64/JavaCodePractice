package do_it_codetestJava;
// 17시 58분 18시 30분
// 실4
// https://www.acmicpc.net/problem/9372

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 상근이의여행 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer count = 0;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            solution();
        }
    }

    public static void solution() throws IOException {
        int[] ins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = ins[0];
        int m = ins[1];
        boolean[] viMap = new boolean[n+1];
        List<Integer>[] graph = new LinkedList[n+1];
        Arrays.fill(viMap, false);
        Arrays.fill(graph, new LinkedList<>());
        for(int i = 0; i < m; i++) {
            Integer[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);
            graph[line[0]].add(line[1]);
            graph[line[1]].add(line[0]);
        }
        System.out.println(n-1);
    }

    public static void dfs(List<Integer>[] graph, boolean[] viMap, Integer cur, Integer goal){
//        if(count == goal)
    }


}
