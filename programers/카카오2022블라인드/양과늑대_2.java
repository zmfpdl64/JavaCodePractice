package programers.카카오2022블라인드;

import java.util.*;

class 양과늑대_2 {
    static int[] info;
    static List<Integer>[] tree;
    static int maxSheep = 0;
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.tree = new ArrayList[info.length];
        for(int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            if(tree[parent] == null) {
                tree[parent] = new ArrayList<>();
            }
            tree[parent].add(child);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list);
        return maxSheep;
    }
    public static void dfs(int cur, int sheep, int wolf, List<Integer> list){
        if(info[cur] == 0) sheep++;
        else wolf++;

        if(wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);

        List<Integer> _list = new ArrayList<>();
        _list.addAll(list);
        _list.remove(Integer.valueOf(cur));
        if(tree[cur] != null) {
            for(int child : tree[cur]){
                _list.add(child);
            }
        }

        for(int next: _list) {
            dfs(next, sheep, wolf, _list);
        }
    }
}