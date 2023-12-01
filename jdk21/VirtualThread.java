package jdk21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class VirtualThread {
    public static Integer threadCount = 50_000;
    public static void main(String[] args) {
//        virtualThread();
        threads();
    }
    public static void threads() {
        long startTime = System.nanoTime();

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for(int i = 0; i < threadCount; i++) {
            executorService.submit(new Run(i));
        }

        long endTime = System.nanoTime();
        System.out.println("시간: " + (endTime- startTime) + "ns");

    }
//    public static void virtualThread() {
//        long startTime = System.nanoTime();
//        for(int i = 0; i < threadCount; i++) {
//            Thread.startVirtualThread(new Run(i));
//        }
//        long endTime = System.nanoTime();
//
//        System.out.println("시간: " + (endTime- startTime) + "ns");
//    }
}
class Run implements Runnable{
    Integer i;
    public Run(Integer i) {
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(i + " : " + "Inside Runnable");
    }
}