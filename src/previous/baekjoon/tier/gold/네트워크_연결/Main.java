package previous.baekjoon.tier.gold.네트워크_연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] group;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        group = new int[n+1];
        for(int i = 1; i<=n; i++){
            group[i] = i;
        }
        PriorityQueue<Line> queue = new PriorityQueue<>();

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            queue.add(new Line(a,b,cost));
        }

        while(!queue.isEmpty()){
            Line l = queue.poll();
            if(find(l.a) != find(l.b)) {
                result += l.cost;
                union(l.a, l.b);
            }
        }

        System.out.println(result);
    }

    static int find(int a){
        if(group[a] == a) return a;
        return group[a] = find(group[a]);
    }

    static void union(int a, int b){
        int groupA = find(a);
        int groupB = find(b);
        group[groupA] = groupB;
    }

    static class Line implements Comparable<Line>{

        int a;
        int b;
        int cost;

        @Override
        public int compareTo(Line o){
            return cost - o.cost;
        }

        public Line(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

    }
}
