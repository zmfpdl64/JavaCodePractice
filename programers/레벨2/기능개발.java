package programers.레벨2;
import java.util.*;
public class 기능개발 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println(solution2(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int startIdx = 0;
        int size = 0;
        while(size != progresses.length){
            int day = 0;
            int count = 0;
            int cur_pro = progresses[startIdx];
            int speed = speeds[startIdx];
            while(true) {
                day += 1;
                if(day * speed + cur_pro >= 100){
                    progresses[startIdx] += day * speed;
                    count += 1;
                    break;
                }
            }
            boolean flag = true;
            for(int i = startIdx+1; i < progresses.length; i++) {
                if(flag && day * speeds[i] + progresses[i] >= 100){
                    count += 1;
                    startIdx = i;
                }else{
                    flag = false;
                }
                progresses[i] += day * speeds[i];
            }
            startIdx += 1;
            size += count;
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public static int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
