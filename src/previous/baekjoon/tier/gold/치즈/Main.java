package previous.baekjoon.tier.gold.치즈;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] cases = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static boolean allMelted = true;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 1) allMelted = false;
            }
        }

        int hour = 0;
        while(!allMelted){
            allMelted = true;
            checkOuterAir();
            for(int i = 1; i< n-1; i++){
                for(int j = 1; j<m-1; j++){
                    if(map[i][j] == 1){
                        if(melted(i,j)) map[i][j] = 0;
                        else allMelted = false;
                    }
                }
            }
            hour++;
        }

        bw.write(String.valueOf(hour));
        bw.flush();
    }

    public static boolean melted(int a, int b){
        int result = 0;
        for(int i = 0; i<4; i++){
            int x = a + cases[i][0];
            int y = b + cases[i][1];
            if(map[x][y] == -1){
                result++;
            }
        }
        return result >= 2;
    }

    // -1은 외부공기, 0은 내부공기
    static int[][] visited;
    static void checkOuterAir(){
        visited = new int[n][m];
        bfs();
    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = 1;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int k = 0; k<length; k++){
                int[] cur = queue.poll();

                for(int i = 0; i<4; i++){
                    int x = cur[0] + cases[i][0];
                    int y = cur[1] + cases[i][1];
                    if(0 <= x && x < n && 0 <=y && y<m){
                        if((map[x][y] == 0 || map[x][y] == -1) && visited[x][y] == 0){
                            visited[x][y] = 1;
                            map[x][y] = -1;
                            queue.add(new int[]{x,y});
                        }
                    }
                }

            }
        }
    }
}
