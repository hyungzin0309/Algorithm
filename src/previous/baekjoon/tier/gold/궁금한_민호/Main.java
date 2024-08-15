package previous.baekjoon.tier.gold.궁금한_민호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int check[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if((i == k || k == j)) continue;
                    if(map[i][j] > map[i][k] + map[k][j]){
                        System.out.println(-1);
                        return;
                    }
                    if(map[i][j] == map[i][k] + map[k][j]){
                        check[i][j] = 1;
                    }
                }
            }
        }

        int result = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(check[i][j] == 0) result += map[i][j];
            }
        }

        System.out.println(result / 2);
    }
}
