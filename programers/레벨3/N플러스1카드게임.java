package programers.레벨3;
/*
1. 1/3 장을 뽑는다

매 라운드 마다 n+1을 맞춘 카드 2장을 내야한다.

코인을 소모 및 카들를 버려야 한다.

낼 카드가 없으면 종료된다.

*/
import programers.테스트용.IsGoodAnswer;

import java.util.*;

public class N플러스1카드게임 {
    public static void main(String[] args) {
//        int[] arr = new int[] {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};
//        int answer = 5;
//        int[] arr = new int[] {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12};
//        int answer = 2;
        int[] arr = new int[] {5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7};
        int answer = 4;
//        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
//        int answer = 1;
        IsGoodAnswer.isPass(0, solution(4, arr), answer);
    }
    public static int solution(int coin, int[] cards) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> tempMap = new HashMap<>();

        int sum = cards.length + 1;
        int life = 1;
        int round = 0;
        for(int i =0; i < cards.length/3; i++) {
            int num = cards[i];
            int dif = sum - num;
            if(map.getOrDefault(dif, -1) != -1) {
                map.remove(dif);
                life++;
            }else{
                map.put(num, i);
            }
        }
        boolean flag = true;

        for(int i = cards.length/3; i < cards.length; i+=2){
            int card1 = cards[i];
            int card2 = cards[i+1];
            int dif1 = sum - card1;
            int dif2 = sum - card2;
            round++;
            life--;
            // 2장 합 맞을 때

            // 나머지 한장 수중에 있을 때
            if(map.containsKey(dif1) && coin >= 1){
                map.remove(dif1);
                coin--;
                life++;
            }
            // 나머지 한장 수중에 있을 때
            if(map.containsKey(dif2) && coin >= 1){
                map.remove(dif2);
                life++;
                coin--;
            }

            // 나머지 한장 임시맵에 있을 때
            if(tempMap.containsKey(dif1) && coin > 1){
                coin-=2;
                life++;
                tempMap.remove(dif1);
            }else{
                tempMap.put(card1, i);
            }

            // 나머지 한장 임시맵에 있을 때
            if(tempMap.containsKey(dif2) && coin > 1){
                life++;
                coin-=2;
                tempMap.remove(dif2);
            }else {
                tempMap.put(card2, i+1);
            }
            if(life == 0) {
                flag = false;
                break;
            }
        }
        if(flag) round++;

        return round;
    }
}
