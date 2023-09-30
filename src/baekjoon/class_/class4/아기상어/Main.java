package baekjoon.class_.class4.아기상어;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[] current;
    static int size = 2;
    static int result;
    static int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                int p = Integer.parseInt(st.nextToken());
                if(p == 9) {
                    current = new int[]{i,j};
                }else{
                    map[i][j] = p;
                }
            }
        }
        sol();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static void sol(){
        while(true){
            int second = bfs();
            if(second == -1) break;
            result += second;
        }
    }

    static int stack = 0;

    static int bfs(){
        boolean[][] visited = new boolean[n][n];;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{current[0], current[1]});
        visited[current[0]][current[1]] = true;

        int second = 0;
        boolean isEatingTime = false;
        PriorityQueue<int[]> candidates = new PriorityQueue<>(new Com());

        while(!queue.isEmpty() && !isEatingTime){
            int length = queue.size();
            for(int i = 0; i< length; i++){
                int[] cur = queue.poll();

                for(int k = 0; k < 4; k++){
                    int nextX = cur[0] + move[k][0];
                    int nextY = cur[1] + move[k][1];
                    if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < n
                            && !visited[nextX][nextY]
                            && map[nextX][nextY] <= size){
                        visited[nextX][nextY] = true;
                        if(map[nextX][nextY] < size && map[nextX][nextY] != 0){
                            isEatingTime = true;
                            candidates.add(new int[]{nextX, nextY});
                        }else{
                            queue.add(new int[]{nextX, nextY});
                        }

                    }
                }
            }
            second++;
        }

        if(candidates.isEmpty()){
            return -1;
        }
        int[] target = candidates.poll();
        current = new int[]{target[0], target[1]};
        map[target[0]][target[1]] = 0;
        stack++;
        if(stack == size){
            stack = 0;
            size++;
        }
        return second;
    }

    public static class Com implements Comparator<int[]>{

        public Com(){

        }

        @Override
        public int compare(int[] a, int[] b){
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        }
    }

}
