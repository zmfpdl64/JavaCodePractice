import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Teststs {
    public static void main(String[] args) {
        for(int i = 0; i < 1_000_000; i++) {
            System.out.print(1_000_000 + " ,");
        }

    }
}

interface  A {
    void test();
}
class AChild implements A{
    public void test() {
        System.out.println("i'm Achild");
    }
}
class BChild implements A{
    @Override
    public void test() {
        System.out.println("i'm BChild");
    }
}