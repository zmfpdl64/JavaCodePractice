package thisisjava.ch08.sec02;

import java.awt.*;
import java.util.ArrayList;

public interface RemoteController {
    final int MAX_VOLUME = 10;
    final int MIN_VOLUME = 0;
    public void turnOn();
    public void turnOff();
    public void setVolume(int volume);

    private void printMessage(){
        System.out.println("기본 메시지 출력");
    }
    default void printMessage(String message){
        System.out.println("기본 메시지 출력 + " + message);
    }


    static void printAnyway() {
        System.out.println("아무거나 출력");
    }

    public default void Mute(boolean mute) {
        if(mute) {
            System.out.println("무음 처리합니다.");
            setVolume(MIN_VOLUME);
        }else {
            System.out.println("무음을 해제합니다.");
        }

    }
}
