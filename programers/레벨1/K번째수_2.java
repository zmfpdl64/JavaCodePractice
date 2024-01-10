package programers.레벨1;

import java.util.*;

public class K번째수_2 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] cmd = commands[i];
            answer[i] = getNum(array, cmd[0], cmd[1], cmd[2]);
        }
        return answer;
    }
    public static int getNum(int[] array, int start, int end, int k) {
        int[] nums = Arrays.copyOfRange(array, start - 1, end);
        Arrays.sort(nums);
        return nums[k-1];
    }
}
