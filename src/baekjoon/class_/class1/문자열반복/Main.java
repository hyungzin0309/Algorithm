package baekjoon.class_.class1.문자열반복;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());

        for(int k = 0; k<cases; k++){
            String[] s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);
            for(char c : s[1].toCharArray()){
                for(int i = 0; i< num; i++){
                    bw.write(String.valueOf(c));
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
