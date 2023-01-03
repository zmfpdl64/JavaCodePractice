import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class plus_mull {
    public static void main(String[] args) {
        plus_mull s = new plus_mull();
        s.solution("3x + 7 + x");
    }
    public String solution(String polynomial) {
        String answer = "";
        HashMap<String, Integer> dic = new HashMap<>();
        String[] str = polynomial.split("\\+");
        int num = 0;
        int x_num = 0;
        for(String s : str) {
           s = s.replace(" ", "");
           if(s.contains("x")){
            s = s.replace("x","");
            if(s.isEmpty())
                x_num += 1;
            else
                x_num += Integer.parseInt(s);
           }
           else{
            num += Integer.parseInt(s);
           }
        }
        if(x_num != 0) {
            if(x_num == 1) {
                answer = "x";
            }
            else
                answer = String.valueOf(x_num)+"x";
            if(num != 0){
                answer += " + " + String.valueOf(num);
            }
        }
        else{
            if(num != 0){
                answer = String.valueOf(num);
            }
            else
                answer = "0";
        }
        return answer;
    }
    
    public int[] solution1(int num, int total) {
        int[] answer = {};
        int x = 0;
        x = (total - plus_mull.add(num))/3;
        
        return IntStream.range(x, x+num).toArray();
    }
    public static Integer add(int n) {
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += i;
        }
        return sum;
    }
}


// String answer = "";
// HashMap<String, Integer> dic = new HashMap<>();
// String[] str = polynomial.split("\\+");
// int num = 0;
// for(String s : str) {
//     s = s.replace(" ","");
//     if(s.contains("x")){
//         if(s.length() >=2){
//             int ind = s.indexOf("x");
//             s = s.substring(0, ind);
//             dic.put("x", dic.getOrDefault("x", 0) + Integer.parseInt(s));
//         }
//         else{
//             dic.put(s, dic.getOrDefault("x", 0)+1);
//         }
//     }
//     else{
//         num += Integer.parseInt(s);
//     }
// }
// if(dic.containsKey("x")){
//     answer = String.valueOf(dic.get("x")) + "x";
//     if(num != 0){
//         answer += " + "+num;
//     }
// }else
//     if(num != 0)
//         answer = String.valueOf(num);
//     else
//         answer = "0";

// return answer;
