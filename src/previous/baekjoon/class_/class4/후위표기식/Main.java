package previous.baekjoon.class_.class4.후위표기식;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Deque<String> queue = new ArrayDeque<>();

        int brackets = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(') brackets++;
            queue.add(String.valueOf(s.charAt(i)));
        }

        Deque<String> temp = new ArrayDeque<>();

        while(!queue.isEmpty()){
            String c = queue.poll();
            if(c.equals(")")){
                Deque<String> bracket = new ArrayDeque<>();
                while(true){
                    String t = temp.pollLast();
                    if(t.equals("(")) {
                        temp.add(inBracket(bracket));
                        brackets--;
                        break;
                    }
                    else bracket.addFirst(t);
                }
            }else{
                temp.addLast(c);
            }
        }
        System.out.println(inBracket(temp));
    }

    static String inBracket(Deque<String> queue){
        int firstOrder = 0;
        for(int i = 0; i<queue.size(); i++){
            String s = queue.poll();
            if(s.equals("*") || s.equals("/")) firstOrder++;
            queue.add(s);
        }
        while(queue.size() != 1){
            Deque<String> tempQueue = new ArrayDeque<>();
            if(firstOrder !=0){
                while(!queue.isEmpty()){
                    String s = queue.poll();
                    if(s.equals("*") || s.equals("/")){
                        String temp = tempQueue.pollLast() + queue.poll();
                        temp += s;
                        tempQueue.addLast(temp);
                        firstOrder--;
                    }else{
                        tempQueue.addLast(s);
                    }
                }
                queue = tempQueue;
            }else if(firstOrder == 0){
                StringBuilder sb = new StringBuilder(queue.poll());
                while(queue.size()!=0){
                    String temp = queue.poll();
                    sb.append(queue.poll());
                    sb.append(temp);
                }
                queue.add(sb.toString());
            }
        }

        return queue.poll();
    }
}
