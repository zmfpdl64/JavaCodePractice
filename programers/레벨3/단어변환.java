package programers.레벨3;
import java.util.*;
import java.util.stream.Collectors;

/*
단어 한글자씩 변환하여 변환횟수 최소 값 구하기

한글자씩 다른 맵 리스트 만들기

예외상황
변환할 수 없을 경우 0을 반환
 */
public class 단어변환 {
    private static int answer = 0;

    public static void main(String[] args) {
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        solution("hit", "cog", words);
    }
    public static int solution(String begin, String target, String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        boolean flag = true;
        for(String word: words) {
            if(word.equals(begin)){
                flag = false;
            }
        }
        if (flag) {
            words = Arrays.copyOf(words, words.length+1);
            words[words.length-1] = begin;
        }

        Map<String, Boolean> viMap = Arrays.stream(words).collect(Collectors.toMap(o1 -> o1, o2 -> Boolean.TRUE));
        for(int i = 0; i < words.length; i++) {
            String word1 = words[i];
            for(int j = i+1; j < words.length; j++) {
                String word2 = words[j];
                if(isSimilar(word1, word2)){
                    if(!map.containsKey(word1)){
                        List<String> wordList1 = new LinkedList<>();
                        wordList1.add(word2);
                        map.put(word1, wordList1);
                    }else{
                        List<String> wordList1 = map.get(word1);
                        wordList1.add(word2);
                        map.put(word1, wordList1);
                    }
                    if(!map.containsKey(word2)) {
                        List<String> wordList = new LinkedList<>();
                        wordList.add(word1);
                        map.put(word2, wordList);
                    }else{
                        List<String> wordList = map.get(word2);
                        wordList.add(word1);
                        map.put(word2, wordList);
                    }
                }
            }
        }
        bfsTransCount(map, viMap, begin, target);
        return answer;
    }


    public static void bfsTransCount(Map<String, List<String>> map, Map<String, Boolean> viMap, String cur, String target){
        Queue<Point> q = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        q.add(new Point(0, cur));
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.word.equals(target)){
                answer = p.time;
                break;
            }
            if(map.containsKey(p.word)){
                for(String word: map.get(p.word)){
                    if(viMap.get(word)){
                        q.add(new Point(p.time+1, word));
                        viMap.put(word, false);
                    }
                }
            }
        }
    }

    public static boolean isSimilar(String a, String b) {
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) count++;
        }
        return count == (a.length()-1);
    }


    public static void dfsTransCount(Map<String, List<String>> map, Map<String, Boolean> viMap, String cur, String target, int count){
        if(target.equals(cur)){
            if(answer == 0 || count < answer){
                answer = count;
            }
            return;
        }
        for(String nex: map.get(cur)){
            if(map.containsKey(nex) && viMap.get(nex)){
                viMap.put(nex, false);
                dfsTransCount(map, viMap, nex, target, count+1);
                viMap.put(nex, true);
            }
        }
        return ;
    }
}

class Point {
    Integer time;
    String word;

    public Point(Integer time, String word) {
        this.time = time;
        this.word = word;
    }
}