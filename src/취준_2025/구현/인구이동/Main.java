package 취준_2025.구현.인구이동;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int[][] map;
    public static int[][] visited;
    public static int n;
    public static int L;
    public static int R;
    public static int days = 0;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol();

        System.out.println(days);
        bw.flush();
    }

    public static List<Point> group;

    public static void sol(){
        while(true){ // 하루마다 돔
            boolean moved = false;
            visited = new int[n][n];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(visited[i][j] == 0){
                        group = new ArrayList<>();
                        makeGroup(i, j);
                        if(group.size() > 1){
                            move();
                            moved = true;
                        }
                    }
                }
            }
            if(moved) {
                days++;
            }else{
                break;
            }
        }
    }
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    public static void makeGroup(int startX, int startY){
        Queue<Point> queue = new LinkedList<>();
        Point start = new Point(startX,startY);
        queue.add(start);
        group.add(start);
        visited[startX][startY] = 1;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] == 1) continue;

                int diff = Math.abs(map[x][y] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = 1;
                    group.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void move(){
        int sum = 0;
        int size = group.size();
        for(Point p : group){
            sum += map[p.x][p.y];
        }
        int avg = sum/size;
        for(Point p : group){
            map[p.x][p.y] = avg;
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
