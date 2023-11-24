package sort;
import java.util.*;

public class BasicSort {
    public static void main(String[] args) {
        integerSort();
        stringSort();
        stringLenSort();
        pointSort();
    }

    public static void integerSort(){
        Integer[] ints = new Integer[]{1, 5, 2, 3, 4};

        Arrays.sort(ints, (i1, i2) -> i2 - i1);
        for(Integer i : ints) {
            System.out.println(i);
        }
        System.out.println();
    }
    public static void stringSort() {
        String[] strings = new String[]{"apple", "lemon", "orange", "mango", "banana"};
        Arrays.sort(strings, Comparator.reverseOrder());
        for(String s : strings) {
            System.out.println(s);
        }
        System.out.println();
    }
    public static void stringLenSort() {
        String[] strings = new String[]{"apple", "lemon", "orange", "mango", "banana"};
        Arrays.sort(strings, (s1, s2) -> s1.length() - s2.length());
        for(String s : strings) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void pointSort() {
        Point[] points = new Point[]{
                new Point(1, 2),
                new Point(1, 4),
                new Point( 2, -1),
                new Point(-1, 5)
        };
        Arrays.sort(points,
                Comparator.comparing
                (
                    Point::getX,
                    Comparator.reverseOrder()
                )
                .thenComparing(Point::getY)
        );
        for(Point p : points) {
            System.out.println(p);
        }
    }
}

class Point{
    Integer x;
    Integer y;
    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " : " + y;
    }
}