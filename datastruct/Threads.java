package datastruct;

import java.lang.reflect.Field;

public class Threads {
    public static void main(String[] args) throws Exception {
        BoundedBuffer buffer = new BoundedBuffer();

        Field count = buffer.getClass().getDeclaredField("count");
        count.setAccessible(true);
        count.set(buffer, -1);

        System.out.println(buffer.getCount());
    }

//    public static void monitor(){
//        BoundedBuffer buffer = new BoundedBuffer();
//        Thread consumer = new Thread(() -> {
//            buffer.consume();
//        });
//        Thread produce = new Thread(() -> {
//            buffer.produce(100);
//        });
//        produce.start();
//        consumer.start();
//
//        produce.join();
//        consumer.join();
//        System.out.println("완료");
//    }
}

class BoundedBuffer {
    private final int[] buffer = new int[5];
    private int count = 0;
    public synchronized void produce(int item)   {
        while(count == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        buffer[count++] = item;
        notifyAll();
    }
    public void consume()   {
        int item = 0;
        synchronized (this) {
            while (count == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            item = buffer[--count];
            notifyAll();
            System.out.println("Consume :" + item);
        }
    }
    public int getCount(){
        return count;
    }
}