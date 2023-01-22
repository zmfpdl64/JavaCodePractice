package thisisjava.ch08.sec02;

public class Television implements RemoteController{
    private int currentVolume = 0;
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV가 꺼졌습니다.");
    }

    @Override
    public void setVolume(int volume) {
        if( MAX_VOLUME >= volume && MIN_VOLUME <= volume)
        {
            this.currentVolume = volume;
            System.out.println("볼륨이 " + volume + "로 조정되었습니다.");
        }else {
            System.out.println("볼륨의 크기가 범위에 맞지않습니다.");
        }
    }
}
