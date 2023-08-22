package baekjoon.class_.class2.solvedAc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int num;
    static int ignore;
    static Map<Integer, Integer> map = new HashMap<>();
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        ignore = (int)Math.round(num * 0.15);
        for(int i = 0; i<num; i++){
            int k = Integer.parseInt(br.readLine());
            map.put(k, map.getOrDefault(k,0)+1);
        }
        sol();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static void sol(){
        ignoreHighest();
        ignoreLowest();
        calculateAvg();
    }

    static void ignoreHighest(){
        int toDo = ignore;
        for(int i = 1; i<= 30; i++){
            while(toDo != 0 && map.getOrDefault(i,0) != 0){
                map.put(i, map.get(i) -1);
                toDo--;
            }
        }
    }

    static void ignoreLowest(){
        int toDo = ignore;
        for(int i = 30; 1 <= i; i--){
            while(toDo != 0 && map.getOrDefault(i,0) != 0){
                map.put(i, map.get(i) -1);
                toDo--;
            }
        }
    }

    static void calculateAvg(){
        Double r = 0.0;
        for(int i = 1; i<= 30; i++){
            r += i*map.getOrDefault(i,0);
        }
        result = (int)Math.round(r/(num - (ignore*2)));
    }
}
