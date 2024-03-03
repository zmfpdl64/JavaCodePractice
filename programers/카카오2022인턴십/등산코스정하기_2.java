//package programers.카카오2022인턴십;
//
///*
//n = 노드 갯수
//[출발 노드, 도착 노드, 시간]
//
//
//출발 지점과 도착지점 동일해야 한다.
//
//submits 산봉우리
//
//정답 [산봉우리 번호, 최솟값]
//*/
//
///*
//로직
//gates 에서 시작
//
//dfs 함수에서
//시작지점 간선보다 같거나 작은 경로로 이동 (X)
//Exception) 큰 간선밖에 없을 수 있음 전부 검색해야 함
//
//배열로 맵 만드면 너무 큼 필요한 간선 정보를 담아야 함
//
//모든 게이트 부터 순회 시작 (x)
//    게이트가 다른 게이트 가면 안됨(전역 변수)
//모든 산봉우리 목적지 (y)
//(x * y) * 간선
//n * (n-x) * n
//*/
//import programers.테스트용.Convertor;
//
//import java.util.*;
//
//class 등산코스정하기_2 {
//    public static void main(String[] args) {
//        int[][] arr1 = {
//                {1, 2, 3},
//                {2,3,5},
//                {2,4,2},
//                {2,5,4},
//                {3,4,4},
//                {4,5,3},
//                {4,6,1},
//                {5,6,1}
//        };
//        int[] arr2 = Convertor.convertIntArray("[1, 3]");
//        int[] arr3 = Convertor.convertIntArray("[5]");
//        int[] result = Convertor.convertIntArray("[5,3]");
//        int[] ans = solution(6, arr1, arr2, arr3);
//        for(int a : ans) {
//            System.out.println(a);
//        }
////        IsGoodAnswer.isPass(0, ans, result);
//
//    }
//    static Map<Integer, Node> lists = new TreeMap<>(
//
//    );
//
//    static int[] result = {0, -1};
//
//    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
//        boolean[] viMap = new boolean[n+1];
//        Arrays.fill(viMap, false);
//        for(int i = 0; i <= n; i++) {
//            lists.add(new Node(i));
//        }
//        for(int gate: gates) {
//            viMap[gate] = true;
//        }
//        for(int goal: summits) {
//            viMap[goal] = true;
//        }
//
//        //path [시작노드, 도착노드, 시간]
//        // gate나 submit이 아닌 값은 비교해서 노드 제거
//        for(int[] path: paths) {
////            lists.
//        }
//        // 게이트 시작
//        for(int gate: gates) {
//        }
//
//        return result;
//    }
//
//}
//class Node{
//    int value;
//    int weight = -1;
//    List<Integer[]> graph = new LinkedList<>();
//    public Node(int value) {
//        this.value = value;
//    }
//
//    public void link(Integer[] node, List<Node> map) {
//        this.graph.add(node);
//        map.get(node[0]).graph.add(new Integer[]{this.value, node[1]});
//    }
//
//    public void minWeight(List<Node> map) {
//        for(Integer[] nex: this.graph){
//            int weight = Math.max(nex[1], this.weight);
//            int nexWeight = map.get(nex[0]).weight;
//            if(nexWeight == -1 || nexWeight > weight){
//                map.get(nex[0]).weight = weight;
//            }
//        }
//    }
//}