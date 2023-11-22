package baekjoon.tier.gold.이진검색트리;

import java.io.*;

public class Main {

    static Node root;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        while(s != null && !s.equals("")){
            int num = Integer.parseInt(s);
            Node node = new Node(num);
            if(root == null){
                root = node;
            } else{
                root.insert(node);
            }
            s = br.readLine();
        }

        root.write();
        bw.flush();
    }

    static class Node{
        int num;
        Node left;
        Node right;

        public Node(int n){
            num = n;
        }

        public void insert(Node node){
            if(node.num < num){
                if(left == null) left = node;
                else left.insert(node);
            }else if(node.num > num){
                if(right == null) right = node;
                else right.insert(node);
            }
        }

        public void write() throws Exception{
            if(left != null){
                left.write();
            }if(right != null){
                right.write();
            }
            bw.write(String.valueOf(num)+"\n");
        }
    }
}
