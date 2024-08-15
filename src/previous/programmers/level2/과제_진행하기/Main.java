package previous.programmers.level2.과제_진행하기;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[][] arr = {{"science", "12:40", "50"},{"music", "12:20", "40"},{"history", "14:00", "30"},{"computer", "12:30", "100"}};
        System.out.print(Arrays.toString(solution(arr)));
    }

    public static String[] solution(String[][] arr){
        String[] result = new String[arr.length];
        Map<String, Integer> remainedTime = new HashMap<>();
        Map<String, Integer> startTime = new HashMap<>();

        Arrays.sort(arr, (o1, o2)->{
            int t1 = (Integer.parseInt(o1[1].split(":")[0]) * 60) + Integer.parseInt(o1[1].split(":")[1]);
            int t2 = (Integer.parseInt(o2[1].split(":")[0]) * 60) + Integer.parseInt(o2[1].split(":")[1]);
            return t1 - t2;
        });

        Stack<String> stop = new Stack<>();
        Queue<String> main = new LinkedList<>();
        Queue<String> success = new LinkedList<>();
        for(String[] a : arr){
            startTime.put(a[0], (Integer.parseInt(a[1].split(":")[0]) * 60) + Integer.parseInt(a[1].split(":")[1]));
            remainedTime.put(a[0], Integer.parseInt(a[2]));
            main.add(a[0]);
        }

        while(success.size() < arr.length){
            if(main.isEmpty()){
                while(!stop.isEmpty()){
                    success.add(stop.pop());
                }
            }
            String current = main.poll();
            if(main.isEmpty()){
                success.add(current);
                continue;
            }
            String next = main.peek();

            int currentEndTime = remainedTime.get(current) + startTime.get(current);
            int nextStartTime = startTime.get(next);
            int restTime = nextStartTime - currentEndTime; // 과제 간 시간이 남는 경우
            int overtime = currentEndTime - nextStartTime; // 뒤 과제의 시작시간보다 오바되는 경우, 최대한 플레이하고 남은 플레이타임

            if(currentEndTime > nextStartTime){ // 현재 과제가 다음 과제의 시작시간을 넘길 때
                remainedTime.put(current, overtime); // 현재 과제의 남은 플레이타임은 다음 플랜의 시작보다 오바되는 시간
                stop.add(current);
            }else if(currentEndTime < nextStartTime){ // 두 과제 사이 시간이 빈다.
                remainedTime.put(current, 0);
                success.add(current);

                int stoppedPlanPlayTime = 0; // 미뤄놨던 과제의 플레이타임 총 합
                while(!stop.isEmpty() && stoppedPlanPlayTime < restTime){
                    String stopped = stop.peek();
                    int stoppedPlanRemainedTime = remainedTime.get(stopped);
                    if(stoppedPlanRemainedTime + stoppedPlanPlayTime > restTime){
                        remainedTime.put(stopped, stoppedPlanRemainedTime - restTime);
                        break;
                    }else if(stoppedPlanRemainedTime + stoppedPlanPlayTime < restTime){
                        remainedTime.put(stopped,0);
                        success.add(stop.pop());
                        stoppedPlanPlayTime += stoppedPlanRemainedTime;
                    }else {
                        remainedTime.put(stopped,0);
                        success.add(stop.pop());
                        break;
                    }
                }

            }else{
                remainedTime.put(current, 0);
                success.add(current);
            }
        }

        for(int i = 0; i< result.length; i++){
            result[i] = success.poll();
        }
        return result;
    }
}
