package previous.inflearn.ten.동전교환_BFS;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        types = new int[num];
        for(int i = 0; i<num; i++){
            int typeNum = sc.nextInt();
            types[i] = typeNum;
            queue.add(typeNum);
        }
        target = sc.nextInt();
        visited = new int[target];
        System.out.println(solution());
    }

    /**
     3
     1 2 5
     15
     */
    static int num;
    static int[] types;
    static int target;
    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    public static int solution(){

        int level = 1;
        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i = 0; i<len; i++){

                int current = queue.poll();
                if(current == target) return level;

                for(int j = 0; j<types.length; j++){

                    int summed = current + types[j];
                    if(summed == target){
                        return level+1;
                    }
                    if(summed < target && visited[summed] == 0){
                        visited[summed] = 1;
                        queue.add(summed);
                    }

                }
            }
            level++;
        }
        return 0;
    }

}
