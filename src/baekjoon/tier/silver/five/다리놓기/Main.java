package baekjoon.tier.silver.five.다리놓기;

import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i< num; i++){
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[1]);
            int r = Integer.parseInt(arr[0]);
            memory = new int[n+1][r+1];
            bw.write(solution(n,r)+ "\n");
            bw.write(factorial(n) / (factorial(n-r) * factorial(r))+ "\n");
            bw.write(factorial(BigInteger.valueOf(n)).divide(factorial(BigInteger.valueOf(n-r)).multiply(factorial(BigInteger.valueOf(r))))+ "\n");
        }
        bw.flush();
    }

    static int[][] memory;

    /**
3
2 2
1 5
13 29
     */
    public static int solution(int n, int r){
        if(memory[n][r] != 0) return memory[n][r];
        if(n == r || r == 0) return 1;
        int result = solution(n-1,r-1) + solution(n-1, r);
        memory[n][r] = result;
        return result;
    }

    public static long factorial(long n){
        if(n == 1 || n == 0) return 1L;
        return n * factorial(n-1);
    }

    public static BigInteger factorial(BigInteger n){
        if(n.equals(BigInteger.valueOf(1))  || n.equals(BigInteger.valueOf(0))) return BigInteger.valueOf(1);
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1)))) ;
    }
}
