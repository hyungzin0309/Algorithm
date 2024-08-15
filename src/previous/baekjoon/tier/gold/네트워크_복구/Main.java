package previous.baekjoon.tier.gold.네트워크_복구;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static Map<Integer, List<Node>> map = new HashMap<>();
    static int[] cost;
    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Node> targets1 = map.getOrDefault(a,new ArrayList<>());
            targets1.add(new Node(a,b,c));
            map.put(a, targets1);

            List<Node> targets2 = map.getOrDefault(b,new ArrayList<>());
            targets2.add(new Node(b,a,c));
            map.put(b, targets2);
        }

        PriorityQueue<Node> queue = new PriorityQueue();
        queue.add(new Node(1,1,0));

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cost[cur.num] == Integer.MAX_VALUE){
                result.add(new int[]{cur.from, cur.num});
                cost[cur.num] = cur.cost;
                for(Node target : map.getOrDefault(cur.num, new ArrayList<>())){
                    queue.add(new Node(target.from, target.num, target.cost + cur.cost));
                }
            }
        }
        result.remove(0);
        bw.write(String.valueOf(result.size())+"\n");
        for(int[] r : result){
            bw.write(r[0] + " " + r[1]+"\n");
        }
        bw.flush();
    }

    static class Node implements Comparable<Node>{
        int from;
        int num;
        int cost;

        public Node(int from, int num, int cost){
            this.from = from;
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return cost - o.cost;
        }
    }
}
