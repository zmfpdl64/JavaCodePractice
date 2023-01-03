import java.util.stream.IntStream;

public class hate_even{
    public static void main(String[] args) {
        hate_even s = new hate_even();
        s.solution(15000);
    }
    public int[] solution(int n){

        return new int[]{n / 5500, n % 5500};
    }
}