package baekjoon.tier.gold.램프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int k;
    static Map<String, Integer> map = new HashMap<>();
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i< n; i++){
            String line = br.readLine();
            int num = map.getOrDefault(line, 0);
            map.put(line, num + 1);
        }
        k=Integer.parseInt(br.readLine());
        for(String line : map.keySet()){
            int zeros = 0;
            for(int i = 0; i<m; i++){
                if(line.charAt(i) == '0'){
                    zeros++;
                }
            }

            if(zeros <= k && zeros % 2 == k % 2){
                result = Math.max(map.get(line), result);
            }
        }

        System.out.println(result);
    }
}
