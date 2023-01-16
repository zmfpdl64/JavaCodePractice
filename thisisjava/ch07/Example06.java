package thisisjava.ch07;

public class Example06 {
    class Parent{
        private String name;

        public Parent(String name) {
            this.name = name;
        }
    }
    class Child extends Parent{
        public int studentNo;

        public Child(String name, int studentNo) {
            super(name);
            this.studentNo = studentNo;
        }
    }
}
