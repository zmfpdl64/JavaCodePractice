package thisisjava.ch08.sec02;

public class Example {
    public static void main(String[] args) {
        RemoteController rc = null;

        rc = new Television();
        rc.turnOn();
        rc.turnOff();
        rc.setVolume(5);
        rc.Mute(true);
        rc.Mute(false);

        rc = new Audio();
        rc.turnOn();
        rc.turnOff();
        rc.setVolume(5);

        rc.setVolume(11);

    }
}
