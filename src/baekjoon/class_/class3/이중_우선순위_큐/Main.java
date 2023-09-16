package baekjoon.class_.class3.이중_우선순위_큐;

import java.io.*;
import java.util.*;

public class Main {

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
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i< num; i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("I")){
                int val = Integer.parseInt(command[1]);
                asc.add(val);
                desc.add(val);
            }else{
                boolean popMin = command[1].equals("-1");
                if(!asc.isEmpty()){
                    if(popMin){
                        int min = asc.poll();
                        desc.remove(min);
                    }else{
                        int max = desc.poll();
                        asc.remove(max);
                    }
                }
            }
        }
        String result = asc.isEmpty() ? "EMPTY\n" : desc.poll() + " " + asc.poll()+"\n";
        bw.write(result);
    }

}


