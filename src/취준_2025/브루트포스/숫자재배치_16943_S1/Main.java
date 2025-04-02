package 취준_2025.브루트포스.숫자재배치_16943_S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static String a;
    public static int aLength;
    public static int b;
    public static int answer = -1;
    public static int[] visited;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        aLength = a.length();
        b = Integer.parseInt(st.nextToken());
        visited = new int[aLength];

        sol(new StringBuilder());

        System.out.println(answer);
    }

    public static void sol(StringBuilder s){
        if(s.length() > 0 && s.charAt(0) == '0') return;

        if(s.length() == aLength) {
            int result = Integer.parseInt(s.toString());
            if(result < b){
                answer = Math.max(answer, result);
            }
        }

        for(int i = 0; i<aLength; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                s.append(a.charAt(i));
                sol(s);
                s.deleteCharAt(s.length()-1);
                visited[i] = 0;
            }
        }
    }

}
