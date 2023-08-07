package baekjoon.silver.two.한줄로서기;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        result = new int[num];
        memory = new int[num];
        String[] line = br.readLine().split(" ");
        for(int i = 0; i< num; i++){
            memory[i] = Integer.parseInt(line[i]);
        }
        sol();
        for(int n : result){
            bw.write(n + " ");
        }
        bw.flush();
    }

    static int num;
    static int[] result;
    static int[] memory;

    static void sol(){
        for(int i = 0; i<num; i++){
            int idx = findMyIdx(memory[i]);
            while(result[idx] != 0){
                idx++;
            }
            result[idx] = i+1;
        }
    }

    static int findMyIdx(int left){
        int zero = 0;
        for(int i = 0; i<num; i++){
            if(zero == left) return i;
            if(result[i] == 0) zero++;
        }
        return 0;
    }

}
