package programers.카카오2021;


import java.util.*;

class 신규아이디추천 {
    static StringBuffer sb = new StringBuffer();
    static Character[] sp = {'-', '_', '.'};
    public String solution(String new_id) {
        new_id = upperCase(new_id);
        new_id = doubleToSingle(new_id);
        new_id = startOrEndDot(new_id);
        new_id = isEmpty(new_id);
        new_id = setLength15(new_id);
        new_id = setUnder3(new_id);
        return new_id;
    }
    public static String upperCase(String name) {
        for(char c: name.toCharArray()){
            sb.append(Character.toLowerCase(c));
        }
        String _name = sb.toString();
        sb.setLength(0);
        return _name;
    }
    public static String replace(String name) {
        for(char c: name.toCharArray()){
            if(Character.isDigit(c) || Character.isLowerCase(c) || isSpecial(c)){
                sb.append(c);
            }
        }
        String _name = sb.toString();
        sb.setLength(0);
        return _name;
    }
    public static boolean isSpecial(Character c) {
        for(char _c : sp) {
            if(c == _c) return true;
        }
        return false;
    }

    public static String isEmpty(String name) {
        if(name.length() == 0) return "a";
        return name;
    }
    public static String setLength15(String name) {
        if(name.length() <= 15) return name;
        return name.substring(0, 16);
    }
    public static String setUnder3(String name) {
        int len = name.length();
        if(len <= 2) {
            sb.append(name.charAt(name.length()-1));
            len++;
        }
        return name + sb.toString();
    }

    public static String doubleToSingle(String name) {
        int len = name.length();
        while(true){
            name = name.replace("..", ".");
            if(len == name.length()) break;
            len = name.length();
        }
        return name;
    }

    public static String startOrEndDot(String name) {
        char start = name.charAt(0);
        char end = name.charAt(name.length()-1);
        if(start == '.'){
            if(end == '.') {
                return name.substring(1, name.length()-1);
            }
            return name.substring(1, name.length());
        }else{
            if(end == '.') {
                return name.substring(0, name.length()-1);
            }
            return name;
        }
    }

}