package thisisjava.ch08.sec08;

public class SearchImpl implements SearchUrl, RemoteController{
    @Override
    public void turnOn() {
        System.out.println("켜졌다.");
    }

    @Override
    public void turnOff() {
        System.out.println("꺼졌다.");
    }

    @Override
    public void search(String url) {
        System.out.println(url + "을 검색합니다.");
    }
}
