package baekjoon.class_.class4.파티;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int x;
    static int[] partyToHome;
    static Map<Integer, List<Node>> map = new HashMap<>();

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            List<Node> nodes = map.getOrDefault(start, new ArrayList<>());
            nodes.add(new Node(end, cost));
            map.put(start, nodes);
        }
        makePartyToHome();
        for(int i = 1; i<=n; i++){
            int toParty = toX(i);
            int toHome = partyToHome[i];
            max = Math.max(max, toParty + toHome);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    static int toX(int home){
        int[] visited = new int[n+1];
        int[] cost = new int[n+1];
        cost[home] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(home, 0));
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(visited[current.node] == 0){
                visited[current.node] = 1;
                cost[current.node] = current.cost;
                for(Node other : map.get(current.node)){
                    queue.add(new Node(other.node, other.cost + cost[current.node]));
                }
            }
        }
        return cost[x];
    }

    static void makePartyToHome(){
        int[] visited = new int[n+1];
        partyToHome = new int[n+1];
        partyToHome[x] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x, 0));
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(visited[current.node] == 0){
                visited[current.node] = 1;
                partyToHome[current.node] = current.cost;
                for(Node other : map.get(current.node)){
                    queue.add(new Node(other.node, other.cost + partyToHome[current.node]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int node;
        int cost;

        public Node(int n, int c){
            node = n;
            cost = c;
        }

        public int compareTo(Node o){
            return cost - o.cost;
        }
    }
}
