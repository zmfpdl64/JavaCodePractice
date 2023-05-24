package JavaPractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MiddleValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine().trim());
        for(int i = 1; i <= T; i++){
            int average = (int) Math.round(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).average().getAsDouble());
            System.out.printf("#%d %d%n", i, average);
        }
    }
}
