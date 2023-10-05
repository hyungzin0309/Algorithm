package baekjoon.class_.class4.최단경로2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int start;
    static int end;
    static Map<Integer, List<Node>> map = new HashMap<>();
    static boolean[] visited;
    static int[] result;
    static int[] record;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        result = new int[n+1];
        record = new int[n+1];
        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            List<Node> targets = map.getOrDefault(n1, new ArrayList<>());
            targets.add(new Node(n2, cost, n1));
            map.put(n1, targets);
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        sol();
        bw.write(result[end]+"\n");
        dfs(end);
        bw.write(step+"\n");
        for(int i = 1; i<= step; i++){
            bw.write(stepList.get(step-i)+" ");
        }
        bw.flush();
    }

    static int step = 1;
    static List<Integer> stepList = new ArrayList<>();

    static void dfs(int current){
        stepList.add(current);
        if(current != start){
            step++;
            dfs(record[current]);
        }
    }

    static void sol(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0, 0));
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(!visited[cur.num]){
                result[cur.num] = cur.cost;
                record[cur.num] = cur.from;
                visited[cur.num] = true;
                for(Node next : map.getOrDefault(cur.num, new ArrayList<>())){
                    queue.add(new Node(next.num, next.cost + result[cur.num], cur.num ));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int num;
        int cost;
        int from;

        public Node(int n, int c, int f){
            num = n;
            cost = c;
            from = f;
        }

        public int compareTo(Node o){
            return cost - o.cost;
        }
    }
}
