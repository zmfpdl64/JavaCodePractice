package JavaPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class bab {
    public static void main(String[] args) {
        bab s = new bab();
        s.solution(new String[]{"aya", "yee", "u", "maa"}); 
    }
    public int solution(String[] babbling) {
        ArrayList<String> cant_s = new ArrayList<>(Arrays.asList("ayaaya", "yeye", "woowoo", "mama"));
        ArrayList<String> can_s = new ArrayList<>(Arrays.asList("aya", "ye", "woo", "ma"));
        int answer  = 0;

        for(String str: babbling) {
            boolean per = true;
            for(int i = 0; i < cant_s.size(); i++) {
                if(str.indexOf(cant_s.get(i)) != -1){ // 안됨
                    per = false;
                    break;
                }
            }
            if(per == true)
                for(int i = 0; i < can_s.size(); i++) {
                    if(str.indexOf(can_s.get(i)) != -1){
                        str = str.replace(can_s.get(i), "");
                    }
                }
            if(str.isEmpty()) answer+= 1;
        }
        return answer;
    }
}
