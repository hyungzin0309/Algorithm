package 취준_2025.Heap.프로그래머스_디스크컨트롤러;

import java.util.*;

public class Main {

    public int solution(int[][] jobs) {
        Queue<Task> timeQueue = new PriorityQueue<>(new TimeComparator());
        Queue<Task> waitingQueue = new PriorityQueue<>();

        for(int i = 0; i< jobs.length; i++){
            timeQueue.add(new Task(i, jobs[i][0], jobs[i][1]));
        }

        int total = 0;
        int seconds = 0;
        while(!timeQueue.isEmpty() || !waitingQueue.isEmpty()){
            while(!timeQueue.isEmpty() && timeQueue.peek().income <= seconds){
                waitingQueue.add(timeQueue.poll());
            }

            if(!waitingQueue.isEmpty()){
                Task task = waitingQueue.poll();
                seconds += task.process;
                total += seconds - task.income;
            }else{
                seconds++;
            }
        }

        return total / jobs.length;
    }

    public class TimeComparator implements Comparator<Task>{
        @Override
        public int compare(Task task1, Task task2){
            return task1.income - task2.income;
        }
    }

    public class Task implements Comparable<Task>{
        int num;
        int income;
        int process;

        @Override
        public int compareTo(Task other){
            if(this.process != other.process) return this.process - other.process;
            if(this.income != other.income) return this.income - other.income;
            return this.num - other.num;
        }

        public Task(int num, int income, int process){
            this.num = num;
            this.income = income;
            this.process = process;
        }
    }
}
