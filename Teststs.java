import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Teststs {
    public static void main(String[] args) {

        String[] strings = new String[] {"1", "2", "3"};
        Integer[] ints = Arrays.stream(strings).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);
        Arrays.stream(ints).forEach(System.out::println);

        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        run.run();
        Supplier<String> supplier = new Supplier<>() {
            @Override
            public String get() {
                return "get";
            }
        };



        new Function<String, String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        };


    }
}
