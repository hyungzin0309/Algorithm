package previous.baekjoon.class_.class4.플로이드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] costs = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(costs[i], Integer.MAX_VALUE);
            costs[i][i] = 0;
        }

        for(int i = 0; i< m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            costs[start-1][end-1]= Math.min(cost, costs[start-1][end-1]);
        }

        for(int j = 0; j<n; j++){
            for(int k = 0; k< n; k++){
                for(int i = 0; i<n; i++){
                    if(costs[i][k] != Integer.MAX_VALUE && costs[k][j] != Integer.MAX_VALUE)
                        costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(long cost : costs[i]){
                long result = cost == Integer.MAX_VALUE ? 0 : cost;
                bw.write(result + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

}
