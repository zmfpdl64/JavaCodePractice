package programers.레벨3;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        String[] ins = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        for(int num : solution(ins)){
            System.out.println(num);
        }
    }
    public static int[] solution(String[] operations) {
        Queue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        Queue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(String operation : operations){
            operate(minQueue, maxQueue, operation);
        }
        Integer max = maxQueue.poll();
        Integer min = minQueue.poll();
        if(max == null || min == null){
            return new int[]{0, 0};
        }
        return new int[]{max, min};
    }
    // 추가, 삭제 연산
    public static void operate(Queue<Integer> minQueue, Queue<Integer> maxQueue, String str) {
        String[] ins = str.split(" ");
        int num = strToInteger(ins[1]);
        if(ins[0].equals("I")){
            minQueue.add(num);
            maxQueue.add(num);
        }else if(ins[0].equals("D")){
            if(num == 1 && !maxQueue.isEmpty()){
                int value = maxQueue.poll();
                minQueue.remove(value);
            }else if(num == -1 && !minQueue.isEmpty()){
                int value = minQueue.poll();
                maxQueue.remove(value);
            }
        }
    }

    // 문자열로 되어 있는 음수, 양수를 판독해 반환합니다.
    public static int strToInteger(String num) {
        if(num.charAt(0) == '-'){
            return -Integer.parseInt(num.substring(1, num.length()));
        }
        return Integer.parseInt(num);
    }
}

