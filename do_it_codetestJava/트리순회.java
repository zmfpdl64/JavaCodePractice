package do_it_codetestJava;

// 18시 31분
//실1
// https://www.acmicpc.net/problem/1991

import java.util.*;
import java.io.*;
public class 트리순회 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        Node base = new Node("A");
        for(int i = 0; i < n; i++) {
            String[] ins = br.readLine().split(" ");
            if(!ins[1].equals(".")){
                base.insertNode(new Node(ins[1]), ins[0], 0);
            }
            if(!ins[2].equals(".")){
                base.insertNode(new Node(ins[2]), ins[0], 1);
            }
        }

        base.PreOrder(base);
        System.out.println();
        base.InOrder(base);
        System.out.println();
        base.PostOrder(base);
    }
}



class Node {
    Node left;
    Node right;
    String value;

    Node (String value) {
        this.value =value;
    }

    public void insertNode(Node node, String goal, int target) {
        if(this.value.equals(goal)){
            if(target == 0) {
                this.left = node;
            }else{
                this.right = node;
            }
            return;
        }
        if(this.left != null ){
            this.left.insertNode(node, goal, target);
        }
        if(this.right != null) {
            this.right.insertNode(node, goal, target);
        }
    }

    public void visit(Node node) {
        if(node != null) {
            System.out.print(node.value);
        }
    }
    public void PreOrder(Node node) {
        visit(node);
        if(node.left!=null)
        PreOrder(node.left);
        if(node.right!=null)
        PreOrder(node.right);
    }
    public void InOrder(Node node) {
        if(node.left!=null)
        InOrder(node.left);
        visit(node);
        if(node.right!=null)
        InOrder(node.right);
    }
    public void PostOrder(Node node) {
        if(node.left!=null)
        PostOrder(node.left);
        if(node.right!=null)
        PostOrder(node.right);
        visit(node);
    }
}