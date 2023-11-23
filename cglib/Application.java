package cglib;

import java.lang.reflect.InvocationHandler;

public class Application {
    public static void main(String[] args) {
        Student student = new Student();
        Handler handler = new Handler(student);


    }
}


