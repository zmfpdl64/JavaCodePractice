package dynamicproxy;

public class Person implements RunMethod {
    @TargetAnotation
    public void run() {
        System.out.println("달리고 있다.");
    }

    @Override
    public void logging() {

    }
}
