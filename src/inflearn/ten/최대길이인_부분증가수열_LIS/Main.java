package inflearn.ten.최대길이인_부분증가수열_LIS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        arr = new int[num];
        step = new int[num];
        for(int i = 0; i< num; i++) {
            arr[i] = sc.nextInt();
            step[i] = 1;
        }
        solution();
        System.out.println(max);
    }

    static int num;
    static int[] arr;
    static int[] step;
    static int max = 0;

    /**
     8
     5 3 7 8 6 2 9 4
     */
    public static void solution(){
        for(int i = 0; i<arr.length; i++){
            int j = 0;
            int previousMax = 0;
            int current = arr[i];

            while(j<i){
                int previous = arr[j];

                if(previous< current && previousMax < step[j]){
                    previousMax = step[j];
                }

                j++;
            }

            step[i] = previousMax+1;
            if(max < previousMax+1) max = previousMax+1;
        }
    }

}
