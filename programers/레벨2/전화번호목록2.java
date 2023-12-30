package programers.레벨2;

import java.util.*;

public class 전화번호목록2 {
    public static boolean solution(String[] phone_book) {
        Map<String, Integer> maps = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++) {
            maps.put(phone_book[i], i);
        }
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                if(maps.containsKey(phone_book[i].substring(0, j))) return false;
            }
        }
        return true;
    }
}
