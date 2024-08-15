package previous.baekjoon.tier.gold.카드섞기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] order;
    static int[] cards;
    static int result = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        order = new int[num];
        cards = new int[num];
        for(int i = 0; i<num; i++){
            cards[i] = i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< num; i++){
            map.put(i, Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< num; i++){
            order[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static void sol(){
        int level = 0;
        while(true){
            try{
                if(check(level!=0)){
                    result = level;
                    return;
                }
                mix();
                level++;
            }catch(Exception e){
                return;
            }
        }
    }

    static boolean check(boolean checkFirst){
        boolean isFirstStatus = true;
        boolean result = true;
        for(int i = 0; i<num; i++){
            if(cards[i] != i) isFirstStatus = false;
            int person = i%3;
            if(person != map.get(cards[i])){
                result = false;
            }
        }
        if(isFirstStatus && checkFirst) throw new RuntimeException();
        return result;
    }

    static void mix(){
        int[] temp = new int[num];
        for(int i = 0; i<num; i++){
            temp[order[i]] = cards[i];
        }
        cards = temp;
    }



}
