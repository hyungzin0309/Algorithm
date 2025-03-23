package 취준_2025.DP.이동하기_11048_S2;

import java.util.*;
import java.io.*;

public class BottomUp {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int m;
    public static int[][] map;
    public static int[][] sol;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        sol = new int[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol();
    }

    public static void sol() throws Exception{
        sol[0][0] = map[0][0];
        for(int i = 1; i<m; i++){
            sol[0][i] = map[0][i] + sol[0][i-1];
        }
        for(int j = 1; j<n; j++){
            sol[j][0] = map[j][0] + sol[j-1][0];
        }

        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                int point = map[i][j];
                sol[i][j] = Math.max(point + sol[i-1][j], point + sol[i][j-1]);
            }
        }

        bw.write(String.valueOf(sol[n-1][m-1]));
        bw.flush();
    }
}


















