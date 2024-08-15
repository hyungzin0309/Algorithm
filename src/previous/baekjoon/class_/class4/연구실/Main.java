package previous.baekjoon.class_.class4.연구실;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(3, 0, -1);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    static void dfs(int num, int previousX, int previousY){
        if(num == 0){
            sol();
            return;
        }

        int startX;
        int startY;

        if(previousY == m-1){
            if(previousX == n-1) return;
            else{
                startX = previousX+1;
                startY = 0;
            }
        }else{
            startX = previousX;
            startY = previousY+1;
        }

        for(int i = startX; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i == startX && j < startY) continue;
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(num-1, i, j);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void sol(){

        int[][] copiedMap = new int[n][m];
        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                copiedMap[i][j] = map[i][j];
            }
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                if(copiedMap[i][j] == 2){
                    bfs(copiedMap,i,j);
                }
            }
        }

        int sum = 0;

        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                if(copiedMap[i][j]==0) sum++;
            }
        }

        result = Math.max(sum, result);
    }

    static int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    static void bfs(int[][] copied, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i< len; i++){
                int[] cur = queue.poll();
                for(int k = 0 ; k<4;k++){
                    int a = cur[0] + move[k][0];
                    int b = cur[1] + move[k][1];

                    if(a >= 0 && b >= 0 && a<n && b<m && copied[a][b] == 0){
                        copied[a][b] = 2;
                        queue.add(new int[]{a,b});
                    }

                }
            }
        }
    }

}
