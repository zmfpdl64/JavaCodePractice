package javastudy;

import java.util.*;

public class 리스코프치환 {
    public static void main(String[] args) {
        A_ a = new A();
        a.print();
        AbstractList<Integer> list = new LinkedList<>();
        AbstractList<Integer> q = new ArrayList<>();
        list.add(10);
        list.add(20);
        Integer remove = list.remove(0);
        q.add(10);
        q.add(20);
        Integer remove1 = q.remove(0);
        System.out.println(remove + " : " + remove1);
    }
}


interface A_{
    void print();
}

class A implements A_{
    public void print(){
        System.out.println("print");
        hello();
    }
    private void hello() {
        System.out.println("hello");
    }
}

class Rectangle {
    int width;
    int height;
    public void setWidth(int width){
        width = width;
        height = width;
    }
    public void setHeight(int height) {
        height = height;
        width = height;
    }
    public int getArea() {
        return width * height;
    }
}
class Square extends Rectangle{

}