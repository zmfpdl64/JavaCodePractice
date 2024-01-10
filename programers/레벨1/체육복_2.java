package programers.레벨1;
import java.util.*;
public class 체육복_2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+2];
        Arrays.fill(student, 0);
        for(int idx: lost) {
            student[idx]--;
        }
        for(int idx: reserve) {
            student[idx]++;
        }

        for(int j = 0; j < 2; j++) {
            for(int i = 1; i <= n; i++){
                int status = student[i];
                if(j == 0){
                    if(status == -1) {
                        if(student[i-1] == 1 && student[i+1] != 1){
                            student[i-1]-=1;
                            student[i] +=1;
                        }else if(student[i+1] == 1 && student[i-1] != 1) {
                            student[i+1]-=1;
                            student[i] += 1;
                        }// lost
                    }
                }else{
                    if(status == -1) {
                        if(student[i-1]==1){
                            student[i-1] = 0;
                            student[i] = 0;
                        }else if(student[i+1]==1){
                            student[i+1] = 0;
                            student[i] = 0;
                        }
                    }
                }
            }
        }
        return (int) Arrays.stream(student).filter(status -> status >= 0).count() - 2;
    }

}
