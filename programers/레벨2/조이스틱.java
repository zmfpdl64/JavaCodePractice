package programers.레벨2;
import java.sql.SQLOutput;
import java.util.*;

// A B A A B B
// 4  5 왼쪽으로 이동하는게 더 빠름
// A B A B B A
// 7  4  오른쪽으로 이동하는데 끝까지 안가도 됨

// 오른쪽에서 2개 골라서 거리 계산

// 현재 예외상황 추측
// AAB

public class 조이스틱 {
    public static void main(String[] args) {
        solution("JEROEN");
        solution("ABAABB");
        solution("ABABBA");
        solution("ZZ");
        solution("NOTBAAAAD");
        solution("AAB");
        solution("AAABBBABA");
        solution("ABAA");
        solution("AAA");
        solution("A");
        solution("BBAAAAAABBBAAAAAABB");
    }

    public static int distance(String str, int startIdx, int goalIdx){
        int max = Math.max(startIdx, goalIdx);
        int min = Math.min(startIdx, goalIdx);
        int distance = Math.min(min * 2 + str.length() - max, min + (str.length()-max)*2) ;
        return distance;
    }
    public static int changeAlpha(char str, char target) {
        int astr = (int) str - 65; // A B A A B
        int atarget = (int) target - 65;
        int max = Math.max(astr, atarget);
        int min = Math.min(astr, atarget);
        int diff1 = Math.abs(astr-atarget);
        int diff2 = min + (26 - max);
        return Math.min(diff1, diff2);
    }

    public static int solution(String name) {
        Character[] chars = new Character[name.length()];
        Arrays.fill(chars, 'A');
        List<Integer> seq = new ArrayList<>();
        int answer = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < name.length(); i++) {
            char chr = name.charAt(i);
            if(chr != 'A'){
                seq.add(i);
            }
        }
        // 거리 계산 로직
        if(seq.size() > 1){ // A B A A B A B
            for(int i = 0; i < seq.size()-1; i++) {
                int fIdx = seq.get(i);
                int sIdx = seq.get(i+1);
                min = Math.min(distance(name, fIdx, sIdx), min);
            }
            // A A A A B B B
            Integer idx = seq.get(seq.size() - 1);
            min = Math.min(min, idx);
            min = Math.min(min, Math.min(name.length()-seq.get(0), min));
        }else if(seq.size() == 1){
            // A A A A A A A
            Integer idx = seq.get(0);
            min = Math.min(min, distance(name, 0, idx));
            min = Math.min(min, idx);
            min = Math.min(min, Math.min(name.length()-seq.get(0), min));
        }else{
            min = 0;
        }
        answer += min;

        // 알파벳 계산 로직
        for(char chr : name.toCharArray()){
            answer += changeAlpha('A', chr);
        }

        return answer;
    }
}
