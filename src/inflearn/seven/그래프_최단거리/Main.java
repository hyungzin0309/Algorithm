package inflearn.seven.그래프_최단거리;
import java.util.*;

public class Main {

    static int nodeNum;
    static int edge;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static boolean isVisited[];
    static Map<Integer, Integer> result = new HashMap<>();

    // 6 9 1 3 1 4 2 1 2 5 3 4 4 5 4 6 6 2 6 5
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodeNum = sc.nextInt();
        edge = sc.nextInt();
        for(int i = 0; i<edge; i++){
            int node = sc.nextInt();
            int targetNode = sc.nextInt();
            List<Integer> targetNodes = map.getOrDefault(node, new ArrayList<>());
            targetNodes.add(targetNode);
            map.put(node, targetNodes);
        }
        isVisited = new boolean[nodeNum+1];
        solution();
    }

    public static void solution(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int level = 0;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                int node = queue.poll();
                for(int targetNode : map.getOrDefault(node,new ArrayList<>())){
                    if(!isVisited[targetNode]){
                        isVisited[targetNode] = true;
                        queue.add(targetNode);
                    }
                }
                result.put(node, level);
            }
            level++;
        }

        for(int i = 2; i<nodeNum + 1; i++){
            System.out.println(i+" : "+result.get(i));
        }
    }


}
