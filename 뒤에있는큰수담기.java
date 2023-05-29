import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 뒤에있는큰수담기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,3,5}));
        System.out.println(solution(new int[]{9,1,5,3,6,2}));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        List<Integer> map = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && map.get(stack.peek()) < map.get(i)){
                answer[stack.pop()] = map.get(i);
            }
            stack.push(i);
        }
        Arrays.stream(answer).boxed().forEach(System.out::println);
        return answer;
    }
}
