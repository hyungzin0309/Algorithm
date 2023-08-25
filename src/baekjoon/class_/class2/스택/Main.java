package baekjoon.class_.class2.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    /*
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i< n; i++){
            String result = func(br.readLine());
            if(result != null && !result.equals("")) bw.write(result+"\n");
        }
        bw.flush();
    }

    static Stack<Integer> stack = new Stack<>();

    static String func(String command){
        switch (command){
            case "pop" : return stack.isEmpty()? "-1" : stack.pop().toString();
            case "size" : return String.valueOf(stack.size());
            case "empty" : return stack.isEmpty()? "1" : "0";
            case "top" : return stack.isEmpty()? "-1" : stack.peek().toString();
            default: stack.push(Integer.parseInt(command.split(" ")[1]));
        }
        return null;
    }
}
