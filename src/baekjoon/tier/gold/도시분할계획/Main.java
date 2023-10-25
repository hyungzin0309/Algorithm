package baekjoon.tier.gold.도시분할계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int result = 0;
    static int unionCount = 0;
    static int[] group;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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

        while(unionCount != n-2){
            Line line = queue.poll();
            if(find(line.a) != find(line.b)){
                union(line.a, line.b);
                result += line.cost;
                unionCount++;
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
