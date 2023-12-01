package do_it_codetestJava;

import java.util.*;
import java.util.stream.IntStream;

public class 단체사진찍기 {
    static String[] members = {
            "A", "C", "F", "J", "M", "N", "R", "T"
    };

    static List<String[]> cases = new ArrayList<>();

    public static int solution(int n, String[] data) {
        int answer = 0;
        boolean[] viMap = new boolean[members.length];
        Arrays.fill(viMap, false);
        if(cases.size() == 0)
            permutation(0, viMap, new String[members.length]);

        String[][] conditions = new String[n][4];
        for(int i = 0; i < n; i++) {
            String[] line = data[i].split("");
            conditions[i] = IntStream.range(0, line.length)
                    .filter(j -> j != 1)
                    .mapToObj(j -> line[j])
                    .toArray(String[]::new);
        }
        for(String[] line : cases){
            boolean flag = true;
            for(String[] condition : conditions) {
                if(!isOkCondition(condition, line)){
                    flag = false;
                    break;
                }
            }
            if(flag) answer += 1;
        }
        return answer;
    }

    public static boolean isOkCondition(String[] condition, String[] line) {
        int startIdx = 0;
        int endIdx = 0;
        int dif_idx;

        String start = condition[0];
        String end = condition[1];
        String sign = condition[2];
        int dif = Integer.parseInt(condition[3]);

        for(int i = 0; i < line.length; i++) {
            String curS = line[i];
            if(start.equals(curS)){
                startIdx = i;
            }else if(end.equals(curS)){
                endIdx = i;
            }
        }
        dif_idx = Math.abs(endIdx - startIdx);
        if (sign.equals("<")){
            return dif_idx < dif+1;
        }else if(sign.equals("=")){
            return dif_idx == dif+1;
        }
        return dif_idx > dif+1;
    }
    public static void permutation(int curIdx, boolean[] viMap, String[] data) {
        if (curIdx == (members.length)){
            cases.add(Arrays.stream(data).toArray(String[]::new));
            return;
        }

        for(int i = 0; i < members.length; i++){
            if(!viMap[i]){
                viMap[i] = true;
                data[curIdx] = members[i];
                permutation(curIdx+1, viMap, data);
                viMap[i] = false;
            }
        }
        return;
    }
    public static void main(String[] args) {
        solution(2, new String[]{"N~F=0", "R~T>2"});
        solution(2, 	new String[]{"M~C<2", "C~M>1"});
//        for(String[] s : cases){
//            for(String c : s){
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }

    }
}

