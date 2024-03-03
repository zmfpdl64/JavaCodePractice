package javastudy;
import java.util.*;
public class Set컬렉션 {
    public static void main(String[] args) {
        hashSetTest();
//        treeSetTest();
    }
    public static void hashSetTest() {
        Set<Node> set = new HashSet<>();
        set.add(new Node(1, 1));
        set.add(new Node(1, 1));
        System.out.println(set.size());
    }
    public static void treeSetTest() {
        Set<Node> set = new TreeSet<>((o1, o2) -> {
            int dif = o1.x - o2.x;
            return dif;
        });
        set.add(new Node(1, 1));
        set.add(new Node(1, 2));
        System.out.println(set.size());

        for(Node node: set){
            System.out.println(node);
        }
    }
}
class Node{
    Integer x;
    Integer y;
    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return  x;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Node)) return false;
        Node node = (Node) obj;
        return this.x == node.x && this.y == node.y;
    }
    //    @Override
//    public String toString() {
//        return "x: "+x + "\n" +
//                "y: "+ y;
//    }
}
