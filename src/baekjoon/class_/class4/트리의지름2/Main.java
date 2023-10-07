package baekjoon.class_.class4.트리의지름2;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean[] visited;
    static Map<Integer, List<Node>> map = new HashMap<>();
    static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while(true){
                int o = Integer.parseInt(st.nextToken());
                if(o == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                List<Node> targets = map.getOrDefault(n,new ArrayList<>());
                targets.add(new Node(o, cost));
                map.put(n, targets);
            }
        }
        visited = new boolean[n+1];
        dfs(1,0);
        visited = new boolean[n+1];
        dfs(lastNode, 0);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static int result;
    static int lastNode;

    static void dfs(int current, int cost){
        visited[current] = true;
        if(result < cost){
            result = cost;
            lastNode = current;
        }

        List<Node> others = map.get(current);
        for(Node other : others){
            if(!visited[other.num]){
                dfs(other.num, cost + other.cost);
            }
        }
    }

    static class Node{
        int num;
        int cost;

        public Node(int n, int c){
            num = n;
            cost = c;
        }
    }
}
