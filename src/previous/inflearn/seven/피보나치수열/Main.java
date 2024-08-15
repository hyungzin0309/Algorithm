package previous.inflearn.seven.피보나치수열;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        int num = 50;
//        solution(num);
        System.out.println();
        arr = new int[num];
        solution2(num);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }


    //for문으로 풀기 -> 성능이 더 좋다
    public static void solution(int num){
        int previous1 = 0;
        int previous2 = 1;
        for(int i = 1; i<= 10; i++){
            int temp = previous2;
            previous2 += previous1;
            previous1 = temp;
            System.out.print(previous1 + " ");
        }
    }


    static int[] arr;
    //재귀함수 풀이 -> stack을 사용하기 때문에 무거움
    public static int solution2(int num){
        if(num == 1 || num == 2) {
            arr[num-1] = 1;
            return 1;
        }
        if(arr[num-1] != 0 )return arr[num-1];
        arr[num-1] = solution2(num-1) + solution2(num-2);
        return arr[num-1];
    }
}
