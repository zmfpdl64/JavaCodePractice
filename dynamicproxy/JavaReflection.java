package dynamicproxy;

import java.lang.reflect.*;

public class JavaReflection {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Person.class;

        Person p = new Person();

        Human person = (Human) Proxy.newProxyInstance(
                Human.class.getClassLoader(),
                new Class[]{Human.class},
                new MyProxyHandler(p));

        person.run();
        person.walk();
    }
}
