import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 18시 55분
public class 연속부분수열합의갯수 {
    public static void main(String[] args) {
        int[] arr = new int[]{7,9,1,1,4};
        System.out.println(solution(arr));
    }
    public static int solution(int[] elements) {
        class LinkedList1<E> extends LinkedList<E>{

            @Override
            public E get(int index) {
                int max = this.size();
                if(index < 0){
                    return super.get(max+index);
                }
                return super.get(index);
            }
        }
        int answer = 0;
        Set<Integer> set = new HashSet<>();


        LinkedList1<Integer> lists = new LinkedList1<>();
        for(Integer i : elements){
            lists.add(i);
        }
        System.out.println(-10 % 2);

        return answer;
    }
}
