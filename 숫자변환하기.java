import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

// 15시 50분
// 16시 10분
public class 숫자변환하기 {
    public static void main(String[] args) {

        System.out.println(solution(10, 40, 5));
    }
    public static int solution(int x, int y, int n) {
        int answer = 0;
        int[] map = new int[y+1];
        Arrays.fill(map, 1_000_001);
        PriorityQueue<Integer[]> stack = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[1], b[1]);
        }

        );
        stack.add(new Integer[]{x, 0});
        while(!stack.isEmpty()){
            Integer[] s = stack.poll();
            int cur = s[0];
            int time = s[1];
            if(map[cur] > time){
                map[cur] = time;
            }
            if((cur + n) <= y) {
                if(map[cur+n] > time+1){
                    stack.add(new Integer[]{cur+n, time+1});
                }
            }
            if((cur * 2) <= y) {
                if(map[cur*2] > time+1){
                    stack.add(new Integer[]{cur*2, time+1});
                }

            }
            if((cur * 3) <= y) {
                if(map[cur*3] > time+1){
                    stack.add(new Integer[]{cur*3, time+1});
                }
            }
        }
        if(map[y] == 1_000_001){
            return -1;
        }
        return map[y];
    }
}
