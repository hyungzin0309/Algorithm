package baekjoon.tier.gold.내리막길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int map[][];
    static int memory[][];
    static int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        memory = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                memory[i][j] = -1;
            }
        }
        List<int[]> memory = new ArrayList<>();
        memory.add(new int[]{0,0});
        System.out.println(dfs(0,0));
    }

    static int dfs(int a, int b){
        if(a == n-1 && b == m-1) {
            return 1;
        }

        memory[a][b] = 0;

        for(int i = 0; i< 4; i++){
            int x = move[i][0] + a;
            int y = move[i][1] + b;
            if(x >= 0 && y >= 0 && x < n && y < m && map[a][b] > map[x][y]){
                if(memory[x][y] == -1){
                    memory[a][b] += dfs(x,y);
                }else{
                    memory[a][b] += memory[x][y];
                }
            }
        }
        return memory[a][b];
    }
}
