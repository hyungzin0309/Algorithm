package previous.inflearn.seven.이진트리탐색_BFS;

import java.util.*;

public class Main {

    static Node root;

    public static void main(String[] args) {
        nodeSetting();
        bfs();
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                Node current = queue.poll();
                System.out.print(current.data + " ");
                if(current.ln != null)queue.offer(current.ln);
                if(current.rn != null)queue.offer(current.rn);
            }
        }

    }

    public static class Node{
        int data;
        Node ln = null;
        Node rn = null;

        public Node(int data){
            this.data = data;
        }
    }

    public static void nodeSetting(){
        root = new Node(1);
        root.ln = new Node(2);
        root.rn = new Node(3);
        root.ln.ln = new Node(4);
        root.ln.rn = new Node(5);
        root.rn.ln = new Node(6);
        root.rn.rn = new Node(7);
    }
}
