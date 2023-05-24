package JavaPractice;

import java.util.*;

//17시 37분
class TimeSolution {
    private static final int MONTH = 12;
    private static final int DAY = 30;
    private static final int HOUR = 24;


    boolean fail = false;
    int days = 1;

    public int[] solution(String s, String[] times) {
        List<Integer[]> map = new ArrayList<>();

        Integer[] date = Arrays.stream(s.split(":")).map(Integer::valueOf).toArray(Integer[]::new);
//        for(int i =0; i < date.length; i++){
//            System.out.println(date[i]);
//        }
        map.add(date);
//        System.out.println(Arrays.toString(date));
        for(int i = 0; i < times.length; i++){
            Integer[] integers = cal_date(times[i], map.get(i));
            map.add(integers);
        }
        for (int i = 0; i < map.size(); i++){
            System.out.println(Arrays.toString(map.get(i)));
        }
        for(int i = 0; i < map.size()-1; i++){
            Integer[] time1 = map.get(i);
            Integer[] time2 = map.get(i+1); // 2, 3, 4, 5 : 일 시 분 초
            compare_time(time1, time2);
        }
        if(fail){
            return new int[]{0, days};
        }
        return new int[]{1, days};

    }

    private void compare_time(Integer[] time1, Integer[] time2) {
        int gettime1 = gettime(time1);
        int gettime2 = gettime(time2);
        if(gettime1 == gettime2 -1){
            days += 1;
        }else if(gettime1 == gettime2){

        }else{
            fail = true;
            days += 1;
        }

    }

    private int gettime(Integer[] time) {
        int year = time[0] * MONTH * DAY;
        int month = time[1] * DAY;
        int day = time[2];
        return year + month + day;
    }

    private Integer[] cal_date(String times, Integer[] clone) {
        Integer[] time = Arrays.stream(times.split(":")).map(Integer::valueOf).toArray(Integer[]::new);
        Integer[] date = clone.clone();
        date[2] += time[0];
        date[3] += time[1];
        date[4] += time[2];
        date[5] += time[3];
            // 일 : 시 : 분 : 초
        if(date[5] > 59){
            date[4] += date[5]/60;
            date[5] %= 60;
        }
        if(date[4] > 59){ // 0 ~ 59
            date[3] += date[4]/60;
            date[4] %= 60;
        }
        if (date[3] > 23){ // 0 ~ 23
            date[2] += date[3]/24;
            date[3] %= 24;
        }
        if(date[2] > 30){ // 1 ~ 29
            date[1] += date[2]/30;
            date[2] %= 30;
        }
        if(date[1] > 12){
            date[0] += date[1]/13;
            date[1] %= 13;
        }

        return date;
    }

    public static void main(String[] args) {
        String date = "2021:04:12:16:08:35";
        String[] times = new String[]{"01:06:30:00", "01:00:12:00"};
//        String[] times2 = new String[]{"01:12:30:00", "01:12:30:00"};
        TimeSolution s = new TimeSolution();
        int[] result = s.solution(date, times);
//        int[] result2 = s.solution(date, times2);
        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(result2));

    }

}