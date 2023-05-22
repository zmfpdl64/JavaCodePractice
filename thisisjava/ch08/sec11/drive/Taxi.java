package thisisjava.ch08.sec11.drive;

public class Taxi implements Vehicle{
    @Override
    public void run() {
        System.out.println("택시가 달립니다.");
    }
}
