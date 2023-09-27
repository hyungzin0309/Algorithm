package baekjoon.class_.class4.가장_긴_바이토닉_부분수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] nums;
    static int[] arr1;
    static int[] arr2;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr1 = new int[n];
        arr2 = new int[n];
        nums = new int[n];
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            arr1[i] = 1;
            arr2[i] = 1;
        }
        for(int i = 1; i< n; i++){
            int cur = nums[i];
            for(int j = 0; j<i; j++){
                int other = nums[j];
                if(other < cur){
                    if(arr1[j] + 1 > arr1[i]){
                        arr1[i] = arr1[j] + 1;
                    }
                }
            }
        }
        arr2[n-1] = 1;
        for(int i = n-2; i>=0; i--){
            int cur = nums[i];
            for(int j = n-1; j> i; j--){
                int other = nums[j];
                if(cur > other){
                    if(arr2[j] + 1 > arr2[i]){
                        arr2[i] = arr2[j] + 1;
                    }
                }
            }
        }

        for(int i = 0; i<n; i++){
            result = Math.max(arr1[i] + arr2[i] - 1, result);
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    static class Info{
        int num;
        int asc;
        int desc;

        public Info(int n){
            num = n;
            asc = 0;
            desc = 1;
        }
    }
}
