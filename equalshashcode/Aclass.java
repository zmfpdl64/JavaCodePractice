package equalshashcode;

public class Aclass {
    public static void main(String[] args) {
        B b = new B();
        b.test();
    }
}

class B extends C implements A{
}
class C {
    public void test() {
        System.out.println("c");
        return;
    }
}
interface A {
    default void test(){
        System.out.println("a");
        return ;
    };
}

