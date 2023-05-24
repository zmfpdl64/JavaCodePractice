package thisisjava.ch12.sec08;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeExample {
    public static void main(String[] args) {
        TimeZone zone = TimeZone.getDefault();
        Calendar calendar = Calendar.getInstance(zone);

        int ampm = calendar.get(Calendar.AM_PM);
        String strampm = null;
        if(ampm == Calendar.AM){
            strampm = "오전";
        }else{
            strampm = "오후";
        }
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println(strampm + " " + hour + "시 " + minute + "분 " + second + "초");

    }
}
