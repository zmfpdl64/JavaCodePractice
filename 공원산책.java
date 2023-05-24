public class 공원산책 {

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int x = 0;
        int y = 0;
        boolean found = false;
        for(int i = 0; i < park.length; i++) {
            for( int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    x = i;
                    y = j;
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        for(String move: routes){
            String[] pos = move.split(" ");
            String direct = pos[0];
            Integer amount = Integer.parseInt(pos[1]);
            System.out.println(direct + amount);
            boolean suc = true;
            Integer mx = x;
            Integer my = y;
            if(direct.equals('N')){
                for(int i = x; x-amount < i ; i--){
                    if(i < 0 || park[i].charAt(y) == 'X'){
                        suc = false;
                        break;
                    }
                }
            }else if(direct.equals('E')){
                for(int i = y; y+amount > i ; i++){
                    if(i >= park[x].length() || park[x].charAt(i) == 'X'){
                        suc = false;
                        break;
                    }
                }
            }else if(direct.equals('S')){
                for(int i = x; x+amount > i ; i++){
                    if(i >= park.length || park[i].charAt(y) == 'X'){
                        suc = false;
                        break;
                    }
                }

            }else{
                for(int i = y; y+amount > i; i++) {
                    if(i < 0 || park[x].charAt(i) == 'X'){
                        suc = false;
                        break;
                    }
                }
            }
            if(suc){
                System.out.println(suc);
                System.out.println(x + " : " + y);
                if(direct.equals('N')){
                    x -= amount;
                }else if(direct.equals('S')){
                    x += amount;
                }else if(direct.equals('E')){
                    y += amount;
                }else{
                    y -= amount;
                }

            }
        }

        return new int[]{x, y};
    }
}
