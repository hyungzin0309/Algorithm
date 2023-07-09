package inflearn.previous.잘린막대구하기_stack;

import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(c);
            else{
                if(s.charAt(i-1) == ')'){
                    stack.pop();
                    result+=1;
                }else{
                    stack.pop();
                    result += stack.size();
                }
            }
        }
        return result;
    }
}
