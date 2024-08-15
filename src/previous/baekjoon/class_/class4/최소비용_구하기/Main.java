package previous.baekjoon.class_.class4.최소비용_구하기;

import java.io.*;
import java.util.*;

public class Main {

    static int lastCity;
    static int busNum;
    static int startCity;
    static int targetCity;
    static Map<Integer, List<Bus>> map = new HashMap<>();
    static int[] visited;
    static int[] costPerCity;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        lastCity = Integer.parseInt(br.readLine());
        visited = new int[lastCity + 1];
        costPerCity = new int[lastCity + 1];
        Arrays.fill(costPerCity, Integer.MAX_VALUE);
        busNum = Integer.parseInt(br.readLine());
        for(int i = 0; i< busNum; i++){
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int target = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            List<Bus> busList = map.getOrDefault(start, new ArrayList<>());
            busList.add(new Bus(target, cost));
            map.put(start, busList);
        }
        String[] s = br.readLine().split(" ");
        startCity = Integer.parseInt(s[0]);
        targetCity = Integer.parseInt(s[1]);

        bw.write(String.valueOf(sol()));
        bw.flush();
    }

    static int sol(){
        Queue<Bus> queue = new PriorityQueue<>();
        queue.add(new Bus(startCity, 0));
        costPerCity[startCity] = 0;
        while(!queue.isEmpty()){
            Bus cb = queue.poll();
            int current = cb.targetCity;
            if(visited[current] == 0) {
                visited[current] = 1;
                for (Bus bus : map.getOrDefault(current, new ArrayList<>())) {
                    int next = bus.targetCity;
                    if (costPerCity[next] > costPerCity[current] + bus.cost) {
                        costPerCity[next] = costPerCity[current] + bus.cost;
                        queue.add(new Bus(next, costPerCity[next]));
                    }
                }
            }
        }
        return costPerCity[targetCity];
    }

    static class Bus implements Comparable<Bus>{
        int targetCity;
        int cost;

        public Bus(int t, int c){
            targetCity = t;
            cost = c;
        }

        public int compareTo(Bus o){
            return cost - o.cost;
        }

    }


}
