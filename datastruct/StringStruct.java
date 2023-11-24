package datastruct;

import java.util.*;
public class StringStruct {
    public static void main(String[] args) {
        stringToInteger();
        stringToCharacters();
    }

    public static void stringToInteger() {
        String[] strings = new String[]{"1", "2"};
        Integer[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        for(Integer i : ints) {
            System.out.println(i);
        }
    }

    public static void stringToCharacters() {
        String[] strings = new String[]{"1", "2"};
        for(String s : strings) {
            char[] chars = s.toCharArray();
            for(char c : chars) {
                int numericValue = Character.getNumericValue(c);
                System.out.println(numericValue + " : " + c);
            }
        }
    }
}
