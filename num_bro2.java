import java.util.ArrayList;

public class num_bro2 {
    public static void main(String[] args) {
        num_bro2 n = new num_bro2();
        System.out.println(n.Solution("100", "2345"));
        

    }
    
    public String Solution(String X, String Y) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        String answer = "";

        for(int i=0; i < 10; i++) {
            arr1.add(0);
            arr2.add(0);
        }
        for(int i=0; i < X.length(); i++) {
            int num = Character.getNumericValue(X.charAt(i));
            arr1.set(num, arr1.get(num)+1);
        }
        for(int i=0; i < Y.length(); i++) {
            int num = Character.getNumericValue(Y.charAt(i));
            arr2.set(num, arr2.get(num)+1);
        }
        for(int i = 9; i >= 0; i--){
            int num = Math.min(arr1.get(i), arr2.get(i));
            if( num!= 0){

            }
        }
        if(answer.isEmpty()){
            return "-1";
        }
        if (Integer.valueOf(answer) == 0) {
            return "0";
        } else {
            return answer;
        }
    }
}
