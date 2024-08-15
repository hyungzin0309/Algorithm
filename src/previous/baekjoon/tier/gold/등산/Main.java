package previous.baekjoon.tier.gold.등산;

import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int t;
    static int d;
    static int map[][];
    static int cost[][];
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};

    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // map, cost 초기화
        map = new int[n][m];
        cost = new int[n * m][n * m];
        for(int i = 0; i<n*m; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            cost[i][i] = 0;
        }

        // map 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (Character.isUpperCase(c)) {
                    map[i][j] = c - 'A';
                } else {
                    map[i][j] = c - 'a' + 26;
                }
            }
        }

        // cost 에 비용 정보 입력 (인접한 노드들에 대한 이동 비용)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int currentHeight = map[i][j];
                int currentNodeNum = (i * m) + j;
                for (int k = 0; k < 4; k++) {
                    int x = i + move[k][0];
                    int y = j + move[k][1];
                    if (x >= 0 && y >= 0 && x < n && y < m) {
                        int targetHeight = map[x][y];
                        int targetNodeNum = (x * m) + y;
                        if (Math.abs(currentHeight - targetHeight) <= t) {
                            if (currentHeight < targetHeight) {
                                cost[currentNodeNum][targetNodeNum] = (int) Math.pow(targetHeight - currentHeight, 2);
                            } else {
                                cost[currentNodeNum][targetNodeNum] = 1;
                            }
                        }
                    }
                }
            }
        }

        // 플로이드 와샬 -> 모든 서로 다른 노드들에 대한 비용 기록
        for (int k = 0; k< n*m; k++){
            for(int i = 0; i< n*m; i++){
                for(int j = 0; j< n*m; j++) {
                    if(cost[i][k] != Integer.MAX_VALUE && cost[k][j] != Integer.MAX_VALUE) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                    }
                }
            }
        }

        // 결과 구하기
        result = map[0][0];
        for (int i = 1; i< n*m; i++){
            if(cost[0][i] != Integer.MAX_VALUE && cost[i][0] != Integer.MAX_VALUE && cost[0][i] + cost[i][0] <= d){
                result = Math.max(result, map[i / m][i % m]);
            }
        }

        System.out.println(result);

    }
}
