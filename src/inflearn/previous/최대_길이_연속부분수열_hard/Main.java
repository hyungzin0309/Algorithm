package inflearn.previous.최대_길이_연속부분수열_hard;

import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n,k,arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int result = 0;
        int zeros = 0;
        int lt = 0;
        for(int rt = 0; rt<n; rt++){
            if(arr[rt] == 0);  zeros++;
            while(zeros > k){
                if(arr[lt] == 0){
                    zeros--;
                }
                lt++;
            }
            result = result < rt - lt +1? rt-lt+1 : result;
        }
        return result;
    }

}
