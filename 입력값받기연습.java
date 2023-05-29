import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 입력값받기연습 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> collect = Arrays.stream(input.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);


    }
}
