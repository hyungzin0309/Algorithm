package previous.baekjoon.class_.class2.소수구하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        Integer a = Integer.parseInt(s[0]);
        Integer b = Integer.parseInt(s[1]);
        int[] arr = new int[b+1];
        for(int i = 2; i <= b; i++){
            if(arr[i] == 0){
                if(a <= i)bw.write(i+"\n");
                for(int k = i; k <= b; k+=i){
                    arr[k] = 1;
                }
            }
        }
        bw.flush();
    }
}
