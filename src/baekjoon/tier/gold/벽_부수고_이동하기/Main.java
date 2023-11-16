package baekjoon.tier.gold.벽_부수고_이동하기;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] visited;
    static int[][] cases = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];
        for(int i = 0; i< n; i++){
            String s = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        bw.write(String.valueOf(sol()));
        bw.flush();

    }

    // 2 : 벽을 부수지 않고 도달
    // 1 : 벽을 부수고 도달
    // 0 : 아직 도달하지 않음

    // - 벽을 부수고 한 지점에 도달했는데, 이미 그 지점에 벽을 부수지 않고 도달한 흔적이(visited[x] == 2) 있는 경우 경우를 따질 필요 없음
    // - 벽을 부수고 한 지점에 도달했는데, 이미 그 지점에 벽을 부수고 도달한 흔적이(visited[x] == 1) 있는 경우 경우를 따질 필요 없음
    // - 벽을 부수지 않고 한 지점에 도달했는데, 이미 그 지점에 벽을 부수지 않고 도달한 흔적이(visited[x] == 2) 있는 경우 경우를 따질 필요 없음

    // + 벽을 부수고 한 지점에 도달했는데, 그 지점을 지난 흔적이 없으면(visited[x] == 0) 경우를 따짐
    // + 벽을 부수지 않고 한 지점에 도달했는데, 그 지점을 지난 흔적이 없으면(visited[x] == 0) 경우를 따짐
    // + 벽을 부수지 않고 한 지점에 도달했을 때, 이미 그 지점에 벽을 부수고 도달한 흔적이(visited[x] == 1) 있더라도 경우를 따져야 함

    static int sol(){
        int level = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(new int[]{0,0},0));
        visited[0][0] = 2;
        while(!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {

                Point current = queue.poll();
                if(current.isTargetPoint()) return level;

                for (int k = 0; k < 4; k++) { // 네 방향 케이스
                    int x = current.point[0] + cases[k][0];
                    int y = current.point[1] + cases[k][1];

                    if (0 <= x && x < n && 0 <= y && y < m){ // 유효한 좌표
                        if (current.destroy == 0) { // 벽을 부수지 않고 현재까지 왔을 때
                            if (visited[x][y] == 0) { // 목표지점에 방문 흔적이 없을 때
                                if (map[x][y] == 0) { // 벽이 아닐 때
                                    visited[x][y] = 2;
                                    queue.add(new Point(new int[]{x, y}, 0));
                                } else if (map[x][y] == 1) { // 벽일 떄
                                    visited[x][y] = 1;
                                    queue.add(new Point(new int[]{x, y}, 1));
                                }
                            }
                            else if( visited[x][y] == 1){ // 한 번 부수고 방문한 흔적이 있을 때
                                if (map[x][y] == 0) { // 벽이 아닐 때
                                    visited[x][y] = 2;
                                    queue.add(new Point(new int[]{x, y}, 0));
                                }
                            }
                        } else if (current.destroy == 1) {
                            if (visited[x][y] == 0) { // 목표지점에 방문 흔적이 없을 때
                                if (map[x][y] == 0) { // 벽이 아닐 때만
                                    visited[x][y] = 1;
                                    queue.add(new Point(new int[]{x, y}, 1));
                                }
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    static class Point{
        int[] point;
        int destroy;

        public Point(int[] p, int d){
            point = p;
            destroy = d;
        }

        public boolean isTargetPoint(){
            return point[0] == n-1 && point[1] == m-1;
        }
    }
}
