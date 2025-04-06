package 취준_2025.완탐.프로그래머스_전력망을_둘로나누기;

import java.util.*;

public class Main {

    public int min = Integer.MAX_VALUE;
    public int[][] wires;
    public int num;

    public int solution(int n, int[][] w) {
        num = n;
        wires = w;
        for (int i = 0; i < wires.length; i++) {
            Map<Integer, List<Integer>> link = new HashMap<>();
            for(int j = 0; j < wires.length; j++){
                if(i==j) continue;
                int from = wires[j][0];
                int to = wires[j][1];
                List<Integer> linked1 = link.getOrDefault(from, new ArrayList<>());
                linked1.add(to);
                link.put(from, linked1);

                List<Integer> linked2 = link.getOrDefault(to, new ArrayList<>());
                linked2.add(from);
                link.put(to, linked2);
            }
            sol(link);
        }
        return min;
    }

    public void sol(Map<Integer, List<Integer>> link) {
        int[] visited = new int[num + 1];
        int start = link.keySet().iterator().next();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int result = 1;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i< length; i++){
                int linked = queue.poll();
                if (visited[linked] == 0) {
                    visited[linked] = 1;
                    for(int j = 0; j<link.get(linked).size(); j++){
                        int point = link.get(linked).get(j);
                        if(visited[point] == 0){
                            visited[point] = 1;
                            queue.add(point);
                            result += 1;
                        }
                    }
                }
            }
        }
        int gap = Math.abs((num - result) - result);
        min = Math.min(min, gap);
    }


}