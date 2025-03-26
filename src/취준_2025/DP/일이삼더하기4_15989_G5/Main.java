package 취준_2025.DP.일이삼더하기4_15989_G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int[] sol;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sol = new int[10001];
        sol[1] = 1;
        sol[2] = 2;
        sol[3] = 3;

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i< n; i++){
            int num = Integer.parseInt(br.readLine());
            bw.write(sol(num) + "\n");
        }

        bw.flush();
    }

    public static int sol(int num){
        if(sol[num] != 0) return sol[num];

        int result;
        if(num % 3 == 0){
            result = sol(num-1) + sol(num-2) - sol(num-3) + 1;
        }else{
            result = sol(num-1) + sol(num-2) - sol(num-3);
        }
        sol[num] = result;
        return result;
    }

}

