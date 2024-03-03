package programers.레벨4;
/*
1. -가 홀수개 일 때 - 이후의 값이 최소 일 때 최대가 된다.
2. -가 짝수개 일 때 - 이후의 값이 최대 일 때 최대가 된다.
 */
import java.util.*;
public class 사칙연산 {
    public static void main(String[] args) {
//        String[] ins = {"1", "-", "3", "+", "5", "-", "8"};
        String[] ins = {"5", "-", "3", "+", "1", "+", "2", "-", "4"};
        solution(ins);
    }
    public static int solution(String[] arr) {
        int answer = 0;
        int minusCount = 0;
        List<Integer> nums = new LinkedList<>();
        Integer a1 = nums.stream().max((o1, o2) -> o1.compareTo(o2)).get();
        for(String a: arr){
            if(a.equals("-")) minusCount++;
        }

        int count = 0;
        for(int i = arr.length-1 ; 0 <= i; i--) {

            if(arr[i].equals("-")){
                count++;
                if(count % 2 == 1) {// -가 홀수 일 때 - 이후의 값이 최소 일 때 최대가 된다.
                    int num = 0;
                    num -= nums.remove(0);
                    while(!nums.isEmpty()){
                        num += nums.remove(0);
                    }
                    nums.add(num);
                }else{
                    int num = 0;
                    while(!nums.isEmpty()){
                        num += nums.remove(0);
                    }
                    nums.add(-num);
                }
            }else if(arr[i].equals("+")){
                continue;
            }else{
                nums.add(Integer.parseInt(arr[i]));
            }


        }
        for(Integer num : nums){
            answer += num;
        }
        System.out.println(answer);

        return answer;
    }
}


//1 -3 5 -8
//
//1 - 3 + 5 - 8 + 7 - 2 + 10 + 20
//3 + 5 - 8 + 7 - 2 + 10 + 20 최대 35
//8 + 7 - 2 + 10 + 20 최소 -43
//2 + 10 + 20 최대 28

