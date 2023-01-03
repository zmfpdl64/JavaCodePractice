import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindMiddle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++){
            nums.add(sc.nextInt());
        }
        Collections.sort(nums);
        Integer num = nums.get(nums.size() / 2);
        System.out.println(num);
    }
}
