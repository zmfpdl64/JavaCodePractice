// 19시 57분
// 20시 13분 16분
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.math.*;

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = 0;
        int maxy = 0;

        int[] answer = {};

        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minx = Math.min(minx, i);
                    maxx = Math.max(maxx, i);
                    miny = Math.min(miny, j);
                    maxy = Math.max(maxy, j);
                }
            }
        }
        return new int[]{minx,miny,maxx+1,maxy+1};
    }
}
