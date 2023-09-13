package baekjoon.class_.class3.뱀과사다리;

import java.io.*;
import java.util.*;

public class Main {

    static int ladderNum;
    static int snakeNum;
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    static int[] visited = new int[101];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        ladderNum = Integer.parseInt(s[0]);
        snakeNum = Integer.parseInt(s[1]);
        for(int i = 0; i< ladderNum; i++){
            String[] ls = br.readLine().split(" ");
            ladder.put(Integer.parseInt(ls[0]),Integer.parseInt(ls[1]));
        }
        for(int i = 0; i< snakeNum; i++){
            String[] ss = br.readLine().split(" ");
            snake.put(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]));
        }
        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;
        int level = 1;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i< length; i++){
                int current = queue.poll();
                for(int k = 1; k<=6; k++){
                    int target = current + k;
                    if(target == 100 || ladder.getOrDefault(target,0) == 100) return level;
                    if(target < 100 && visited[target] == 0){
                        visited[target] = 1;
                        int ladderTarget = ladder.getOrDefault(target,0);
                        int snakeTarget = snake.getOrDefault(target,0);
                        if(ladderTarget != 0 || snakeTarget != 0){
                            if(ladderTarget != 0){
                                if(visited[ladder.get(target)] == 0){
                                    visited[ladder.get(target)] = 1;
                                    queue.add(ladder.get(target));
                                }
                            }else if(snakeTarget != 0){
                                if(visited[snake.get(target)] == 0){
                                    visited[snake.get(target)] = 1;
                                    queue.add(snake.get(target));
                                }
                        }
                        }else{
                            queue.add(target);
                        }
                    }
                }
            }
            ++level;
        }
        return 0;
    }

}
