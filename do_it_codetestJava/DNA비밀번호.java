package do_it_codetestJava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DNA비밀번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine();
        int count = 0;
        String[] map = sc.nextLine().split("");
//        String[] checkmap = new String[P];
//        String[] acgt = "ACGT".split("");

        Map<String, Integer> dna = new HashMap<>();

        dna.put("A", sc.nextInt());
        dna.put("C", sc.nextInt());
        dna.put("G", sc.nextInt());
        dna.put("T", sc.nextInt());

        for(int i = 0; i < S; i++) {
            if(dna.containsKey(map[i])){
                dna.put(map[i], dna.get(map[i])-1);
            }
            if(i >= P) {
                if(dna.containsKey(map[i])){
                    dna.put(map[i-P], dna.get(map[i-P])+1);
                }
            }
            if(i >= P-1 && isGood(dna)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean isGood(Map<String, Integer> dna) {
        Collection<Integer> values = dna.values();
        for(Integer value : values) {
            if(value > 0) {
                return false;
            }
        }
        return true;
    }
}
