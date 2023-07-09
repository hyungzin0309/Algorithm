package inflearn.seven.인접행렬경로탐색;

import java.util.*;

public class Main {

    static int targetNodeNum;
    static Map<Integer, List<Integer>> map = new HashMap<>();

    // 5 9 1 2 1 3 1 4 2 1 2 3 2 5 3 4 4 2 4 5
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        targetNodeNum = sc.nextInt();
        int edgeNum = sc.nextInt();

        for(int i = 0; i<edgeNum; i++){
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            List<Integer> endNodeList = map.getOrDefault(startNode, new ArrayList<>());
            endNodeList.add(endNode);
            map.put(startNode, endNodeList);
        }
        dfs(1, new ArrayList<>());

    }

    private static void dfs(int current, List<Integer> route) {
        route.add(current);
        if(current == targetNodeNum){
            route.forEach(node -> System.out.print(node + " "));
            System.out.println();
        }else{
            List<Integer> myTargetNodes = map.get(current);
            myTargetNodes.forEach(myTarget -> {
                if(!route.contains(myTarget)){
                    List<Integer> newRoute = new ArrayList<>(route);
                    dfs(myTarget, newRoute);
                }
            });
        }

    }


}
