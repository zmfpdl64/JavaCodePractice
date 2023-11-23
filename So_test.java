import java.util.*;
import java.io.*;
public class So_test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> graph = new TreeMap<Integer, List<Integer>>();
        List<Integer> queue = new LinkedList<>();
        List<Integer> seq = new LinkedList<>();
        boolean[] viMap = new boolean[n];

        for(int i = 0; i <= n; i++ ){
            viMap[i] = false;
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++){
            String[] ins = br.readLine().split(" ");
            int a = Integer.parseInt(ins[0]);
            int b = Integer.parseInt(ins[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        queue.add(1);
        viMap[1] = true;

        while(queue.size() != 0){
            Integer curV = queue.remove(0);
        }

    }

    class Node{
        Node left;
        Node right;
        Integer value;
        public Node(Node left, Node right,Integer value){
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    class Tree{
        Node root;

        public Tree(){
            this.root = new Node(null, null, 1);
        }

        public void insert(Node value, int a, int b) {
            if(value.value.equals(a)){
                if(value.left == null){
                    value.left = new Node(null, null, b);
                }else{
                    value.right = new Node(null, null, b);
                }
            }else if(value.value.equals(b)) {
                if(value.left == null) {
                    value.left = new Node(null, null, a);
                }
            }



        }
    }
}
