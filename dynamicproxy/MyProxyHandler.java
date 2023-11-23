package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyHandler implements InvocationHandler {
    private final Object target;

    public MyProxyHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("========측정 시작==========");
        long startTime = System.nanoTime();

        Object result = method.invoke(target, args);

        long endTime = System.nanoTime();
        long resultTime = endTime - startTime;
        System.out.println("로깅 :"+ resultTime + " ns");
        System.out.println("===========측정 종료===========");

        return result;
    }
}
