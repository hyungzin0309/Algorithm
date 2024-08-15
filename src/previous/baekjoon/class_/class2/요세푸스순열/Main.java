package previous.baekjoon.class_.class2.요세푸스순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class Main {

    static int n;
    static int k;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s  = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        bw.write("<");
        bw.write(sol());
        bw.write(">");
        bw.flush();
    }

    static String sol(){
        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i< n+1; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int index = 1;
            while(index != k){
                queue.add(queue.poll());
                index++;
            }
            result.append(queue.poll());
            result.append(", ");
        }
        return result.substring(0,result.length()-2);
    }
}
