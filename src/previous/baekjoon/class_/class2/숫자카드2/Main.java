package previous.baekjoon.class_.class2.숫자카드2;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<num; i++){
            int n = Integer.parseInt(s[i]);
            int nNum = map.getOrDefault(n, 0);
            map.put(n, nNum+1);
        }

        int num2 = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");
        for(int i = 0; i<num2; i++){
            int n = Integer.parseInt(s2[i]);
            bw.write(map.getOrDefault(n,0)+" ");
        }
        bw.flush();
    }
}
