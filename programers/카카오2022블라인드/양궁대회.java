package programers.카카오2022블라인드;

/*
어피치 먼저 발사

동점일 경우 어피치가 가져감

정답이 여러개일 때 적은 점수 더 많이 맞힌 경우

지거나 비기는 경우 -1
*/


import java.util.*;

class 양궁대회 {
    static List<Integer[]> cases = new LinkedList<>();
    public Integer[] solution(int n, int[] info) {
        Integer[] answer = new Integer[11];
        Arrays.fill(answer, 0);
        int[] shot = new int[11];
        int dif = 0;
        dfs(info, 0, n, shot);

        for(Integer[] _case: cases) {
            int lion = 0;
            int apeach = 0;
            for(int i = 0; i < _case.length; i++) {
                if(_case[i] != 0) lion += 10 - i;
                else if(info[i] != 0) apeach += 10 - i;
            }
            int _dif = lion - apeach;
            if(_dif > dif) {
                dif = _dif;
                answer = _case;
            }else if(_dif == dif) {
                for(int i = _case.length-1; i >= 0; i--) {
                    if(_case[i] > answer[i]){
                        dif = _dif;
                        answer = _case;
                        break;
                    }else if(_case[i] < answer[i]){
                        break;
                    }
                }
            }
        }
        if(answer.length == 0 || dif == 0) answer = new Integer[]{-1};
        return answer;
    }

    public static void dfs(int[] info, int cur, int count, int[] shot){
        if(cur == info.length){
            Integer[] _arr = Arrays.stream(shot).boxed().toArray(Integer[]::new);
            _arr[info.length-1] += count;
            cases.add(_arr);
            return;
        }
        dfs(info, cur+1, count, shot);

        if(info[cur]+1 <= count){
            shot[cur] = info[cur]+1;
            dfs(info, cur+1, count- (info[cur]+1), shot);
            shot[cur] = 0;
        }
    }
}