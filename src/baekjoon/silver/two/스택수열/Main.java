package baekjoon.silver.two.스택수열;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        target = new int[num];
        for(int i = 0; i<num; i++){
            target[i] = Integer.parseInt(br.readLine());
        }
        sol();
        while(!result.isEmpty()){
            bw.write(result.poll()+"\n");
        }
        bw.flush();
    }

/**
8
4
3
6
8
7
5
2
1
*/
    static int num;
    static int[] target;
    static LinkedList<String> result = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();

    static void sol(){
        int index = 0;
        int targetNum = target[index];
        for(int i = 1; i<= num; i++){
            if(i == targetNum){
                result.add("+");
                result.add("-");
                if(index != num-1) targetNum = target[++index];
                while(!stack.isEmpty() && stack.peek() == targetNum){
                    result.add("-");
                    stack.pop();
                    if(index != num-1) targetNum = target[++index];
                }
            }else {
                result.add("+");
                stack.push(i);
            }
        }
        if(!stack.isEmpty()){
            result = new LinkedList<>();
            result.add("NO");
        }
    }

}
