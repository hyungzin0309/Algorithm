package previous.inflearn.eight.합이_같은_부분집;

import java.util.*;

public class Main {

    static int targetSum;
    static int[] arr;
    static boolean[] isUsed;
    static boolean isExisted;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        arr = new int[num];
        isUsed = new boolean[num];
        for(int i = 0; i< num; i++) {
            arr[i] = sc.nextInt();
        }

        solution(num);
    }

    public static void solution(int num){
        int total = Arrays.stream(arr).sum();
        if(total % 2 == 1){
            System.out.print("NO");
            return;
        }
        targetSum = total/2;
        dfs(0);
        System.out.print(isExisted?"YES":"NO");
    }

    public static void dfs(int current){
        if(current == arr.length-1){
            int sum = 0;
            for(int i = 0; i< arr.length; i++){
                if(isUsed[i]) sum += arr[i];
            }
            if(sum == targetSum) isExisted = true;
        }else{
            isUsed[current] = true;
            dfs(current+1);
            isUsed[current] = false;
            dfs(current+1);
        }
    }
}
