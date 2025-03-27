package 취준_2025.DP.점프점프_11060_S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DP {

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
        for(int i = 0; i<n-1; i++){
            if (i > 0 && sol[i] == 0) return -1;
            int point = sol[i];
            int canMove = map[i];
            for(int j = 1; j<=canMove; j++){
                if(i+j >= n) break;
                if(sol[i+j] == 0){
                    sol[i+j] = point + 1;
                }
                else {
                    sol[i+j] = Math.min(point + 1, sol[i+j]);
                }
            }
        }
        return sol[n-1];
    }
}
