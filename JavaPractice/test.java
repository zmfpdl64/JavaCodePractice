package JavaPractice;

import java.io.*;

public class test {

    private String answer = "";

    private boolean checkMap(String[][] inputMap) {
        int size = inputMap.length;
        String num = inputMap[0][0];

        for(int i = 0; i < inputMap.length; i++){
            for(int j = 0; j < inputMap.length; j++){
                if( !inputMap[i][j].equals(num) ){
                    divMap(inputMap);
                    return false;
                }
            }
        }
        answer += num;
        return true;
    }
    private void divMap(String[][] inputMap){
        int size = inputMap.length;
        answer += "(";
        String[][] map1 = new String[size/2][size/2];
        String[][] map2 = new String[size/2][size/2];
        String[][] map3 = new String[size/2][size/2];
        String[][] map4 = new String[size/2][size/2];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i < size/2 && j < size/2){
                    map1[i][j] = inputMap[i][j];
                }else if(i >= size/2 && j < size/2){
                    map2[i - size/2][j] = inputMap[i][j];
                }else if(i < size/2 && j >= size/2){
                    map3[i][j - size/2] = inputMap[i][j];
                }else{
                    map4[i-size/2][j-size/2] = inputMap[i][j];
                }
            }
        }
        checkMap(map1);
        checkMap(map3);
        checkMap(map2);
        checkMap(map4);
        answer += ")";
    }
    private void createString(String[][] inputMap) {

    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            test test = new test();
            int size = Integer.parseInt(input);
            String[][] map = new String[size][size];
            //1. 배열만들기
            for(int i = 0; i < size; i++){
                map[i] = br.readLine().split("");
            }
            //2. 0, 1로 2의 n승 자리 일치하는지 확인
            test.checkMap(map);
            //3. 맵 분할 함수
            //4. 일치했을 때 문자열 반환

            System.out.println(test.answer);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
