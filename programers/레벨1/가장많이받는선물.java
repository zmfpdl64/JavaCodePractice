package programers.레벨1;
/*
1. A -> B 5  B -> 3
다음 B -> A

EX) (A -> B 0 B -> A 0) OR (A -> B n B -> A n)
선물지수 더 작은사람

선물지수란?
선물지수: 선물한 선물수 - 받은 선물수

선물지수도 같으면 PASS
*/

/*
그리디 문제
MAP 이번달 선물준사람 : 선물받은사람들
*/

/*
선물받은 사람들 수는 50명 미만 그러니 List로 몇번거래했는지 확인가능(시간복잡도 OK)
*/

import java.util.*;
public class 가장많이받는선물 {
    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {
                "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"
        };
        solution(friends, gifts);
    }
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, List<String>> gmap = new HashMap<String, List<String>>();
        Map<String, List<String>> rmap = new HashMap<String, List<String>>();
        Map<String, Integer> nextGift = new HashMap<String, Integer>();

        // key, value  자료형 전처리
        for(int i = 0; i < friends.length; i++) {
            List<String> list = new LinkedList<>();
            gmap.put(friends[i], list);
            List<String> list2 = new LinkedList<>();
            rmap.put(friends[i], list2);

            nextGift.put(friends[i], 0);
        }
        // 연결된 정보 초기화
        for(int i = 0; i < gifts.length; i++) {
            String[] edge = gifts[i].split(" ");

            List<String> list = gmap.get(edge[0]);
            List<String> list2 = rmap.get(edge[1]);
            list.add(edge[1]);
            list2.add(edge[0]);
        }
        // 다음달 선물 결과 계산
        for(int i = 0; i < friends.length; i++) {
            String giver = friends[i];
            for(int j = i+1; j < friends.length; j++) {
                String receiver = friends[j];

                int gCount = count(giver, receiver, gmap);
                int rCount = count(receiver, giver, gmap);

                boolean flag = true;
                boolean ignore = false;
//                System.out.println(giver + " : " +  receiver);
                if(gCount < rCount){
//                    System.out.println("giver win");
                }else if( gCount > rCount) {
//                    System.out.println("receiver win");
                    flag = false;
                }else { //선물 지수 비교
                    int giver_present_Index = gmap.get(giver).size() - rmap.get(receiver).size();
                    int receiver_present_Index = rmap.get(giver).size() - gmap.get(receiver).size();
                    if(giver_present_Index < receiver_present_Index){
//                        System.out.println("giver win_");
                    }else if(giver_present_Index > receiver_present_Index){
//                        System.out.println("receiver win_");
                        flag = false;
                    }else{
                        ignore = true;
                    }
                }
                if(!ignore){
                    if(flag) {
//                        nextGift.put(giver, nextGift.get(giver)-1);
                        nextGift.put(receiver, nextGift.get(receiver)+1);
                    }else{
                        nextGift.put(giver, nextGift.get(giver)+1);
//                        nextGift.put(receiver, nextGift.get(receiver)-1);
                    }
                }
            }
        }
        for(Integer value: nextGift.values()){
            answer = Math.max(value, answer);
            System.out.println(answer);
        }
        return answer;
    }

    public static int count(String giver, String receiver, Map<String, List<String>> map){
        List<String> list = map.get(giver);

        return (int) list.stream().filter(o1 -> o1.equals(receiver)).count();
    }
}
