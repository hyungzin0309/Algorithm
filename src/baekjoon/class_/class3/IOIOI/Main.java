package baekjoon.class_.class3.IOIOI;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int length;
    static int result = 0;
    static Stack<Character> stack = new Stack<>();;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        length = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i = 0; i< length; i++){
            char c = s.charAt(i);

            // 차곡차곡 쌓기
            if((c == 'I' && (stack.isEmpty() || stack.peek() == 'O'))
                ||(c == 'O' && !stack.isEmpty() && stack.peek() == 'I'))
            {
                stack.push(c);
            }
            // 불규칙하게 들어왔을 때
            else{
                cal();
                stack.clear();
                if(c == 'I') stack.push(c);
            }
        }
        cal();

        bw.write(String.valueOf(result));
        bw.flush();
    }

    static void cal(){
        if(stack.isEmpty()) return;
        if(stack.size() /2 == 0) stack.pop();
        if(stack.size() >= ((n*2)+1)){
            result += (stack.size() - ((n*2)+1))/2 + 1;
        }
    }


}
