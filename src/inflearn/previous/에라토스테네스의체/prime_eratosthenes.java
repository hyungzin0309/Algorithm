package inflearn.previous.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 소수 구하기 (에라토스테네스의 체)
public class prime_eratosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(solution(num));
    }

    public static int solution(int num){
        int result = 0;
        int nums[] = new int[num+1];
        for(int i = 2; i<num+1; i++) {
            if(nums[i] == 0){
                result++;
                for(int j = i; j<num+1; j = j+i){
                    nums[j] = 1;
                }
            }
        }
        return result;
    }
}
