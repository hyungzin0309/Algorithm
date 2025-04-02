package 취준_2025.구현.미세먼지안녕_17144_G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int m;
    public static int k;
    public static int[][] map;
    public static int[][] newMap;
    public static int x1 = 0;
    public static int x2 = 0;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i= 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j<m; j++){
                Integer val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if(val == -1){
                    if(x1 == 0) x1 = i;
                    else x2 = i;
                }
            }
        }
        System.out.println(sol());
    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static int sol(){
        for(int second = 0; second< k; second++){
            //확산
            newMap = new int[n][m];
            for(int x = 0; x<n; x++){
                for(int y = 0; y<m; y++){
                    newMap[x][y] += map[x][y];
                    if(map[x][y] == -1) continue;
                    if(map[x][y] == 0) continue;
                    for(int k = 0; k<4; k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(ny == 0 && (nx == x1 || nx == x2)) continue; // 공기청정기자리 확산불가
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        newMap[nx][ny] += map[x][y] / 5;
                        newMap[x][y] -= (map[x][y] / 5);
                    }
                }
            }
            map = newMap;
            //공기청정
            //상단
            //왼쪽, 위에서 아래로
            for(int i = x1 - 1; i>=1; i--){
                map[i][0] = map[i-1][0];
            }
            // 위쪽끝, 오른쪽에서 왼쪽으로
            for(int i = 0; i < m-1; i++){
                map[0][i] = map[0][i+1];
            }
            // 오른쪽 끝, 아래에서 위로
            for(int i = 0; i<x1; i++){
                map[i][m-1] = map[i+1][m-1];
            }
            // 가운데, 왼쪽에서 오른쪽
            for(int i = m-1; i>=2; i--) {
                map[x1][i] = map[x1][i - 1];
            }
            map[x1][1] = 0;

            //하단
            // 왼쪽, 아래에서 위로
            for(int i = x2 + 1; i<n-1; i++){
                map[i][0] = map[i+1][0];
            }
            // 오른쪽에서 왼쪽으로
            for(int i = 0; i < m-1; i++){
                map[n-1][i] = map[n-1][i+1];
            }
            // 위에서 아래로
            for(int i = n-1; i>x2; i--){
                map[i][m-1] = map[i-1][m-1];
            }
            // 왼쪽에서 오른쪽
            for(int i = m-1; i>=2; i--) {
                map[x2][i] = map[x2][i - 1];
            }
            map[x2][1] = 0;

        }
        int result = 0;
        for(int i= 0; i<n; i++){
            for(int j= 0; j<m; j++){
                result += map[i][j];
            }
        }
        return result+2;
    }
}
