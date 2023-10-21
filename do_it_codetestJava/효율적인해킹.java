package do_it_codetestJava;

import java.util.*;
import java.io.*;

public class 효율적인해킹 {
    static Integer[][] maps;
    static Boolean[] vi_map;
    static List<Integer> answer = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        maps = new Integer[n+1][n+1];
        vi_map = new Boolean[n+1];
        int max_net = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maps[b][a] = b;
        }
        for(int i = 0; i < n; i++) {
            vi_map[i] = false;
        }
        for(int i = 1; i < maps.length; i++) {
            Integer[][] maps_copy = returnMaps();
            Boolean[] vi_map_copy = returnViMap();
            dfs(maps_copy, vi_map_copy, i, new LinkedList<>());
        }
        StringBuilder sb = new StringBuilder();
        for (Iterator<Integer> it = answer.iterator(); it.hasNext(); ) {
            sb.append(it.next()).append(" ");
        }
        System.out.println(sb);

    }
    public static void dfs(Integer[][] maps_copy, Boolean[] vi_map_copy, int cur, List<Integer> net) {
        net.add(cur);

        if(answer.size() < net.size()) {
            Collections.sort(net);
            answer = net;
        }

        vi_map_copy[cur] = true;
        for(Integer nex : maps_copy[cur]) {
            if(nex != null){
                if(!vi_map_copy[nex]) {
                    dfs(maps_copy, vi_map_copy, nex, net);
                }
            }
        }
    }

    public static Integer[][] returnMaps() {
        Integer[][] integers = new Integer[maps.length][maps[0].length];
        for(int i = 0; i < maps.length; i++) {
            integers[i] = Arrays.copyOf(maps[i], maps[i].length);
        }
        return integers;
    }
    public static Boolean[] returnViMap() {
        Boolean[] vi_map_copy = new Boolean[vi_map.length];
        for(int i = 0; i < vi_map.length; i++) {
            vi_map_copy[i] = false;
        }
        return vi_map_copy;
    }


}
