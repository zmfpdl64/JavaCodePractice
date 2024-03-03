package programers.레벨3;
import java.util.*;
public class 순위 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
        };
        System.out.println(solution(5, arr));
    }
    public static int solution(int n, int[][] results) {
        int answer = 0;
        boolean[] viMap = new boolean[n+1];
        List<List<Integer>> Lmap = new ArrayList<>();
        List<List<Integer>> Wmap = new ArrayList<>();


        for(int i = 0; i <= n; i++) {
            Lmap.add(new ArrayList<>());
            Wmap.add(new ArrayList<>());
            viMap[i] = true;
        }
        for(int[] edge : results) {
            int a = edge[0];
            int b = edge[1];
            List<Integer> wL = Wmap.get(a);
            List<Integer> lL = Lmap.get(b);
            wL.add(b);
            lL.add(a);
        }
        for(int i = 1; i <= n; i++) {
            boolean[] _viMap = Arrays.copyOf(viMap, viMap.length);
            dfs(i, _viMap, Wmap);
            dfs(i, _viMap, Lmap);
            int count = count(_viMap);
            if(count == 2) answer++;
        }

        return answer;
    }

    public static void dfs(int start, boolean[] viMap, List<List<Integer>> map) {
        for(Integer nex: map.get(start)){
            if(viMap[nex]){
                viMap[nex] = false;
                dfs(nex, viMap, map);
            }
        }
    }
    public static int count(boolean[] viMap) {
        int count = 0;
        for(boolean c: viMap) {
            if(c) count++;
        }
        return count;
    }
}
