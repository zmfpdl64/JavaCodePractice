package programers.카카오2022블라인드;

import java.util.*;

class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        // Map<String, Integer> nameToIndex = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();
        // 이름: 인덱스 초기화
        for(int i = 0; i < id_list.length; i++) {
            // nameToIndex.put(id_list[i], i);
            map.put(id_list[i], new HashSet<String>());
        }
        // 인덱스: Set 신고 [이용자, 신고자]
        for(String _report: report) {
            String[] split = _report.split(" ");
            String from = split[0];
            String to = split[1];

            Set<String> set = map.get(to);
            set.add(from);
            map.put(to, set);
        }

        return map.values().stream().mapToInt(i -> i.size()).toArray();
    }
}