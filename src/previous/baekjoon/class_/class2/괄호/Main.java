package previous.baekjoon.class_.class2.괄호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            bw.write(sol(br.readLine()));
        }
        bw.flush();
    }

    static String sol(String s){
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(c == '(') queue.add(c);
            else {
                if(queue.isEmpty()) return "NO\n";
                queue.poll();
            }
        }
        return queue.isEmpty() ? "YES\n" : "NO\n";
    }
}
