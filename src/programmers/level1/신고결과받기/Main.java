package programmers.level1.신고결과받기;

import java.util.Arrays;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] users = {"con", "ryan"};
        String[] history = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int stopNum = 2;
        System.out.println(Arrays.toString(solution(users, history, stopNum)));
    }

    public static int[] solution(String[] users, String[] histories, int stopNum){
        Map<String, Set<String>> reportInfo = new HashMap<>();
        for(String history: histories){
            String[] h = history.split(" ");
            String report = h[0];
            String reported = h[1];
            Set set = reportInfo.getOrDefault(reported, new HashSet());
            set.add(report);
            reportInfo.put(reported,set);
        }
        Map<String, Integer> mailingNum = new HashMap<>();
        reportInfo.forEach((key, value) -> {
            if(value.size() >= stopNum) {
                value.forEach(name -> mailingNum.put(name,mailingNum.getOrDefault(name,0)+1));
            }
        });

        int[] result = new int[users.length];
        for(int i = 0; i<result.length; i++){
            result[i] = mailingNum.getOrDefault(users[i],0);
        }
        return result;
    }
}
