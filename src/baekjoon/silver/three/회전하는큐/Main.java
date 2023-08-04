package baekjoon.silver.three.회전하는큐;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        num = Integer.parseInt(s[0]);
        pickNum = Integer.parseInt(s[1]);
        for(int i = 1; i<num+1; i++){
            queue.add(i);
        }
        String[] s2 = br.readLine().split(" ");
        needNums = new int[pickNum];
        for(int i = 0; i< pickNum; i++){
            needNums[i] = Integer.parseInt(s2[i]);
        }
        sol();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static int num;
    static int pickNum;
    static int[] needNums;
    static int result = 0;
    static LinkedList<Integer> queue = new LinkedList<>();

    static void sol(){
        for(int i = 0; i< pickNum; i++){
            int size = queue.size();
            int index = queue.indexOf(needNums[i]);
            if(index <= size - index){
                while(queue.peek() != needNums[i]){
                    queue.add(queue.poll());
                    result++;
                }
                queue.poll();
            }else{
                while(queue.peek() != needNums[i]){
                    queue.addFirst(queue.pollLast());
                    result++;
                }
                queue.poll();
            }
        }
    }
}
