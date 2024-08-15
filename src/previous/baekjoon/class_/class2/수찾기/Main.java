package previous.baekjoon.class_.class2.수찾기;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String[] s = br.readLine().split(" ");
        for(int i = 0; i< num; i++){
            map.put(Integer.parseInt(s[i]),1);
        }
        int num2 = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");
        for(int i = 0; i< num2; i++){
            bw.write(String.valueOf(map.getOrDefault(Integer.parseInt(s2[i]),0))+"\n");
        }
        bw.flush();
    }
}
