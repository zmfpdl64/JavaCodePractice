package thisisjava.ch06.sec15;

public class SingletonExample {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.equals(singleton2));
    }
}
