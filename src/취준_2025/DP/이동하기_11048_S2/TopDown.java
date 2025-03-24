package 취준_2025.DP.이동하기_11048_S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TopDown {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int m;
    public static int[][] map;
    public static int[][] sol;
    public static int INIT_NUM = Integer.MIN_VALUE - 1;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        sol = new int[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                sol[i][j] = INIT_NUM;
            }
        }

        System.out.println(sol(n-1, m-1));
    }

    public static int sol(int n, int m) throws Exception{
        if(n == 0 && m == 0) return map[0][0];
        if(n < 0 || m < 0) return 0; // index 가 넘어가는 경우, 영향가지 않는 숫자 리턴. 음수가 있는 문제에서는 먹히지 않는 방법!!! -> index 가 음수가 되는 경우는 제외하도록 분기쳐야함
        if(sol[n][m] != INIT_NUM) return sol[n][m];

        int point = map[n][m];
        int result = Math.max(sol(n-1, m) + point, sol(n,m-1) + point);

        sol[n][m] = result;
        return result;
    }


}
