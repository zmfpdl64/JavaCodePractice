package programers.카카오2023;


/* 40분
1. 가입자 최대
2. 판매액 최대

n명 사용자에게 m개를 할인하여 판매

이모티콘 할인율 [10, 20, 30, 40]
1 ~ 40 %

이모티콘 플러스 OR 이모티콘 구입
[이모티콘 할인율, 가격]
가격 = (이모티콘1 + 이모티콘2) * 할인율 ,  이모티콘 플러스



이모티콘 7개 이하 존재

유저 100명 이하

idea 1
그리디??

idea 2
  4^7
완탐 이모티콘

*/
import java.util.*;

class 이모티콘할인행사 {

    public static void main(String[] args) {
        int[][] in1 = {
                {40, 10000}, {25, 10000}
        };
        int[] in2 = {7000, 9000};
        solution(in1, in2);
    }
    static int[] rate = new int[] {10, 20, 30, 40};
    static List<Integer[]> discountRates = new LinkedList<>();

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0, 0};

        createDiscountRate(0, new Integer[emoticons.length]);
        for(Integer[] discounts : discountRates) {
            int[] temp = {0, 0};
            for(int[] user: users) {
                int maxRate = user[0];
                int maxValue = user[1] * 100;
                int price = 0;
                for(int i = 0; i < discounts.length; i++) {
                    if(discounts[i] >= maxRate) {
                        price += (100-discounts[i]) * emoticons[i];
                    }
                }
                if(maxValue <= price) {
                    temp[0] += 1;
                }else{
                    temp[1] += price / 100;
                }
            }
            if(answer[0] < temp[0] || answer[0] == temp[0] && answer[1] < temp[1]){
                answer = temp;
            }
        }
        return answer;
    }
    public static void createDiscountRate(int depth, Integer[] result){
        if(depth == result.length){
            discountRates.add(result.clone());
            return;
        }
        for(int i = 0; i < rate.length; i++) {
            result[depth] = rate[i];
            createDiscountRate(depth+1, result);
        }
    }
}
