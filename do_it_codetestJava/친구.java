package do_it_codetestJava;

// https://www.acmicpc.net/problem/1058

// 그래프
import java.util.*;
import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class 친구 {
    static Map<Integer, List<Integer>> maps = new TreeMap<>();
    static List<Integer> friends = new ArrayList<>();
    static Integer answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            String[] ins = reader.readLine().split("");
            List<Integer> container = new CopyOnWriteArrayList<>();
            friends.add(0);
            maps.put(i, container);
            for(int j = 0; j < ins.length; j++) {
                if(ins[j].equals("Y")){
                    container.add(j);
                }
            }
        }
        for(int k = 0; k < maps.size(); k++) {
            dfs(k);
        }
        for(int i = 0; i < n; i++) {
            answer = Math.max(maps.get(i).size() + friends.get(i), answer);
        }

        System.out.println(answer);
    }

    public static void dfs(int cur){
        List<Integer> list = maps.get(cur);
        for(int i = 0; i < list.size(); i++) {
            Integer pos1 = list.get(i);
            List<Integer> list1 = maps.get(pos1);
            for(int j = i+1; j < list.size(); j++) {
                Integer pos2 = list.get(j);
                List<Integer> list2 = maps.get(pos2);
                setAdd(list1, pos2);
                setAdd(list2, pos1);
            }
        }
    }

    public static void setAdd(List<Integer> list, Integer num) {
        if(!list.contains(num)){
            friends.set(num, friends.get(num)+1);
        }
    }

}
