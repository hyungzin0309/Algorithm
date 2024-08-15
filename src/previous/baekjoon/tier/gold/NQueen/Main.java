package previous.baekjoon.tier.gold.NQueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int n;
    static int result;
    static int arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(0);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int row){
        if(row == n) {
            result++;
            return;
        }
        for(int i = 0; i< n; i++){
            arr[row] = i;
            if(possible(row)){
                dfs(row + 1);
            }
        }
    }

    public static boolean possible(int row){
        // 세로줄 검사
        for(int i = 0; i<row; i++){
            if(arr[i] == arr[row]) return false;
            if(Math.abs(row - i) == Math.abs(arr[row] - arr[i])) return false;
        }
        return true;
    }
}
