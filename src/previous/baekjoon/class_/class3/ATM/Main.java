package previous.baekjoon.class_.class3.ATM;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i< num; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        int result = 0;
        for(int i = num; 0 < i; i--){
            result += arr[num - i] * i;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
