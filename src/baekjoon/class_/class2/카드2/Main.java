package baekjoon.class_.class2.카드2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=num; i++){
            queue.add(i);
        }
        int index = 1;
        while(queue.size() != 1){
            if(index % 2 == 1){
                queue.poll();
            }else{
                queue.add(queue.poll());
            }
            index++;
        }
        bw.write(String.valueOf(queue.poll()));
        bw.flush();
    }


}
