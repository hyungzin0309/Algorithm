package 취준_2025.정렬.프로그래머스_H_Index;
import java.util.*;
public class Main {
    public int solution(int[] citations) {
        int sum = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : citations){
            queue.add(num);
        }
        int result = 0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            sum += 1;

            if(num > sum) result = Math.max(sum, result);
            if(sum >= num) result = Math.max(num, result);
        }
        return result;
    }
}
