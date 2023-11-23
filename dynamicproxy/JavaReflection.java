package dynamicproxy;

import java.lang.reflect.*;

public class JavaReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Person.class;

        Person p = new Person();



        RunMethod person = (RunMethod) Proxy.newProxyInstance(RunMethod.class.getClassLoader(), new Class[]{RunMethod.class}, new MyProxyHandler(p));

        person.logging();

    }
}
