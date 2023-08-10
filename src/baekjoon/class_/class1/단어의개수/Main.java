package baekjoon.class_.class1.단어의개수;

import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int result = s.length;
        if(s.length != 0){
            if(s[0].equals("")) result--;
            if(s[s.length-1].equals("")) result--;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
