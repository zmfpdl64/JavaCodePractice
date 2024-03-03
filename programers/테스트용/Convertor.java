package programers.테스트용;
import java.util.*;

public class Convertor {
    public static String[] convertString(String str){
        return str.substring(1, str.length()-1).replace(" ", "").split(",");
    }

    public static int[] convertIntArray(String str) {
        return Arrays.stream(convertString(str)).mapToInt(Integer::valueOf).toArray();
    }

    public static String convertArray(String str) {
        return str.replace("[", "{").replace("]", "}");
    }

}
