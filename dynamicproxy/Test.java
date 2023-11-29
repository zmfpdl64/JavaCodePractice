package dynamicproxy;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int n = 10;
        List<Integer>[] lists = new LinkedList[n];
        for(int i = 0; i < lists.length; i++) {
            List<Integer> list = lists[i];

        }

    }

    public static void Thread(int a, int b){

    }
}

interface Orange{
    default void test() {
        System.out.println("orange1");
    }
}
interface Orange2{
    default void test() {
        System.out.println("orange2");
    }
}

class Go implements Orange2, Orange{
    public void test() {
    }
}
class OrangeImpl implements Orange{

}