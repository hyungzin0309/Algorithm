package inflearn.previous.매출합_슬라이딩윈도우;

import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr){
        int result = firstSum(k, arr); // 처음 합
        int sum = result;

        int firstIndex = 0;
        int lastIndex = k;

        while(lastIndex < n){
            sum -= arr[firstIndex];
            sum += arr[lastIndex];
            if(sum > result) result = sum;
            firstIndex++;
            lastIndex++;
        }

        return result;
    }

    private static int firstSum(int k, int[] arr){
        int result = 0;
        for(int i = 0; i<k; i++){
            result += arr[i];
        }
        return result;
    }

}
