package baekjoon.class_.class3.숨바꼭질;

import java.io.*;
import java.util.*;

public class Main {

    static int start;
    static int target;
    static int result;
    static int[] memory = new int[100001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        target = Integer.parseInt(s[1]);

        result = bfs();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static int bfs(){
        Queue<Integer> queue = new LinkedList<>(List.of(start));
        int level = 0;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i< length; i++){
                int current = queue.poll();
                if(current == target) return level;
                if(current != 0 && memory[current-1] != 1){
                    queue.add(current-1);
                    memory[current-1] = 1;
                }
                if(current+1 < memory.length && memory[current+1] != 1){
                    queue.add(current+1);
                    memory[current+1] = 1;
                }
                if(current*2 < memory.length && memory[current*2] != 1){
                    queue.add(current*2);
                    memory[current*2] = 1;
                }
            }
            level++;
        }
        return -1;
    }
}
