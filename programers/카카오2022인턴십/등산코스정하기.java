package programers.카카오2022인턴십;

/*
n = 노드 갯수
[출발 노드, 도착 노드, 시간]


출발 지점과 도착지점 동일해야 한다.

submits 산봉우리

정답 [산봉우리 번호, 최솟값]
*/

/*
로직
gates 에서 시작

dfs 함수에서
시작지점 간선보다 같거나 작은 경로로 이동 (X)
Exception) 큰 간선밖에 없을 수 있음 전부 검색해야 함

배열로 맵 만드면 너무 큼 필요한 간선 정보를 담아야 함

모든 게이트 부터 순회 시작 (x)
    게이트가 다른 게이트 가면 안됨(전역 변수)
모든 산봉우리 목적지 (y)
(x * y) * 간선
n * (n-x) * n
*/
import programers.테스트용.Convertor;
import programers.테스트용.IsGoodAnswer;

import java.util.*;
class 등산코스정하기 {
    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 2, 3},
                {2,3,5},
                {2,4,2},
                {2,5,4},
                {3,4,4},
                {4,5,3},
                {4,6,1},
                {5,6,1}
        };
        int[] arr2 = Convertor.convertIntArray("[1, 3]");
        int[] arr3 = Convertor.convertIntArray("[5]");
        int[] result = Convertor.convertIntArray("[5,3]");
        int[] ans = solution(6, arr1, arr2, arr3);
        for(int a : ans) {
            System.out.println(a);
        }
//        IsGoodAnswer.isPass(0, ans, result);

    }
    static List<List<Integer[]>> lists = new LinkedList<>();
    static int[] result = {0, -1};

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> goalSet = new HashSet<>();
        boolean[] viMap = new boolean[n+1];
        Arrays.fill(viMap, false);
        for(int i = 0; i <= n; i++) {
            lists.add(new LinkedList<>());
        }
        // 게이트 set 자료 초기화
        for(int gate: gates) {
            viMap[gate] = true;
            gateSet.add(gate);
        }
        for(int goal: summits) {
            viMap[goal] = true;
            goalSet.add(goal);
        }

        //path [시작노드, 도착노드, 시간]
        // gate나 submit이 아닌 값은 비교해서 노드 제거
        for(int[] path: paths) {
//            int start = path[0];
//            int end = path[1];
            lists.get(path[0]).add(new Integer[]{path[1], path[2]});
            lists.get(path[1]).add(new Integer[]{path[0], path[2]});
        }
        // 게이트 시작
        for(int gate: gates) {
            for(int goal: summits) {
                boolean[] _viMap = viMap.clone();
                _viMap[goal] = false;
                dfs(goal, gate, 0, gate, _viMap);
            }
        }

        return result;
    }
    public static void dfs(int goal, int start, int maxTime, int cur, boolean[] viMap){
        if(viMap[goal] && goal == cur){
            if(result[1] >= maxTime){
                if(result[1] > maxTime) {
                    result[0] = goal;
                    result[1] = maxTime;
                }else{
                    if(result[0] > goal){
                        result[0] = goal;
                        result[1] = maxTime;
                    }
                }
                return;
            }else if(result[1] == -1) result = new int[]{goal, maxTime};
        }
        for(Integer[] node: lists.get(cur)){
            Integer nex = node[0];
            Integer time = node[1];
            //시작 게이트 외에 순회하지 않기 위해서
            if(!viMap[nex] || nex == goal && (result[1] == -1 || result[1] >= time)){
                viMap[nex] = true;
                dfs(goal, start, Math.max(maxTime, time), nex, viMap);
                viMap[nex] = false;
            }
        }
    }
}