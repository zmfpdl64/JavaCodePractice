package do_it_codetestJava;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_num {
    public Integer solution(String nums) {
        return Arrays.stream(nums.split("")).mapToInt(Integer::valueOf).sum();
    }
    public int solution1(String nums) {
        int sum = 0;
        for(int i = 0; i < nums.length(); i++){
            sum += Character.getNumericValue(nums.charAt(i));
        }
        return sum;
    }
    public int solution2(String nums) {
        char[] characters = nums.toCharArray();
        int sum = 0;
        for(int i = 0; i < characters.length; i++){
            sum += characters[i]- '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        Sum_num s = new Sum_num();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(s.solution(input));
        System.out.println(s.solution1(input));
        System.out.println(s.solution2(input));
    }
}
