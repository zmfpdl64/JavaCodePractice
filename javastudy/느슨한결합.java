package javastudy;

public class 느슨한결합 {
    public static void main(String[] args) {
        Basic basic = new BasicImpl(10, 20);
        Basic basic2 = new BasicImpl2(10, 20);
        Basic basic3 = new BasicImpl3(10, 20);



        plus(basic);
        plus(basic2);
        plus(basic3);

        mulitiplex((Deep) basic);
        mulitiplex((Deep) basic2);
        mulitiplex((Deep) basic3);
    }
    public static void plus(Basic basic) {
        System.out.println(basic.plus());
    }

    public static void mulitiplex(Deep deep) {
        System.out.println(deep.multiplex());
    }



}


interface Basic {
    Integer plus();
    Integer subtraction();
}

interface Deep {
    Integer multiplex();
    Integer division();
}

class BasicImpl implements Basic, Deep{
    public BasicImpl(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Integer a;
    public Integer b;

    @Override
    public Integer plus() {
        return a + b;
    }

    @Override
    public Integer subtraction() {
        return a - b;
    }

    @Override
    public Integer multiplex() {
        return a * b;
    }

    @Override
    public Integer division() {
        return a / b;
    }
}
class BasicImpl2 implements Basic, Deep{
    public Integer a;
    public Integer b;

    public BasicImpl2(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer plus() {
        return a + b + 1;
    }

    @Override
    public Integer subtraction() {
        return a - b - 1;
    }

    @Override
    public Integer multiplex() {
        return a * b * 2;
    }

    @Override
    public Integer division() {
        return a / b / 2;
    }
}
class BasicImpl3 extends BasicImpl2 {

    public BasicImpl3(Integer a, Integer b) {
        super(a, b);
    }

    @Override
    public Integer plus() {
        return a + b;
    }

    @Override
    public Integer subtraction() {
        return a - b;
    }
}