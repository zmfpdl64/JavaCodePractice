package javastudy;
import java.util.*;
public class StreamTest {
    public static void main(String[] args) {
        String[] s = {"Hello", "World"};
        String[] _s = Arrays.stream(s)
                .map(i -> i.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toArray(String[]::new);
        for(String __s : _s) {
            System.out.printf(__s);
        }
    }
}
