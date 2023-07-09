package programmers.level2.연속된부분수열의합;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2};
        int k = 6;
        System.out.println(Arrays.toString(solution(arr,k)));
    }

    public static int[] solution(int[] arr, int k){
        int start = 0;
        int end = 0;
        int sum = arr[0];
        int[] result = new int[2];
        int minLength = Integer.MAX_VALUE;

        while(true){

            if(sum < k){
                end++;
                if(end > arr.length-1) break;
                sum += arr[end];
            }else if(sum == k){
                if(end - start < minLength){
                    result[0] = start;
                    result[1] = end;
                    minLength = end-start;
                }
                sum -= arr[start];
                start++;
            }else{
                sum -= arr[start];
                start++;
            }
        }

        return result;
    }
}
