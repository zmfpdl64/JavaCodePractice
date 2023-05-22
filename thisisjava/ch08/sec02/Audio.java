package thisisjava.ch08.sec02;

public class Audio implements RemoteController{
    private int currentVolume = 0;
    private int memoryVolume;

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
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

    @Override
    public void Mute(boolean mute) {
        if(mute) {
            this.memoryVolume = this.currentVolume;
            System.out.println("무음 처리됩니다.");
            setVolume(MIN_VOLUME);
        }else {
            this.currentVolume = this.memoryVolume;
            System.out.println("무음이 해제됩니다.");
            setVolume(this.memoryVolume);
        }
    }

    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");

    }
}
