package previous.inflearn.ten.최대길이인_부분증가수열_DFS;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        arr = new int[num];
        visited = new boolean[num];
        for(int i = 0; i< num; i++) {
            arr[i] = sc.nextInt();
        }
        solution();
        System.out.println(max);
    }

    static int num;
    static int[] arr;
    static int max = 0;
    static boolean[] visited;
    static int len = 0;

    /**
     8
     5 3 7 8 6 2 9 4
     */
    public static void solution(){
        dfs(0,0);
    }

    public static void dfs(int previousNum, int index){
        if(num-1 < index){
            if(max < len) max = len;
        }else{
            int current = arr[index];
            if(previousNum < current){
                len++;
                dfs(current, index + 1);
                len --;
                dfs(previousNum, index + 1);
            }else{
                dfs(previousNum, index + 1);
            }
        }
    }
}
