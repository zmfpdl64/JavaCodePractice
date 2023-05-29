import java.util.Arrays;

// 14시 49분
// 15시 30분
public class n개이하로다른비트 {


    public static void main(String[] args) {
        long a = 7;
        solution(new long[]{a});
    }

    public static String checkMin(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0'){
                sb.setCharAt(i, '1');
                for(int j = i+1; j < s.length(); j++) {
                    if(s.charAt(j) == '1'){
                        sb.setCharAt(j, '0');
                        break;
                    }
                }
                break;
            }
        }
        return sb.toString();
    }
    public static String TenToBin(Long n){
        StringBuffer bf = new StringBuffer();
        while(n != 0){
            long mod = n % 2;
            long div = n / 2;
            n = div;
            bf.append(mod);
        }
        bf.append(0);
        return bf.reverse().toString();
    }
    public static long BinToTen(String n) {
        long total = 0;
        for(double i= 0; i < n.length(); i++) {
            if(n.charAt((int) i) == '1'){
                total += Math.pow(2, n.length()-i-1);
            }
        }
        return total;
    }
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int c = 0 ; c < numbers.length; c++){
            String num = TenToBin(numbers[c]);
            String s = checkMin(num);
            long n = BinToTen(s);
            answer[c] = n;
        }
        return answer;
    }

    public static long[] solution2(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int c = 0 ; c < numbers.length; c++){
            String num = Long.toString(answer[c], 2);
            String s = checkMin(num);
            long n = Long.parseLong(s, 10);
            answer[c] = n;
        }
        return answer;
    }

}
