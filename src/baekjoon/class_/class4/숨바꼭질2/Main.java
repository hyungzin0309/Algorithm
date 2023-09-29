package baekjoon.class_.class4.숨바꼭질2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Main {

    static int s;
    static int t;
    static int[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        if(s == t) {
            bw.write(0+"\n");
            bw.write(String.valueOf(1));
            bw.flush();
            return;
        }

        visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = 0;
        int level = 0;
        while(!queue.isEmpty() && !isFindLevel){
            level++;
            int length = queue.size();
            for(int i = 0; i< length; i++){
                int cur = queue.poll();
                int[] nextPoints = {cur-1, cur+1, 2*cur};
                for(int next : nextPoints){
                    if(next <= 100000 && next >= 0 && level <= visited[next]){
                        visited[next] = level;
                        if(next == t){
                            isFindLevel = true;
                            type++;
                        }else{
                            queue.add(next);
                        }
                    }
                }
            }
        }
        bw.write(level+"\n");
        bw.write(String.valueOf(type));
        bw.flush();

    }
    static boolean isFindLevel;
    static int type;
}
