package do_it_codetestJava;

import java.util.Scanner;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = new int['Z'+1];
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine();
        char[] map = sc.nextLine().toCharArray();

        arr['A'] = -sc.nextInt();
        arr['C'] = -sc.nextInt();
        arr['G'] = -sc.nextInt();
        arr['T'] = -sc.nextInt();

        for(int i = 0; i < P; i++){
            arr[map[i]] += 1;
        }

        isGood(arr);

        for(int i = P; i < S; i++) {
            arr[map[i]] += 1;
            arr[map[i-P]] -= 1;
            isGood(arr);
        }
        System.out.println(Main.count);
    }
    public static void isGood(int[] arr) {
        boolean aGood = arr['A'] >=0;
        boolean cGood = arr['C'] >=0;
        boolean gGood = arr['G'] >=0;
        boolean tGood = arr['T'] >=0;
        if(aGood && cGood && gGood && tGood)  Main.count++;
    }
}
