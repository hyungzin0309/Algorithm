package 취준_2025.DP.팰린드롬_10942_G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BottomUp {

    public static int num;
    public static int[] arr;
    public static int[][] dp;
    public static BufferedWriter bw;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        arr = new int[num];
        dp = new int[num][num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeDp();

        int questions = Integer.parseInt(br.readLine());
        for(int i = 0; i< questions; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            solve(start, end);
        }
        bw.flush();
    }


    public static void solve(int start, int end) throws Exception{
        if(dp[start-1][end-1] == 1){
            bw.write("1\n");
        }else{
            bw.write("0\n");
        }
    }

    public static void makeDp(){
        // 자기자신 팰린드롬 초기화
        for(int i = 0; i < num; i++){
            dp[i][i] = 1;
        }

        for(int i = 0; i < num-1; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = 1;
            }
        }

        for(int i = num-3; i >= 0; i--){
            for(int j = i+2; j< num; j++){
                if(arr[i] == arr[j] && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                }
            }
        }

    }
}
