package programers.레벨1;
import java.util.*;
import java.util.stream.IntStream;

public class 모의고사 {
    public static void main(String[] args) {
        int NUM = 10_000_000;
        int[] pr = new int[NUM];
        for(int i = 0; i < NUM; i++) {
            pr[i] = i % 5 + 1;
        }
        long startTime = System.currentTimeMillis();
        solution(pr);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }
//    public static int[] solution(int[] answer) {
//        int[] a = {1, 2, 3, 4, 5};
//        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
//        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
//        int[] score = new int[3];
//        for(int i=0; i<answer.length; i++) {
//            if(answer[i] == a[i%a.length]) {score[0]++;}
//            if(answer[i] == b[i%b.length]) {score[1]++;}
//            if(answer[i] == c[i%c.length]) {score[2]++;}
//        }
//        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
//        ArrayList<Integer> list = new ArrayList<>();
//        if(maxScore == score[0]) {list.add(1);}
//        if(maxScore == score[1]) {list.add(2);}
//        if(maxScore == score[2]) {list.add(3);}
//        return list.stream().mapToInt(i->i.intValue()).toArray();
//    }
    public static int[] solution(int[] answers) {
        int[] math_1 = new int[] {1,2,3,4,5};
        int[] math_2 = new int[] {2,1,2,3,2,4,2,5};
        int[] math_3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[][] maths = new int[][]{math_1, math_2, math_3};
        int[] answer = {0, 0, 0};

        for(int i = 0; i < answers.length; i++) {
            int num = answers[i];
            for(int j = 0; j < maths.length; j++) {
                int mathNum = maths[j][i % maths[j].length];
                if(num == mathNum){
                    answer[j]++;
                }
            }
        }
        int max = Arrays.stream(answer).max().getAsInt();
        for(int num : answer){
            System.out.println(num);
        }

        return IntStream.range(0, answer.length).filter(idx -> max == answer[idx]).map(num -> num+1).toArray();
    }
}
