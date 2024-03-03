package programers.카카오2021;
/*

코팅 언어 cpp, java, python


각 질문들에 대해 지원자 수 반환하기

질문 10만
nlogn 까지 가능

*/
import java.util.*;
import java.util.concurrent.*;

class 순위검색 {
    static String[] lan = {"cpp", "java", "python", "-"};
    static String[] job = {"backend", "frontend", "-"};
    static String[] career = {"junior, senior", "-"};
    static String[] food = {"chicken", "pizza", "-"};
    String[][] arr = {lan, job, career, food};

    public static void main(String[] args) {

        test1();
        test2();
    }
    public static void test1() {
        Set<Score> set = new HashSet<>();
        Score score1 = new Score(0, 10);
        Score score2 = new Score(0, 10);
        set.add(score1);
        set.add(score2);
        System.out.println(set.size());
    }
    public static void test2() {
        Map<Score,Integer> set = new HashMap<>();
        Score score1 = new Score(0, 10);
        Score score2 = new Score(0, 10);
        set.put(score1, 1);
        set.put(score2, 1);
        System.out.println(set.size());
    }
    public int[] solution(String[] info, String[] query) {
        Map<String, Map<Integer, Integer>>[] map = new HashMap[4];
        Map<Node, Set<Map.Entry<Integer,Integer>>> count = new HashMap<>();
        int[] answer = new int[query.length];
        int idx = 0;
        // hashMap 초기화
        // [part] : [ _part : [id : score] ]
        for(String[] ar : arr) {
            map[idx] = new HashMap<>();
            for(String a : ar) {
                map[idx].put(a, new HashMap<>());
            }
            idx++;
        }
        // info 주입
        for(int id = 0; id < info.length; id++) {
            String[] s = info[id].split(" ");
            Integer score = Integer.valueOf(s[4]);
            // [part] : [ _part : [id : score] ]
            for(int i = 0; i < s.length-1; i++) {
                Map<Integer, Integer> _map = map[i].getOrDefault(s[i], new HashMap<>());
                Map<Integer, Integer> _map2 = map[i].getOrDefault("-", new HashMap<>());

                _map.put(id, score);
                _map2.put(id, score);

                map[i].put(s[i], _map);
                map[i].put("-", _map2);
            }
        }

        // [part] : [ _part : [id : score] ]
        for(int i = 0; i < lan.length; i++) {
            Set<Map.Entry<Integer,Integer>> _set = new TreeSet<>((o1, o2) -> {
                return o1.getValue() - o2.getValue();
            });

            String _l = lan[i];
            _set.addAll(map[0].get(_l).entrySet());
            for(int j = 0; j <job.length; j++) {
                String _j = job[j];
                _set.retainAll(map[1].get(_j).entrySet());
                for(int k = 0; k < career.length; k++) {
                    String _c = career[k];
                    _set.retainAll(map[2].get(_c).entrySet());
                    for(int z = 0; z < food.length; z++) {
                        String _f = food[z];
                        _set.retainAll(map[3].get(_f).entrySet());
                        String[] ins = {_l, _j, _c, _f};
                        Node node = new Node(ins);
                        Set<Map.Entry<Integer, Integer>> copySet = new HashSet<>(_set);
                        count.put(node, copySet);
                        _set.removeAll(map[3].get(_f).entrySet());
                    }
                    _set.removeAll(map[2].get(_c).entrySet());
                }
                _set.removeAll(map[1].get(_j).entrySet());
            }
        }


        idx = 0;
        for(String q : query) {
            String[] _q = q.replace(" and ", " ").split(" ");

            Integer _score = Integer.valueOf(_q[4]);
            String[] key = Arrays.copyOfRange(_q, 0, 3);
            Set<Map.Entry<Integer, Integer>> entries = count.get(new Node(key));
            int sum = 0;
            for(Map.Entry<Integer, Integer> entry : entries) {
                if(entry.getValue() > _score) break;
                sum++;
            }
            answer[idx++] = entries.size() - sum;
        }
        return answer;
    }
}
class Node{
    String[] s;
    public Node(String[] s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Node)) return false;
        Node node = (Node) obj;
        return node.hashCode() == obj.hashCode();
    }
    @Override
    public int hashCode() {
        int sum = 0;
        for(String _s : s) {
            sum += _s.hashCode();
        }
        return sum;
    }
}
class Score {
    Integer idx;
    Integer score;
    public Score(Integer id, Integer score) {
        this.idx = id;
        this.score = score;
    }
    public Score(Map.Entry<Integer,Integer> set) {
        this.idx = set.getKey();
        this.score = set.getValue();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Score)) return false;
        Score scr = (Score) obj;
        return this.idx.equals(scr.idx);
    }
    @Override
    public int hashCode() {
        return this.idx;
    }
}
