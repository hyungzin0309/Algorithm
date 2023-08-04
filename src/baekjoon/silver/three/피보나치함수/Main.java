package baekjoon.silver.three.피보나치함수;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cases = Integer.parseInt(br.readLine());
        arr = new int[41][2];
        for(int i = 0; i< cases; i++){
            int[] result = sol(Integer.parseInt(br.readLine()));
            bw.write(String.valueOf(result[0]+" "+result[1])+"\n");
        }
        bw.flush();
    }

    static int cases;
    static int[][] arr;

    public static int[] sol(int num){
        if(num == 1){
            arr[1] = new int[]{0,1};
            return new int[]{0,1};
        }if(num == 0){
            arr[0] = new int[]{1,0};
            return new int[]{1,0};
        }

        if(arr[num][0] != 0 && arr[num][1] != 0){
            return arr[num];
        }

        int[] a1 = sol(num-1);
        int[] a2 = sol(num-2);

        arr[num] = new int[]{a1[0]+a2[0], a1[1]+a2[1]};
        return arr[num];
    }


}
