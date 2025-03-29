package 취준_2025.DP.팰린드롬_10942_G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TopDown {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int[] map;
    public static int[][] sol;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n];
        sol = new int[n][n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
            sol[i][i] = 1;
        }

        int questionNum = Integer.parseInt(br.readLine());
        for(int i = 0; i< questionNum; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = sol(start-1,end-1);
            bw.write((result == -1 ? 0 : 1) + "\n");
        }
        bw.flush();
    }

    public static int sol(int start, int end){
        if(sol[start][end] != 0) return sol[start][end];

        int result;
        if(start == end) {
            result = 1;
        } else if(end-start == 1){
            result = map[start] == map[end] ? 1 : -1;
        } else{
            if(sol(start+1, end-1) == 1 && map[start] == map[end]){
                result = 1;
            }else{
                result = -1;
            }
        }
        sol[start][end] = result;
        return result;
    }
}
















