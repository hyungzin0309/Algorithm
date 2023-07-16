package inflearn.nine.원더랜드_최소스패닝트리_카루스칼;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cityNum = sc.nextInt();
        roads = sc.nextInt();
        cities = new int[cityNum+1];
        for(int i = 0; i< cityNum+1; i++) cities[i] = i;
        edges = new int[roads][3];
        for(int i = 0; i<roads; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        System.out.println(solution());
    }

    static int cityNum;
    static int roads;
    static int[] cities;
    static int[][] edges;

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
    public static int solution(){
        int result = 0;
        Arrays.sort(edges, (o1, o2)->{
            return o1[2] - o2[2];
        });

        for(int[] edge : edges){
            if(find(edge[0]) != find(edge[1])){
                result += edge[2];
                union(edge[0], edge[1]);
            }
        }

        return result;
    }

    public static void union(int city1, int city2){
        cities[find(city1)] = find((city2));
    }

    public static int find(int city){
        if(city == cities[city]) return city;
        else return cities[city] = find(cities[city]);
    }

}
