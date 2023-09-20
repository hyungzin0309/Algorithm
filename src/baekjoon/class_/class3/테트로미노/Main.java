package baekjoon.class_.class3.테트로미노;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i< n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        sol();
        bw.write(String.valueOf(max));
        bw.flush();
    }

    static void sol(){
        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                visited[i][j] = 1;
                dfs(i,j,1, map[i][j]);
                checkFuckShape(i,j);
                visited[i][j] = 0;
            }
        }
    }

    static void dfs(int x, int y, int num, int sum){
        if(num == 4){
            max = Math.max(max, sum);
            return;
        }

        if(x > 0 && visited[x-1][y] == 0){
            visited[x-1][y] = 1;
            dfs(x-1, y, num + 1, sum + map[x-1][y]);
            visited[x-1][y] = 0;
        }
        if(y > 0 && visited[x][y-1] == 0){
            visited[x][y-1] = 1;
            dfs(x, y-1, num + 1, sum + map[x][y-1]);
            visited[x][y-1] = 0;
        }
        if(x < n-1 && visited[x+1][y] == 0){
            visited[x+1][y] = 1;
            dfs(x+1, y, num + 1, sum + map[x+1][y]);
            visited[x+1][y] = 0;
        }
        if(y < m-1 && visited[x][y+1] == 0){
            visited[x][y+1] = 1;
            dfs(x, y+1, num + 1, sum + map[x][y+1]);
            visited[x][y+1] = 0;
        }
    }

    //볼록모양 블럭 체크
    static void checkFuckShape(int x, int y){
        List<Integer> fourWayPoint = new ArrayList<>();
        int sum = map[x][y];
        if(x > 0 && visited[x-1][y] == 0){
            int point = map[x-1][y];
            fourWayPoint.add(point);
            sum += point;
        }
        if(y > 0 && visited[x][y-1] == 0){
            int point = map[x][y-1];
            fourWayPoint.add(point);
            sum += point;
        }
        if(x < n-1 && visited[x+1][y] == 0){
            int point = map[x+1][y];
            fourWayPoint.add(point);
            sum += point;
        }
        if(y < m-1 && visited[x][y+1] == 0){
            int point = map[x][y+1];
            fourWayPoint.add(point);
            sum += point;
        }
        if(fourWayPoint.size() == 3){
            max = Math.max(max, sum);
        }else if(fourWayPoint.size() == 4){
            for(int i = 0; i< 4; i++){
                max = Math.max(max, sum - fourWayPoint.get(i));
            }
        }
    }

}
