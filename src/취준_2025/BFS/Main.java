package 취준_2025.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //a
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        Stack<String> a = new Stack<>();
        for(int i = 0; i<n; i++){
            a.push(String.valueOf(s.charAt(i)));
        }

        //b
        n = Integer.parseInt(st.nextToken());
        s = st.nextToken();
        Stack<String> b = new Stack<>();
        for(int i = 0; i<n; i++){
            a.push(String.valueOf(s.charAt(i)));
        }

        //c
        n = Integer.parseInt(st.nextToken());
        s = st.nextToken();

        Stack<String> c = new Stack<>();
        for(int i = 0; i<n; i++){
            a.push(String.valueOf(s.charAt(i)));
        }

        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(a,b,c));

        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i< length; i++){

            }
        }

        bw.flush();
    }

    public static int sol(){
        return 0;
    }

    public static class Data{
        Stack<String> a;
        Stack<String> b;
        Stack<String> c;

        public Data(Stack<String> a,Stack<String> b,Stack<String> c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean win(){
            return !a.contains("B") && !a.contains("C") && !b.contains("A") && !b.contains("C") && !c.contains("A") && !c.contains("B");
        }
    }
}
