package programmers.PCCP.제1회;

import java.util.*;

public class Solution4 {

    public static void main(String[] args) {
        int[][] arr = {{2, 0, 10},{1, 5, 5},{3, 5, 3},{3, 12, 2}};
        int[][] arr2 = {{3, 6, 4}, {4, 2, 5},{1, 0, 5},{5, 0, 5}}; // [19, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static long[] solution(int[][] program) {
        Arrays.sort(program, (o1, o2)->{
            return  o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
        });
        long[] answer = new long[11];
        Queue<Program> queue = new LinkedList<>();
        PriorityQueue<Program> waitingQueue = new PriorityQueue<>();

        for(int i = 0; i< program.length; i++){
            int[] a = program[i];
            queue.add(new Program(a[0], a[1], a[2]));
        }
        int now = 0;
        while(!(queue.isEmpty() && waitingQueue.isEmpty())){
            while(!queue.isEmpty() && queue.peek().start <= now){
                waitingQueue.add(queue.poll());
            }
            if(waitingQueue.isEmpty()){
                Program todo = queue.poll();
                now = todo.start + todo.runtime;
            }else{
                Program todo = waitingQueue.poll();
                int priority = todo.priority;
                int start = todo.start;
                int runtime = todo.runtime;
                answer[priority] = answer[priority] + (now-start);
                now += runtime;
            }
        }
        answer[0] = now;
        return answer;
    }

    static class Program implements Comparable<Program>{
        int priority;
        int start;
        int runtime;

        public Program(int priority,int start,int runtime){
            this.priority = priority;
            this.start = start;
            this.runtime = runtime;
        }

        public int compareTo(Program o){
            return this.priority - o.priority;
        }
    }
}
