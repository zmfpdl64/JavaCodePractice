package JavaPractice;

import java.util.Scanner;

public class RockPaperScissors {
    static final int ROCK = 2;
    static final int SICSSOR = 1;
    static final int PAPER = 3;
    static final boolean WIN = true;
    static final boolean LOSE = false;





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 1; i <= t; i++){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            Gamer gamerA = new Gamer(A);
            Gamer gamerB = new Gamer(B);
            if(gamerA.compare(gamerB.state) == WIN){
                System.out.println("A");
            }else
                System.out.println("B");
        }
    }
    static class Gamer {
        public final int state;
        public boolean win = false;

        public Gamer(Integer state){
            this.state = state;
        }
        public boolean compare(Integer opponent_state){
            if(state == ROCK){
                if(opponent_state == SICSSOR){
                    return WIN;
                }
                return LOSE;
            }
            if(state == SICSSOR){
                if(opponent_state == ROCK){
                    return LOSE;
                }
                return WIN;
            }
            if(opponent_state == ROCK){
                return WIN;
            }
            return LOSE;
        }
    }
}
