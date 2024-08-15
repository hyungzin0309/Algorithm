package previous.inflearn.nine.원더랜드_최소스패닝트리_프림;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cityNum = sc.nextInt();
        roads = sc.nextInt();
        for(int i = 0; i<roads; i++){
            int city1 = sc.nextInt();
            int city2 = sc.nextInt();
            int cost = sc.nextInt();
            List<Edge> list1 = map.getOrDefault(city1,new ArrayList<>());
            list1.add(new Edge(city1,city2,cost));
            List<Edge> list2 = map.getOrDefault(city2,new ArrayList<>());
            list2.add(new Edge(city2,city1,cost));
            map.put(city1,list1);
            map.put(city2,list2);
        }
        visited = new boolean[cityNum+1];
        System.out.println(solution());
    }

    /**
     9 12
     1 2 12
     1 9 25
     2 3 10
     2 8 17
     2 9 8
     3 4 18
     3 7 55
     4 5 44
     5 6 60
     5 7 38
     7 8 35
     8 9 15
     */

    static int cityNum;
    static int roads;
    static Map<Integer,List<Edge>> map = new HashMap<>();
    static boolean[] visited;
    public static int solution(){
        int result = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.addAll(map.get(1));
        visited[1] = true;
        while(!queue.isEmpty()){
            Edge edge = queue.poll();
            if(!visited[edge.city2]){
                result += edge.cost;
                visited[edge.city2] = true;
                queue.addAll(map.getOrDefault(edge.city2, new ArrayList<>()));
            }
        }
        return result;
    }

    public static class Edge implements Comparable<Edge>{
        int city1;
        int city2;
        int cost;
        public int compareTo(Edge other){
            return this.cost - other.cost;
        }
        public Edge(int c1, int c2, int cost){
            city1 = c1;
            city2 = c2;
            this.cost = cost;
        }
    }
}
