package baekjoon.silver.five.다리놓기;
import java.util.*;

public class dfs {

    static int num;
    static int[] results;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        results = new int[num];
        for(int i = 0; i<num; i++){
            results[i] = solution(sc.nextInt(), sc.nextInt());
        }

        for(int i = 0; i< num; i++){
            System.out.println(results[i]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) / 1000.0 + " seconds");
    }

    public static int solution(int n, int m){
        result = 0;
        last = n;
        int gap = m - n;
        dfs(1, gap);
        return result;
    }

    static int result;
    static int last;
    public static void dfs(int index, int gap){
        if(gap == 0 || index > last) {
            result++;
            return;
        }
        for(int i = 0; i<=gap; i++){
            dfs(index  + 1, i);
        }
    }

}
