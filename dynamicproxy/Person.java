package dynamicproxy;

public class Person implements Human {
    @Override
    public void run() {
        System.out.println("달리고 있다.");
    }

    @Override
    public void walk() {
        System.out.println("걷고 있다.");
    }

}
