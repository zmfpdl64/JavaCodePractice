package do_it_codetestJava;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;


/*
1. 수강신청 먼저 한 사람 대기순위 우선
2. 이미 대기열에 들어간 상태에서 다시 신청시 후순위
3. 비활성화되면 앞 사람부터 수강신청 완료

// 제한 50만 * 50만 이면 시초

// 입력
50만

hashmap 사용시 최대 10만 남음
10만 * log 10만
60만

idea 1
// -> 아웃
List로 2중포문 중복 제거 방식 후 앞사람 3명 추출




 */
public class 수강신청 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[] kl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] answer = new String[kl[0]];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < kl[1]; i++) {
            String ins = br.readLine();
            map.put(ins, i);
        }
        List<Map.Entry<String, Integer>> sortedMap = new LinkedList<>(map.entrySet());
        Collections.sort(sortedMap, (o1, o2) -> {
           return o1.getValue().compareTo(o2.getValue());
        });

        int count = 0;
        for(Map.Entry<String, Integer> set : sortedMap){
            answer[count++] = set.getKey();
            if(count >= kl[0]) break;
        }
        for(String i : answer){
            if(i != null)
                System.out.println(i);
        }
    }
}
