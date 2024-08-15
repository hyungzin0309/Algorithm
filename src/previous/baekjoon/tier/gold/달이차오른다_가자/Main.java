package previous.baekjoon.tier.gold.달이차오른다_가자;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int h = 1; h <= 9; h++) {
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == h && !visited[i][j]) {
                        result += bfs(i, j, h);
                    }
                }
            }
        }

        System.out.println(result);
    }

    static int bfs(int x, int y, int height) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> pool = new ArrayList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        boolean isEnclosed = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            pool.add(current);

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] < height && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    } else if (map[nx][ny] <= height) {
                        isEnclosed = false;
                    }
                } else {
                    isEnclosed = false;
                }
            }
        }

        if (isEnclosed) {
            for (Point p : pool) {
                map[p.x][p.y]++;
            }
            return pool.size();
        }
        return 0;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
