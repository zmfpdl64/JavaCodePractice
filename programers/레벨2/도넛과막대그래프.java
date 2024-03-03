package programers.레벨2;


/*
1개 이상의 정점
단방향 간선

도넛(순회)
정점 n, 간선 n

막대(단방향)
정점 n , 간선 n - 1

8자(그래프)
정점 2n + 1 , 간선 2n + 2


정답
[정점 번호, 도넛, 막대, 8자]

1. 시작지점 파악(가장 연결 지점이 많은 노드)
2. 각각의 식을 활용하여 어떤 유형인지 파악
3. viMap을 (시작지점, 도착지점) Map으로 구현

*/
import java.util.*;

class 도넛과막대그래프 {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 3}, {4,3}, {1,1}, {2,1}
        };
        for(int i : solution(arr)) System.out.printf("%d", i);
    }
    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int startIdx = 0;
        Map<Integer, List<Node>> map = new HashMap<>();
        Map<Integer, Integer> startMap = new HashMap<>();
        for(int[] edge: edges) {
            int s = edge[0];
            int e = edge[1];
            if(map.containsKey(s)){
                List<Node> nodes = map.get(s);
                nodes.add(new Node(e));
                map.put(s, nodes);
            }else{
                List<Node> nodes = new ArrayList<>();
                nodes.add(new Node(e));
                map.put(s, nodes);
            }
            if(!map.containsKey(e)){
                List<Node> nodes = new ArrayList<>();
                map.put(e, nodes);
            }
            startMap.put(s, startMap.getOrDefault(s, 0));
            startMap.put(e, startMap.getOrDefault(e, 0) + 1);
        }
        //시작 정점 찾기
        for(Map.Entry<Integer, List<Node>> node: map.entrySet()){
            int value = startMap.getOrDefault(node.getKey(), 1);
            if(node.getValue().size() >= 2 && value == 0){
                startIdx = node.getKey();
            }
        }
        // 시작 정점부터 탐색
        answer[0] = startIdx;
        for(Node start: map.get(startIdx)){
            Set<Integer> set = new HashSet<>();
            set.add(start.num);
            Integer[] ans = dfs(map, start.num, set, 0);
            if(isEight(ans[0], ans[1])){
                answer[3] += 1;
            }else if(isDonut(ans[0], ans[1])){
                answer[1] += 1;
            }else if(isStick(ans[0], ans[1])){
                answer[2] += 1;
            }
        }
        return answer;
    }

    public static Integer[] dfs(Map<Integer, List<Node>> map, int startIdx, Set<Integer> nodes, int edges){
        Integer size = nodes.size();
        Integer edge = edges;
        for(Node node: map.getOrDefault(startIdx, new ArrayList<>())){
            if(!node.isVisited){
                node.isVisited = true;
                nodes.add(node.num);
                Integer[] ans = dfs(map, node.num, nodes, edge+1);
                size = Math.max(size, ans[0]);
                edge = Math.max(edge, ans[1]);
            }
        }
        return new Integer[]{size, edge};
    }


    public static boolean isEight(int nodes, int edges) {
        return (nodes - 1) == (edges - 2);
    }
    public static boolean isStick(int nodes, int edges) {
        return nodes - 1 == edges;
    }
    public static boolean isDonut(int nodes, int edges) {
        return nodes == edges;
    }
}
class Node {
    public int num;
    public boolean isVisited = false;
    public Node(int num) {
        this.num = num;
    }
}