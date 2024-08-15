package previous.baekjoon.class_.class3.듣보잡;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int g1 = Integer.parseInt(s[0]);
        int g2 = Integer.parseInt(s[1]);
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<g1; i++){
            map.put(br.readLine(),1);
        }
        for(int i = 0; i<g2; i++){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name,0)+1);
        }
        List<String> resultList = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == 2) {
                resultList.add(key);
            }
        }
        bw.write(resultList.size()+"\n");
        Collections.sort(resultList);
        for(String name : resultList){
            bw.write(name+"\n");
        }
        bw.flush();
    }
}
