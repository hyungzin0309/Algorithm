package baekjoon.class_.class3.이중_우선순위_큐;

import java.io.*;
import java.util.TreeMap;

public class Main_TreeMap {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for(int i = 0; i< cases; i++){
            sol();
        }
        bw.flush();
    }

    static void sol() throws Exception{
        int num = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i< num; i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("I")){
                int val = Integer.parseInt(command[1]);
                map.put(val,map.getOrDefault(val,0)+1);
            }else{
                boolean popMin = command[1].equals("-1");
                if(map.size()!=0){
                    if(popMin){
                        if(map.firstEntry().getValue() == 1) map.remove(map.firstKey());
                        else map.put(map.firstKey(), map.firstEntry().getValue()-1);
                    }else{
                        if(map.lastEntry().getValue() == 1) map.remove(map.lastKey());
                        else map.put(map.lastKey(), map.lastEntry().getValue()-1);
                    }
                }
            }
        }
        String result = map.isEmpty() ? "EMPTY\n" : map.lastKey() + " " + map.firstKey() + "\n";
        bw.write(result);
    }
}
