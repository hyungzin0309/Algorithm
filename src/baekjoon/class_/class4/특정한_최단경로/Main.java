package baekjoon.class_.class4.특정한_최단경로;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int lineNum;
    static int[] visited;
    static Map<Integer, List<Target>> map = new HashMap<>();
    static int m1;
    static int m2;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        lineNum = Integer.parseInt(s[1]);
        for(int i = 0; i< lineNum; i++){
            String[] line = br.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]);
            int node2 = Integer.parseInt(line[1]);
            int distance = Integer.parseInt(line[2]);
            List<Target> node1Targets = map.getOrDefault(node1, new ArrayList<>());
            node1Targets.add(new Target(node2, distance));
            map.put(node1, node1Targets);
            List<Target> node2Targets = map.getOrDefault(node2, new ArrayList<>());
            node2Targets.add(new Target(node1, distance));
            map.put(node2, node2Targets);
        }
        s = br.readLine().split(" ");
        m1 = Integer.parseInt(s[0]);
        m2 = Integer.parseInt(s[1]);

        int d1 = sol1();
        int d2 = sol2();
        if(d1 == -1 && d2 == -1) min = -1;
        else if(d1 != -1 && d2 != -1) min = Math.min(min,Math.min(d1,d2));
        else if(d1 != -1 && d2 == -1) min = d1;
        else if(d1 == -1 && d2 != -1) min = d2;

        bw.write(String.valueOf(min));
        bw.flush();
    }

    // 1 -> m1 -> m2 -> n
    static int sol1(){
        int distance1 = bfs(1,m1);
        int distance2 = bfs(m1,m2);
        int distance3 = bfs(m2,n);
        if(distance1 == -1 || distance2 == -1 || distance3 == -1) return -1;
        int result = distance1 + distance2 + distance3;
        return result;
    }

    // 1 -> m2 -> m1 -> n
    static int sol2(){
        int distance1 = bfs(1,m2);
        int distance2 = bfs(m2,m1);
        int distance3 = bfs(m1,n);
        if(distance1 == -1 || distance2 == -1 || distance3 == -1) return -1;
        int result = distance1 + distance2 + distance3;
        return result;
    }

    static int bfs(int start, int target){
        visited = new int[n+1];
        Queue<Target> queue = new LinkedList<>();
        queue.add(new Target(start, 0));
        int distance = 0;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i< length; i++){
                Target current = queue.poll();
                if(current.distance != 0) {
                    current.distance = current.distance - 1;
                    queue.add(current);
                }else{
                    visited[current.nodeNum] = 1;
                    if(current.nodeNum == target) return distance;
                    else{
                        List<Target> targets = map.getOrDefault(current.nodeNum, new ArrayList<>());
                        for(Target ta : targets){
                            if(visited[ta.nodeNum] != 1){
                                queue.add(new Target(ta.nodeNum, ta.distance-1));
                            }
                        }
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    static class Target{
        int nodeNum;
        int distance;

        public Target(int t, int d) {
            nodeNum = t;
            distance = d;
        }
    }

}
