package previous.baekjoon.tier.gold.최소스패닝트리;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static Line[] lines;
    static int[] grouping;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grouping = new int[n+1];
        lines = new Line[m];
        for(int i = 0; i< n; i++){
            grouping[i] = i;
        }
        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lines[i] = new Line(n1, n2, c);
        }
        Arrays.sort(lines);
        for(Line line : lines){
            if(find(line.node1) != find(line.node2)){
                result += line.cost;
                union(line.node1, line.node2);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static int find(int n){
        if(grouping[n] == n) return n;
        return grouping[n] = find(grouping[n]);
    }

    public static void union(int n1, int n2){
        int group1 = find(n1);
        int group2 = find(n2);
        if(group1 != group2) grouping[group1] = group2;
    }

    public static class Line implements Comparable<Line>{
        int node1;
        int node2;
        int cost;

        public Line(int a, int b, int c){
            node1 = a;
            node2 = b;
            cost = c;
        }

        public int compareTo(Line o){
            return cost - o.cost;
        }
    }
}
