import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Base {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int[] map;
    public static int[][] sol;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n];
        sol = new int[n][n];

        bw.flush();
    }

    public static int sol(){
        return 0;
    }
}
