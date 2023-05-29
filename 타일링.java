// 13시 37분
// 13시 48분 11분
import java.util.Arrays;

public class 타일링 {
    public static void main(String[] args) {

    }
    public long solution(int n) {
        int answer = 0;
        long div = 1_000_000_007;
        long[] map;
        if(n <= 3){
            map = new long[3];
        }
        else{
            map = new long[n];
        }
        map[0] = 1;
        map[1] = 2;
        map[2] = map[1] + map[0];
        for(int i = 3; i < n; i++){
            map[i] = (map[i-1]+map[i-2])%div;
        }
        return map[n];
    }
}
