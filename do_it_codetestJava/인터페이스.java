package do_it_codetestJava;

public interface 인터페이스 {
    public  static final int a = 10;
    default void sayHello(){
        System.out.println("hello");
    }
    void test();
}

class Human implements 인터페이스{
    @Override
    public void test() {

    }
}

class Test1{
    public static void main(String[] args) {
        인터페이스 h = new Human();
        h.sayHello();
    }
}