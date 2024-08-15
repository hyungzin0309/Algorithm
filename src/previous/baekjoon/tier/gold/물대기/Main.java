package previous.baekjoon.tier.gold.물대기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int result;
    static int[] group;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Line> queue = new PriorityQueue<>();
        n = Integer.parseInt(st.nextToken());
        group = new int[n+1];

        for(int i=1; i<=n; i++){
            group[i] = i;
            int cost = Integer.parseInt(br.readLine());
            queue.add(new Line(0,i,cost));
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int cost = Integer.parseInt(st.nextToken());
                if(i < j){
                    queue.add(new Line(i,j,cost));
                }
            }
        }

        while(!queue.isEmpty()){
            Line line = queue.poll();
            if(union(line.a, line.b)){
                result += line.cost;
            }
        }

        System.out.println(result);
    }

    static int find(int a){
        if(group[a] == a) return a;
        return group[a] = find(group[a]);
    }

    static boolean union(int a, int b){
        int groupA = find(a);
        int groupB = find(b);
        if(groupA == groupB) return false;

        group[groupA] = groupB;
        return true;
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
