package datastruct;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;

public class ListStruct {
    public static void main(String[] args) throws InterruptedException {

//        arrayListToLinkedList();
//        Point point = new Point();
//        logging(Point::getX, point);
        Thread[] threads = new Thread[10];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ": 종료");
                }
            });
            threads[i].start();


        }
        while(true) {
            for(int i = 0; i < threads.length; i++) {
                Thread.State state = threads[i].getState();
                System.out.println(i + " : " + state);
                if(state == Thread.State.WAITING || state == Thread.State.TERMINATED) {
                    threads[i].start();
                }
                System.out.println(threads[i].getState());
                System.out.println();
            }
        }

    }

    public static void ArrayToList() {
        String[] strings = new String[]{"1", "2", "3", "4", "5"};
        List<String> stringList = new LinkedList<>(Arrays.asList(strings));

        for(String s : stringList) {
            System.out.println(s);
        }
    }
    public static void arrayListToLinkedList() {
        Consumer<List<Integer>> consumer = (i1) -> {
            for(int i = 0; i < 10_000; i++) {
                i1.add(i);
            }
        };

        List<Integer> arrayList = new ArrayList<>();
        logging(consumer, arrayList);
        List<Integer> linkedList = new LinkedList<>(arrayList);
        logging(consumer, linkedList);
    }

    public static <T> void logging(Consumer<T> c, T t) {
        System.out.println("============측정 시작===========");
        long startTime = System.nanoTime();
        c.accept(t);
        long endTime = System.nanoTime();
        System.out.println("측정 시간: " + (endTime - startTime) + " ms");
        System.out.println("==========측정 종료===========");
    }

    public static void stringToCharacter(){
        List<String> lists = new ArrayList<>(Arrays.asList("A","B","C"));
        for(String s : lists) {
            int ascii = (int) s.charAt(0);
            char s1 = (char) ascii;

            System.out.println(ascii);
            System.out.println(s1);
        }
    }
    public static void CharacterToNumericInt() {
        List<String> lists = new ArrayList<>(Arrays.asList("1","2","3"));
        for(String s : lists){
            int num = Character.getNumericValue(s.charAt(0));
            System.out.println(num);
        }
    }
}

class Point {
    int x = 10;
    int y = 20;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

interface TriFunction<T, U, V, R> extends Consumer<T>{
    public R apply(T t, U u, V v);
}