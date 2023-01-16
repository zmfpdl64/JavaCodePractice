package thisisjava.ch07.example07;

public class Child extends Parent{
    public String name;

    public Child() {
        this("홍길동");
        System.out.println("Child() call");
    }

    public Child(String name) {
        super(); // 1번
        this.name = name; //2번
        System.out.println("Child(String name) call");
    }
}
