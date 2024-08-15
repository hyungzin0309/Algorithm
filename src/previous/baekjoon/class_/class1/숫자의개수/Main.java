package previous.baekjoon.class_.class1.숫자의개수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        sol();
        for(int i : result){
            bw.write(String.valueOf(i) + "\n");
        }
        bw.flush();
    }

    static int a;
    static int b;
    static int c;
    static int[] result = new int[10];

    static void sol(){
        Map<Character, Integer> map = new HashMap<>();
        String num = String.valueOf(a*b*c);
        for(char c : num.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c : map.keySet()){
            result[Integer.parseInt(String.valueOf(c))] = map.get(c);
        }
    }

}
