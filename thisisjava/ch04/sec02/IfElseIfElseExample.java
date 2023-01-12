package thisisjava.ch04.sec02;

import org.w3c.dom.ranges.RangeException;

/**
 *  0 <= N <= 100
 *  90점 이상 A
 *  80점 이상 B
 *  70점 이상 C
 *  70점 미만 D
 */

public class IfElseIfElseExample {
    public static void main(String[] args) {

        int score = 77;

        try {
            if(score > 100 || score < 0) {
                throw new IllegalStateException("범위를 벗어났습니다.");
            }
            if (score >= 90) {
                System.out.println("A");
            } else if (score >= 80) {
                System.out.println("B");
            } else if (score >= 70) {
                System.out.println("C");
            } else {
                System.out.println("D");
            }
        }catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

