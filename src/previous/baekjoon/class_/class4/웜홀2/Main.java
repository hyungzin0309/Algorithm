package previous.baekjoon.class_.class4.웜홀2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());

        while(cases-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            lines = new ArrayList<>();

            for(int i = 0; i< m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                lines.add(new Line(a,b,c));
                lines.add(new Line(b,a,c));
            }

            for(int i = 0; i< w; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                lines.add(new Line(a,b,-c));
            }
            if(sol()) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();;
    }

    static List<Line> lines;
    static int n, m, w;

    static boolean sol(){

        for(int i = 1; i<=n; i++){

            int[] costs = new int[n+1];
            Arrays.fill(costs, Integer.MAX_VALUE);
            boolean updated = false;
            costs[i] = 0;
            for(int j = 0; j<n; j++){
                updated = false;
                for(Line line : lines){
                    if(costs[line.end] > costs[line.start] + line.cost){
                        costs[line.end] = costs[line.start] + line.cost;
                        updated = true;
                    }
                }
                if(!updated) break;
            }
            if(updated) return true;
        }

        return false;
    }

    static class Line{
        int start;
        int end;
        int cost;

        public Line(int s, int n, int c){
            start = s;
            end = n;
            cost = c;
        }
    }
}
