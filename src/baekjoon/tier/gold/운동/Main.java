package baekjoon.tier.gold.운동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] cost;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cost = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
            cost[i][i] = 0;
        }
        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[start][end] = c;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                for(int k = 1; k<=n; k++){
                    if(cost[i][k] != Integer.MAX_VALUE && cost[k][j] != Integer.MAX_VALUE){
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                    }
                }
            }
        }

        for(int i = 1; i<n; i++){
            for(int j = i+1; j<=n; j++){
                if(cost[i][j] != Integer.MAX_VALUE && cost[j][i] != Integer.MAX_VALUE){
                    result = Math.min(result, cost[i][j] + cost[j][i]);
                }
            }
        }

        result = result == Integer.MAX_VALUE? -1 : result;
        System.out.println(result);
    }
}
