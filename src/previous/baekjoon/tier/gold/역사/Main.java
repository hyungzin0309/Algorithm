package previous.baekjoon.tier.gold.역사;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int map[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1][n2] = -1;
            map[n2][n1] = 1;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++) {
                for(int k = 1; k<=n; k++) {
                    if(i != j && map[i][j] == 0 && map[i][k] != 0 && map[k][j]!=0){
                        if(map[i][k] == map[k][j]) map[i][j] = map[i][k];
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        for(int i = 0; i<s; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            bw.write(map[n1][n2]+"\n");
        }
        bw.flush();
    }

}
