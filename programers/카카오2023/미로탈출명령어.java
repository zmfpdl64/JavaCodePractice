package programers.카카오2023;

/*
사전 순
d, l, r, u

*/
import java.util.*;
class 미로탈출명령어 {
    public static void main(String[] args) {
//        System.out.println( "2".compareTo("1"));
        solution(3, 4, 2, 3, 3, 1, 5);
    }
    static int[][] move = {
            {1, 0}, {0, -1}, {0, 1}, {-1, 0}
    };
    static String[] move_s = {
            "d", "l", "r", "u"
    };
    static Map<String, String> map = new HashMap<>();

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        int[][] viMap = new int[n+1][m+1];
        int dif = k - (Math.abs(x - r) + Math.abs(y - c));
        map.put("d1", "du");
        map.put("l1", "lr");
        map.put("r1", "rl");
        map.put("u1", "ud");

        if(isPossible(x, y, r, c, k)) return "impossible";
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, x, y, ""));
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.row == r && cur.col == c){
                answer = cur.s;
                break;
            }
            for(int i = 0; i < move.length; i++) {
                int nx = move[i][0] + cur.row;
                int ny = move[i][1] + cur.col;
                if(1 <= nx && nx <= n && 1 <= ny && ny <= m && (cur.time+1 < viMap[nx][ny] | viMap[nx][ny] == 0)){
                    viMap[nx][ny] = cur.time+1;
                    q.add(new Node(cur.time+1, nx, ny, cur.s + move_s[i]));
                }
            }
        }
        System.out.println(answer);

        answer = addLoad(answer, 0, x, y, n, m, k, dif, new StringBuffer());
        for(Map.Entry<String, String> entry: map.entrySet()){
            answer = answer.replace(entry.getKey(), entry.getValue());
        }

        System.out.println(answer);
        return answer;
    }
    //  "d", "l", "r", "u"
    /*
        d <-> u
        l <-> r
     */
    public static String addLoad(String load, int curIdx,int x, int y, int n, int m, int k, int dif, StringBuffer sb) {
        String result = "";

        if(dif == 0){
            return sb.toString();
        }
        String s = load.substring(curIdx, curIdx+1);
        for(int i = 0; i < move.length; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            int count = 0;
            if(1 <= nx && nx <= n && 1 <= ny && ny <= m &&s.compareTo(move_s[i]) > 0 && count < (dif/2)){
                sb.append(move_s[i]+ "1");
                count++;
                while(1 <= nx && nx <= n && 1 <= ny && ny <= m &&s.compareTo(move_s[i]) > 0 && count < (dif/2)){
                    nx += move[i][0];
                    ny += move[i][1];
                    sb.append(move_s[i]+ "1");
                    count++;
                }
                dif -= count*2;
            }

        }
        if(dif > 0){
            sb.append(s);
            result = addLoad(load, curIdx+1, x, y, n, m, k, dif, sb);
        }else{
            for(int i = curIdx; i < load.length(); i++) {
                sb.append(load.substring(i, i+1));
            }
            result = sb.toString();
        }
        return result;

    }
    public static boolean isPossible(int x, int y, int r, int c, int k) {
        int len = Math.abs(x - r) + Math.abs(y - c);
        if(len > k) return false;
        return len % 2 != k % 2;
    }

}

class Node {
    int time;
    int row;
    int col;
    String s;
    public Node(int time, int row, int col, String s){
        this.time = time;
        this.row = row;
        this.col = col;
        this.s = s;
    }
}