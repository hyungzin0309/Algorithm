package baekjoon.class_.class3.미로탐색;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        for(int i = 0; i< n; i++){
            String line = br.readLine();
            for(int j = 0; j< m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        bfs();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int level = 1;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i< length; i++){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if(x==n-1 && y==m-1) {
                    result = level;
                    return;
                }

                if(x > 0 && map[x-1][y] == 1) {
                    map[x-1][y] = 0;
                    queue.add(new int[]{x-1,y});
                }
                if(y > 0 && map[x][y-1] == 1) {
                    map[x][y-1] = 0;
                    queue.add(new int[]{x,y-1});
                }
                if(x < n-1 && map[x+1][y] == 1) {
                    map[x+1][y] = 0;
                    queue.add(new int[]{x+1,y});
                }
                if(y < m-1 && map[x][y+1] == 1) {
                    map[x][y+1] = 0;
                    queue.add(new int[]{x,y+1});
                }
            }
            level++;
        }
    }
}
