package programers.레벨1;

import java.util.*;
import java.util.stream.*;

public class 체육복 {
    public static void main(String[] args) {
//        solution(5, new int[]{2, 4}, new int[] {1,3,5});
        solution2(8, new int[]{2,3,6,7}, new int[] {1,4,5,8});
//        solution2(5, new int[]{2,3,4}, new int[] {2,4});
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        final int CHECK = 0;
        int[] newArray = new int[n+2];
        List<Integer> reserveList = List.of();
        Arrays.fill(newArray, 0);
        for(int i = 0; i < lost.length; i++) {
            int lostIdx = lost[i];
            newArray[lostIdx-1] += 1;
            newArray[lostIdx+1] += 1;
            newArray[lostIdx] = -1000;
        }
        for(int j = 0; j <= 1; j++) {
            for(int i = 0; i < reserveList.size(); i++) {
                int reserveIdx = reserveList.get(i);
                int curCount = newArray[reserveIdx];
                if(curCount == 1 || (curCount >= 1 && j == 1) || curCount < 0){
                    int prev = newArray[reserveIdx-1];
                    int next = newArray[reserveIdx+1];
                    int cur = newArray[reserveIdx];
                    if(cur < -5){
                    }
                    else if(prev < 0){
                        newArray[reserveIdx-1] = CHECK;
                        newArray[reserveIdx-2] -= 1;
                    }else if(next < 0){
                        newArray[reserveIdx+1] = CHECK;
                        newArray[reserveIdx+2] -= 1;
                    }
                    newArray[reserveIdx] = 0;
                }
            }
        }
        answer = (int) Arrays.stream(newArray).filter(num -> num >= -2).count()-2;
//        System.out.println(answer);
        return answer;
    }

    public static int solution2(int n, int[] lost, int[] reserve){
        int[] people = new int[n+2];
        int answer = n;

        for (int l : lost)
            people[l]--;
        for (int r : reserve)
            people[r]++;

        for (int i = 1; i < people.length-1; i++) {
            if(people[i] == -1) {
                if(people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }

        return answer;
    }
}
