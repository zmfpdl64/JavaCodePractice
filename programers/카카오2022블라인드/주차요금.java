package programers.카카오2022블라인드;

/*
출차 내역없으면 23:59분 간주
차량 번호별로 요금 나누기

[기본 시간, 기본 요금, 단위 시간, 단위 요금]


잘못된 입력 없음
*/
import java.util.*;
class Solution {
    Integer maxTime = 23 * 60 + 59;
    public int[] solution(int[] fee, String[] records) {
        Map<String, Integer> answer = new TreeMap<>();
        Map<String, Integer> carPark = new TreeMap<>();

        //시간 계산
        for(String record: records) {
            String[] _record = record.split(" ");
            Integer curTime = getTime(_record[0]);
            if(_record[2] == "IN"){
                carPark.put(_record[1], curTime);
            }else{
                int difTime = curTime - carPark.get(_record[1]);
                answer.put(_record[1], answer.getOrDefault(_record[1], 0) + difTime);
                carPark.remove(_record[1]);
            }
        }
        //출차 안한 금액 계산
        for(Map.Entry<String,Integer> map: carPark.entrySet()){
            int difTime = maxTime - map.getValue();
            String num = map.getKey();
            answer.put(num, answer.getOrDefault(num, 0) + difTime);
        }
        //요금 계산
        // [기본 시간, 기본 요금, 단위 시간, 단위 요금]
        int[] ans = answer.values().stream().mapToInt(i -> {
            int _fee = fee[1];
            int _time = i - fee[0];

            if(_time <= 0){
                return _fee;
            }else{
                int mod = _fee % fee[2];
                _fee += _time / fee[2] * fee[3];

                if(mod==0) return _fee;
                return _fee + fee[3];
            }
        }).toArray();

        for(int i: ans){
            System.out.println(i);
        }
        return null;
    }
    public Integer getTime(String time) {
        int[] _time = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return _time[0] * 60 + _time[1];
    }
}