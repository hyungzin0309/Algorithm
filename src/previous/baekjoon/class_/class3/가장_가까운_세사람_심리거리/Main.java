package previous.baekjoon.class_.class3.가장_가까운_세사람_심리거리;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for(int i = 0; i< cases; i++){
            bw.write(sol()+"\n");
        }
        bw.flush();
    }

    static int sol() throws Exception{
        int num = Integer.parseInt(br.readLine());
        String[] typeArr = br.readLine().split(" ");
        map = new HashMap<>();
        for(int i = 0; i<num; i++){
            map.put(typeArr[i], map.getOrDefault(typeArr[i],0)+1);
        }

        min = Integer.MAX_VALUE;
        keyArr = map.keySet().toArray(new String[0]);
        dfs(0, new ArrayList<>());
        return min;
    }
    static int min;
    static Map<String, Integer> map;
    static String[] keyArr;

    static void dfs(int index, List<String> keys){
        if(index == keyArr.length && keys.size() < 3) return;
        if(keys.size() == 3){
            min = Integer.min(min, cal(keys));
            return;
        }
        String key = keyArr[index];
        int keyNum = map.get(key);
        if(keyNum >= 3){
            min = 0;
            return;
        }
        if(keyNum == 2 && keys.size() != 2) {
            keys.add(key);
            keys.add(key);
            dfs(index + 1, keys);
            keys.remove(keys.size() - 1);
            keys.remove(keys.size() - 1);
        }

        keys.add(key);
        dfs(index+1,keys);
        keys.remove(keys.size()-1);

        dfs(index+1,keys);
    }

    static int cal(List<String> keys){
        int result = 0;
        result += cal2(keys.get(0),keys.get(1));
        result += cal2(keys.get(1),keys.get(2));
        result += cal2(keys.get(0),keys.get(2));
        return result;
    }

    static int cal2(String type1, String type2){
        int result = 0;
        for(int i = 0; i<4; i++){
            result = type1.charAt(i) == type2.charAt(i) ? result : result+1;
        }
        return result;
    }

}
