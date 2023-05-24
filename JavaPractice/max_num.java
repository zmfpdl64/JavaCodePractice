package JavaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class max_num {
    
    public static void main(String[] args) {
        int n = 3;
        for(int i = 0; i < n; i++){
            for(int j = i; j <=n; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public int[] solution(String my_string) {
        String str = "";

        return IntStream.range(0, my_string.length()).map(i -> my_string.charAt(i)).filter(Character::isDigit).map(i -> i-48).sorted().toArray();
    }
}
