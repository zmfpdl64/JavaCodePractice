package programers.테스트용;

public class IsGoodAnswer {
    public static void isPass(int idx, int submit, int answer ){
        boolean flag = true;
        if(submit != answer) flag = false;
        printResult(idx, flag);
    }
    public static void isPass(int idx, int[] submit, int[] answer) {
        boolean flag = true;
        for(int i = 0; i < submit.length; i++) {
            if(submit[i] != answer[i]) flag  = false;
        }
        printResult(idx, flag);
    }
    public static void printResult(int idx, boolean flag) {
        if(flag) System.out.println(idx + " : " + "정답입니다");
        else System.out.println(idx + " : " + "틀렸습니다.");
    }

}
