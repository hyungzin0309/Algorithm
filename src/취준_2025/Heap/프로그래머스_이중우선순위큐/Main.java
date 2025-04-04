package 취준_2025.Heap.프로그래머스_이중우선순위큐;
import java.util.*;
public class Main {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(String o : operations){
            if(o.equals("D -1")){
                if(!min.isEmpty()){
                    max.remove(min.poll());
                }
            }else if(o.equals("D 1")){
                if(!min.isEmpty()){
                    min.remove(max.poll());
                }
            }else{
                int newnum = Integer.parseInt(o.split(" ")[1]);
                min.add(newnum);
                max.add(newnum);
            }
        }
        if(min.isEmpty()) return new int[]{0,0};

        return new int[]{max.poll(),min.poll()};
    }
}
