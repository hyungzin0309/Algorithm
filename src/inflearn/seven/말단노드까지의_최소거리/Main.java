package inflearn.seven.말단노드까지의_최소거리;

import java.util.*;

public class Main {

    static Node root;

    public static void main(String[] args) {
        nodeSetting();
        System.out.println(dfs(root, -1));
        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                Node node = queue.poll();
                if(node.ln == null && node.rn == null) return level;
                else {
                    if(node.ln != null)queue.add(node.ln);
                    if(node.rn != null)queue.add(node.rn);
                }
            }
            level++;
        }
        return -1;
    }

    public static int dfs(Node node, int level){
        level++;
        if(node.rn == null && node.ln == null){
            return level;
        }
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;

        if(node.ln != null) l = dfs(node.ln, level);
        if(node.rn != null) r = dfs(node.rn, level);
        return Math.min(l,r);
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
        root.rn.ln = new Node(8);
        root.ln.ln = new Node(4);
        root.ln.ln.ln = new Node(6);
        root.ln.ln.ln.ln = new Node(7);
        root.ln.rn = new Node(5);
    }
}
