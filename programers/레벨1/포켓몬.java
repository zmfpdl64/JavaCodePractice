package programers.레벨1;

import java.util.*;
public class 포켓몬 {
    public static void main(String[] args) {
    }
    public int solution(int[] nums) {
        Set<Integer> maps = new HashSet<>();
        for(int num: nums) {
            maps.add(num);
        }
        if(maps.size() >= nums.length/2) return nums.length/2;
        return maps.size();
    }
}
