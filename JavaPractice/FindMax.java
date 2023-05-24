package JavaPractice;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;


public class FindMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer T = Integer.valueOf(sc.nextLine().trim());
        for(int i = 1; i <= T; i++){
            OptionalInt optionalInt = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).max();
            int max = 0;
            if(optionalInt.isPresent()){
                max = optionalInt.getAsInt();
            }

            System.out.printf("#%d %d%n", i, max);
        }
    }
}
