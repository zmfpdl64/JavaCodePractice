package do_it_codetestJava;

public abstract class 추상클래스 {
    protected int a;
    protected int b;
    public void total() {
        System.out.println( a + b );
    }

    public static void sayHello(){
        System.out.println("hello");
    }
    public abstract void setA(int a);
    public abstract void setB(int b);
}

class 추상자식 extends 추상클래스 {
    @Override
    public void setA(int a) {
        this.a = a;
    }

    @Override
    public void setB(int b) {
        this.b = b;
    }
}
class Test {
    public static void main(String[] args) {
        추상클래스 a = new 추상자식();
        a.setA(10);
        a.setB(20);
        a.total();
    }
}
