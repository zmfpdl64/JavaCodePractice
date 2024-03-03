package programers.카카오2022블라인드;

/*
[0,0,1,1,1,0,1,0,1,0,1,1]

*/
import java.util.*;
class 양과늑대 {
    static boolean[][] map = new boolean[18][18];

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        boolean[] viMap = new boolean[18];
        Arrays.fill(viMap, false);

        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            map[from][to] = true;
            map[to][from] = true;
        }
        // for(int i = 0; i < info.length; i++) {
        //     if(info[i] == 1) {
        //         viMap[i] = true;
        //     }
        // }

        return answer;
    }
    public static Node dfs(int[] info, int cur, Node node, boolean[] viMap) {
        Node _node = node.clone();

        if(_node.isGood()) {
            return _node;
        }
        for(int i = 0; i < map[cur].length; i++) {
            if(map[cur][i] == true && viMap[i] == false && _node.isGood()){
                viMap[i] = true;
                if(info[i] == 0) {
                    _node.ship++;
                    _node = goodSelect(dfs(info, i, _node, viMap), node);
                    _node.ship--;
                }
                else {
                    _node.wolf++;
                    _node = goodSelect(dfs(info, i, _node, viMap), node);
                    _node.wolf--;
                }
            }
        }
        return _node;
    }
    public static Node goodSelect(Node nex, Node cur) {
        if(nex.getDif() > cur.getDif()) return nex;
        return cur;
    }
}
class Node implements Cloneable{
    Integer ship;
    Integer wolf;
    public Node(Integer ship, Integer wolf) {
        this.ship = ship;
        this.wolf = wolf;
    }
    public boolean isGood(){
        return ship > wolf;
    }
    public int getDif() {
        return ship - wolf;
    }
    @Override
    public Node clone(){
        try {
            return (Node) super.clone();
        }catch (Exception e) {
            return null;
        }
    }
}