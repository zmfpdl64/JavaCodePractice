package do_it_codetestJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 18시 33분
// 실3
// https://www.acmicpc.net/problem/2606
public class 바이러스 {
    private static Map<Integer, List<Integer>> maps = new HashMap<>();
    private static List<Boolean> vi_map = new ArrayList<>();
    private static Integer answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        Integer[][] net = new Integer[m][2];
        for(int i = 0; i < m; i++) {
            String[] nm = reader.readLine().split(" ");
            int net1 = Integer.parseInt(nm[0]);
            int net2 = Integer.parseInt(nm[1]);
            net[i] = new Integer[]{net1, net2};
        }
        solution(n, m, net);
    }

    public static void solution(Integer n, Integer m, Integer[][] net) {

        vi_map = new ArrayList<>(Collections.nCopies(n + 1, false));


        for (int i = 0; i < m; i++) {
            Integer pre = net[i][0];
            Integer post = net[i][1];
            if (maps.containsKey(pre)) {
                maps.get(pre).add(post);
            } else {
                maps.put(pre, new LinkedList<>(Collections.singletonList(post)));
            }
            if (maps.containsKey(post)) {
                maps.get(post).add(pre);
            }else {
                maps.put(post, new LinkedList<>(Collections.singletonList(pre)));
            }
        }
        try {
            dfs(1);
            System.out.println(answer);
        }catch(Exception e) {
            System.out.println(answer);
        }
    }

    public static void dfs(Integer pos) {
        vi_map.set(pos, true);
        for(Integer nex : maps.get(pos)) {
            if (!vi_map.get(nex)) {
                answer += 1;
                vi_map.set(nex, true);
                dfs(nex);
            }
        }
    }
}

