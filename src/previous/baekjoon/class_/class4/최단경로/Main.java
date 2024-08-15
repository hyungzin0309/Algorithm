package previous.baekjoon.class_.class4.최단경로;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int start;
    static Map<Integer, List<Node>> map = new HashMap<>();
    static int[] result;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[n+1];
        visited = new int[n+1];
        start = Integer.parseInt(br.readLine());
        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Node> nodes = map.getOrDefault(s, new ArrayList<>());
            nodes.add(new Node(e, c));
            map.put(s, nodes);
        }

        sol();

        for(int i = 1; i<= n; i++){
            bw.write(i!= start && result[i] == 0 ? "INF" : String.valueOf(result[i]));
            bw.write("\n");
        }
        bw.flush();
    }

    static void sol(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(visited[current.num] == 0){
                visited[current.num] = 1;
                result[current.num] = current.cost;
                for(Node next : map.getOrDefault(current.num, new ArrayList<>())){
                    queue.add(new Node(next.num, next.cost + result[current.num]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int num;
        int cost;

        @Override
        public int compareTo(Node o){
            return cost - o.cost;
        }

        public Node(int n, int c){
            cost = c;
            num = n;
        }

    }
}