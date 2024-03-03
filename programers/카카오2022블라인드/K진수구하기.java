package programers.카카오2022블라인드;
import java.util.*;
public class K진수구하기 {
    public static void main(String[] args) {
        String[] nums = split("0220");

    }
    public static String[] split(String num) {
        String[] nums = Arrays.stream(num.split("0")).filter(i -> !i.equals("")).toArray(String[]::new);
        Map<String, Integer> map = new HashMap<>();
        return nums;
    }
}
