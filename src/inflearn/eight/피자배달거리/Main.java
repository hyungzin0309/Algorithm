package inflearn.eight.피자배달거리;
import java.util.*;
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        width = sc.nextInt();
        alive = sc.nextInt();
        guide = new int[width][width];


        for(int i = 0; i< width; i++){
            for(int j = 0; j< width; j++) {
                int type = sc.nextInt();
                guide[i][j] = type;
                if(type == 1) houses.add(new int[]{i,j});
                if(type == 2) stores.add(new int[]{i,j});
            }
        }
        if(stores.size() < alive) alive = stores.size();

        solution();
    }

    static int width;
    static int alive; // 살릴 피자 수
    static int[][] guide;
    static int minDistance = Integer.MAX_VALUE;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> stores = new ArrayList<>();
    static Stack<Integer> pickedStores = new Stack<>();
    /**
     4 4
     0 1 2 0
     1 0 2 1
     0 2 1 2
     2 0 1 2
     */
    public static void solution(){
        dfs(0);
        System.out.println(minDistance);
    }

    public static void dfs(int storeIndex){
        if(pickedStores.size() == alive){
            int currentMin = getMinDistance();
            if(currentMin < minDistance) minDistance = currentMin;
        }else if(pickedStores.size() + (stores.size() - storeIndex) < alive){
            return;
        }else{
            pickedStores.add(storeIndex);
            dfs(storeIndex +1);
            pickedStores.pop();
            dfs(storeIndex +1);
        }
    }

    public static int getMinDistance(){
        int result = 0;

        for(int i = 0; i< houses.size(); i++){
            int min = Integer.MAX_VALUE;
            int[] house = houses.get(i);
            for(int j= 0; j< alive; j++){
                int[] store = stores.get(pickedStores.get(j));
                int distance = Math.abs(store[0] - house[0]) + Math.abs(store[1] - house[1]);
                if(distance < min) min = distance;
            }

            result += min;
        }
        return result;
    }
}
