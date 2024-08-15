package previous.baekjoon.tier.gold.알고스팟;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] cost;
    static int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cost = new int[n][m];

        for(int i = 0; i< n; i++){
            String line = br.readLine();
            Arrays.fill(cost[i],Integer.MAX_VALUE);
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0,0,0));

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cost[cur.x][cur.y] == Integer.MAX_VALUE) {
                cost[cur.x][cur.y] = cur.cost;
                for(int i = 0; i<4; i++){
                    int x = cur.x + move[i][0];
                    int y = cur.y + move[i][1];
                    if(x >= 0 && y>=0 && x<n && y<m){
                        queue.add(new Node(x,y,map[x][y] + cur.cost));
                    }
                }
            }
        }

        System.out.println(cost[n-1][m-1]);
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return cost - o.cost;
        }
    }
}
