package baekjoon.tier.gold.불우이웃돕기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int[] group;
    static int count = 0;
    static int result = 0;
    static int total = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        group = new int[n];
        PriorityQueue<Line> queue = new PriorityQueue<>();
        for(int i = 0; i<n; i++){
            group[i] = i;
            String line = br.readLine();
            for(int j = 0; j<n; j++){
                char c = line.charAt(j);
                int cost;
                if(c == '0') cost = 0;
                else if (Character.isLowerCase(c)) cost = c - 'a' + 1;
                else if (Character.isUpperCase(c)) cost = c - 'A' + 27;
                else cost = 0;
                if(cost != 0)queue.add(new Line(i, j, cost));
                total += cost;
            }
        }

        while(!queue.isEmpty()){
            Line line = queue.poll();
            if(union(line.a, line.b)){
                result += line.cost;
                count++;
            }
        }

        if(count != n-1) System.out.println(-1);
        else System.out.println(total - result);
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
