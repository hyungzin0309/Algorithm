package previous.baekjoon.tier.gold.배달;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Point start;
    static List<Point> deliveryPoints = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][2][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    start = new Point(i, j, 0, 0, 0);
                } else if (map[i][j] == 'C') {
                    deliveryPoints.add(new Point(i, j));
                }
            }
        }

        int result = bfs();
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.deliveredFirst == 1 && current.deliveredSecond == 1) {
                return current.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#' || visited[nx][ny][current.deliveredFirst][current.deliveredSecond]) continue;

                int deliveredFirst = current.deliveredFirst;
                int deliveredSecond = current.deliveredSecond;

                if (nx == deliveryPoints.get(0).x && ny == deliveryPoints.get(0).y) deliveredFirst = 1;
                if (nx == deliveryPoints.get(1).x && ny == deliveryPoints.get(1).y) deliveredSecond = 1;

                visited[nx][ny][deliveredFirst][deliveredSecond] = true;
                queue.add(new Point(nx, ny, current.count + 1, deliveredFirst, deliveredSecond));
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Point {
        int x, y, count, deliveredFirst, deliveredSecond;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int count, int deliveredFirst, int deliveredSecond) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.deliveredFirst = deliveredFirst;
            this.deliveredSecond = deliveredSecond;
        }
    }
}
