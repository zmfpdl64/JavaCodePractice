package do_it_codetestJava;

import java.util.*;
import java.io.*;
public class 킹2 {

    private static Map<String, Integer[]> moves = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ins = reader.readLine().split(" ");
        int n = Integer.parseInt(ins[2]);

        moves.put("R", new Integer[]{0, 1});
        moves.put("L", new Integer[]{0, -1});
        moves.put("B", new Integer[]{-1, 0});
        moves.put("T", new Integer[]{1, 0});
        moves.put("RT", new Integer[]{1, 1});
        moves.put("LT", new Integer[]{1, -1});
        moves.put("RB", new Integer[]{-1, 1});
        moves.put("LB", new Integer[]{-1, -1});


        Instance king = new Instance(ins[0]);
        Instance dol = new Instance(ins[1]);
        for(int i =0; i < n; i++) {
            String nexS = reader.readLine();
            Integer[] nexI = moves.get(nexS);

            Instance copyKing = new Instance(king);
            Instance copyDol = new Instance(dol);

            try{
                dol.move(king, nexI);
                king.move(nexI);

            }catch(RuntimeException e) {
                king = copyKing;
                dol = copyDol;
            }
        }
        System.out.println(king.curPosition());
        System.out.println(dol.curPosition());
    }


}
class Instance{
    private int x; // row
    private int y; // col
    private int SIZE = 8;
    Character[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8};



    public Instance(String position) {
        for(int i = 0; i < chars.length; i++) {
            if(position.charAt(0) == chars[i]){
                this.y = ints[i];
                break;
            }
        }
        this.x = Character.getNumericValue(position.charAt(1));
    }

    public Instance(Instance instance) {
        this.x = instance.getX();
        this.y = instance.getY();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public String curPosition() {
        return chars[getY()-1]+String.valueOf(getX());
    }
    public void setX(int move) {
        int nx = move + x;
        if(0< nx && nx <= SIZE) {
            this.x = nx;
            return;
        }
        throw new RuntimeException();
    }

    public void setY(int move) {
        int ny = move + y;
        if(0< ny && ny <= SIZE) {
            this.y = ny;
            return;
        }
        throw new RuntimeException();
    }
    public void move(Integer[] move) {
        setX(move[0]);
        setY(move[1]);
    }
    public void move(Instance king, Integer[] move) {
        if (king.getX() + move[0] == this.x && king.getY() + move[1] == this.y) {
            move(move);
        }
    }
}