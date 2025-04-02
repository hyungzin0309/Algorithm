package 취준_2025.브루트포스.감시_15683_G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int m;
    public static int[][] map;
    public static List<Cctv> cctvs = new ArrayList<>();
    public static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++){
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if(val >= 1 && val<6){
                    cctvs.add(new Cctv(i,j,val));
                }
            }
        }

        sol(0, map);
        System.out.println(answer);
        bw.flush();
    }

    static int[][] cctvType = {{},{1},{1,3},{0,1},{0,1,3},{0,1,2,3}}; // CCTV 타입 별 화살표 방향 묶음
    static int[][] move = {{-1,0},{0,1},{1,0},{0,-1}}; // 위,오,아래,왼

    public static void sol(int index, int[][] currentMap){
        if(index == cctvs.size()){
            answer = Math.min(answer, count(currentMap));
            return;
        }
        Cctv cctv = cctvs.get(index);
        int[] directions = cctvType[cctv.type];

        for(int i = 0; i<4; i++){
            int[][] newMap = deepCopy(currentMap);
            for(int j = 0; j< directions.length; j++){
                int dir = (directions[j] + i) % 4;
                int[] moveType = move[dir];
                int dx = cctv.x; // 이동좌표
                int dy = cctv.y;
                int dirX = moveType[0];
                int dirY = moveType[1];
                while(true){
                    dx += dirX;
                    dy += dirY;
                    if(dx < 0 || dy < 0 || dx >= n || dy >= m || map[dx][dy] == 6){
                        break;
                    }
                    newMap[dx][dy] = 7;
                }
            }
            sol(index+1, newMap);
        }
    }

    public static int count(int[][] map){
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static int[][] deepCopy(int[][] map){
        int[][] result = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                result[i][j] = map[i][j];
            }
        }
        return result;
    }

    public static class Cctv{
        int x;
        int y;
        int type;

        public Cctv(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
