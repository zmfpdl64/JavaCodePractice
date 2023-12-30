public class ExceptionTest {
    public static void main(String[] args) {
        ifElse();
        throwCatch();

    }

    public static void ifElse(){
        long start = System.nanoTime();
        for(int i =0; i < 10_000; i++) {
            if(true){
                continue;
            }
        }
        long end = System.nanoTime();
        System.out.println("걸린 시간: " + (end-start));
    }

    public static void throwCatch(){
        long start = System.nanoTime();
        for(int i =0; i < 10_000; i++) {
            try {
                throw new RuntimeException();
            }catch (RuntimeException e) {
                continue;
            }
        }
        long end = System.nanoTime();
        System.out.println("걸린 시간: " + (end-start));
    }

}
