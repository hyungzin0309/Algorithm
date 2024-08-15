package previous.baekjoon.class_.class3.one으로만들기;

import java.io.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        for(int i = 1; i<n+1; i++){
            switch(i){
                case 1 : arr[i] = 0; break;
                case 2 :
                case 3 : arr[i] = 1; break;
                default : arr[i] = calculate(i);
            }
        }

        bw.write(String.valueOf(arr[n]));
        bw.flush();
    }

    static int calculate(int num){
        int result = Integer.MAX_VALUE;
        if(num % 2 == 0){
            result = Math.min(arr[num/2] + 1, result);
        }
        if(num % 3 == 0){
            result = Math.min(arr[num/3] + 1, result);
        }
        result = Math.min(arr[num-1] + 1, result);
        return result;
    }


}
