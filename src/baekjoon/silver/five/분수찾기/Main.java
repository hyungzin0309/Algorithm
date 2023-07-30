package baekjoon.silver.five.분수찾기;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] result = sol(num);
        bw.write(String.valueOf(result[0])+"/"+String.valueOf(result[1]));
        bw.flush();
    }

    public static int[] sol(int num){
        int[] current = new int[2];
        current[0] = 1;
        current[1] = 1;
        boolean leftDown = false;
        for(int i = 1; i<num; i++){
            if(current[0] == 1){
                if(current[1] % 2 == 0){
                    current[0] += 1;
                    current[1] -= 1;
                }else {
                    current[1] += 1;
                    leftDown = true;
                }
            }else if(current[1] == 1){
                if(current[0] % 2 == 1){
                    current[0] -= 1;
                    current[1] += 1;
                }else{
                    current[0] += 1;
                    leftDown = false;
                }
            }else {
                if(leftDown) {
                    current[0] += 1;
                    current[1] -= 1;
                }else{
                    current[0] -= 1;
                    current[1] += 1;
                }
            }
        }
        return current;
    }

}
