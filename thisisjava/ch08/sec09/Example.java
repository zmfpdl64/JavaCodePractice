package thisisjava.ch08.sec09;

public class Example {
    public static void main(String[] args) {
        InterfaceImplC implc = new InterfaceImplC();

        interfaceA ia = implc;
        ia.methodA();

        interfaceB ib = implc;
        ib.methodB();

        interfaceC ic = implc;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
