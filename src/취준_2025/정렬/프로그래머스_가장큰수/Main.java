package 취준_2025.정렬.프로그래머스_가장큰수;

import java.util.*;

public class Main {
    public String solution(int[] numbers) {
        Queue<Number> queue = new PriorityQueue<>();
        for(int num : numbers){
            queue.add(new Number(num));
        }
        String result = "";
        while(!queue.isEmpty()){
            result += queue.poll().num;
        }
        if(result.startsWith("0")) return "0";
        return result;
    }

    public class Number implements Comparable<Number>{
        String num;

        public Number(int num){
            this.num = String.valueOf(num);
        }

        @Override
        public int compareTo(Number other){
            int num1 = Integer.parseInt(this.num + other.num);
            int num2 = Integer.parseInt(other.num + this.num);
            return num2 - num1;
        }
    }
}
