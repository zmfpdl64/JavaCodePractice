package programers.카카오2021;

/*
코스요리 (단품요리 2개 이상)
최소 2번 이상 주문 요리만 코스요리에 포함

결과
알파뱃 순 오름차순

*/

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

class 메뉴리뉴얼 {
    // idx : 단품들
    static Map<Integer, Set<String>> map = new HashMap<>();
    // idx : 존재하는 갯수
    static Map<Integer, Integer> count = new HashMap<>();

//    public String[] solution(String[] orders, int[] course) {
//        List<String> answer = new LinkedList<>();
//        Set<Integer> set = new ConcurrentSkipListSet();
//        Map<String, Map<Integer, Integer>>[] s = new HashMap[4];
//        int idx = 0;
//        for(String order: orders) {
//            Set<String> set1 = new TreeSet<>();
//            Arrays.stream(order.split("")).forEach(s -> set1.add(s));
//            map.put(idx, set1);
//            count.put(idx++, 1);
//        }
//        int[] sortedKey = map.keySet().stream().sorted((o1, o2) -> {
//            int size1 = map.get(o1).size();
//            int size2 = map.get(o2).size();
//            return size1 - size2;
//        }).mapToInt(Integer::valueOf).toArray();
//
//        for(int i = 0; i < sortedKey.length; i++) {
//            int key  = sortedKey[i];
//            Set<String> set1 = map.get(key);
//            Set<String> set2 = map.get(key);
//            for(int j = i+1; j < sortedKey.length; j++) {
//                int key2 = sortedKey[j];
//                Set<String> set2 = map.get(key2);
//
//                int cnt = 0;
//                for(String s : set){
//                    if(!set2.contains(s)) break;
//                    cnt++;
//                }
//                if(cnt == set.size()) count.put(key,count.get(cnt)+1);
//            }
//        }
//
//        for(int c : course) {
//            for(Map.Entry<Integer, Integer> o : count.entrySet()) {
//                if(o.getValue().equals(c)) {
//                    answer.add(orders[o.getKey()]);
//                }
//            }
//        }
//
//
//
//        return answer.stream().sorted().toArray(String[]::new);
//    }
}