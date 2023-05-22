package thisisjava.ch08.sec08;

public class Example {
    public static void main(String[] args) {
        SearchImpl si = new SearchImpl();
        si.turnOn();
        si.search("https://www.youtube.com");
        si.turnOff();
    }
}
