package programers.레벨2;
import java.util.*;

/*
주어지는 갯수 2개 이상 20개 이하
+ 또는 -
20자리 -1 +1 2 ^
2^20 == 1,000,000번
 */
public class 타겟넘버 {
    public static void main(String[] args) {
        solution(new int[] {1, 1, 1, 1, 1}, 3);
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0,  0, target);
        return answer;
    }
    public static int dfs(int[] numbers, int sum, int cur, int target){
        int _count = 0;
        if(cur == numbers.length){
            if(sum == target) return 1;
            return 0;
        }
        int num = numbers[cur];
        _count += dfs(numbers, sum + num, cur+1, target);
        _count += dfs(numbers, sum - num, cur+1, target);
        return _count;
    }
}
