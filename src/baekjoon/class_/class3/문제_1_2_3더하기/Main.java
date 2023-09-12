package baekjoon.class_.class3.문제_1_2_3더하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int target;
    static int result;
    static int[] nums = new int[]{1,2,3};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for(int i = 0; i< cases; i++){
            result = 0;
            target = Integer.parseInt(br.readLine());
            dfs(0);
            bw.write(result + "\n");
        }
        bw.flush();
    }

    static void dfs(int num){
        if(num == target){
            result++;
            return;
        }else if(target < num){
            return;
        }

        for(int i = 0; i< 3; i++){
            num += nums[i];
            dfs(num);
            num -= nums[i];
        }
    }


}
