package previous.baekjoon.class_.class2.통계학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int num;
    static Map<Integer, Integer> map = new HashMap<>();

    static double avg;
    static Integer middle;
    static int max;
    static int min;
    static List<Integer> mostAppearedNums = new ArrayList<>();
    static Integer mostAppeared;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        for(int i = 0; i< num; i++){
            int k = Integer.parseInt(br.readLine());
            map.put(k, map.getOrDefault(k, 0)+1);
        }
        sol();
        Integer mostapp = mostAppearedNums.size()==1?mostAppearedNums.get(0) :mostAppearedNums.get(1);
        bw.write((int)Math.round(avg)+"\n");
        bw.write(middle+"\n");
        bw.write( mostapp+"\n");
        bw.write(Math.abs(max - min)+"\n");
        bw.flush();
    }

    static void sol(){
        avg = 0.0;
        int checkMiddle = 0;
        int middleNum = num/2 + 1;
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        min = keys[0];
        max = keys[keys.length-1];
        for(int i = 0; i< keys.length; i++){
            int key = keys[i];
            int keyNum = map.get(key);

            if(mostAppeared == null || mostAppeared < keyNum) {
                mostAppeared = keyNum;
                mostAppearedNums.clear();
                mostAppearedNums.add(key);
            }else if(mostAppeared == keyNum){
                mostAppearedNums.add(key);
            }

            checkMiddle += keyNum;
            if(middle== null && checkMiddle >= middleNum) middle = key;

            avg += key * keyNum;
        }
        avg /= num;
        Collections.sort(mostAppearedNums);
    }
}
