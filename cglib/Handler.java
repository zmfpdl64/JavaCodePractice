package cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {
    private final Object object;

    public Handler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("========측정 시작==========");
        long startTime = System.nanoTime();

        Object result = method.invoke(object, args);

        long endTime = System.nanoTime();
        long resultTime = endTime - startTime;
        System.out.println("로깅 :"+ resultTime + " ns");
        System.out.println("===========측정 종료===========");

        return result;
    }
}
