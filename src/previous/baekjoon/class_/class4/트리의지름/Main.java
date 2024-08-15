package previous.baekjoon.class_.class4.트리의지름;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int n;
    static Map<Integer, List<Node>> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i< n-1; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            List<Node> n1List = map.getOrDefault(n1, new ArrayList<>());
            n1List.add(new Node(n2, cost));
            map.put(n1, n1List);
            List<Node> n2List = map.getOrDefault(n2, new ArrayList<>());
            n2List.add(new Node(n1, cost));
            map.put(n2, n2List);
        }

        visited = new boolean[n+1];
        dfs(1,0);
        visited = new boolean[n+1];
        dfs(lastNode,0);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static int result;
    static int lastNode;
    static boolean visited[];

    static void dfs(int node, int cost){
        visited[node] = true;
        if(result < cost){
            result = cost;
            lastNode = node;
        }

        for(Node other : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[other.num]){
                dfs(other.num, cost + other.cost);
            }
        }
    }

    static class Node{
        int num;
        int cost;

        public Node(int a, int b){
            num = a;
            cost = b;
        }
    }
}
