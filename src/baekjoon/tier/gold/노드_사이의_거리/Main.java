package baekjoon.tier.gold.노드_사이의_거리;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static Map<Integer, List<Node>> map = new HashMap<>();
    static int visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i< n-1; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            List<Node> targets1 = map.getOrDefault(node1, new ArrayList<>());
            targets1.add(new Node(node2, cost));
            map.put(node1, targets1);
            List<Node> targets2 = map.getOrDefault(node2, new ArrayList<>());
            targets2.add(new Node(node1, cost));
            map.put(node2, targets2);
        }
        for(int i = 0; i<m; i++){
            cost = 0;
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            dfs(node1, node2, 0);
            bw.write(cost+"\n");
        }
        bw.flush();
    }

    static int cost = 0;

    static boolean dfs(int current, int target, int previous){
        if(current == target) return true;
        for(Node node : map.getOrDefault(current, new ArrayList<>())){
            if(node.num != previous){
                cost += node.cost;
                if(dfs(node.num, target, current)) return true;
                cost -= node.cost;
            }
        }
        return false;
    }

    public static class Node{
        int num;
        int cost;

        public Node(int n, int c){
            num = n;
            cost = c;
        }
    }

}
