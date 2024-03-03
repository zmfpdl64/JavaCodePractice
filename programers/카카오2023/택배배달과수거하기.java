package programers.카카오2023;
/*
17

가장 먼 곳 부터 해결
보유 갯수 50개 이하
집 갯수 10만
 */
public class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long delivery = 0;
        long pickup = 0;
        for(int i = n-1; i >= 0; i--) {
            delivery -= deliveries[i];
            pickup -= pickups[i];
            while(delivery < 0 || pickup < 0){
                delivery += cap;
                pickup += cap;
                answer += (i+1) * 2;
            }
        }
        return answer;
    }
}
