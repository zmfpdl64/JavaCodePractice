package thisisjava.ch08.sec11.drive;


public class Example {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Taxi taxi = new Taxi();
        Vehicle bus = new Bus();
        driver.drive(taxi);
        driver.drive(bus);
    }
}
