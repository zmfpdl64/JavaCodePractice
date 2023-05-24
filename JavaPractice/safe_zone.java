package JavaPractice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class safe_zone {
    public static void main(String[] args) {
        
    }
    public int solution(int[][] board) {
        int answer = 0;
        int[][] fire_zone = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j <board[i].length; j++){
                if(board[i][j] == 1) {
                    for(int k = 0; k < 8; k++){
                        int move_x = j + fire_zone[k][0];
                        int move_y = i + fire_zone[k][1];
                        if(move_x >= board[i].length|| move_x < 0 || move_y >= board.length || move_y < 0){
                            continue;
                        }
                        else{
                            if(board[move_y][move_x] != 1)
                                board[move_y][move_x] = 2;
                        }
    
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 0)
                    answer +=1;
            }
        }
        return answer;
    }
}
