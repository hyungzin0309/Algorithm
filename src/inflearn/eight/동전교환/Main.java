package inflearn.eight.동전교환;

import java.util.*;

public class Main {

    static int arr[];
    static int total;
    static boolean[] check = new boolean[20000];

    /**
      3
      1 2 5
      15
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int typeNum = sc.nextInt();
        arr = new int[typeNum];
        for(int i = 0; i< typeNum; i++){
            arr[i] = sc.nextInt();
        }
        total = sc.nextInt();
        System.out.print(solution());
    }

    public static int solution(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int level = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                int currentSum = queue.poll();
                for(int j = 0; j<arr.length; j++){
                    int next = currentSum + arr[j];
                    if(next == total) return level+1;
                    if(next < total && !check[next]) queue.add(next);
                    check[next] = true;
                }
            }
            level++;
        }
        return -1;
    }

}
