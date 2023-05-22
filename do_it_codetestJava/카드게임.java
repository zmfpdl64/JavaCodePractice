package do_it_codetestJava;

import java.util.*;
import java.util.stream.Collectors;

public class 카드게임 {

    public static void main(String[] args) {
        solution();
    }
    public static void solution(){
        class Myobj{
            public Myobj(int a, int b, String c){
                this.a = a;
                this.b = b;
                this.c = c;
            }
            public int a;
            public int b;
            public String c;
        }
        List<Myobj> lists = new ArrayList<>();
        lists.add(new Myobj(1, 2, "3"));
        lists.add(new Myobj(2, 1, "5"));
        lists.add(new Myobj(2, 3, "6"));
        lists.sort(Comparator.comparing(o -> o.a));
        lists.sort(Comparator.comparing((Myobj o) -> o.a).reversed()
                .thenComparing(Comparator.comparing((Myobj o) -> o.b).reversed())
                .thenComparing((o1, o2) ->
                        o2.c.toLowerCase().compareTo(o1.c.toLowerCase())
        )
        );
        for(Myobj o : lists){
            System.out.println(o.a + " : " + o.b + " : " + o.c);
        }

    }
}
