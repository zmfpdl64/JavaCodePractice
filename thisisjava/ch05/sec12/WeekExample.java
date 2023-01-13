package thisisjava.ch05.sec12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class WeekExample {
    public static void main(String[] args) {
        Week today = null;

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);

        System.out.println(year + "년 "+ month + 1 + "월 " + day + "일 " + hour + "시 " + minute + "분 " + second + "초");
        int week = cal.get(Calendar.DAY_OF_WEEK);

        switch(week) {
            case 1: today = Week.SUNDAY; break;
            case 2: today = Week.MONDAY; break;
            case 3: today = Week.TUESDAY; break;
            case 4: today = Week.WENESDAY; break;
            case 5: today = Week.THURSDAY; break;
            case 6: today = Week.FRIDAY; break;
            default: today = Week.SATURDAY; break;
        }

        if(today == Week.SUNDAY) {
            System.out.println("일요일");
        }else {
            System.out.println("일요일 아니다.");
        }
    }
}
