package 취준_2025.DP.점프점프_11060_S2;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BFS {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int[] map;
    public static int[] sol;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n];
        sol = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sol());
    }

    public static int sol() throws Exception{
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i< length; i++){

                Point point = queue.poll();

                for(int move = 1; move<= map[point.index]; move++){
                    int targetPoint = point.index + move;
                    if(targetPoint >= n) break;
                    if(sol[targetPoint] == 0) {
                        sol[targetPoint] = point.num + 1;
                        queue.add(new Point(targetPoint, point.num + 1));
                    }
                }
            }
        }
        if(n == 1) return 0;
        return sol[n-1] == 0 ? -1 : sol[n-1];
    }

    public static class Point{
        int index;
        int num;

        public Point(int index, int num){
            this.index = index;
            this.num = num;
        }
    }

}
