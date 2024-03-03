package JavaPractice;

import java.util.HashMap;
import java.util.Map;

public class 해시테스트 {
    public static void main(String[] args) {
//        Integer a = new Integer(10);
//        Integer b = new Integer(10);
        Object a = new Object();
        Object b = new Object();
        System.out.println(a == b);
        System.out.println(System.identityHashCode(10));
        System.out.println(System.identityHashCode(10));
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.hashCode() + " : " + b.hashCode());
    }
}
