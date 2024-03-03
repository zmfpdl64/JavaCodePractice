package programers.카카오2023;

public class 표현가능한이진트리 {

    public static void main(String[] args) {
//        long[] arr = new long[] {7, 42, 5};
//        long[] arr = new long[] {122};
//        long[] arr = new long[] {63, 111, 95};
//        long[] arr = new long[] {95};
        for(int i : solution(new long[]{111})){
            System.out.println(i);
        }
//        long[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 128, 129, 16512, 2147516555L};
//        int[] ans = {1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1};
//        int[] result = solution(arr);
//        for(int i = 0; i < ans.length; i++) {
//            System.out.println(i+1 + " : " + (ans[i] == result[i]));
//            System.out.println(ans[i] + " : " + result[i]);
//        }
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            String _num = tenToBin(num);
            System.out.println(_num);
            if(_num.charAt((_num.length()-1)/2) == '1' && isTree(_num, 0, _num.length()-1, '1')) answer[i] = 1;
        }
        return answer;
    }
    public static String tenToBin(long num) {
        StringBuffer bf = new StringBuffer();

        while(num != 0) {
            long mod = num % 2;
            num /= 2;
            bf.append(mod);
        }
        return bf.reverse().toString();
    }

    public static boolean isTree(String num, int start, int end, Character prev){

        int mid = (start + end) / 2;
        Character c = num.charAt(mid);

        if(prev == '0' && c == '1'){
            return false;
        }
        if(start >= end) return true;

        if(!isTree(num, start, mid-1, c))
            return false;
        if(!isTree(num, mid+1, end, c))
            return false;
        return true;
    }
}
